package com.jade.app.vo;

public class PageVO {

	private int totCnt;					// ��ü �Խù� ����
	private int pagePerBlock = 10;		// �Ѻ�� �� ������ ��
	private int curPageNo = 1;			// ���� ������ ��ȣ
	private int contentCntPerPage = 10;	// ���������� � ������
	private int startPage = 1;			// ���� ������ ����� ���� ������
	private int endPage = pagePerBlock;	// ���� ������ ����� �� ������
	private boolean prev = false;		// ���� �������� ���� ȭ��ǥ
	private boolean next;				// ���� �������� ���� ȭ��ǥ
	private int curBlock;				// ���� ������ ���
	private int lastBlock;				// ������ ������ ���
	private int totPage = 0;			//��ü ������ ��
	
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
		// ������ ��ȣ�� ���ؼ� ���Ѵ�.
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
