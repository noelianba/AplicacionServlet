<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="es.open4job.web.model.vo.EstacionServicio"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%

EstacionServicio estacion = (EstacionServicio)session.getAttribute("estacion");
out.println(estacion.getId());
out.println(estacion.getTitle());
out.println(estacion.getFecha());
out.println(estacion.getCor_x());
out.println(estacion.getCor_y());
out.println(estacion.getIcon());

%>
</body>
</html>