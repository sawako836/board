package kr.or.ddit.attachment.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.attachment.model.Attachment;


public class AttachmentServiceTest {
	
	private static final Logger logger = LoggerFactory.getLogger(AttachmentServiceTest.class);
	private IAttachmentService attachmentService;
	
	@Before
	public void setup() {
		attachmentService = new AttachmentService();
	}

	@Test
	public void getAttachmentListTest() {
		/***Given***/
		int pnum = 1;
		
		/***When***/
		List<Attachment> attacmentList = attachmentService.getAttachmentList(pnum);
		
		/***Then***/
		assertEquals(1, attacmentList.size());
	}
	
	@Test
	public void insertAttachmentTest() {
		/***Given***/
		Attachment attachment = new Attachment();
		attachment.setUploadname("첨부파일추가테스트");
		attachment.setFilepath("파일경로테스트");
		
		/***When***/
		int insertCnt = attachmentService.insertAttachment(attachment);

		/***Then***/
		assertEquals(1, insertCnt);
	}
	
	@Test
	public void deleteAttachmentTest() {
		/***Given***/
		int anum = 3;
		
		/***When***/
		int deleteCnt = attachmentService.deleteAttachment(anum);

		/***Then***/
		assertEquals(1, deleteCnt);
	}
	
	@Test
	public void getAttachmentTest() {
		/***Given***/
		int anum = 5;
		
		/***When***/
		Attachment attachment = attachmentService.getAttachment(anum);

		/***Then***/
		assertEquals("cony.png", attachment.getUploadname());
	}

}
