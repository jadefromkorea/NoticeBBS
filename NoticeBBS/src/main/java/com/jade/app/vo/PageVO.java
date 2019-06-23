package com.jade.app.vo;

public class PageVO {

	private int totCnt;					// 전체 게시물 개수
	private int pagePerBlock = 10;		// 한블록 당 페이지 수
	private int curPageNo = 1;			// 현재 페이지 번호
	private int contentCntPerPage = 10;	// 한페이지에 몇개 보일지
	private int startPage = 1;			// 현재 페이지 블록의 시작 페이지
	private int endPage = pagePerBlock;	// 현재 페이지 블록의 끝 페이지
	private boolean prev = false;		// 이전 페이지로 가는 화살표
	private boolean next;				// 다음 페이지로 가는 화살표
	private int curBlock;				// 현재 페이지 블록
	private int lastBlock;				// 마지막 페이지 블록
	private int totPage = 0;			//전체 페이지 수
	
	public void prevnext(int curPageNo) {
		if(getLastBlock() == 1) {
			setPrev(false);
			setNext(false);
		}
		else if(curPageNo>0 && curPageNo<6) {
			setPrev(false);
			setNext(true);
		}
		else if(getLastBlock() == getCurBlock()){
			setPrev(true);
			setNext(false);
		}
		else {
			setPrev(true);
			setNext(true);
		}
	}
	
	public int calcpage(int totCnt, int contentCntPerPage) {
		int totPage = totCnt / contentCntPerPage;
		if(totCnt % contentCntPerPage >0) totPage++;
		
		return totPage++;
	}
	
	public int getTotCnt() {
		return totCnt;
	}
	public void setTotCnt(int totCnt) {
		this.totCnt = totCnt;
	}
	public int getPagePerBlock() {
		return pagePerBlock;
	}

	public void setPagePerBlock(int pagePerBlock) {
		this.pagePerBlock = pagePerBlock;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getCurPageNo() {
		return curPageNo;
	}
	public void setCurPageNo(int curPageNo) {
		this.curPageNo = curPageNo;
	}
	public int getContentCntPerPage() {
		return contentCntPerPage;
	}
	public void setContentCntPerPage(int contentCntPerPage) {
		this.contentCntPerPage = contentCntPerPage;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int curBlock) {
		this.startPage = (curBlock*pagePerBlock)-(pagePerBlock-1);
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int getlastbolck, int getcurBlock) {
		if(getlastbolck == getcurBlock) {
			this.endPage = calcpage(getTotCnt(), getContentCntPerPage());
		}
		else this.endPage = getStartPage()+(pagePerBlock-1);
	}
	public boolean isPrev() {
		return prev;
	}
	public void setPrev(boolean prev) {
		this.prev = prev;
	}
	public boolean isNext() {
		return next;
	}
	public void setNext(boolean next) {
		this.next = next;
	}
	public int getCurBlock() {
		return curBlock;
	}
	public void setCurBlock(int curPageNo) {
		// 페이지 번호를 통해서 구한다.
		this.curBlock = curPageNo/pagePerBlock;
		if(curPageNo%pagePerBlock>0) {
			this.curBlock++;
		}
	}
	public int getLastBlock() {
		return lastBlock;
	}
	public void setLastBlock(int totCnt) {
		this.lastBlock = totCnt / (pagePerBlock*this.contentCntPerPage);
		if((totCnt % (pagePerBlock*this.contentCntPerPage))>0) {
			this.lastBlock++;
		}
	}

	public int getTotPage() {
		return totPage;
	}

	public int setTotPage(int totCnt, int contentCntPerPage) {
		totPage = totCnt / contentCntPerPage;
		if(totCnt % contentCntPerPage >0) totPage++;
		
		return totPage;
	}

	public String toString1() {
		return "totCnt: " + totCnt + " | curPageNo: " + curPageNo + " | contentCntPerPage: " + contentCntPerPage + " | startPage: " + startPage + " | endPage: " + endPage  
				+ " | prev: " + prev + " | next: " + next + " | curBlock: " + curBlock+ "| lastBlock: " + lastBlock + "| totPage: " + totPage +"\n";
	}
	
}
