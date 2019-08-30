<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>\
 <%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>      
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
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
			font-family: "微软雅黑";
			border-bottom:3px solid transparent; 
			cursor: pointer;	
			white-space: nowrap;
			outline: none;
			padding: 0 5px 5px;
			border-bottom-color: #f84949;
			font-size: 16px;
		}
		#showDiv{
			text-align: left;
			color:#f01428;
			font-size:15px;
			font-family: "微软雅黑";
			width: 100%;
			margin-top: 5px;
		}
		
		.text-field__input1{
			padding-top:0px;
			background: none;
			
			bottom: 0;
			left: 0;
			opacity: 1;
			padding: 0;
			position:  relative;
			right: 0;
			top: 0;
			width: 100%;
			z-index: 0;
			
			line-height: 1.15;
			width: 100%;
			height: 68px;
			/* margin-top: 15px; */
			
			border: 1px solid #bbb;
			font-family: "微软雅黑";
			font-size: 19px;
			padding-left: 9px;
			
		}
		.text-field__input2{
			background: none;
			bottom: 0;
			left: 0;
			opacity: 1;
			padding: 0;
			position:  relative;
			right: 0;
			top: 0;
			width: 100%;
			z-index: 0;
			
			line-height: 1.15;
			width: 100%;
			height: 68px;
			margin-top: 36px;		
			border: 1px solid #bbb;
			margin-bottom: 30px;
			
			border: 1px solid #bbb;
			font-family: "微软雅黑";
			font-size: 17px;
			padding-left: 9px;
		}
		.text-field{
			border: 1px solid #bbb;
			display: inline-block;
			position: relative;
			padding: .7625em 1.2em;
			margin-bottom: .75em;
			text-align: left;
			width: 100%;
		}
		
		.text-field__label{
			color: #BBBBBB;
			display: block;
			margin: .4375em 0;
			-moz-user-select: none;
			
			max-width: 100%;
			font-weight: 700;
			display: inline-block;
			margin-bottom: 5px;
			margin-top: 10px;
			justify-content: flex-start;
			
			border: 1px solid #333;
		}
		.text-field__label2{
			color: #BBBBBB;
			display: block;
			margin: .4375em 0;
			-moz-user-select: none;
			
			max-width: 100%;
			font-weight: 700;
			display: inline-block;
			margin-bottom: 5px;
			margin-top: 10px;
			justify-content: flex-start;
			
			
		}
		.sign-in-form__sign-in{
			display: block;
		}
		input::-webkit-input-placeholder {
		        color: #bbb;
		        font-size:18px ;
										        
	    }	
		.sign-in-button{
			
			padding: 1em 2em;
			margin-bottom: 1.25rem;
			width: 100%;
			background-color: #f84949;
			border: 1px solid #dd4242;
			color: white;
			border-radius:.3125em;
			cursor: pointer;
			outline: none;
			text-align: center;
			transition:all .3s ease;
			margin-top: inherit;
			font-family: "微软雅黑";
			font-size: 17px;
		}
		.sign-in__extras{
			margin: 1.25rem 0;
			line-height: 1.5;
			font-size: 14px;
			padding: 0px;
			text-align: center;
			
		}
		.sign-in__extras a{
			color: #4a90e2;
		}
	</style>
	<script >
			function init(){
				//书写轮图片显示的定时操作
				setInterval("changeImg()",15000);
			}
			
			//书写函数
			var i=0
			function changeImg(){
				console.log(i)
				i++;
				//获取图片位置并设置src属性值
				$('#left_bg').css("background-image","url(img/bgc"+i+".jpg)")
				if(i==11){
					i=0;
				}
			}
	</script>
</head>
<body onload="init()">
	
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
				<!--两个输入框-->
					<div class="sign-in-form__sign-in">
						<form class="sign-in-form"  action="${pageContext.request.contextPath}/regist" method="post" >
								<div id="showDiv" ></div><br /> 
						<!--	<div class="text-field__label" for="id"></div>-->
								<input type="text" class="text-field__input1" id="id"  name="name" placeholder="请输入您的手机号" autocapitalize="off" autocorrect="off" onkeyup="searchWord(this)">	
					
							<!--</div>-->
						
							<!--<div class="text-field__label2" for="id">-->
								
								<input type="password" class="text-field__input2" id="pwd"  name="password" placeholder="密码至少6位字符"autocomplete="off" autocapitalize="off" autocorrect="off">	
								
							<!--</div>-->
							
							
								<button type="submit" class="sign-in-button" name="submit" id="submit">立即注册</button>
						
								<div class="sign-in__extras">
									<a href="" >忘记密码？</a>
								</div>
					
						
								
					</div>
				</div>
				
			</div>
			
		</div>
			
			<script type="text/javascript">
			function searchWord(obj){
				//1、获得输入框的输入的内容
				var word = $(obj).val();
				//2、根据输入框的内容去数据库中模糊查询---List<User>
				var content = "";
					
					  $.ajax({
						type:"post",
						async:true,
						url:"<%=basePath%>/checkUsername",
						data:{"word":word},
						success:function(data){
							if(data=="ok"){
								console.log("收到了")
								/* content+="<div style='padding:5px;>用户名可用</div>";
								$("#showDiv").html(content); */
								$("#showDiv").text("用户名已存在");
								
								$("#showDiv").css("color","#f01428");
								
							}else{
								console.log("没有收到")
								$("#showDiv").text("用户名可用");
								$("#showDiv").css("color","#79c23b");
								
							}	
						}
						
					}); 
					
				
				
				
			}
				
/* 
						if(data.length>0){
							for(var i=0;i<data.length;i++){
								content+="<div style='padding:5px;cursor:pointer' onclick='clickFn(this)' onmouseover='overFn(this)' onmouseout='outFn(this)'>"+data[i]+"</div>";
							}
							$("#showDiv").html(content);
							$("#showDiv").css("display","block"); */
	
				
				
				
			
			/* $('#submit').click(function(){
				if($('#username').val()==null||$('#pwd').val()==null){
					 $('#tishi').text("请输入完整用户名或密码") 
				}
				 
			}) */
			</script>		
			
		
		
		
			


	
</body>
</html>