package kr.or.ddit.comments.repository;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.comments.model.Comments;
import kr.or.ddit.util.MybatisUtil;

public class CommentsDaoTest {
	
	private static final Logger logger = LoggerFactory.getLogger(CommentsDaoTest.class);
	private ICommentsDao commentsDao;
	private SqlSession sqlSession;
	
	@Before
	public void setup() {
		logger.debug("ReplyDaoTestBefore()");
		commentsDao = CommentsDao.getInstance();
		sqlSession = MybatisUtil.getSession();
	}
	
	@After
	public void tearDown() {
		sqlSession.close();
	}

	@Test
	public void getCommentsListTest() {
		/***Given***/
		int pnum = 1;
		
		/***When***/
		List<Comments> replyList = commentsDao.getCommentsList(sqlSession, pnum);

		/***Then***/
		assertEquals(2, replyList.size());
	}
	
	@Test
	public void insertCommentsTest() {
		/***Given***/
		Comments comments = new Comments();
		comments.setCmtcont("아무댓글");
		comments.setPnum(1);
		comments.setUserid("cony");
		
		/***When***/
		int insertCnt = commentsDao.insertComments(sqlSession, comments);
		sqlSession.commit();

		/***Then***/
		assertEquals(1, insertCnt);
	}
	
	@Test
	public void deleteCommentsTest() {
		/***Given***/
		int cnum = 4;
		
		/***When***/
		int deleteCnt = commentsDao.deleteComments(sqlSession, cnum);
		sqlSession.commit();

		/***Then***/
		assertEquals(1, deleteCnt);
	}

}
