<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="${cp}/js/jquery-3.4.1.min.js"></script>
<script>
	// 임시로 ajax
	$(function(){
		$.ajax({
			url : "/boardList",
			dataType : 'json',
			success : function(datas){
				var code = "";
				$(datas).each(function(i,v){
					if(v.usagestatus == "n"){
						code += '<li class="hidden"><a href="' + "#" + '">' + v.boardname + '<span class="sr-only">(current)</span></a></li>';
					}else{
						code += '<li class="active"><a href="' + "${cp}/postPagingList?inum=" + v.inum + '">' + v.boardname + '<span class="sr-only">(current)</span></a></li>';
					}
				})
				$("#list").append(code);
			},
			error : function(xhr){
				alert(xhr.status);
			}
		})
	})
</script>
</head>
<body>
	<form id="frm" action="${cp }/boardList" method="get"></form>
	<ul id="list" class="nav nav-sidebar">
	<!-- a tag : get method -->
	<li class="active"><a href="${cp }/newBoard">게시판 생성 <span class="sr-only">(current)</span></a></li>
</ul>
</body>
</html>