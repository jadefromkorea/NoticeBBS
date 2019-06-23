package com.jade.app.dao;

import java.util.List;

import com.jade.app.vo.NoticeVO;

public interface NoticeDao {
	public void insert(NoticeVO user);

	public List<NoticeVO> readAll(NoticeVO noticeVO);
	public String selectNoticeListTotCnt();

	public void update(NoticeVO user);

	public void delete(NoticeVO notice);

	public NoticeVO read(String no);

}
