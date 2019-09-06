package kr.or.ddit.post.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Post {
	private static final Logger logger = LoggerFactory.getLogger(Post.class);
	
	private int pnum;         	 //게시글번호
	private int inum;	     	 //게시판 번호
	private String postsubject;  //게시글 제목
	private String postcontent;  //게시글 내용
	private String userid;       //작성자
	private Date postdate;     	 //작성일시
	private String deletion;     //삭제여부
	private int pnum2;        	 //부모게시글번호
	private int posttem;		 //그룹넘버
	private int layer;			 //계층
	
	public int getPnum() {
		return pnum;
	}
	public void setPnum(int pnum) {
		this.pnum = pnum;
	}
	public int getInum() {
		return inum;
	}
	public void setInum(int inum) {
		this.inum = inum;
	}
	public String getPostsubject() {
		return postsubject;
	}
	public void setPostsubject(String postsubject) {
		this.postsubject = postsubject;
	}
	public String getPostcontent() {
		return postcontent;
	}
	public void setPostcontent(String postcontent) {
		this.postcontent = postcontent;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPostdate() {
		logger.debug("getPostdate method call");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(postdate);
	}
	public void setPostdate(Date postdate) {
		this.postdate = postdate;
	}
	public String getDeletion() {
		return deletion;
	}
	public void setDeletion(String deletion) {
		this.deletion = deletion;
	}
	public int getPnum2() {
		return pnum2;
	}
	public void setPnum2(int pnum2) {
		this.pnum2 = pnum2;
	}
	public int getPosttem() {
		return posttem;
	}
	public void setPosttem(int posttem) {
		this.posttem = posttem;
	}
	public int getLayer() {
		return layer;
	}
	public void setLayer(int layer) {
		this.layer = layer;
	}
	@Override
	public String toString() {
		return "Post [pnum=" + pnum + ", inum=" + inum + ", postsubject=" + postsubject + ", postcontent=" + postcontent
				+ ", userid=" + userid + ", postdate=" + postdate + ", deletion=" + deletion + ", pnum2=" + pnum2
				+ ", posttem=" + posttem + ", layer=" + layer + "]";
	}

}
