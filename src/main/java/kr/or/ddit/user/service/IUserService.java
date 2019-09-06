package kr.or.ddit.user.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.common.model.PageBoard;
import kr.or.ddit.user.model.User;

public interface IUserService {
	
	/**
	* Method : getUserList
	* 작성자 : SEM-PC
	* 변경이력 :
	* @return
	* Method 설명 :전체 사용자 리스트 조회
	*/
	List<User> getUserList();

	/**
	* Method : getUser
	* 작성자 : SEM-PC
	* 변경이력 :
	* @param userId
	* @return
	* Method 설명 : 사용자 상세조회
	*/
	User getUser(String userId);

	/**
	 * 
	* Method : getUserPagingList
	* 작성자 : PC-04
	* 변경이력 :
	* @param sqlSession
	* @param page
	* @return
	* Method 설명 : 사용자 페이징 리스트 조회
	 */
	Map<String, Object> getUserPagingList(PageBoard page);
	
	/**
	 * 
	* Method : insertUser
	* 작성자 : PC-04
	* 변경이력 :
	* @param user
	* Method 설명 : 사용자 등록 
	 */
	int insertUser(User user);
	
	/**
	 * 
	* Method : deleteUser
	* 작성자 : PC-04
	* 변경이력 :
	* @param user
	* Method 설명 : 사용자 삭제
	 */
	int deleteUser(String userId);
	
	/**
	 * 
	* Method : updateUser
	* 작성자 : PC-04
	* 변경이력 :
	* @param sqlSession
	* @param user
	* @return
	* Method 설명 : 사용자 수정
	 */
	int updateUser(User user);

}
