<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<p>
Id   : ${user.id}<br/>
Name : ${user.userName}<br/>
Password : ${user.password}<br/>
Role : ${fn:length(user.roles)}
</p>
</body>
</html>
