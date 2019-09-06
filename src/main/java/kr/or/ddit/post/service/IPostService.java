package kr.or.ddit.post.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.post.model.Post;

public interface IPostService {
	/**
	 * 
	* Method : getpostList
	* 작성자 : PC-04
	* 변경이력 :
	* @param map
	* @param inum
	* @return
	* Method 설명 : 게시글 리스트 조회
	 */
	public Map<String, Object> getPostPagingList(Map<String, Integer> map, int inum);
	
	/**
	 * 
	* Method : getPost
	* 작성자 : PC-04
	* 변경이력 :
	* @param post
	* @return
	* Method 설명 : 게시글 조회
	 */
	public Post getPost(int pnum);
	
	/**
	 * 
	* Method : insertPost
	* 작성자 : PC-04
	* 변경이력 :
	* @param post
	* @return
	* Method 설명 : 게시글 등록
	 */
	public int insertPost(Post post);
	
	/**
	 * 
	* Method : updatePost
	* 작성자 : PC-04
	* 변경이력 :
	* @param post
	* @return
	* Method 설명 : 게시글 수정
	 */
	public int updatePost(Post post);
	
	/**
	 * 
	* Method : deletePost
	* 작성자 : PC-04
	* 변경이력 :
	* @param pnum
	* @return
	* Method 설명 : 게시글 삭제
	 */
	public int deletePost(int pnum);
}
