package kr.or.ddit.post.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.attachment.model.Attachment;
import kr.or.ddit.attachment.service.AttachmentService;
import kr.or.ddit.attachment.service.IAttachmentService;
import kr.or.ddit.comments.model.Comments;
import kr.or.ddit.comments.service.CommentsService;
import kr.or.ddit.comments.service.ICommentsService;
import kr.or.ddit.post.model.Post;
import kr.or.ddit.post.service.IPostService;
import kr.or.ddit.post.service.PostService;

@WebServlet("/postDetail")
public class PostDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory.getLogger(PostDetailController.class);
	private IPostService postService;
	private IAttachmentService attachmentService;
	private ICommentsService commentsService;
	
	@Override
	public void init() throws ServletException {
		postService = PostService.getInstance();
		attachmentService = new AttachmentService();
		commentsService = CommentsService.getInstance();
	}
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pnum = Integer.parseInt(request.getParameter("pnum"));
		int inum = Integer.parseInt(request.getParameter("inum"));
		
		Post post = new Post();
		post.setPnum(pnum);
		post.setInum(inum);
		
		Post getPost = postService.getPost(post);
		
		request.setAttribute("post", getPost);
		
		List<Attachment> attachmentList = attachmentService.getAttachmentList(pnum);
		
		request.setAttribute("attachmentList", attachmentList);
		
		List<Comments> commentsList = commentsService.getCommentsList(pnum);
		
		request.setAttribute("commentsList", commentsList);
		
		request.getRequestDispatcher("/post/postdetail.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
