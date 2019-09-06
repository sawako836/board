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
<script src="${cp }/SE2/js/HuskyEZCreator.js"></script>
<script>
	var fileSizeCheck = true;

	var oEditors = [];
	
	$(document).ready(function() {
		// Editor Setting
		nhn.husky.EZCreator.createInIFrame({
			oAppRef : oEditors,
			elPlaceHolder : "smarteditor", 
			sSkinURI : "${cp}/SE2/SmartEditor2Skin.html",
			fCreator : "createSEditor2", 
			htParams : {
				
				bUseToolbar : true,
				
				bUseVerticalResizer : true,
				
				bUseModeChanger : true, 
			}
		});
	
		// 전송버튼 클릭이벤트
		$("#saveBtn").click(function(){
			if(confirm("저장하시겠습니까?")) {
				oEditors.getById["smarteditor"].exec("UPDATE_CONTENTS_FIELD", []);
	
				if(validation()) {
					$("#postcontent").val($("#smarteditor").val());
					
					if(fileSizeCheck){
						$("#postUpdateFrm").submit();
					}else{
						alert("첨부파일 갯수는 최대 5개까지 입니다.");
					}
				
				}
			}
		})
		
		// 필수값 Check
		function validation(){
			var contents = $.trim(oEditors[0].getContents());
			if(contents === '<p>&nbsp;</p>' || contents === ''){ 
				alert("내용을 입력하세요.");
				oEditors.getById['smarteditor'].exec('FOCUS');
				return false;
			}
		
			return true;
		}
		
		$("input[type=file]").change(function () {
			fileSizeCheck = true;
			
            var fileInput = document.getElementById("attachment");
              
            var files = fileInput.files;
            
            var count = (files.length + ${attachmentList.size()});
            
			$('#counter').html(count + " / 5");


            if(count > 5){
            	alert("최대5개")
            	fileSizeCheck = false;
            }
        });
		
	});
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
				<form id="postUpdateFrm"class="form-horizontal" role="form" action="${cp}/postUpdate" method="post" enctype="multipart/form-data">
				
					<div class="form-group">
						<label for="postsubject" class="col-sm-2 control-label">제목</label>
						<div class="col-sm-10">
							<input type="hidden" value="${post.pnum}" name="pnum">
							<input type="hidden" value="${post.inum}" name="inum">
							<input type="text" class="form-control" id="postsubject" name="postsubject"
								placeholder="제목" value="${post.postsubject}">
						</div>
					</div>
					
					<div class="form-group">
						<label for="postcontent" class="col-sm-2 control-label">글내용</label>
						<div class="col-sm-10">
							<textarea name="postcontent" id="smarteditor" rows="10" cols="100" style="width:766px; height:412px;">
								${post.postcontent}
							</textarea> 
							<input type="hidden" name="postcontent" id="postcontent">
						</div>
					</div>
					
					<div class="form-group">
						<label for="attachment" class="col-sm-2 control-label">첨부파일</label>
						<div id="attadiv" class="col-sm-10">
							<c:forEach items="${attachmentList}" var="attachment">
								<label class="control-label">${attachment.uploadname}</label>
								<a href="${cp}/attachmentDelete?pnum=${post.pnum}&inum=${post.inum}&anum=${attachment.anum}">
						        	<span class="glyphicon glyphicon-remove"></span>
						        </a>
						        <br>
							</c:forEach>
						</div>
					</div>
					
					<div class="form-group">
						<label for="picture" class="col-sm-2 control-label">첨부파일</label>
						<div class="col-sm-10">
							<input type="file" class="form-control" id="attachment" name="attachment" 
								placeholder="첨부파일" maxlength="5" multiple="multiple">
							<span style="color:#aaa;" id="counter">${attachmentList.size()} / 5</span>
						</div>
					</div>
					
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="button" id="saveBtn" class="btn btn-default">저장</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
