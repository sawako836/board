package kr.or.ddit.board.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.board.model.Board;

public class BoardDao implements IBoardDao {

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
	public int insertBoard(SqlSession sqlSession, Board board) {
		return sqlSession.insert("board.insertBoard", board);
	}

	/**
	 * 
	* Method : getBoardList
	* 작성자 : PC-04
	* 변경이력 :
	* @param sqlSession
	* @return
	* Method 설명 : 게시글 리스트 조회
	 */
	@Override
	public List<Board> getBoardList(SqlSession sqlSession) {
		return sqlSession.selectList("board.getBoardList");
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
	public int deleteBoard(SqlSession sqlSession, int inum) {
		return sqlSession.delete("board.deleteBoard", inum);
	}

	/**
	 * 
	* Method : updateBoard
	* 작성자 : PC-04
	* 변경이력 :
	* @param sqlSession
	* @param seq
	* @return
	* Method 설명 : 게시글 수정
	 */
	@Override
	public int updateBoard(SqlSession sqlSession, Board board) {
		return sqlSession.update("board.updateBoard", board);
	}

}
