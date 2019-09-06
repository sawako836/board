package kr.or.ddit.comments.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Comments {
	private int cnum;        	//댓글번호
	private String cmtcont;     //내용
	private Date cdate;         //작성일시
	private int pnum;        	//게시글번호
	private String userid;      //사용자아이디
	private String cmtdeletion; //삭제여부
	
	public int getCnum() {
		return cnum;
	}
	public void setCnum(int cnum) {
		this.cnum = cnum;
	}
	public String getCmtcont() {
		return cmtcont;
	}
	public void setCmtcont(String cmtcont) {
		this.cmtcont = cmtcont;
	}
	public Date getCdate() {
		return cdate;
	}
	public String getCdate_fmt() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(cdate);
	}
	public void setCdate(Date cdate) {
		this.cdate = cdate;
	}
	public int getPnum() {
		return pnum;
	}
	public void setPnum(int pnum) {
		this.pnum = pnum;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getCmtdeletion() {
		return cmtdeletion;
	}
	public void setCmtdeletion(String cmtdeletion) {
		this.cmtdeletion = cmtdeletion;
	}
	@Override
	public String toString() {
		return "Comments [cnum=" + cnum + ", cmtcont=" + cmtcont + ", cdate=" + cdate + ", pnum=" + pnum + ", userid="
				+ userid + ", cmtdeletion=" + cmtdeletion + "]";
	}
	
}                       
