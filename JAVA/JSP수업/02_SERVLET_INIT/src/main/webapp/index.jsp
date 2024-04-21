<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
	<style>
		*{margin :5px;}
		.wrapper>header{
			height : 150px; border:1px solid;
		}
		.wrapper>header>.top-header{
			height:45px;
			border : 1px solid;	
			
		}
		.wrapper>header>.top-header>ul{
			display:flex;
			justify-content: right;
			align-items : center;
			list-style:none;
			padding : 0px;
		}
		.wrapper>header>.top-header>ul>li{
			width : 120px;
			height : 100%;
			border : 1px solid;
		}
		.wrapper>header>nav{
			height:75px;
			border : 1px solid;
		}
		.wrapper>main{
			height:500px; border : 1px solid;
		}
		.wrapper>footer{
			height : 300px; border : 1px solid;
		}
	</style>
<body>

	<div class="wrapper">
		<header>
			<%@include file="fragments/topHeader.jsp" %>
			<%@include file="fragments/nav.jsp" %>
		</header>
		<main>
			<section></section>
			<section></section>
			<section></section>
		</main>
		<footer>
			<%@include file="fragments/footer.jsp" %>
		</footer>
	</div>
	<!-- 웹 페이지 레이아웃 구조
		wrapper: 전체 컨텐츠를 감싸는 컨테이너
		header: 페이지의 상단 부분
		topHeader.jsp: 상단 헤더의 내용을 포함한 JSP 파일
		nav.jsp: 네비게이션 메뉴의 내용을 포함한 JSP 파일
		main: 페이지의 주요 내용이 표시되는 부분
		section: 주요 내용이 표시되는 섹션(여러 개의 섹션으로 구성)
		footer: 페이지의 하단 부분
		footer.jsp: 하단 푸터의 내용을 포함한 JSP 파일\
		
		=> 각 부분은 별도의 JSP 파일(topHeader.jsp, nav.jsp, footer.jsp)로 구성되어 있어 재사용성이 높음
	 -->
</body>
</html>