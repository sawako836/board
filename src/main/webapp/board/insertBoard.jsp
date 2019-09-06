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
		$('#insertbtn').on('click', function(){
			var boardname = $(this).parent().siblings().find($(".boardname")).val();
			var usagestatus = $(this).parent().siblings().find($(".usagestatus")).val();

			if(boardname == ""){
				alert("게시판 이름을 입력해주세요.");
				return false;
			}else{
				$('#insert .boardname').val(boardname);	
				$('#insert .usagestatus').val(usagestatus);
			}
			console.log("usagestatus : ",usagestatus);
			console.log("boardname : ",boardname);
			$('#insert').submit();
			
		})
		
		
		$('.modify').on('click', function(){
 			var inum = $(this).parent().siblings().find($(".inum")).val();
 			console.log("inum : ",inum);
			var boardname = $(this).parent().siblings().find($(".boardname")).val();
			var usagestatus = $(this).parent().siblings().find($(".usagestatus")).val();
			
 			$('#update .inum').val(inum);
			$('#update .boardname').val(boardname);
			$('#update .usagestatus').val(usagestatus);
			
			$('#update').submit();
			
		})
	})
</script>
<style>
	td {
		text-align : center;
		padding : 20px;
	}
</style>
</head>

<body>
	<%@ include file="/commonJsp/header.jsp"%>
	<div class="container-fluid">
		<div class="row">

			<div class="col-sm-3 col-md-2 sidebar">
				<%@ include file="/commonJsp/left.jsp"%>
			</div>

			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
		<form id="insert" action="${cp }/newBoard" method="post">
			<input name="boardname" type="hidden" class="form-control boardname">
			<input name="usagestatus" type="hidden" class="form-control usagestatus">
		</form>
		<form id="update" action="${cp }/modifyBoard" method="post">
			<input name="boardname" type="hidden" class="form-control boardname">
			<input name="usagestatus" type="hidden" class="form-control usagestatus">
			<input name="inum" type="hidden" class="form-control inum">
		</form>
			<h2 class="sub-header">게시판 생성</h2>
				<table class="table table-bordered">
							<tr>
							<td><label class="col-sm control-label">게시판 이름${userid}</label></td>
							<td>
								<input name="boardname" type="text" class="form-control boardname">
							</td>
							<td>
								<select class="form-control usagestatus">
										<option value="y" selected>사용</option>
										<option value="n">미사용</option>
								</select>
							</td>
							<td><button id="insertbtn" type="button" class="btn btn-info">생성</button></td>
						</tr>

					<c:forEach items="${boardList }" var="v">
						<tr>
							<td><label class="col-sm control-label">게시판 이름</label></td>
							<td>
								<input name="boardname" type="text" class="form-control boardname" value="${v.boardname}">
								<input name="inum" type="hidden" class="form-control inum" value="${v.inum}">
							</td>
							<td>
								<select class="form-control usagestatus">
									<c:choose>
										<c:when test="${v.usagestatus == 'y'}">
											<option value="y" selected>사용</option>
											<option value="n">미사용</option>
										</c:when>
										<c:otherwise>
											<option value="y">사용</option>
											<option value="n" selected>미사용</option>
										</c:otherwise>
									</c:choose>
								</select>
							</td>
							<td><button type="button" class="btn btn-success modify">수정</button></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</body>
</html>
