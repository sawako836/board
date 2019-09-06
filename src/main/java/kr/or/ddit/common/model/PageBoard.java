package kr.or.ddit.common.model;

public class PageBoard {
	private int page;
	private int pagesize;
	
	// 기본생성자를 임의적으로 만듬.
	public PageBoard() {	
	}
	
	public PageBoard(int page, int pagesize) {
		this.page = page;
		this.pagesize = pagesize;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	
}
