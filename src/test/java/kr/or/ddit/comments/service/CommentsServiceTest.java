package kr.or.ddit.comments.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.comments.model.Comments;


public class CommentsServiceTest {
	
	private static final Logger logger = LoggerFactory.getLogger(CommentsServiceTest.class);
	private ICommentsService commentsService;
	
	@Before
	public void setup() {
		logger.debug("ReplyServiceTestBefore()");
		commentsService = CommentsService.getInstance();
	}

	@Test
	public void getCommentsListTest() {
		/***Given***/
		int pnum = 1;
		
		/***When***/
		List<Comments> commentsList = commentsService.getCommentsList(pnum);

		/***Then***/
		assertEquals(2, commentsList.size());
	}
	
	@Test
	public void insertCommentsTest() {
		/***Given***/
		Comments comments = new Comments();
		comments.setCmtcont("아무내용이나써보자");
		comments.setPnum(1);
		comments.setUserid("cony");
		
		/***When***/
		int insertCnt = commentsService.insertComments(comments);

		/***Then***/
		assertEquals(1, insertCnt);
	}
	
	@Test
	public void deleteReplyTest() {
		/***Given***/
		int cnum = 6;
		
		/***When***/
		int deleteCnt = commentsService.deleteComments(cnum);

		/***Then***/
		assertEquals(1, deleteCnt);
	}

}
