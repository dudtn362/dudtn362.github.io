<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="articlesList" value="${articlesMap.articlesList}" />
<c:set var="totArticles" value="${articlesMap.totArticles}" />
<c:set var="section" value="${articlesMap.section}" />
<c:set var="pageNum" value="${articlesMap.pageNum}" />

<%
request.setCharacterEncoding("UTF-8");
%>
<!---------------- Navigation--------------------------------------------------------------->
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />

<link rel="icon" type="image/x-icon" href="resources/assets/favicon.ico" />
<!-- Font Awesome icons (free version)-->
<script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js"
	crossorigin="anonymous"></script>
<!-- Google fonts-->
<link href="https://fonts.googleapis.com/css?family=Varela+Round"
	rel="stylesheet" />
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="../resources/css/styles.css" rel="stylesheet" />
<%
String id = (String) session.getAttribute("login.id");
if (id == null) {
	id = "GUEST";
}
%>

<style>
.no-uline {
	text-decoration: none;
}

.sel-page {
	text-decoration: none;
	color: red;
}

.cls1 {
	text-decoration: none;
}

.cls2 {
	text-align: center;
	font-size: 30px;
}
</style>
<meta charset="UTF-8">
<title>글목록창</title>

</head>
<!---------------- Navigation--------------------------------------------------------------->

