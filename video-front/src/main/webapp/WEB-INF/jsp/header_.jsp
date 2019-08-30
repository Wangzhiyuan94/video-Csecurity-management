<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
 <%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>长传页面</title>
<link type="text/css" rel="stylesheet" a href="css/reset.css"/>
<script src="js/jquery-1.8.3.js"></script>
	<style type="text/css">
			body{
				font-family: "微软雅黑";
				/*font-size: 15px;*/
			}
			#top{
				height: 56px;
				width: 100%;
				background-color:#FFFFFF;
/*				top:0;
				left: 0;
				position: fixed;
				z-index: 6!important;*/
				box-shadow: 0 2px 4px rgba(0,0,0,0.1), 0 -1px 1px rgba(0,0,0,0.05);;
				
			}
			#top_logo{
				width: 90px;
				height: 56px;
				background-color: #FFFFFF;
				float: left;
				margin-left: 350px;
				margin-right: 10px;
				
			}
			#top_logo_img{
				width: 85px;
				height: 25px;
				background-image: url(img/weheartit.png);
				background-size: 85px 25px;
				margin-top: 13px;
				
				
			}
			
			#top_logo2{
				width: 110px;
				height: 56px;
				background-color: #FFFFFF;
				float: left;
				
		
			}
			#icon{
				width: 40px;
				height: 33px;
				background-image: url(icon/icon_index.png);
				background-size: 40px 30px;
				margin-top: 9px;	
				float: left;				
			}
			#icon1{
				width: 40px;
				height: 33px;
				background-image: url(icon/icom_find.png);
				background-size: 40px 30px;
				margin-top: 9px;	
				float: left;				
			}
			#icon2{
				width: 40px;
				height: 33px;
				background-image: url(icon/icon_passaget.png);
				background-size: 40px 30px;
				margin-top: 9px;	
				float: left;				
			}
			.zhupingmu{
				color: #9b9b9b;
				text-align: center;
				font-size: 16px;
				width: 60px;
				height: 33px;
				float: left;
				margin-top: 15px;
				font-family: "微软雅黑";
			}
			#top_logo3{
				width: 110px;
				height: 56px;
				background-color: #FFFFFF;
				float: left;
		
			}
			#top_logo4{
				width: 110px;
				height: 56px;
				background-color: #FFFFFF;
				float: left;
		
			}						
			#top_content{
				background-color: azure;
				width: 130px;
				height:56px;
				float: right; 
			}
			
			#top_content a{
				margin-left:4px;
				margin-top: 10px;
				color:  blueviolet;
				display: inline-block;
				
			}
			#banner{
				width: 63%;
				height: 50px;
				/* background-color: yellowgreen; */
				margin-top: 30px;
				margin-right: auto;
				margin-left: auto;	
				box-shadow:0 1px 0 rgba(0,0,0,0.05)
			}
			#title{
				height: 50px;
				width: 100px;
				font-family:"微软雅黑";
				font-weight:bold;
				line-height: 50px;
				text-align: center;
				font-size: 20px;
				background-color: #FFFFFF; 
				font-family: helvetica,arial;
				
				float: left;				
			}
			#sort{
				background-color: #FFFFFF;
				height: 50px;
				width: 150px;
				float: left;
				
			}
			.content_div{
				width: 100px;
				height: 50px;
				background-color:  #FFFFFF;
				color: black;
				text-align: center;
				line-height: 50px;
				float: left;
				
			}
			.sort_div{
				width: 50px;
				height: 50px;
				/* background-color: aqua; */
				float: left
				
			}
			.sort_div a{
				display: block;
				width: 20px;
				height: 20px;
				/* background-color:  #FF7F50;  */
				margin-left: 13px;
				margin-top: 3.3px;
				
				
			}
			.up{
			
				background-size: 20px 20px;
				background-position-y: 3px;
				background-image: url("icon/箭头 上.png");
				margin-top: 13px;
				
			}
			.down{
				
				background-size: 20px 20px;
				background-position-y: -3px;	
				background-image: url("icon/箭头.png");
			}
	
	</style>
	


</head>
<body>
<!--头部-->
		<script type="text/javascript" >
			function upLoad(){
				 	if($('#username').text()=="登录")
					{
					alert("请先登录")
					}

					
			}
		
		</script>		
		
		<div id="top">
			<div id="top_logo">
				<div id="top_logo_img"></div>
			</div>
			<a href="" id="top_logo2">
				<div id="icon"></div>
				<span class="zhupingmu">主屏幕</span>
			</a>
			
			<div id="top_logo3">
				<div id="icon1"></div>
				<span class="zhupingmu">发现</span>
			</div>

			<div id="top_logo4">
				<div id="icon2"></div>
				<span class="zhupingmu">文章</span>
			</div>
			
			<div id="top_content">
				<c:if test="${empty user }">
				<a href="${pageContext.request.contextPath}/login_.jsp" id="username">登录</a>
				<a href="${pageContext.request.contextPath}/regist.jsp">注册</a>
				<a href="javascript:void(0);" onclick="upLoad()">上传</a>
				</c:if>		
				
				<c:if test="${!empty user }">
				<a href="">${user.name }</a>
				<a href="logout">退出</a>
				<a href="upLoad.jsp">上传</a>
				</c:if>	
					
			</div>
		</div>
		
		
		<!--导航栏-->
		<div id="banner">
			<div id="title">
				一拍视频
			</div>
			<div id="sort">
				<div class="content_div" >点赞数排序</div>
				<!--排序-->
				<div class="sort_div">
					<a href="sortByGoodCount?column=goodCount&sortType=asc" class="up" ></a>
					<a href="sortByGoodCount?column=goodCount&sortType=desc" class="down" ></a>
				</div>
				
			</div>
			<div class="sort">
				<div class="content_div" >时间排序</div>
				<!--排序-->
				<div class="sort_div">
					<a href="" class="up"></a>
					<a href="" class="down"></a>
				</div>
				
			</div>
		</div>



</body>
</html>