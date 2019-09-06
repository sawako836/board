package kr.or.ddit.attachment.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.attachment.model.Attachment;
import kr.or.ddit.attachment.repository.AttachmentDao;
import kr.or.ddit.attachment.repository.IAttachmentDao;
import kr.or.ddit.util.MybatisUtil;

public class AttachmentService implements IAttachmentService {
	private static IAttachmentDao attachmentdao;
	
	public AttachmentService() {
		attachmentdao = new AttachmentDao();
	}
	
	/**
	 * 
	* Method : getAttachmentList
	* 작성자 : PC-04
	* 변경이력 :
	* @param pnum
	* @return
	* Method 설명 : 댓글 리스트 조회
	 */
	@Override
	public List<Attachment> getAttachmentList(int pnum) {
		SqlSession sqlSession = MybatisUtil.getSession();
		List<Attachment> attachmentList = attachmentdao.getAttachmentList(sqlSession, pnum);
		sqlSession.close();
		
		return attachmentList;
	}

	/**
	 * 
	* Method : insertAttachment
	* 작성자 : PC-04
	* 변경이력 :
	* @param attachment
	* @return
	* Method 설명 : 첨부파일 추가
	 */
	@Override
	public int insertAttachment(Attachment attachment) {
		SqlSession sqlSession = MybatisUtil.getSession();
		int insert = attachmentdao.insertAttachment(sqlSession, attachment);
		sqlSession.commit();
		sqlSession.close();
		return insert;
	}

	/**
	 * 
	 * Method : getAttachment
	 * 작성자 : PC-04
	 * 변경이력 :
	 * @param anum
	 * @return
	 * Method 설명 : 첨부파일 조회
	 */
	@Override
	public Attachment getAttachment(int anum) {
		SqlSession sqlSession = MybatisUtil.getSession();
		Attachment attachment = attachmentdao.getAttachment(sqlSession, anum);
		sqlSession.commit();
		sqlSession.close();
		return attachment;
	}
	
	/**
	 * 
	* Method : deleteAttachment
	* 작성자 : PC-04
	* 변경이력 :
	* @param anum
	* @return
	* Method 설명 : 첨부파일 삭제
	 */
	@Override
	public int deleteAttachment(int anum) {
		SqlSession sqlSession = MybatisUtil.getSession();
		int delete = attachmentdao.deleteAttachment(sqlSession, anum);
		sqlSession.commit();
		sqlSession.close();
		return delete;
	}
}
