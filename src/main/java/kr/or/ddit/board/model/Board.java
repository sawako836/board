package kr.or.ddit.board.model;

import java.util.Date;

public class Board { 
	private int inum;            //게시판 번호
	private String boardname;    //게시판 이름
	private String usagestatus;  //사용여부
	private String userid;       //등록자
	private Date pboarddate;     //등록일시
	
	public int getInum() {
		return inum;
	}
	public void setInum(int inum) {
		this.inum = inum;
	}
	public String getBoardname() {
		return boardname;
	}
	public void setBoardname(String boardname) {
		this.boardname = boardname;
	}
	public String getUsagestatus() {
		return usagestatus;
	}
	public void setUsagestatus(String usagestatus) {
		this.usagestatus = usagestatus;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public Date getPboarddate() {
		return pboarddate;
	}
	public void setPboarddate(Date pboarddate) {
		this.pboarddate = pboarddate;
	}
	@Override
	public String toString() {
		return "IBoard [inum=" + inum + ", boardname=" + boardname + ", usagestatus=" + usagestatus + ", userid="
				+ userid + ", pboarddate=" + pboarddate + "]";
	}
	
}
