package kr.or.ddit.attachment.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.attachment.model.Attachment;


public interface IAttachmentService {
/**
 * 
* Method : getAttaList
* 작성자 : PC-04
* 변경이력 :
* @param pnum
* @return
* Method 설명 : 댓글 리스트 조회
 */
	public List<Attachment> getAttachmentList(int pnum);
	
	/**
	 * 
	* Method : insertAttachment
	* 작성자 : PC-04
	* 변경이력 :
	* @param attachment
	* @return
	* Method 설명 : 첨부파일 추가
	 */
	public int insertAttachment(Attachment attachment);
	
	/**
	 * 
	* Method : getAttachment
	* 작성자 : PC-04
	* 변경이력 :
	* @param anum
	* @return
	* Method 설명 : 첨부파일 조회
	 */
	public Attachment getAttachment(int anum);
	
	/**
	 * 
	 * Method : deleteAttachment
	 * 작성자 : PC-04
	 * 변경이력 :
	 * @param anum
	 * @return
	 * Method 설명 : 첨부파일 삭제
	 */
	public int deleteAttachment(int anum);
}

