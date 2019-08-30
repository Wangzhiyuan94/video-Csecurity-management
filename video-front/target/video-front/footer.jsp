<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>长传页面</title>
<link type="text/css" rel="stylesheet" a href="css/reset.css"/>
<script src="js/jquery-1.8.3.js"></script>
	<style type="text/css">
		#foot{
				margin-top:2em !important;
				background:#f9f9f9;
				transition:box-shadow ease 100ms;
				box-shadow:0 2px 4px rgba(0,0,0,0.1), 0 -1px 1px rgba(0,0,0,0.05);
			}
			.container{
				width: 1408px;
				position:relative;
				margin:0 auto;
				box-sizing:border-box;
				margin-top: 28px;
				background-color: blue;
				height: 172px;
				background-image: url("img/footer.png");
			}
	</style>
	


</head>
<body>
<!--尾部-->
		<div id="foot">
			<div class="container">
				<div id="downloadPic "></div>
				
			</div>
		</div>
		
</body>
</html>