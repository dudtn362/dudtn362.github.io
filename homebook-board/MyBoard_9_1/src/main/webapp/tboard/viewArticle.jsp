<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="true"%>
<%
request.setCharacterEncoding("UTF-8");
%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!---------------- Navigation--------------------------------------------------------------->
<!DOCTYPE html>
<html lang="en">
<head>

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
<meta charset="UTF-8">
<title>글보기</title>
<style>
#tr_btn_modify {
	display: none;
}
</style>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
     function backToList(obj){
	    obj.action="${contextPath}/board/listArticles.do";
	    obj.submit();
     }
 
	 function fn_enable(obj){
		 document.getElementById("i_title").disabled=false;
		 document.getElementById("i_content").disabled=false;
	//	 document.getElementById("i_imageFileName").disabled=false;
		 document.getElementById("tr_btn_modify").style.display="block";
		 document.getElementById("tr_btn").style.display="none";
	 }
	 
	 function fn_modify_article(obj){
		 obj.action="${contextPath}/board/modArticle.do";
		 obj.submit();
	 }
	 
	 function fn_remove_article(url,articleNO){
		 var form = document.createElement("form");
		 form.setAttribute("method", "post");
		 form.setAttribute("action", url);
	     var articleNOInput = document.createElement("input");
	     articleNOInput.setAttribute("type","hidden");
	     articleNOInput.setAttribute("name","articleNO");
	     articleNOInput.setAttribute("value", articleNO);
		 
	     form.appendChild(articleNOInput);
	     document.body.appendChild(form);
	     form.submit();
	 
	 }
	 
	 function fn_reply_form(url, parentNO){
		 var form = document.createElement("form");
		 form.setAttribute("method", "post");
		 form.setAttribute("action", url);
	     var parentNOInput = document.createElement("input");
	     parentNOInput.setAttribute("type","hidden");
	     parentNOInput.setAttribute("name","parentNO");
	     parentNOInput.setAttribute("value", parentNO);
		 
	     form.appendChild(parentNOInput);
	     document.body.appendChild(form);
		 form.submit();
	 }
	 
	 function readURL(input) {
	     if (input.files && input.files[0]) {
	         var reader = new FileReader();
	         reader.onload = function (e) {
	             $('#preview').attr('src', e.target.result);
	         }
	         reader.readAsDataURL(input.files[0]);
	     }
	 }  
 </script>


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
				<div class="text-center" style="margin-top:100px">


					<form name="frmArticle" method="post" action="${contextPath}"
						enctype="multipart/form-data">
						<table border=0 align="center">
							<tr>
								<td width=150 align="center" bgcolor=#FF9933>글번호</td>
								<td align="left"><input type="text" value="${article.articleNO }"
									disabled /> <input type="hidden" name="articleNO"
									value="${article.articleNO}" /></td>
							</tr>
							<tr>
								<td width="150" align="center" bgcolor="#FF9933">작성자 아이디</td>
								<td align="left"><input type=text value="${article.id }" name="writer"
									disabled /></td>
							</tr>
							<tr>
								<td width="150" align="center" bgcolor="#FF9933">제목</td>
								<td align="left"><input type=text value="${article.title }" name="title"
									id="i_title" disabled /></td>
							</tr>
							<tr>
								<td width="150" align="center" bgcolor="#FF9933">내용</td>
								<td><textarea rows="20" cols="60" name="content"
										id="i_content"  width=450px height=200 disabled />${article.content }</textarea></td>
							</tr>

							<c:if
								test="${not empty article.imageFileName && article.imageFileName!='null' }">
								<tr>
									<td width="150" align="center" bgcolor="#FF9933" rowspan="2">
										이미지</td>
									<td><input type="hidden" name="originalFileName"
										value="${article.imageFileName }" /> <img
										src="${contextPath}/download.do?articleNO=${article.articleNO}&imageFileName=${article.imageFileName}"
										id="preview" width=450px height=200 /><br></td>
								</tr>
								<tr>
									<td><input type="file" name="imageFileName "
										id="i_imageFileName" disabled onchange="readURL(this);" />
									</td>
								</tr>
							</c:if>
							<tr>
								<td width="150" align="center" bgcolor="#FF9933">등록일자</td>
								<td><input type=text
									value="<fmt:formatDate value="${article.writeDate}" />"
									disabled /></td>
							</tr>
							<tr id="tr_btn_modify">
								<td nowrap colspan="2" align="center"><input type=button
									value="수정반영하기" onClick="fn_modify_article(frmArticle)">
									<input type=button value="취소" onClick="backToList(frmArticle)">
								</td>
							</tr>

							<tr id="tr_btn">
								<td colspan="2" align="center"><c:if
										test="${article.id == article.ids}">
										<input type=button value="수정하기" onClick="fn_enable(this.form)">
										<input type=button value="삭제하기"
											onClick="fn_remove_article('${contextPath}/board/removeArticle.do', ${article.articleNO})">
									</c:if> <input type=button value="리스트로 돌아가기"
									onClick="backToList(this.form)"> <%
 
 if (id != null) {
 %> <input type=button value="답글쓰기"
									onClick="fn_reply_form('${contextPath}/board/replyForm.do', ${article.articleNO})">

									<%
									}
									%></td>
							</tr>
						</table>
					</form>


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
