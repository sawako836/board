package kr.or.ddit.board.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.board.model.Board;
import kr.or.ddit.post.model.Post;

public interface IBoardDao {

	/**
	 * 
	* Method : insertBoard
	* 작성자 : PC-04
	* 변경이력 :
	* @param sqlSession
	* @param board
	* @return
	* Method 설명 : 게시판 생성
	 */
	int insertBoard(SqlSession sqlSession, Board board);
	
	/**
	 * 
	* Method : getBoardList
	* 작성자 : PC-04
	* 변경이력 :
	* @param sqlSession
	* @return
	* Method 설명 : 게시판 리스트 조회
	 */
	List<Board> getBoardList(SqlSession sqlSession);

	/**
	 * 
	* Method : deleteBoard
	* 작성자 : PC-04
	* 변경이력 :
	* @param sqlSession
	* @param seq
	* @return
	* Method 설명 : 게시판 삭제
	 */
	int deleteBoard(SqlSession sqlSession, int inum);
	
	/**
	 * 
	* Method : updateBoard
	* 작성자 : PC-04
	* 변경이력 :
	* @param sqlSession
	* @param seq
	* @return
	* Method 설명 : 게시판 수정
	 */
	int updateBoard(SqlSession sqlSession, Board board);

}

