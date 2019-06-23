<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>공지사항 상세</title>
<link type="text/css" rel="stylesheet" href="/resources/css/notice.css"/>
</head>
<%
String curPageNo = request.getParameter("curPageNo");
String contentCntPerPage = request.getParameter("contentCntPerPage");
%>
	<body>
	<!-- 타이틀 -->
   	<div id="title">
   		<ul>
   			<li><img src="/resources/images/notice/title_dot.gif" alt=""/>공지사항 상세</li>
   		</ul>
   	</div>
        	
    <div id="table">
		<table width="1000" align="left" border="1" cellpadding="1" cellspacing="0">
			<colgroup>
   				<col width="10%"/>
   				<col width="30%"/>
   				<col width="10%"/>
   				<col width="20%"/>
   				<col width="10%"/>
   				<col width="20%"/>
   			</colgroup>
			<tr>
				<th align="center">글번호</th> <td align="center">${notice.no}</td>
				<th align="center">제목</th> <td align="left" colspan="3"  class="tbtd_content">${notice.title}</td>
			</tr>
			<tr>
				<th align="center">내용</th> <td align="left" colspan="5" class="tbtd_content">${notice.content}</td>
			</tr>
			<tr>
				<th align="center">작성일</th> <td align="center">${notice.regDtm}</td>
				<th align="center">최종수정일</th> <td align="center">${notice.modDtm}</td>
				<th align="center">작성자</th> <td align="center">${notice.writer}</td>
			</tr>
			<tr>
				<td colspan="6" align="center">
					<input type="button" value="목록" onClick="location.href='getNoticeList.do?curPageNo=<%=curPageNo %>&contentCntPerPage=<%=contentCntPerPage %>'" />
					<input type="button" value="수정" onClick="location.href='updateNoticeForm.do?no=${notice.no}&curPageNo=<%=curPageNo %>&contentCntPerPage=<%=contentCntPerPage %>'" />
					<input type="button" value="삭제" onClick="location.href='deleteNotice.do?no=${notice.no}&curPageNo=<%=curPageNo %>&contentCntPerPage=<%=contentCntPerPage %>'" />
				</td>
			</tr>
		</table>
	</div>
	</body>
</html>

