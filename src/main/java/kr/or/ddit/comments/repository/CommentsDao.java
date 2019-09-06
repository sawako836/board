package kr.or.ddit.comments.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.comments.model.Comments;


public class CommentsDao implements ICommentsDao {
	
	private static ICommentsDao commentsDao;
	
	public static ICommentsDao getInstance() {
		if(commentsDao == null) {
			commentsDao = new CommentsDao();
		}
		return commentsDao;
	}
	
	@Override
	public List<Comments> getCommentsList(SqlSession sqlSession, int pnum) {
		return sqlSession.selectList("comments.getCommentsList", pnum);
	}

	@Override
	public int insertComments(SqlSession sqlSession, Comments comments) {
		return sqlSession.insert("comments.insertComments", comments);
	}

	@Override
	public int deleteComments(SqlSession sqlSession, int cnum) {
		return sqlSession.update("comments.deleteComments", cnum);
	}

}
