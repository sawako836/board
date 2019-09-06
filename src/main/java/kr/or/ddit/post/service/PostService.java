package kr.or.ddit.post.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.post.model.Post;
import kr.or.ddit.post.repository.IPostDao;
import kr.or.ddit.post.repository.PostDao;
import kr.or.ddit.util.MybatisUtil;

public class PostService implements IPostService {
	
	private static IPostService postService;
	
	public static IPostService getInstance() {
		if(postService == null) {
			postService = new PostService();
		}
		return postService;
	}
	
	private IPostDao postDao;
	
	private PostService() {
		postDao = PostDao.getInstance();
	}

	@Override
	public Map<String, Object> getPostPagingList(Map<String, Integer> map, int inum) {
		SqlSession sqlSession = MybatisUtil.getSession();
		List<Post> postList = postDao.getPostPagingList(sqlSession, map);
		int postTotalCnt = postDao.getPostTotalCnt(sqlSession, inum);
		sqlSession.close();
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("postList", postList);
		resultMap.put("paginationSize", (int) Math.ceil((double)postTotalCnt/map.get("pagesize")));
		
		return resultMap;
	}

	@Override
	public Post getPost(int pnum) {
		SqlSession sqlSession = MybatisUtil.getSession();
		Post resultPost = postDao.getPost(sqlSession, pnum);
		sqlSession.close();
		return resultPost;
	}

	@Override
	public int updatePost(Post post) {
		SqlSession sqlSession = MybatisUtil.getSession();
		int updateCnt = postDao.updatePost(sqlSession, post);
		sqlSession.commit();
		sqlSession.close();
		return updateCnt;
	}

	@Override
	public int deletePost(int pnum) {
		SqlSession sqlSession = MybatisUtil.getSession();
		int deleteCnt = postDao.deletePost(sqlSession, pnum);
		sqlSession.commit();
		sqlSession.close();
		return deleteCnt;
	}

	@Override
	public int insertPost(Post post) {
		SqlSession sqlSession = MybatisUtil.getSession();
		postDao.insertPost(sqlSession, post);
		int pnum = post.getPnum();
		sqlSession.commit();
		sqlSession.close();
		return pnum;
	}

}
