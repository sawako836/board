<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Jsp-Main-basicLib</title>

<%@include file="/commonJsp/basicLib.jsp" %>
<script>
	$(function(){
		var pnum = "${post.pnum}";
		var inum = "${post.inum}";
		var posttem = "${post.posttem}";
		$("#pnum").val(pnum);
		$("#inum").val(inum);
		$("#posttem").val(posttem);
		
		
		$("#updatePost").on("click", function(){
			$("#post").prop("action", "${cp}/postUpdate");
			
			$("#post").submit();
		})
		
		$("#deletePost").on("click", function(){
			$("#post").prop("action", "${cp}/postDelete");
			
			$("#post").submit();
		})
		
		$("#rePost").on("click", function(){
			$("#post").prop("action", "${cp}/postInsert");
			
			$("#post").submit();
		})
		
		$("#commentsInsert").on("click", function(){
			$("#post").prop("action", "${cp}/insertComments");
			var cmtcont = $("#textarea").val();
			$("#cmtcont").val(cmtcont);
			
			$("#post").submit();
		})
		
		// textarea 글자수 제한
		$('#textarea').on("keyup", function(){
			var content = $(this).val();
			$('#counter').html("(" + content.length + " / 500)"); //글자수 실시간 카운팅

			if (content.length > 500) {
				alert("최대 500자까지 입력 가능합니다.");
				$(this).val(content.substring(0, 500));
				$('#counter').html("(500 / 500)");
			}
		});
	})
</script>
</head>

<body>
	<%@ include file="/commonJsp/header.jsp"%>

	<div class="container-fluid">
		<div class="row">

			<div class="col-sm-3 col-md-2 sidebar">
				<%@ include file="/commonJsp/left.jsp"%>
			</div>
	
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
 				<form id="post" action="" method="get">
 					<input id="pnum" type="hidden" name="pnum" value="${post.pnum}">
 					<input id="inum" type="hidden" name="inum" value="${post.inum}">
 					<input id="posttem" type="hidden" name="posttem" value="${post.posttem}">
 					<input id="cmtcont" type="hidden" name="cmtcont" value="${comments.cmtcont}">
 					
 				</form>
				<form id="post" action="" class="form-horizontal" role="form">
					<div class="form-group">
						<label for="postsubject" class="col-sm-2 control-label">제목</label>
						<div class="col-sm-10">
							<label class="control-label">${post.postsubject}</label>
						</div>
					</div>

					<div class="form-group">
						<label for="postcontent" class="col-sm-2 control-label">글내용</label>
						<div class="col-sm-10">
							<label class="control-label">${post.postcontent}</label>
						</div>
					</div>
					<div class="form-group">
						<label for="attachment" class="col-sm-2 control-label">첨부파일</label>
						<div id="attachment" class="col-sm-10">
							<c:forEach items="${attachmentList}" var="attachment">
								<label class="control-label">${attachment.uploadname}</label>
								<a href="${cp}/attachmentDownload?anum=${attachment.anum}" download="${attachment.uploadname}">
									<span class="glyphicon glyphicon-download-alt"></span>
								</a>
								<br>
							</c:forEach>
						</div>
					</div>
					
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
<%-- 							<c:if test="${userid == post.userid}"> --%>
								<button type="button" id="updatePost" class="btn btn-default">수정</button>
								<button type="button" id="deletePost" class="btn btn-default">삭제</button>
<%-- 							</c:if> --%>
							<button type="button" id="rePost" class="btn btn-default">답글</button>
						</div>
					</div>
					
					<div class="form-group" style="background:white; padding:5px;">
						<label for="pass" class="col-sm-2 control-label">댓글</label>
						<div id="comments" class="col-sm-10">
							<c:forEach items="${commentsList}" var="comments">
								<c:choose>
									<c:when test="${comments.cmtdeletion == 'n'}">
										<label class="control-label">삭제된 댓글입니다.</label>
									</c:when>
									<c:otherwise>
										<label class="control-label">${comments.cmtcont}</label>
									</c:otherwise>
								</c:choose>
								<label class="control-label">[${comments.userid} / ${comments.cdate_fmt}]</label>
<%-- 								<c:if test="${userid == comments.userid && comments.cmtdeletion == 'y'}"> --%>
									<a href="${cp}/deleteComments?cnum=${comments.cnum}&pnum=${comments.pnum}&inum=${post.inum}">
							        	<span class="glyphicon glyphicon-remove"></span>
							        </a>
<%-- 								</c:if> --%>
								<br>
							</c:forEach>
							<textarea id="textarea" rows="3" cols="50"></textarea>
							<span style="color:#aaa;" id="counter">(0 / 500)</span>

							<button type="button" id="commentsInsert" class="btn btn-default" style="vertical-align:top;">댓글 저장</button>
						</div>
					</div>
					
				</form>
			</div>
		</div>
	</div>
</body>
</html>
