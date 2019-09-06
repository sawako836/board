package kr.or.ddit.board.repository;

import static org.junit.Assert.*;

import java.awt.Window;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.board.model.Board;
import kr.or.ddit.common.model.PageBoard;
import kr.or.ddit.post.model.Post;
import kr.or.ddit.post.repository.IPostDao;
import kr.or.ddit.util.MybatisUtil;

public class BoardDaoTest {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardDaoTest.class);
	private IBoardDao boardDao;
	private IPostDao postDao;
	private SqlSession sqlSession;
	
	// 테스트에 공통적으로 필요한 자원을 생성/ 초기화
	   @Before
	   public void setup() {
	      logger.debug("BoardDaoTestBefore()");
	      boardDao = new BoardDao();
	      sqlSession = MybatisUtil.getSession();
	      
	   }
	   
	   // 테스트에 공통적으로 사용한 자원을 해제
	   @After
	   public void tearDown() {
	      logger.debug("BoardDaoTestAfter()");
	      sqlSession.close();
	   }

	@Test
	public void getBoardList() {
		/***Given***/
		
		/***When***/
		List<Board> boardList = boardDao.getBoardList(sqlSession);

		/***Then***/
		assertEquals(0, boardList.size());
	}
	
	@Test
	public void insertBoardTest() {
		/***Given***/
		Board board = new Board();
		
		board.setBoardname("게시판 테스트");
		board.setUsagestatus("y");
		board.setUserid("sally");
		/***When***/
		int insertCnt = boardDao.insertBoard(sqlSession, board);
		sqlSession.commit();

		/***Then***/
		logger.debug(insertCnt+"");
		assertEquals(insertCnt, 1);
	}
	
	@Test
	public void updateBoardTest() {
		/***Given***/
		Board board = new Board();
		board.setInum(2);
		board.setBoardname("수정다오게시판");
		board.setUsagestatus("y");
		
		/***When***/
		int inum = 2;
		int updateCnt = boardDao.updateBoard(sqlSession, board);
		sqlSession.commit();

		/***Then***/
		assertEquals(0, updateCnt);
	}

}
