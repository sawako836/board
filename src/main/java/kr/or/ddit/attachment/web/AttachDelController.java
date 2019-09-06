package kr.or.ddit.attachment.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.attachment.service.AttachmentService;
import kr.or.ddit.attachment.service.IAttachmentService;

@WebServlet("/attachmentDelete")
public class AttachDelController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory.getLogger(AttachDelController.class);
	private IAttachmentService attachmentService;
	
	@Override
	public void init() throws ServletException {
		attachmentService = new AttachmentService();
	}
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int anum = Integer.parseInt(request.getParameter("anum"));
		int pnum = Integer.parseInt(request.getParameter("pnum"));
		int inum = Integer.parseInt(request.getParameter("inum"));
		
		int deleteCnt = attachmentService.deleteAttachment(anum);
		
		response.sendRedirect(request.getContextPath()+"/postUpdate?pnum=" + pnum + "&inum=" + inum);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
