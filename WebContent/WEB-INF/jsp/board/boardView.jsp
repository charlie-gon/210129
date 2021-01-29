<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세 페이지</title>

<style>

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

.replyColumn{
	background-color: #dddddd;
}

</style>

<!-- 스크립트 작업 영역 --> 
<script>
	function deleteAlert(){
		var msg = confirm("정말 삭제하시겠습니까?");
		if(msg){
			location.href = "boardDelete.do?row=" + ${vo.bId};
		}
	}
	
	function updateAlert(){
		var msg = confirm("정말 수정하시겠습니까?");
		if(msg){
			location.href = "boardUpdateForm.do?row=" + ${vo.bId};
		}
	}
</script>

<jsp:include page="../main/menu.jsp" />

<!-- Page content -->
<div class="w3-content" style="max-width: 2000px; margin-top: 46px" align="center" id="main">


	<div align="center">
		<h1>게시글 상세 페이지</h1>
		
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
				<td align="center" colspan="5" id="bTitle">${vo.bTitle }</td>
			</tr>
			<tr>
				<th width="50">내용</th>
				<td colspan="7"><textarea rows="10" cols="100" required="required" readonly>${vo.bContent }</textarea></td>
			</tr>
		</table>
		<p/>
	<!-- 댓글 출력 -->
	<div class="reply">
		<c:if test="${not empty list }">
			<table border="1">
				<tr class="replyColumn">
					<td align="center">내용</td>
					<td align="center">날짜</td>
				</tr>
			</table>
			<c:forEach var="rvo" items="${list }">
				<table border="1">
					<tr>
						<td width="500">${rvo.subject }</td>
						<td width="100">${rvo.rdate }</td>
					</tr>
				</table>
			</c:forEach>
		</c:if>
	</div>
	
		<p />
		<div>
			<button type="button" onclick="updateAlert()">글 수정</button>
			&nbsp;&nbsp;
			<button type="button" onclick="deleteAlert()">글 삭제</button>
			&nbsp;&nbsp;
			<button type="button" onclick="location.href='/210129/boardList.do'">목록으로이동</button>
		</div>
		
	</div>


</html>