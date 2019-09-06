package kr.or.ddit.comments.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.comments.service.CommentsService;
import kr.or.ddit.comments.service.ICommentsService;

@WebServlet("/deleteComments")
public class CommentsDelController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private static final Logger logger = LoggerFactory.getLogger(CommentsDelController.class);
	private ICommentsService commentsService;
	
	@Override
	public void init() throws ServletException {
		commentsService = CommentsService.getInstance();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cnum = Integer.parseInt(request.getParameter("cnum"));
		int pnum = Integer.parseInt(request.getParameter("pnum"));
		int inum = Integer.parseInt(request.getParameter("inum"));
		
		int deleteCnt = commentsService.deleteComments(cnum);
		
		response.sendRedirect(request.getContextPath()+"/postDetail?pnum=" + pnum + "&inum=" + inum);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
