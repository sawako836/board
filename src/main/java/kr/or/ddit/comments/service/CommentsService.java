package kr.or.ddit.comments.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.comments.model.Comments;
import kr.or.ddit.comments.repository.CommentsDao;
import kr.or.ddit.comments.repository.ICommentsDao;
import kr.or.ddit.util.MybatisUtil;

public class CommentsService implements ICommentsService {
	
	private static ICommentsService commentsService;
	
	public static ICommentsService getInstance() {
		if(commentsService == null) {
			commentsService = new CommentsService();
		}
		return commentsService;
	}
	
	private ICommentsDao commentsDao;
	
	private CommentsService() {
		commentsDao = CommentsDao.getInstance();
	}

	@Override
	public List<Comments> getCommentsList(int pnum) {
		SqlSession sqlSession = MybatisUtil.getSession();
		List<Comments> commentsList = commentsDao.getCommentsList(sqlSession, pnum);
		sqlSession.close();
		return commentsList;
	}

	@Override
	public int insertComments(Comments comments) {
		SqlSession sqlSession = MybatisUtil.getSession();
		int insertCnt = commentsDao.insertComments(sqlSession, comments);
		sqlSession.commit();
		sqlSession.close();
		return insertCnt;
	}

	@Override
	public int deleteComments(int cnum) {
		SqlSession sqlSession = MybatisUtil.getSession();
		int deleteCnt = commentsDao.deleteComments(sqlSession, cnum);
		sqlSession.commit();
		sqlSession.close();
		return deleteCnt;
	}

}
