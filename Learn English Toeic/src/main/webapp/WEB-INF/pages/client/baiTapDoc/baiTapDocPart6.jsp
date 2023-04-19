<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Luyện bài tập đọc - Part 6</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="UTF-8" />
<style type="text/css">
.hidden {
	display: none;
}

.error-message {
	color: red;
}

.radioLabel {
	float: left;
}

.anchor {
	display: block;
	height: 115px; /*same height as header*/
	margin-top: -115px; /*same height as header*/
	visibility: hidden;
}
</style>
</head>
<body>
	<jsp:include page="../template/header.jsp"></jsp:include>

	<div class="container">
		<!--PAGE TITLE-->
		<div class="span9" style="text-align: center">
			<h2 style="font-weight: bold">LUYỆN ĐỌC PART 6</h2>
			<div class="page-header"></div>
		</div>

		<!-- /. PAGE TITLE-->
		<div class="row">
			<div class="span9" style="text-align: center">
				<!--Blog Post-->
				<div class="blog-post">
					<h3>${baiTapDoc.tenBaiDoc}</h3>
					<input type="hidden" value="${baiTapDoc.id }" id="baiTapDocId">
					<div class="postmetadata">
						<a name="middle">
							<ul>
								<li><c:if test="${baiTapDoc.doKho == 1}">
                                    Độ khó - Dễ 
                                </c:if> <c:if test="${baiTapDoc.doKho == 2}">
                                    Độ khó - Trung bình
                                </c:if> <c:if test="${baiTapDoc.doKho == 3}">
                                    Độ khó - Khó
                                </c:if></li>
							</ul>
						</a>
					</div>
					<img src="<c:url value="/file/images/baiDocId=${baiTapDoc.id }.png"  />"
						style="width: 300px; height: 150px;">
					<p>Read the texts that follow. A word or phrase is missing in some of the sentences. Four answer choices are given below each of the sentences. Select the best answer to complete the text.
</p></div>

				</div>

			
				<div class="span9" style="text-align: left">		
				<div id="cauHoi"></div>

				<div class="pagination" style="text-align: center">
					<ul class="ul-pagination"></ul>
				</div>

				<hr align="center">

				<div class="span9" style="text-align: center">
					<button class="btn btn-success" id="btnNopBai">Nộp bài</button>
					<a class="btn btn-success hidden" id="btnBaiThiKhac"
						href="/webtoeic/bai-doc">Làm bài thi khác</a>
				</div>

				<!--/.Pagination-->
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
	<div class="row col-md-6">
		<div class="modal fade" id="nopBaiModal" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalLabel" aria-hidden="true" data-backdrop="static"
			data-keyboard="false">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">KẾT QUẢ</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<h4 id="ketQuaText"></h4>
					</div>
					<div class="modal-footer">
						<input class="btn btn-danger" id="btnLamLai" type="button" value="Làm lại" />
						<input class="btn btn-primary" id="btnXemGiaiThich" type="button"
							value="Xem Giải thích" />

					</div>
				</div>
			</div>
		</div>
	</div>

	<jsp:include page="../template/footer.jsp"></jsp:include>
	<script
		src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.1/jquery.validate.min.js"></script>
	<script src="<c:url value='/js/client/baiDoc/lamBaiDocPart6.js'/>"></script>

</body>
</html>
