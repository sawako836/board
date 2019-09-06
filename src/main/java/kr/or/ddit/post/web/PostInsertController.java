package kr.or.ddit.post.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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

/**
 * Servlet implementation class PostInsertController
 */
@WebServlet("/postInsert")
@MultipartConfig(maxFileSize = 1024*1024*5, maxRequestSize = 1024*1024*5*5)
public class PostInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory.getLogger(PostInsertController.class);
	private IPostService postService;
	private IAttachmentService attachmentService;
	
	@Override
	public void init() throws ServletException {
		postService = PostService.getInstance();
		attachmentService = new AttachmentService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int inum = Integer.parseInt(request.getParameter("inum"));
		String pnum = request.getParameter("pnum");
		String posttem = request.getParameter("posttem");
		
		request.setAttribute("inum", inum);
		request.setAttribute("pnum", pnum);
		request.setAttribute("posttem", posttem);
		
		request.getRequestDispatcher("/post/postInsert.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int inum = Integer.parseInt(request.getParameter("inum"));
		String postsubject = request.getParameter("postsubject");
		String postcontent = request.getParameter("postcontent");
		
		HttpSession session = request.getSession();
		String userid = (String) session.getAttribute("userid");
		
		String pnum2v = request.getParameter("pnum");
		String posttemv = request.getParameter("posttem");
		
		int pnum2 = pnum2v.equals("") ? 0 : Integer.parseInt(pnum2v);
		int posttem = posttemv.equals("") ? 0 : Integer.parseInt(posttemv);
		
		Post post = new Post();
		post.setInum(inum);
		post.setPostsubject(postsubject);
		post.setPostcontent(postcontent);
		post.setUserid("cony");
		
		logger.debug("pnum2 : {}", pnum2);
		logger.debug("posttemv : {}", posttemv);
		
		if(pnum2 != 0 && posttem != 0) {
			post.setPnum2(pnum2);
			post.setPosttem(posttem);
		}
		
		int pnum = postService.insertPost(post);
		
		List<Part> parts = (List<Part>) request.getParts();
		
		for(Part part : parts) {
			if(part.getName().equals("attachment")) {
				String uploadname = "";
				String filepath = "";
				if(part.getSize() > 0) {
					uploadname = FileuploadUtil.getFilename(part.getHeader("Content-Disposition"));
					String filename = UUID.randomUUID().toString();
					String ext = FileuploadUtil.getFileExtension(part.getHeader("Content-Disposition"));
					filepath = FileuploadUtil.getPath() + filename + ext;
					part.write(filepath);
					
					Attachment attachment = new Attachment();
					attachment.setUploadname(uploadname);
					attachment.setFilepath(filepath);
					attachment.setPnum(pnum);
					int atinsertCnt = attachmentService.insertAttachment(attachment);
				}
				
				
			}
		}
		
		response.sendRedirect(request.getContextPath() + "/postDetail?inum=" + inum + "&pnum=" + pnum);
		
	}

}
