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

<style>
	.postTr:hover{
		background : pink;
	}
</style>

<script>
	$(function(){
		$(".postTr").on("click", function(){
// 			$("#pnum").val($(".postTr > td").eq(0).text());
//  		$("#getPost").submit();
 			var inum = $(this).children().eq(0).text();
 			var pnum = $(this).children().eq(1).text();

			$("#pnum").val(pnum);
			$("#inum").val(inum);
			
			$("#getPost").submit();
 		})
		
		$("#insertPost").on("click", function(){
			$("#insertPostFrm").submit();
		})
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
			
				<form id="getPost" action="${cp }/postDetail" method="get">
					<input id="pnum" type="hidden" name="pnum">
					<input id="inum" type="hidden" name="inum">
				</form>
				
				<table class="table table-striped">
					<tr>
						<th>게시글번호</th>
						<th>제목</th>
						<th>작성자 아이디</th>
						<th>작성일시</th>
					</tr>
					
				<c:forEach items="${postList }" var="post">
								<tr class="postTr" data-userId="${post.userid}">
									<td style="display:none;">${post.inum }</td>
									<td>${post.pnum }</td>
									<td>${post.postsubject }</td>
									<td>${post.userid }</td>
									<td>${post.postdate }</td>
								</tr>
							</c:forEach>
						</table>
					</div>
				<c:forEach items="${post }" var="get">
						<c:choose>
							<c:when test="${post.deletion == 'n'}">
								<tr class="deleteTr">
									<td>${post.pnum}</td>
									<td style="display:none;">${post.inum }</td>
									<td>
										<c:forEach begin="0" end="${post.posttem}" var="i">
											<c:if test="${i > 0}">
												&nbsp;&nbsp;&nbsp;
											</c:if>
										</c:forEach>
										<c:if test="${post.posttem > 0}">
											<span class="glyphicon glyphicon-chevron-down"></span>
										</c:if>
										삭제된 게시물 입니다.
									</td>
									<td>${post.userid}</td>
									<td>${post.postdate}</td>
								</tr>
							</c:when>
							<c:otherwise>
								<tr class="postTr">
									<td>${post.pnum}</td>
									<td style="display:none;">${post.pnum }</td>
									<td>
										<c:forEach begin="0" end="${post.posttem}" var="i">
											<c:if test="${i > 0}">
												&nbsp;&nbsp;&nbsp;
											</c:if>
										</c:forEach>
										<c:if test="${post.posttem > 0}">
											<span class="glyphicon glyphicon-chevron-down"></span>
										</c:if>
										${post.postsubject}
									</td>
									<td>${post.userid}</td>
									<td>${post.postdate}</td>
								</tr>
							</c:otherwise>
						</c:choose>
					</c:forEach>
	
				</table>
				
				<button id="insertPost" type="button" class="btn btn-default pull-right">새글 등록</button>
				<form id="insertPostFrm" action="${cp}/postInsert" method="get">
					<input id="inum" type="hidden" name="inum" value="${inum}">
				</form>

				<div class="text-center">
					<ul class="pagination">
					<!-- 페이지네이션 방향 : << -->
						<c:choose>
							<c:when test="${page == 1}">
								<li class="disabled">
								    <a href="#" aria-label="Previous">
								    	<span aria-hidden="true">&laquo;</span>
								    </a>
							    </li>
							</c:when>
							<c:otherwise>
								<li>
								    <a href="${cp}/postPagingList?page=1&pagesize=10&inum=${inum}" aria-label="Previous">
								    	<span aria-hidden="true">&laquo;</span>
								    </a>
							    </li>
							</c:otherwise>
						</c:choose>
						<!-- 페이지네이션 방향 : < -->
						<c:choose>
							<c:when test="${page == 1}">
								<li class="disabled">
								    <a href="#" aria-label="Previous">
								    	<span aria-hidden="true">&lt;</span>
								    </a>
							    </li>
							</c:when>
							<c:otherwise>
								<li>
								    <a href="${cp}/postPagingList?page=${page-1}&pagesize=10&inum=${inum}" aria-label="Previous">
								    	<span aria-hidden="true">&lt;</span>
								    </a>
							    </li>
							</c:otherwise>
						</c:choose>
						
					    
						<c:forEach begin="1" end="${paginationSize}" var="selectpage">
							<c:choose>
								<c:when test="${selectpage == page }">
									<li class="active"><span>${selectpage}</span></li>
								</c:when>
								<c:otherwise>
									<li><a href="${cp}/postPagingList?page=${selectpage}&pagesize=10&inum=${inum}">${selectpage}</a></li>
								</c:otherwise>
							</c:choose>
						</c:forEach>
						<!-- 페이지네이션 방향 : > -->
						<c:choose>
							<c:when test="${page == paginationSize}">
								<li class="disabled">
								    <a href="#" aria-label="Next">
								    
								    	<span aria-hidden="true">&gt;</span>
								    </a>
							    </li>
							</c:when>
							<c:otherwise>
								<li>
								    <a href="${cp}/postPagingList?page=${page+1}&pagesize=10&inum=${inum}" aria-label="Next">
								    	<span aria-hidden="true">&gt;</span>
								    </a>
							    </li>
							</c:otherwise>
						</c:choose>
						<!-- 페이지네이션 방향 : >> -->
						<c:choose>
							<c:when test="${page == paginationSize}">
								<li class="disabled">
								    <a href="#" aria-label="Next">
								    	<span aria-hidden="true">&raquo;</span>
								    </a>
							    </li>
							</c:when>
							<c:otherwise>
								<li>
								    <a href="${cp}/postPagingList?page=${paginationSize}&pagesize=10&inum=${inum}" aria-label="Next">
								    	<span aria-hidden="true">&raquo;</span>
								    </a>
							    </li>
							</c:otherwise>
						</c:choose>
					</ul>
				</div>
				
			</div>
		</div>
	</div>
</body>
</html>
