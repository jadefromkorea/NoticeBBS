<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>공지사항</title>
<link type="text/css" rel="stylesheet" href="/resources/css/notice.css"/>
<script type="text/javascript">
function page(idx){
	var curPageNo = idx;
	var contentCntPerPage = 10;
	location.href="getNoticeList.do?curPageNo=" +curPageNo + "&contentCntPerPage=" + contentCntPerPage;
}
</script>

</head>
<body style="text-align:center; margin:0 auto; display:inline; padding-top:100px;">
	<!-- 타이틀 -->
   	<div id="title">
   		<ul>
   			<li><img src="/resources/images/notice/title_dot.gif" alt=""/>공지사항 리스트</li>
   		</ul>
   	</div>
        	
	<!-- List -->
    <div id="table">
		<table width="1000" align="left" border="1" cellpadding="1" cellspacing="0">
			<colgroup>
   				<col width="10%"/>
   				<col width="40%"/>
   				<col width="20%"/>
   				<col width="20%"/>
   				<col width="10%"/>
   			</colgroup>
   			<thead>
				<tr>
					<th align="center">글번호</th>
					<th align="center">제목</th>
					<th align="center">작성일</th>
					<th align="center">최종수정일</th>
					<th align="center">작성자</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="notice" items="${noticeList}">
				<tr>
					<td align="center">${notice.no}</td>
					<td align="center">
					<a href="getNotice.do?no=${notice.no}&curPageNo=${page.curPageNo}&contentCntPerPage=${page.contentCntPerPage}">${notice.title}</a>
					</td>
					<td align="center">${notice.regDtm}</td>
					<td align="center">${notice.modDtm}</td>
					<td align="center">${notice.writer}</td>
				</tr>
				</c:forEach>
			</tbody>	
			<tfoot>
				<tr>
					<td colspan="5">
						<c:if test="${page.prev}">
							<a style="text-decoration: none;" href="javascript:page(${page.startPage-1});"><img src="/resources/images/notice/btn_page_pre10.gif"></a>
						</c:if>
						<c:forEach begin="${page.startPage}" end="${page.endPage}" var="idx">
							<a style="text-decoration: none;" href="javascript:page(${idx});">${idx}</a>
						</c:forEach>
						
						
						<c:if test="${page.next}">
							<a style="text-decoration: none;" href="javascript:page(${page.endPage+1});"><img src="/resources/images/notice/btn_page_next10.gif"></a>
						</c:if>
					</td>
				</tr>
				<tr>
					<td colspan="5">
						<input type="button" onClick="location.href='insertNoticeForm.do?curPageNo=${page.curPageNo}&contentCntPerPage=${page.contentCntPerPage}'" value="등록"/>
					</td>
				</tr>
			</tfoot>
		</table>
	</div>
</body>
</html>

