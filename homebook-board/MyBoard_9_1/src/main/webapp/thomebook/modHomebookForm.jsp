<%@ page language="java" contentType="text/html; charset=UTF-8"
      pageEncoding="UTF-8"
    isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"  />
<%
  request.setCharacterEncoding("UTF-8");
%> 
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
<title>가계부 정보 수정창</title>
<style>
  .cls1 {
     font-size:40px;
     text-align:center;
   }
</style>

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


					 <h1 class="cls1">가계부 정보 수정창</h1>
<form  method="post" action="${contextPath}/homebook/modHomebook.do?serialno=${bookInfo.serialno}">
 <table align="center" >
  	<tr>
       <td width="200"><p align="right">등록번호</td>
       <td width="400"><input type="text" name="serialno" value="${bookInfo.serialno}" disabled></td>
    </tr>
    <tr>
       <td width="200"><p align="right">등록일자</td>
       <td width="400"><input type="text" name="day" value="${bookInfo.day}" ></td>
    </tr>
 
 	<tr>
       <td width="200"><p align="right">수지구분</td>
       <td width="400"><input type="text" name="section" value="${bookInfo.section}" ></td>
    </tr>
    <tr>
        <td width="200"><p align="right">계정과목</td>
        <td width="400"><input type="text"  name="accounttitle" value="${bookInfo.accounttitle}"></td>
    </tr>
    <tr>
        <td width="200"><p align="right">적요</td>
        <td width="400"><p><input type="text"  name="remark"  value="${bookInfo.remark}"></td>
    </tr>
    <tr>
        <td width="200"><p align="right">수입</td>
        <td width="400"><p><input type="text"  name="revenue"  value="${bookInfo.revenue}"></td>
    </tr>
    <tr>
        <td width="200"><p align="right">지출</td>
        <td width="400"><p><input type="text"  name="expense"  value="${bookInfo.expense}"></td>
    </tr><tr>
        <td width="200"><p align="right">회원아이디</td>
        <td width="400"><p><input type="text"  name="mem_id"  value="${bookInfo.mem_id}" disabled></td>
    </tr>
 
    <tr align="center" >
    <td colspan="2" width="400"><input type="submit" value="수정하기" >
       <input type="reset" value="다시입력" > </td>
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
