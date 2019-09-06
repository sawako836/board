package kr.or.ddit.post.service;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.common.model.PageBoard;
import kr.or.ddit.post.model.Post;

public class PostServiceTest {
	
	private static final Logger logger = LoggerFactory.getLogger(PostServiceTest.class);
	private IPostService postService;
	
	@Before
	public void setup() {
		logger.debug("PostServiceTestBefore()");
		postService = PostService.getInstance();
	}

	@Test
	public void getPostPagingList() {
		/***Given***/
		int inum = 2;
		int page = 1;
		int pagesize = 2;
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("inum", inum);
		map.put("page", page);
		map.put("pagesize", pagesize);
		
		/***When***/
		Map<String, Object> resultMap = postService.getPostPagingList(map, inum);
		
		List<Post> postList = (List<Post>) resultMap.get("postList");
		int paginationSize = (int) resultMap.get("paginationSize");

		/***Then***/
		assertEquals(0, postList.size());
		assertEquals(2147483647, paginationSize);
	}
	
	@Test
	public void insertPostTest() {
		/***Given***/
		int pnum = 1;
		Post post = new Post();
		post.setInum(3);
		post.setPostsubject("추가테스트제목");
		post.setPostcontent("추가테스트내용");
		post.setDeletion("y");
		post.setUserid("cony");
		
		/***When***/
		pnum = postService.insertPost(post);

		/***Then***/
		assertEquals(1, pnum);
	}
	
	@Test
	public void updatePostTest() {
		/***Given***/
		int pnum = 1;
		Post post = new Post();
		post.setPnum(1);
		post.setPostsubject("수정제목테스트");
		post.setPostcontent("수정내용테스트");
		
		/***When***/
		int updateCnt = postService.updatePost(post);

		/***Then***/
		assertEquals(1, updateCnt);
	}
	
	@Test
	public void deletePostTest() {
		/***Given***/
		int pnum = 1;
		
		/***When***/
		int deleteCnt = postService.deletePost(pnum);

		/***Then***/
		assertEquals(1, deleteCnt);
	}

}
