<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>새글작성 Form</title>
</head>

<jsp:include page="../main/menu.jsp" />

<!-- Page content -->
<div class="w3-content" style="max-width: 2000px; margin-top: 46px" align="center">

<form id="frm" name="frm" action="boardInsert.do" method="post">
		<div align="center"><h1>새글 작성</h1></div>
		<div align="center">
			<table border="1">
				<tr>
					<th width="100">제목</th>
					<td><input type="text" id="bTitle" name="bTitle" required="required"></td>
					<th width="100">작성자</th>
					<td><input type="text" id="bName" name="bName" required="required"></td>
					<th width="100">작성일자</th>
					<td><input type="date" id="bDate" name="bDate"></td>
				</tr>
				<tr>
					<th width="50">내용</th>
					<td colspan="5"><textarea type="text" id="bContent" name="bContent" rows="10" cols="100" required="required"></textarea></td>
				</tr>
			</table>
			
			<p/>
			<div>
			<button type="submit">등록</button>&nbsp;&nbsp;&nbsp;
			<button type="reset">취소</button>&nbsp;&nbsp;&nbsp;
			<button type="button" onclick="location.href='/210129/boardList.do'">목록으로 이동</button>
		</div>
		</div>
	</form>
</html>