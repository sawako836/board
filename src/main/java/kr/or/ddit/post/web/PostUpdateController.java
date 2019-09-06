package kr.or.ddit.post.web;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.attachment.model.Attachment;
import kr.or.ddit.attachment.service.AttachmentService;
import kr.or.ddit.attachment.service.IAttachmentService;
import kr.or.ddit.post.model.Post;
import kr.or.ddit.post.service.IPostService;
import kr.or.ddit.post.service.PostService;
import kr.or.ddit.util.FileuploadUtil;

@WebServlet("/postUpdate")
@MultipartConfig(maxFileSize = 1024*1024*5, maxRequestSize = 1024*1024*5*5)
public class PostUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory.getLogger(PostUpdateController.class);
	private IPostService postService;
	private IAttachmentService attachmentService;
	
	@Override
	public void init() throws ServletException {
		postService = PostService.getInstance();
		attachmentService = new AttachmentService();
	}
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pnum = Integer.parseInt(request.getParameter("pnum"));
		
		Post post = new Post();
		post.setPnum(pnum);
		
		Post getPost = postService.getPost(pnum);
		
		request.setAttribute("post", getPost);
		
		List<Attachment> attachmentList = attachmentService.getAttachmentList(pnum);
		
		request.setAttribute("attachmentList", attachmentList);
		
		request.getRequestDispatcher("/post/postUpdate.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int inum = Integer.parseInt(request.getParameter("inum"));
		int pnum = Integer.parseInt(request.getParameter("pnum"));
		String postsubject = request.getParameter("postsubject");
		String postcontent = request.getParameter("postcontent");
		
		Post post = new Post();
		post.setPnum(pnum);
		post.setPostsubject(postsubject);
		post.setPostcontent(postcontent);
		
		int updateCnt = postService.updatePost(post);
		
		List<Part> parts = (List<Part>) request.getParts();
		
		for(Part part : parts) {
			if(part.getName().equals("attachment")) {
				String uploadname = "";
				String filepath = "";
				if(part.getSize() > 0) {
					uploadname = FileuploadUtil.getFilename(part.getHeader("Content-Disposition"));
					String realfilename = UUID.randomUUID().toString();
					String ext = FileuploadUtil.getFileExtension(part.getHeader("Content-Disposition"));
					filepath = FileuploadUtil.getPath() + realfilename + ext;
					part.write(filepath);
					
					Attachment attachment = new Attachment();
					attachment.setUploadname(uploadname);
					attachment.setFilepath(filepath);
					attachment.setPnum(pnum);
					int atinsertCnt = attachmentService.insertAttachment(attachment);
				}
				
				
			}
		}
		
		response.sendRedirect(request.getContextPath()+"/postDetail?inum=" + inum + "&pnum=" + pnum);
		
	}

}
