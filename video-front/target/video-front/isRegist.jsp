<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册成功</title>
<link type="text/css" rel="stylesheet" a href="css/reset.css"/>
	<script src="js/jquery-1.8.3.js"></script>
	<style type="text/css">
		body html{
			color: #333;
			font-family:sans-serif;
			font-size: 16px;
			-webkit-font-smoothing:antialiased;
			height: 100%;
		}
		.main{
			width: 100%;
			height: 937px;		
		}
		#left{
			
		width: 1505px;
		height:100%;
		float: left;
		
		}	
		#left_bg{
			background-image: url(img/bgc1.jpg);
			opacity: 1;
			background-position: 50%;
			background-repeat: no-repeat;
			background-size: cover;
			position:relative;
			height: 100%;
		}
		#right{
			width: 398px;
			height: 100%;
			float: left;
			/*background-color: antiquewhite;*/
			
		}
		#right_inner{
			position: relative;
			width: 80%;
			height: 80%;
			margin-left: 39.7px;
			margin-top: 50px;
			margin-right: 39.7px;
		}
		#select{
			height: 28px;
			width: 100%;
			/*background-color: aqua;*/
			margin-top: 12px;
			display: flex;
			justify-content: center;
		}
		.option_login{
			background-color:  white;
			border: none;
			margin-left: 30px;
			margin-right: 30px;
			width: 42px;
			height: 26px;
			font-family: "微软雅黑";
			/* border-bottom:3px solid transparent; */
			cursor: pointer;	
			white-space: nowrap;
			outline: none;
			padding: 0 5px 5px;
			border-bottom-color: #f84949;
			font-size: 16px;
		}
		.option_regist{
			background-color:  white;
			border: none;
			margin-left: 30px;
			margin-right: 30px;
			width: 42px;
			height: 26px;
			/* font-family: "微软雅黑"; */
			border-bottom:3px solid transparent; 
			cursor: pointer;	
			white-space: nowrap;
			outline: none;
			padding: 0 5px 5px;
			border-bottom-color: #f84949;
			font-size: 16px;
		}
		#right_inner_main{
			
			width: 349px;
			height: 90px;
			/* text-align: center; */
		}

		.right_inner_heading_confirmed-icon{
			display: inline-block;
			margin-right:8px;
			position:relative; 
			top:8px;
			background-image:url("icon/right_inner_heading_confirmed-icon.png");
			width: 34px; 
			height: 34px;	
			/* background-color: blue; */
			background-size: 34px 34px;
			
			
		}
		.right_inner_heading{
			padding-bottom:1.25rem;
			
			width: 349px;
			height: 31px;
			margin-top: 25px;
			text-align: center;
			
		}
		h4{
			font-size: 19px;
			font-weight: 400;
			font-family: "微软雅黑";
		}
		#right_inner_reback{
			
			line-height:1.5;
			font-size: 14px;
			margin-top: 18px;
		}	

		#right_inner_reback a{
			color: #4a90e2;
			font-size:20px;
			outline: none;
			text-align: center;
			margin:1.25rem 0;
			font-weight: bold;
			margin-left: 120px;
			cursor:pointer;
			text-decoration: underline;
			}

	</style>
</head>
<body>
	
	<div class="main">
			
			<!--页面左侧-->
			<div id="left">
				<div id="left_bg"></div>			
			</div>
			
			<!--页面右侧-->
			<div id="right">
				<div id="right_inner">
					<div id="select">
						<button class="option_login" >
							<a href="${pageContext.request.contextPath}/login_.jsp">登录</a>
						</button>
						<button class="option_regist" onclick="javascript:void(0);">注册</button>
					</div>	
					
				<!-- 显示部分 -->
					<div id="right_inner_main">
						<h4 class="right_inner_heading">
							<span class="right_inner_heading_confirmed-icon"></span>
							注册成功，请登录
						</h4>
						<div id="right_inner_reback">
							<a href="login_.jsp">返回登录</a>
						</div>	
					
					</div>
				
				</div>
				
			</div>
			
		</div>
			
			
			
		
		
		
			


	
</body>
</html>