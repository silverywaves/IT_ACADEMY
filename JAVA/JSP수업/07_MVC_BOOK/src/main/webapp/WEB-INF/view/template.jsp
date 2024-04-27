<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<!-- link -->
	<%@include file="/resources/static/jsp/link.jsp" %>

	<!-- common.css -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/static/css/common.css" />
	<!-- 
		${pageContext.request.contextPath}로 프로젝트 경로 추가 -> 정적자원에 대한 default Servlet 추가(web.xml)
		웹 애플리케이션의 루트 경로를 동적으로 가져와 상대 경로 설정시, 다른 환경이나 다른 경로에 배포할 때도 정적 리소스의 경로 문제 없이 원활하게 동작
	-->

	<!-- user/myinfo.css -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/static/css/user/myinfo.css" />

	<!-- common.js -->
	<script src="${pageContext.request.contextPath}/resources/static/js/common.js" defer></script>
	
</head>
<body>
	
	<div class="wrapper">
		<header>
			
			<!-- top-header -->
			<%@ include file="/resources/static/jsp/topHeader.jsp" %>
			<!-- nav -->
			<%@ include file="/resources/static/jsp/nav.jsp" %>

		</header>
       	
       	
       	<main class="layout-150">
       		
       		
       		
            <section class=breadcrum-block>
	            <nav style="--bs-breadcrumb-divider: '>';" aria-label="breadcrumb">
				  <ol class="breadcrumb">
				    <li class="breadcrumb-item"><a href="#">HOME</a></li>
				    <li class="breadcrumb-item active" aria-current="page">MYINFO(ROLE_USER)</li>
				  </ol>
				</nav>
            </section>
            <section>
            	<div class="main-block">
            		<aside class=left>


            		</aside>
            		<div class=right>
            			
            		
		
            		</div>	
            	</div>
       		
            </section>
            <section></section>
            <section></section>
            <section></section>
            
        </main>
        
        
        <footer>
        	<!-- footer  -->
			<%@ include file="/resources/static/jsp/footer.jsp" %>
       </footer>
        	
	</div>
</body>
</html>