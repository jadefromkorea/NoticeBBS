package com.jade.app.service;

import java.util.List;

import com.jade.app.vo.NoticeVO;

public interface NoticeService {
	
	public void insertNotice(NoticeVO notice);

	public List<NoticeVO> getNoticeList(NoticeVO noticeVO);
	public String selectNoticeListTotCnt();

	public void deleteNotice(NoticeVO notice);

	public NoticeVO getNotice(String no);

	public void updateNotice(NoticeVO notice);
}
