<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>공지사항 수정</title>
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
   			<li><img src="/resources/images/notice/title_dot.gif" alt=""/>공지사항 수정</li>
   		</ul>
   	</div>
        	
    <div id="table">
	    <form method="post" action="updateNotice.do?curPageNo=<%=curPageNo %>&contentCntPerPage=<%=contentCntPerPage %>"  >
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
					<input type="hidden" name="no" value="${notice.no }"/>
					<th align="center">제목</th> <td colspan="3"><input type="text" value="${notice.title}" name="title"  style="width:95%"/></td>
					<th align="center">글번호</th> <td align="center">${notice.no}</td>
				</tr>
				<tr>
					<th align="center">내용</th> <td colspan="5" align="left"class="tbtd_content"><textarea cols="120" rows="5" name="content">${notice.content}</textarea></td>
				</tr>
				<tr>
					<th align="center">작성일</th> <td align="center"><input type="text" value="${notice.regDtm}" name="regDtm" class="essentiality" readonly style="width:95%"/></td>
					<th align="center">최종수정일</th> <td align="center"><input type="text" value="${notice.modDtm}" name="modDtm" class="essentiality" readonly style="width:95%"/></td>
					<th align="center">작성자</th> <td align="center"><input type="text" value="${notice.writer}" name="writer" style="width:95%"/></td>
				</tr>
				<tr>
					<td colspan="6" align="center">
						<input type="submit" value="저장" />
						<input type="button" value="목록" onClick="location.href='getNoticeList.do?curPageNo=<%=curPageNo %>&contentCntPerPage=<%=contentCntPerPage %>'" />
					</td>
				</tr>
			</table>
		</form>
	</div>
	
	
	</body>
</html>

