package kr.or.ddit.board.service;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.board.model.Board;
import kr.or.ddit.common.model.PageBoard;
import kr.or.ddit.post.model.Post;
import kr.or.ddit.post.service.IPostService;

public class BoardServiceTest {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardServiceTest.class);
	private IBoardService boardService;
	private IPostService postService;
	
	@Before
	public void setup() {
		logger.debug("BoardServiceTestBefore()");
		boardService = new BoardService();
	}

	@Test
	public void getBoardListTest() {
		/***Given***/
		
		/***When***/
		List<Board> boardList = boardService.getBoardList();

		/***Then***/
		assertEquals(4, boardList.size());
	}
	
	@Test
	public void insertBoardTest() {
		/***Given***/
		Board board = new Board();
		
		board.setBoardname("테스트게시판");
		board.setUsagestatus("y");
		board.setUserid("cony");
		/***When***/
		int insertCnt = boardService.insertBoard(board);

		/***Then***/
		logger.debug(insertCnt+"");
		assertEquals(insertCnt, 1);
	}
	
	@Test
	public void updateBoardTest() {
		/***Given***/
		Board board = new Board();
		board.setInum(2);
		board.setUsagestatus("n");
		board.setBoardname("테스트수정게시판");
	
		int inum = 3;
		/***When***/
		int updateCnt = boardService.updateBoard(board);

		/***Then***/
		assertEquals(0, updateCnt);
	}

}
