<%
    String contextName = request.getContextPath();
	contextName = contextName.equals("/") ? "" : contextName;
    String basePath = request.getScheme() + "://" + 
                      request.getServerName() + ":" + request.getServerPort() + contextName + "/";
%>
