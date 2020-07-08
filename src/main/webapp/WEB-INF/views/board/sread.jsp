<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>


<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<div class="container">
		<div class="row text-center">
			<h1>글 search 자세히 보기</h1>
			</div>
			<div class="row">
				<div class="form-group">
					<label for="title">제목</label>
				 	<input readonly value="${vo.title}" class="form-control">
				</div>
				<div class="form-group">
					<label for="writer">작성자</label>
				 	<input readonly value="${vo.writer}" class="form-control">
				</div>
				<div class="form-group">
					<label for="content">내용</label>
					<textarea rows="5" readonly class="form-control">${vo.content}</textarea>
				</div>
					
			<div class ="form-group text-right">
				<button class="btn btn-info" id="reply_form">댓글</button>
				<button class="btn btn-warning" id="updatebtn">수정</button>
				<button class="btn btn-danger" id="deletebtn">삭제</button>
				<button class="btn btn-primary" id="listbtn">목록</button>
			</div>		
		</div>	
	</div>
	
	<script type="text/javascript">
		$(document).ready(function(){
			$("#reply_form").click(function(){
					
			});	
			$("#updatebtn").click(function(){
				location.assign("/board/update/${vo.bno}");	
			});
			$("#deletebtn").click(function(){
				location.assign("/board/delete/${vo.bno}");	
			});	
			$("#listbtn").click(function(){
				location.href="/board/list";
				//location.assign("/board/list");  같다
			});
		});
	</script>

</body>
</html>