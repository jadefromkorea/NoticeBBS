package com.jade.app.vo;

public class NoticeVO extends PageVO {

	private int no;				// 글번호
	private String title;		// 제목
	private String content;		// 공지내용
	private String regDtm;		// 작성일
	private String modDtm;		// 최종수정일
	private String writer;		// 작성자
	private String flag="";		// CRUD 구분
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegDtm() {
		return regDtm;
	}
	public void setRegDtm(String regDtm) {
		this.regDtm = regDtm;
	}
	public String getModDtm() {
		return modDtm;
	}
	public void setModDtm(String modDtm) {
		this.modDtm = modDtm;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	@Override
	public String toString() {
		return "no: " + no + " | title: " + title + " | content: " + content + " | regDtm: " + regDtm + " | modDtm: " + modDtm  + " | writer: " + writer + " | writer: " + writer + "\n";
	}
}
