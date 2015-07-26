<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="e" uri="https://www.owasp.org/index.php/OWASP_Java_Encoder_Project" %>
<!DOCTYPE html>
<html>
<head><!-- CDN hosted by Cachefly -->
<script src="//tinymce.cachefly.net/4.2/tinymce.min.js"></script>
<_script>tinymce.init({selector:'textarea'});</script>
</head>
<body>
<h2>Comments</h2>
<c:forEach var="comment" items="${comments}">
${comment}
<hr>
</c:forEach>
<h2>More comments are welcome...</h2>
<c:url var="url" value="/newcomment"/>
<form action="${url}" method="POST">
	<textarea name="comment"></textarea>
	<input type="submit" value="Enviar"/>
</form>
</body>
</html>
</body>
</html>
