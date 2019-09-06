package kr.or.ddit.attachment.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import kr.or.ddit.attachment.model.Attachment;

public interface IAttachmentDao {
	/**
	 * 
	* Method : getAttachmentList
	* 작성자 : PC-04
	* 변경이력 :
	* @param sqlSession
	* @param pnum
	* @return
	* Method 설명 : 댓글 리스트 조회
	 */
	public List<Attachment> getAttachmentList(SqlSession sqlSession, int pnum);
	
	/**
	 * 
	* Method : insertAttachment
	* 작성자 : PC-04
	* 변경이력 :
	* @param sqlSession
	* @param attach
	* @return
	* Method 설명 : 첨부파일 추가
	 */
	public int insertAttachment(SqlSession sqlSession, Attachment attach);
	
	/**
	 * 
	 * Method : getAttachment
	 * 작성자 : PC-04
	 * 변경이력 :
	 * @param sqlSession
	 * @param anum
	 * @return
	 * Method 설명 : 첨부파일 조회
	 */
	public Attachment getAttachment(SqlSession sqlSession, int anum);
	
	/**
	 * 
	* Method : deleteAttachment
	* 작성자 : PC-04
	* 변경이력 :
	* @param sqlSession
	* @param anum
	* @return
	* Method 설명 : 첨부파일 삭제
	 */
	public int deleteAttachment(SqlSession sqlSession, int anum);
	
}
