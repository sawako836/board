<%@page import="kr.or.ddit.board.model.Board"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
[
	<%
	List<Board> list = (List<Board>)request.getAttribute("boardList"); 
		for(int i = 0; i < list.size(); i++){
		Board board = list.get(i);
		if(i > 0)out.print(",");
%>
		{
			"inum" : "<%=board.getInum() %>",
			"boardname" : "<%=board.getBoardname() %>",
			"usagestatus" : "<%=board.getUsagestatus() %>",
			"userid" : "<%=board.getUserid() %>",
			"pboarddate" : "<%=board.getPboarddate() %>"
		}
	<%} %>
]