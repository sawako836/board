package kr.or.ddit.post.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.post.model.Post;

public interface IPostDao {
	/**
	 * 
	* Method : getpostList
	* 작성자 : PC-04
	* 변경이력 :
	* @param sqlSession
	* @param map
	* @return
	* Method 설명 : 게시글 리스트 조회
	 */
	public List<Post> getPostPagingList(SqlSession sqlSession, Map<String, Integer> map);
	
	/**
	 * 
	* Method : getPostTotalCnt
	* 작성자 : PC-04
	* 변경이력 :
	* @param sqlSession
	* @param inum
	* @return
	* Method 설명 : 게시글 총 수량 조회
	 */
	public int getPostTotalCnt(SqlSession sqlSession, int inum);
	
	/**
	 * 
	* Method : insertPost
	* 작성자 : PC-04
	* 변경이력 :
	* @param sqlSession
	* @param post
	* @return
	* Method 설명 : 게시글 등록
	 */
	public int insertPost(SqlSession sqlSession, Post post);
	
	/**
	 * 
	* Method : getPost
	* 작성자 : PC-04
	* 변경이력 :
	* @param sqlSession
	* @param post
	* @return
	* Method 설명 : 게시글 조회
	 */
	public Post getPost(SqlSession sqlSession, Post post);
	
	/**
	 * 
	* Method : updatePost
	* 작성자 : PC-04
	* 변경이력 :
	* @param sqlSession
	* @param post
	* @return
	* Method 설명 : 게시글 수정
	 */
	public int updatePost(SqlSession sqlSession, Post post);
	
	/**
	 * 
	* Method : deletePost
	* 작성자 : PC-04
	* 변경이력 :
	* @param sqlSession
	* @param inum
	* @return
	* Method 설명 : 게시글 삭제
	 */
	public int deletePost(SqlSession sqlSession, int inum);
}
