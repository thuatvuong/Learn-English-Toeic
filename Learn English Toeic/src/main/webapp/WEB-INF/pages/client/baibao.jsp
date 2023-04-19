<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Danh sách Articles</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<style type="text/css">
.hidden {
	display: none;
}
.error-message {
	color: red;
}
.anchor {
	display: block;
	height: 115px; /*same height as header*/
	margin-top: -115px; /*same height as header*/
	visibility: hidden;
}
.pagination {
  	justify-content: center;
	display: block;
}
</style>
</head>
<body>
	<jsp:include page="./template/header.jsp"></jsp:include>

	<div class="container">
		<!--PAGE TITLE-->
		<div class="span9" style="text-align: center">
			<div class="page-header">
				<h4 style="font-weight: bold;">DANH SÁCH Articles</h4>
			</div>
		</div>

		<!-- /. PAGE TITLE-->
		<div class="row">
			<div class="span9" style="text-align: center">
				<div class="danhSach" style="text-align: left; padding-left: 45px;">
				</div>
				<div class="pagination">
					<ul class="ul-pagination"></ul>
				</div>
				<p class="hidden" id="pTag">Không có dữ liệu</p>

			</div>
			<div class="span3">

				<div class="side-bar">
					<h3>Danh mục</h3>
					<ul class="nav nav-list">
						<li><a href="/listening">LUYỆN BÀI NGHE</a></li>
						<li><a href="/reading">LUYỆN BÀI ĐỌC</a></li>
						<li><a href="/listExam">THI THỬ</a></li>						
						<li><a href="/listGrammar">HỌC NGỮ PHÁP</a></li>
						<li><a href="/listVocab">HỌC TỪ VỰNG</a></li>
						<li><a href="/listArticles">ARTICLES</a></li>
					</ul>

				</div>
			</div>
		</div>
	</div>
<br><br><br><br><br><br><br><br>
	<jsp:include page="./template/footer.jsp"></jsp:include>
	<script
		src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.1/jquery.validate.min.js"></script>
	<script src="<c:url value='/resources/js/client/article.js'/>"></script>
</body>
</html>