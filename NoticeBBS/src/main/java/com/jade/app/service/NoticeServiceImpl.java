package com.jade.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jade.app.dao.NoticeDao;
import com.jade.app.vo.NoticeVO;

@Service("noticeService")
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	NoticeDao noticeDao;

	public void insertNotice(NoticeVO notice) {
		noticeDao.insert(notice);
	}

	public List<NoticeVO> getNoticeList(NoticeVO noticeVO) {
		return noticeDao.readAll(noticeVO);
	}
	public String selectNoticeListTotCnt() {
		return noticeDao.selectNoticeListTotCnt();
	}

	public void deleteNotice(NoticeVO notice) {
		noticeDao.delete(notice);
		
	}

	public NoticeVO getNotice(String no) {
		return noticeDao.read(no);
	}

	public void updateNotice(NoticeVO notice) {
		noticeDao.update(notice);
		
	}
}
