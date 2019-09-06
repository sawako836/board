package kr.or.ddit.comments.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.comments.model.Comments;
import kr.or.ddit.comments.service.CommentsService;
import kr.or.ddit.comments.service.ICommentsService;


/**
 * Servlet implementation class ReplyInsertController
 */
@WebServlet("/insertComments")
public class CommentsInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory.getLogger(CommentsInsertController.class);
	private ICommentsService commentsService;
	
	@Override
	public void init() throws ServletException {
		commentsService = CommentsService.getInstance();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmtcont = request.getParameter("cmtcont");
		int pnum = Integer.parseInt(request.getParameter("pnum"));
		int inum = Integer.parseInt(request.getParameter("inum")); 
		
		HttpSession session = request.getSession();
		String userid = (String) session.getAttribute("userid");
		
		
		Comments comments = new Comments();
		comments.setCmtcont(cmtcont);
		comments.setPnum(pnum);
//		comments.setUserid(userid);
		comments.setUserid("cony");
		
		int insertCnt = commentsService.insertComments(comments);
		
		response.sendRedirect(request.getContextPath()+"/postDetail?pnum=" + pnum + "&inum=" + inum);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
