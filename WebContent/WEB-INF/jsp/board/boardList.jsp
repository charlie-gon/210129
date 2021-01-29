<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 목록</title>

<style>
tr.row:hover {
	background: turquoise;
	cursor: pointer;
}

#main {
	position: absolute;
	top: 10%;
	left: 50%;
	margin: -150px 0 0 -200px;
}

table{
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

td, th {
  border: 1px solid #dddddd;
  padding: 8px;
}

tr:nth-child(even) {
  background-color: #dddddd;
}

</style>
<!-- 스크립트 작업 영역 -->   
<!-- 글 상세보기 시 post방법으로 데이터 전달 --> 
<script>
	function formSubmit(str){
		frm.bId.value = str;
		frm.submit();
	}
</script>    


<jsp:include page="../main/menu.jsp" />
<body>
<!-- Page content -->
<div class="w3-content" style="max-width: 2000px; margin-top: 46px" align="center" id="main">

	<div align="center">
		<h1>게시글 목록</h1>
		<!-- formSubmit 메소드에 값 전달하기 위한 히든 form -->
		<div>
			<form id="frm" name="frm" action="boardView.do" method="post">
				<input type="hidden" id="bId" name="bId">
			</form>
		</div>
		
	</div>
	<div align="center">
		<table border="1">
			<tr>
				<th width="100">글번호</th>
				<th width="100">제목</th>
				<th width="100">작성자</th>
				<th width="100">작성일자</th>
				<th width="100">조회수</th>
			</tr>

			<c:if test="${empty list }">
				<tr>
					<td colspan="5" align="center">게시글이 없습니다.</td>
				</tr>
			</c:if>

			<c:if test="${not empty list }">
				<c:forEach var="vo" items="${list }">
					<tr align="center" class="row" onclick="formSubmit(${vo.bId })">
						<td>${vo.bId }</td>
						<td>${vo.bTitle }</td>
						<td>${vo.bName }</td>
						<td>${vo.bDate }</td>
						<td>${vo.bHit }</td>
					</tr>
				</c:forEach>
			</c:if>
		</table>
		<p />
		<div>
			<button type="button" onclick="location.href='boardInputForm.do'">글쓰기</button>&nbsp;&nbsp;&nbsp;
		</div>
		
	</div>

</div>
</body>
</html>