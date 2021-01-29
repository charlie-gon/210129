<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 수정 Form</title>
</head>

<style>
	#bContent{
		background-color:rgb(255, 255, 204);
	}
	
	#main {
	position: absolute;
	top: 10%;
	left: 50%;
	margin: -150px 0 0 -500px;
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
</style>

<script>
	function editAlert(){
		frm.action = "boardUpdateComplete.do";
		frm.submit();
	}
	
	function editCancel(){
		frm.action = "boardView.do";
		frm.submit();
	}
	
</script>

<jsp:include page="../main/menu.jsp" />

<!-- Page content -->
<div class="w3-content" style="max-width: 2000px; margin-top: 46px" align="center" id="main">

<div align="center">

		<h1>게시글 수정 페이지</h1>
		
		<!-- Hidden Form for editAlert() -->
		<!-- BoardDAO update 쿼리문에는 bId를 받아오면 해당 bContent 수정을 진행하므로 -->
		<!-- bId 값을 받아오기 위해 hidden form을 생성하여 bId값을 받아오도록 한다 -->
		<div>
			<form id="frm" name="frm" method="post">
				<input type="hidden" id="bId" name="bId" value="${vo.bId }">

				<table border="1">
					<tr>
						<th width="100">작성자</th>
						<td align="center">${vo.bName }</td>
						<th width="100">작성일자</th>
						<td align="center">${vo.bDate }</td>
						<th width="100">조회수</th>
						<td align="center">${vo.bHit }</td>
					</tr>
					<tr>
						<th width="100">제목</th>
						<td align="center" colspan="5">${vo.bTitle }</td>
					</tr>
					<tr>
						<th width="50">내용</th>
						<td colspan="7"><textarea rows="10" cols="100" required="required" id="bContent" name="bContent">${vo.bContent }</textarea></td>
					</tr>
				</table>

				<p />
				<div>
					<button type="button" onclick="editAlert()">수정완료</button>
					&nbsp;&nbsp;
					<button type="reset" onclick="editCancel()">취소</button>
					&nbsp;&nbsp;
					<button type="button" onclick="location.href='/210129/boardList.do'">목록으로 이동</button>
				</div>
			</form>
		</div>
	</div>
</div>

</html>