package kr.or.ddit.post.repository;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.post.model.Post;
import kr.or.ddit.util.MybatisUtil;

public class PostDaoTest {
	
	private static final Logger logger = LoggerFactory.getLogger(PostDaoTest.class);
	private IPostDao postDao;
	private SqlSession sqlSession;
	
	@Before
	public void setup() {
		logger.debug("PostDaoTestBefore()");
		postDao = new PostDao();
		sqlSession = MybatisUtil.getSession();
	}
	
	@After
	public void tearDown() {
		logger.debug("PostDaoTestAfter()");
		sqlSession.close();
	}

	@Test
	public void getPostPagingListTest() {
		/***Given***/
		int inum = 2;
		int page = 1;
		int pagesize = 2;
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("inum", inum);
		map.put("page", page);
		map.put("pagesize", pagesize);
		
		/***When***/
		List<Post> postList = postDao.getPostPagingList(sqlSession, map);

		/***Then***/
		assertEquals(11, postList.size());

	}
	
	@Test
	public void getPostTotalCnt() {
		/***Given***/
		int inum = 2;
		
		/***When***/
		int postTotalCnt = postDao.getPostTotalCnt(sqlSession, inum);

		/***Then***/
		assertEquals(2, postTotalCnt);
	}
	
	@Test
	public void insertPostTest() {
		/***Given***/
		Post post = new Post();
		post.setInum(3);
		post.setPostsubject("게시글추가제목");
		post.setPostcontent("게시글추가내용");
		post.setDeletion("y");
		post.setUserid("cony");
		
		/***When***/
		int insertCnt = postDao.insertPost(sqlSession, post);

		/***Then***/
		assertEquals(1, insertCnt);
	}
	
	@Test
	public void updatePostTest() {
		/***Given***/
		int pnum = 22;
		Post post = new Post();
		post.setPnum(pnum);
		post.setPostsubject("제목수정테스트");
		post.setPostcontent("내용수정테스트");
		
		/***When***/
		int updateCnt = postDao.updatePost(sqlSession, post);
		sqlSession.commit();

		/***Then***/
		assertEquals(1, updateCnt);
	}
	
	@Test
	public void deletePostTest() {
		/***Given***/
		int pnum = 1;
		
		/***When***/
		int deleteCnt = postDao.deletePost(sqlSession, pnum);
		sqlSession.commit();

		/***Then***/
		assertEquals(1, deleteCnt);
	}

}