<body id="page-top">

	<nav class="navbar navbar-expand-lg navbar-light fixed-top"
		id="mainNav">
		<div class="container px-4 px-lg-5">
			<a class="navbar-brand" href='../Main.jsp'>HOME</a>
			<button class="navbar-toggler navbar-toggler-right" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarResponsive"
				aria-controls="navbarResponsive" aria-expanded="false"
				aria-label="Toggle navigation">
				Menu <i class="fas fa-bars"></i>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ms-auto">
					<li class="nav-item"><a class="nav-link"
						href="../member/memberForm.do">회원가입</a></li>
					<li class="nav-item"><a class="nav-link"
						href="../member/modMemberForm.do">본인정보</a></li>
					<li class="nav-item"><a class="nav-link"
						href="../homebook/homebookForm.do">가계부입력</a></li>
					<li class="nav-item"><a class="nav-link"
						href="../homebook/listHomebooks.do">회원자료</a></li>
					<%
					if (id.equals("admin")) {
					%>

					<li class="nav-item"><a class="nav-link"
						href="../member/listMembers.do">모든회원</a></li>
					<%
					}
					%>
					<li class="nav-item"><a class="nav-link"
						href="../board/listArticles.do">게시판</a></li>

				</ul>
			</div>
		</div>

		<td align="center" width="200"><h3 class="y"><%=id%>님&nbsp;&nbsp;
			</h3> <%
 if (id.equals("GUEST")) {
 %>
			<button class="btn btn-primary"
				onclick="location.href='../login/formLogin.jsp'">로그인</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<%
			} else {
			%> &nbsp;&nbsp;&nbsp;&nbsp;
			<button class="btn btn-primary" onclick="location.href='../login'">로그아웃</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<%
			}
			%></td>
		</tr>


	</nav>


	<!------- Masthead-------------------------------------------------------------->
	<header class="masthead">
		<div
			class="container px-4 px-lg-5 d-flex h-100 align-items-center justify-content-center">
			<div class="d-flex justify-content-center">
				<div class="text-center">


					<table align="center" border="1" width=800>
						<tr height="10" align="center" bgcolor="lightgrey">
							<td nowrap>글번호&nbsp;&nbsp;</td>&nbsp;&nbsp;&nbsp;&nbsp;
							<td nowrap>작성자</td>
							<td nowrap>제목</td>
							<td nowrap>작성일</td>
						</tr>
						<c:choose>
							<c:when test="${empty articlesList}">
								<tr height="10">
									<td colspan="4">
										<p align="center">
											<b><span style="font-size: 9pt;">등록된 글이 없습니다.</span></b>
										</p>
									</td>
								</tr>
							</c:when>
							<c:when test="${!empty articlesList}">
								<c:forEach var="article" items="${articlesList }"
									varStatus="articleNum">
									<tr align="center">
										<td nowrap width="10%">${articleNum.count}</td>
										<td nowrap width="25%" text-align='center'>${article.id }</td>
										<td nowrap align='left' width="40%"><span
											style="padding-right: 30px"></span> 
											<c:choose>
												<c:when test='${article.level > 1 }'>
													<c:forEach begin="1" end="${article.level }" step="1">
														<span style="padding-left: 10px"></span>
													</c:forEach>
													<span style="font-size: 12px;">[답변]</span>
													<a class='cls1' nowrap
														href="${contextPath}/board/viewArticle.do?articleNO=${article.articleNO}">${article.title}</a>
												</c:when>
												<c:otherwise>
													<a class='cls1' nowrap
														href="${contextPath}/board/viewArticle.do?articleNO=${article.articleNO}">${article.title }</a>
												</c:otherwise>
											</c:choose></td>
										<td nowrap width="20%">&nbsp;&nbsp;<fmt:formatDate
												value="${article.writeDate}" /></td>
									</tr>
								</c:forEach>
							</c:when>
						</c:choose>
					</table>

					<div class="cls2">
						<c:if test="${totArticles != null }">
							<c:choose>
								<c:when test="${totArticles >100 }">
									<!-- 글 개수가 100 초과인경우 -->
									<c:forEach var="page" begin="1" end="10" step="1">
										<c:if test="${section >1 && page==1 }">
											<a class="no-uline"
												href="${contextPath }/board/listArticles.do?section=${section-1}&pageNum=${(section-1)*10 +1 }">&nbsp;
												pre </a>
										</c:if>
										<a class="no-uline"
											href="${contextPath }/board/listArticles.do?section=${section}&pageNum=${page}">${(section-1)*10 +page }
										</a>
										<c:if test="${page ==10 }">
											<a class="no-uline"
												href="${contextPath }/board/listArticles.do?section=${section+1}&pageNum=${section*10+1}">&nbsp;
												next</a>
										</c:if>
									</c:forEach>
								</c:when>
								<c:when test="${totArticles ==100 }">
									<!--등록된 글 개수가 100개인경우  -->
									<c:forEach var="page" begin="1" end="10" step="1">
										<a class="no-uline" href="#">${page } </a>
									</c:forEach>
								</c:when>

								<c:when test="${totArticles< 100 }">
									<!--등록된 글 개수가 100개 미만인 경우  -->
									<c:forEach var="page" begin="1" end="${totArticles/10 +1}"
										step="1">
										<c:choose>
											<c:when test="${page==pageNum }">
												<a class="sel-page"
													href="${contextPath }/board/listArticles.do?section=${section}&pageNum=${page}">${page }
												</a>
											</c:when>
											<c:otherwise>
												<a class="no-uline"
													href="${contextPath }/board/listArticles.do?section=${section}&pageNum=${page}">${page }
												</a>
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</c:when>
							</c:choose>
						</c:if>
					</div>
					<br> <br>

					<%
					if (id != "GUEST") {
					%>
					<a class="cls1" href="${contextPath}/board/articleForm.do"><p
							class="cls2">글쓰기</p></a>
					<%
					}
					%>




				</div>
			</div>
		</div>
	</header>
	<!-- About-------------------------------------------------------------------------->



	<!-- Footer----------------------------------------------------------------------->
	<footer class="footer bg-black small text-center text-white-50">
		<div class="container px-4 px-lg-5">Copyright &copy; Your
			Website 2022</div>
	</footer>
	<!-- Bootstrap core JS-->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	<!-- Core theme JS-->
	<script src="resources/js/scripts.js"></script>
	<!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
	<!-- * *                               SB Forms JS                               * *-->
	<!-- * * Activate your form at https://startbootstrap.com/solution/contact-forms * *-->
	<!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
	<script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
</body>
</html>
