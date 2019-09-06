package kr.or.ddit.board.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.board.model.Board;

public interface IBoardService {
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
	int insertBoard(Board board);
	
	/**
	 * 
	* Method : getBoardList
	* 작성자 : PC-04
	* 변경이력 :
	* @param sqlSession
	* @return
	* Method 설명 : 게시판 리스트 조회
	 */
	List<Board> getBoardList();

	/**
	 * 
	* Method : deleteBoard
	* 작성자 : PC-04
	* 변경이력 :
	* @param sqlSession
	* @param inum
	* @return
	* Method 설명 : 게시판 삭제
	 */
	int deleteBoard(int inum);
	
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
	int updateBoard(Board board);
}
