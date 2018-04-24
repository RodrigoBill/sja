<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>

<link href="<c:url value="/resources/css/contato.css" />" rel="stylesheet">
<script	src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script src="<c:url value="/resources/js/contato.js"/>"></script>
<script src="<c:url value="/resources/js/jquery.js"/>"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Submit new Contact</h2>
<form id="saveContact">
                <div>
                    <label for="firstNameInput">First Name</label>
                    <input type="text" name="nome" id="nomeInput" />
                </div>
                <div><input id="submit" type="submit" value="Save Contact"></div>
            </form>

            <br><br>
            <h2>Table Contact</h2>
            <table id="contactTableResponse" class="table tr">
                <thead>
                    <tr>
                    	<th>ID</th>
                        <th>NOME</th>
                    </tr>
                </thead>
                <tfoot>
                    <tr>
                        <td colspan="4">JQuery Ajax</td>
                    </tr>
                </tfoot>
                <tbody>
                	<c:forEach items="${contatos}" var="contato">
                        <tr>
                        	<td>${contato.id}</td>
                            <td>${contato.nome}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
</body>
</html>