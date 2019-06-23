<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>공지사항 등록</title>
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
   			<li><img src="/resources/images/notice/title_dot.gif" alt=""/>공지사항 등록</li>
   		</ul>
   	</div>
        	
    <div id="table">
	    <form method="post" action="insertNotice.do?curPageNo=<%=curPageNo %>&contentCntPerPage=<%=contentCntPerPage %>"  >
			<table width="1000" align="left" border="1" cellpadding="1" cellspacing="0">
				<colgroup>
	   				<col width="10%"/>
	   				<col width="90%"/>
	   			</colgroup>
				<tr>
					<th align="center">제목</th> <td><input type="text" name="title" class="txt" style="width:95%"/></td>
				</tr>
				<tr>
					<th align="center">내용</th> <td align="left"class="tbtd_content"><textarea cols="120" rows="5" name="content" class="txt"></textarea></td>
				</tr>
				<tr>
				<!-- 
					<th align="center">작성일</th> <td align="center"><input type="text" name="regDtm" class="essentiality" class="datepicker" id="date1" readonly/></td>
					<th align="center">최종수정일</th> <td align="center"><input type="text" name="modDtm" class="essentiality" class="datepicker" id="date2" readonly/></td>
				 -->
					<th align="center">작성자</th> <td align="left"><input type="text" name="writer" class="txt" style="width:25%"/></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="저장" />
						<input type="button" value="목록" onClick="location.href='getNoticeList.do?curPageNo=<%=curPageNo %>&contentCntPerPage=<%=contentCntPerPage %>'" />
					</td>
				</tr>
			</table>
		</form>
	</div>
	
	
	
	</body>
</html>

