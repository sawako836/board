package kr.or.ddit.attachment.model;

public class Attachment {
	private int anum;                //첨부파일번호
	private String uploadname;       //업로드파일명
	private String filepath;         //실제파일경로
	private int pnum;                //게시글번호
	
	public int getAnum() {
		return anum;
	}
	public void setAnum(int anum) {
		this.anum = anum;
	}
	public String getUploadname() {
		return uploadname;
	}
	public void setUploadname(String uploadname) {
		this.uploadname = uploadname;
	}
	public String getFilepath() {
		return filepath;
	}
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	public int getPnum() {
		return pnum;
	}
	public void setPnum(int pnum) {
		this.pnum = pnum;
	}
	@Override
	public String toString() {
		return "Attachment [anum=" + anum + ", uploadname=" + uploadname + ", filepath=" + filepath + ", pnum=" + pnum
				+ "]";
	}
		
}
