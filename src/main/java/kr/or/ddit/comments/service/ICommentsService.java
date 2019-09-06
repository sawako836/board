package kr.or.ddit.comments.service;

import java.util.List;


import kr.or.ddit.comments.model.Comments;


public interface ICommentsService {
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
	List<Comments> getCommentsList(int pnum);
	
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
	int insertComments(Comments comments);
	
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
	int deleteComments(int cnum);
}
