<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
<head>

<link href="<c:url value="/resources/css/table.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/form.css" />" rel="stylesheet">


<script type="text/javascript" src="<c:url value="/resources/js/jquery.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/segmento.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/cliente.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/form.js"/>"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Viagem</title>
</head>
<body>

<%@include file="/WEB-INF/view/segmento.jsp"%>
<%@include file="/WEB-INF/view/tabelaSegmento.jsp"%>

<%@include file="/WEB-INF/view/cliente.jsp"%>
<%@include file="/WEB-INF/view/tabelaCliente.jsp"%>
</body>
</html>