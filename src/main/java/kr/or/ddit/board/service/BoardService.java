package kr.or.ddit.board.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.board.model.Board;
import kr.or.ddit.board.repository.BoardDao;
import kr.or.ddit.board.repository.IBoardDao;
import kr.or.ddit.util.MybatisUtil;

public class BoardService implements IBoardService {
	private IBoardDao boardDao;
	
	public BoardService() {
		boardDao = new BoardDao();
	}
	
	/**
	 * 
	* Method : insertBoard
	* 작성자 : PC-04
	* 변경이력 :
	* @param sqlSession
	* @param board
	* @return
	* Method 설명 : 게시판 등록
	 */
	@Override
	public int insertBoard(Board board) {
		SqlSession sqlSession = MybatisUtil.getSession();
		int insert = boardDao.insertBoard(sqlSession, board);
		sqlSession.commit(); 
		sqlSession.close();
		return insert;
	}

	/**
	 * 
	* Method : getBoardList
	* 작성자 : PC-04
	* 변경이력 :
	* @param sqlSession
	* @return
	* Method 설명 : 게시판 리스트 조회
	 */
	@Override
	public List<Board> getBoardList() {
		SqlSession sqlSession = MybatisUtil.getSession();
		List<Board> boardList = boardDao.getBoardList(sqlSession);
		sqlSession.close();
		
		return boardList;
	}

	/**
	 * 
	* Method : deleteBoard
	* 작성자 : PC-04
	* 변경이력 :
	* @param sqlSession
	* @param seq
	* @return
	* Method 설명 : 게시글 삭제
	 */
	@Override
	public int deleteBoard(int inum) {
		SqlSession sqlSession = MybatisUtil.getSession();
		int delete = boardDao.deleteBoard(sqlSession, inum);
		sqlSession.commit();
		sqlSession.close();
		return delete;
	}

	/**
	 * 
	* Method : updateBoard
	* 작성자 : PC-04
	* 변경이력 :
	* @param sqlSession
	* @param inum
	* @return
	* Method 설명 : 게시판 수정
	 */
	@Override
	public int updateBoard(Board board) {
		SqlSession sqlSession = MybatisUtil.getSession();
		int update = boardDao.updateBoard(sqlSession, board);
		sqlSession.commit(); 
		sqlSession.close();
		return update;
	}

}
