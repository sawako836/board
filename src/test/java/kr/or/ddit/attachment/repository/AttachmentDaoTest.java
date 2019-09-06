package kr.or.ddit.attachment.repository;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.attachment.model.Attachment;
import kr.or.ddit.util.MybatisUtil;

public class AttachmentDaoTest {
	
	private static final Logger logger = LoggerFactory.getLogger(AttachmentDaoTest.class);
	private IAttachmentDao attachmentDao;
	private SqlSession sqlSession;
	
	@Before
	public void setup() {
		logger.debug("AttaDaoTestBefore()");
		attachmentDao = AttachmentDao.getInstance();
		sqlSession = MybatisUtil.getSession();
	}
	
	@After
	public void tearDown() {
		logger.debug("AttaDaoTestAfter()");
		sqlSession.close();
	}

	@Test
	public void getAttaListTest() {
		/***Given***/
		int pnum = 1;
		
		/***When***/
		List<Attachment> attaList = attachmentDao.getAttachmentList(sqlSession, pnum);
		
		/***Then***/
		assertEquals(1, attaList.size());
	}
	
	@Test
	public void insertAttaTest() {
		/***Given***/
		Attachment attachment = new Attachment();
		attachment.setUploadname("test첨부파일추가");
		attachment.setFilepath("첨부파일 경로");
		attachment.setPnum(1);
		
		/***When***/
		int insertCnt = attachmentDao.insertAttachment(sqlSession, attachment);
		sqlSession.commit();

		/***Then***/
		assertEquals(1, insertCnt);
	}
	
	@Test
	public void deleteAttaTest() {
		/***Given***/
		int anum = 2;
		
		/***When***/
		int deleteCnt = attachmentDao.deleteAttachment(sqlSession, anum);
		sqlSession.commit();

		/***Then***/
		assertEquals(1, deleteCnt);
	}
	
	@Test
	public void getAttaTest() {
		/***Given***/
		int anum = 5;
		
		/***When***/
		Attachment attachment = attachmentDao.getAttachment(sqlSession, anum);

		/***Then***/
		assertEquals("cony.png", attachment.getUploadname());
	}

}
