package kr.or.ddit.attachment.web;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.attachment.model.Attachment;
import kr.or.ddit.attachment.service.AttachmentService;
import kr.or.ddit.attachment.service.IAttachmentService;

@WebServlet("/attachmentDownload")
public class AttachmentDownController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory.getLogger(AttachmentDownController.class);
	private IAttachmentService attachmentService;
	
	@Override
	public void init() throws ServletException {
		attachmentService = new AttachmentService();
	}
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int anum = Integer.parseInt(request.getParameter("anum"));
		
		Attachment attachment = attachmentService.getAttachment(anum);
		
		String filepath = attachment.getFilepath();
		
		ServletOutputStream sos = response.getOutputStream();
		
		File file = new File(filepath);
		FileInputStream fis = new FileInputStream(file);
		
		byte[] buff = new byte[512];
		int len = 0;
		while((len = fis.read(buff,0,512)) != -1) {
			sos.write(buff, 0, len);
		}
		
		fis.close();
	}
}
