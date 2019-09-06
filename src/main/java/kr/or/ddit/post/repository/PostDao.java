package kr.or.ddit.post.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.post.model.Post;

public class PostDao implements IPostDao {
	
	private static IPostDao postDao;
	
	public static IPostDao getInstance() {
		if(postDao == null) {
			postDao = new PostDao();
		}
		return postDao;
	}
	
	@Override
	public List<Post> getPostPagingList(SqlSession sqlSession, Map<String, Integer> map) {
		return sqlSession.selectList("post.getPostPagingList", map);
	}

	@Override
	public int getPostTotalCnt(SqlSession sqlSession, int inum) {
		return sqlSession.selectOne("post.getPostTotalCnt", inum);
	}

	@Override
	public int insertPost(SqlSession sqlSession, Post post) {
		return sqlSession.insert("post.insertPost", post);
	}

	@Override
	public Post getPost(SqlSession sqlSession, Post post) {
		return sqlSession.selectOne("post.getPost", post);
	}

	@Override
	public int updatePost(SqlSession sqlSession, Post post) {
		return sqlSession.update("post.updatePost", post);
	}

	@Override
	public int deletePost(SqlSession sqlSession, int pnum) {
		return sqlSession.delete("post.deletePost", pnum);
	}

}
