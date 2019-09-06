package kr.or.ddit.comments.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.comments.model.Comments;


public interface ICommentsDao {
	/**
	 * 
	* Method : getCommentsList
	* 작성자 : PC-04
	* 변경이력 :
	* @param sqlSession
	* @param pnum
	* @return
	* Method 설명 : 댓글 리스트 조회
	 */
	List<Comments> getCommentsList(SqlSession sqlSession, int pnum);
	
	/**
	 * 
	* Method : insertComments
	* 작성자 : PC-04
	* 변경이력 :
	* @param sqlSession
	* @param comments
	* @return
	* Method 설명 : 댓글 추가
	 */
	int insertComments(SqlSession sqlSession, Comments comments);
	
	/**
	 * 
	* Method : deleteComments
	* 작성자 : PC-04
	* 변경이력 :
	* @param sqlSession
	* @param cnum
	* @return
	* Method 설명 : 댓글 삭제
	 */
	int deleteComments(SqlSession sqlSession, int cnum);
}
