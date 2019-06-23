package com.jade.app.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jade.app.vo.NoticeVO;

@Repository("noticeDao")
public class NoticeDaoImpl implements NoticeDao {

	@Autowired
    private SqlSession session;
	
	public NoticeVO read(String no) {
		NoticeVO notice  = session.selectOne("notice.selectNoticeByNo", no);
		return notice;
	}

	public List<NoticeVO> readAll(NoticeVO noticeVO) {
		List<NoticeVO> noticeList = session.selectList("notice.selectNoticeList", noticeVO);
		return noticeList;
	}
	public String selectNoticeListTotCnt() {
		String totCnt = session.selectOne("notice.selectNoticeListTotCnt");
		return totCnt;
	}
	
	public void insert(NoticeVO notice) {
		session.insert("notice.insertNotice", notice);
		System.out.println("등록된 Record no=" + notice.getNo() );
	}

	public void update(NoticeVO notice) {
		session.update("notice.updateNotice", notice);
	}

	public void delete(NoticeVO notice) {
		session.delete("notice.deleteNotice", notice);
		System.out.println("삭제된 Record no = " + notice.getNo() ); 
	}




	

}
