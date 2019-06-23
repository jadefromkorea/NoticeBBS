package com.jade.app.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jade.app.service.NoticeService;
import com.jade.app.vo.NoticeVO;

@Controller
public class NoticeController {
	private static final Logger logger = LoggerFactory.getLogger(NoticeController.class);
	
	@Autowired
	private NoticeService noticeService;

	@RequestMapping(value = "/")
	public String homepage(Model model) {
		
		return "redirect:/getNoticeList.do?";
	}
	
	@RequestMapping("/getNoticeList.do")
	public String getNoticeList(Model model, NoticeVO noticeVO) {
		String totCnt = noticeService.selectNoticeListTotCnt();
		noticeVO.setTotCnt(Integer.parseInt(totCnt));
		
		int curPageNo = noticeVO.getCurPageNo();
		
		// 등록 후 리스트 조회시 마지막 블럭으로 조회된다.
		if(noticeVO.getFlag().equals("C")) {
			noticeVO.setTotPage(noticeVO.getTotCnt(), noticeVO.getContentCntPerPage());
			curPageNo = noticeVO.getTotPage();
		}
		
		int contentCntPerPage = noticeVO.getContentCntPerPage();
		
		noticeVO.setCurPageNo((curPageNo-1)*10);
		noticeVO.setContentCntPerPage(contentCntPerPage);
		noticeVO.setCurBlock(curPageNo);
		noticeVO.setLastBlock(noticeVO.getTotCnt());
		noticeVO.prevnext(curPageNo);
		noticeVO.setStartPage(noticeVO.getCurBlock());
		noticeVO.setEndPage(noticeVO.getLastBlock(), noticeVO.getCurBlock());
		
		List<NoticeVO> noticeList = noticeService.getNoticeList(noticeVO);
		
		noticeVO.setCurPageNo(curPageNo);
		model.addAttribute("noticeList", noticeList);
		model.addAttribute("page", noticeVO);
		
		return "noticeList";
	}

	@RequestMapping("/getNotice.do")
	public ModelAndView getNotice(@RequestParam String no) {
		NoticeVO notice = noticeService.getNotice(no); 
		return new ModelAndView("noticeDetail","notice",notice);
	}
	
	@RequestMapping("/insertNoticeForm.do")
	public String insertNoticeForm() {	
		
		return "noticeInsert";
	}
	
	@RequestMapping("/insertNotice.do")
	public String insertNotice(@ModelAttribute NoticeVO notice) {	
		if (notice != null)
			noticeService.insertNotice(notice);
		return "redirect:/getNoticeList.do?curPageNo=" + notice.getCurPageNo() + "&contentCntPerPage=" + notice.getContentCntPerPage() + "&flag=C";
	}
	
	@RequestMapping("/updateNoticeForm.do")
	public ModelAndView updateNoticeForm(@RequestParam String no) {
		NoticeVO notice = noticeService.getNotice(no); 
		return new ModelAndView("noticeUpdate","notice",notice);
	}
	
	@RequestMapping("/updateNotice.do")
	public String updateNotice(@ModelAttribute NoticeVO notice) {
		noticeService.updateNotice(notice);
		return "redirect:/getNoticeList.do?curPageNo=" + notice.getCurPageNo() + "&contentCntPerPage=" + notice.getContentCntPerPage();
	}
	
	@RequestMapping(value="/deleteNotice.do")
	public String deleteNotice(@ModelAttribute NoticeVO notice) {
		noticeService.deleteNotice(notice);
		return "redirect:/getNoticeList.do?curPageNo=" + notice.getCurPageNo() + "&contentCntPerPage=" + notice.getContentCntPerPage();
	}
	
	@ExceptionHandler
	public String handleException(Exception e) {
		return "viewError";
	}
}
