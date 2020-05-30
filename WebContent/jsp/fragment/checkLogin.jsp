<%@page import="me.spring.entity.User"%>
<%@ include file="basePath.jsp" %>
<%
	User loginUser = (User)session.getAttribute("loginUser");
	if (loginUser == null) {
		response.sendRedirect(basePath);
	}
%>