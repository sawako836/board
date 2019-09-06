package kr.or.ddit.attachment.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.attachment.model.Attachment;

public class AttachmentDao implements IAttachmentDao {
	
	private static IAttachmentDao attachmentDao;
	
	public static IAttachmentDao getInstance() {
		if(attachmentDao == null) {
			attachmentDao = new AttachmentDao();
		}
		return attachmentDao;
	}
	
	@Override
	public List<Attachment> getAttachmentList(SqlSession sqlSession, int pnum) {
		return sqlSession.selectList("attachment.getAttachmentList", pnum);
	}

	@Override
	public int insertAttachment(SqlSession sqlSession, Attachment attachment) {
		return sqlSession.insert("attachment.insertAttachment", attachment);
	}

	@Override
	public Attachment getAttachment(SqlSession sqlSession, int anum) {
		return sqlSession.selectOne("attachment.getAttachment", anum);
	}
	
	@Override
	public int deleteAttachment(SqlSession sqlSession, int anum) {
		return sqlSession.delete("attachment.deleteAttachment", anum);
	}


}
