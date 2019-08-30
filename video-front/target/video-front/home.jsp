<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib prefix="itheima" uri ="http://customUri"%>
 <%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
<link type="text/css" rel="stylesheet" a href="css/reset.css"/>
<link rel="stylesheet" href="css/good.css" /> 





		<style type="text/css">
									
			#main{
				/* background-color: yellowgreen; */
				width: 1200px;
				margin-top: 30px;
				margin-left: auto;
				margin-right: auto;	
				height: 1158px;			
			}
			.item{
				width: 365px;
				/* background-color:  orange; */
				float: left;
				top:0;
				margin-right:17px;
				margin-left:17px;
				padding-bottom:54px;
				height: 222px;
				margin-bottom: 15px;
				/* margin-left: 0px; */
				box-shadow:0 2px 4px rgba(0,0,0,0.1), 0 -1px 2px rgba(0,0,0,0.05);
			}
			.good_btn{
				margin-right: 20px;
				float: right;
			}
			.video_msg{
				width: 100%;
				bottom:0px;
				margin-bottom: 10px;
				float: left;
				height:50px; 
			}
			video{
				/* box-shadow:0 2px 4px rgba(0,0,0,0.1), 0 -1px 1px rgba(0,0,0,0.05); */
				border-top: 0;
				width: 100%; 
				height:100%; 
				object-fit: fill;
			}
			.video_name{
			float: left;
			margin-top: 10px;
			font-family: "微软雅黑";
			}
			.pagination{
				display:inline-block;
				padding-left:0;
				margin:0 0;
				border-radius:4px;
				margin-left: 20px;

			}
			ul{
				margin-top: 0;
				margin-bottom: 10px;
				text-align:center;
				
			}
			.pagination>li{
				display: inline;
			}
			
	</style>
			
	</head>
</head>
<body>
<!--头部-->
		<jsp:include page="header_.jsp"></jsp:include>
<!--中间部分-->

		<div id="main">
 			<c:forEach items="${pageInfo.list }" var="video">
			<div class="item" >
				<video  controls="controls" poster="${video.picPath}" >
					
					<source src="myvideo/Javajiefei1.mp4" type="video/mp4"></source>
					
				</video>
				
				<div class="video_msg">	
						<div class="video_name">${video.videoName }	</div>
						<div class="likeCount" id="likeCount${video.id}">${video.goodCount}</div>
						<div class="heart " id="like${video.id}" rel="like"></div>
		               
					</div>
							
			</div>
			
			</c:forEach>
			
				
				
							
		</div>
		
		
		<!--分页 -->
		 <div class="row">
        <!--文字信息-->
        <%-- <div class="col-md-6">
            当前第 ${pageInfo.pageNum} 页.总共 ${pageInfo.pages} 页.一共 ${pageInfo.total} 条记录
        </div> --%>
 
        <!--点击分页-->
        <div class="col-md-12">
            <nav aria-label="Page navigation" style= "text-align: center">
                <ul class="pagination">
                    
                    <li><a href="${pageContext.request.contextPath}/video?pn=1">首页</a></li>
                    
                    <!--上一页-->
                    <li>
                        <c:if test="${pageInfo.hasPreviousPage}">
                            <a href="${pageContext.request.contextPath}/video?pn=${pageInfo.pageNum-1}" aria-label="Previous">
                                <span aria-hidden="true">«</span>
                            </a>
                        </c:if>
                    </li>
 
                    <!--循环遍历连续显示的页面，若是当前页就高亮显示，并且没有链接-->
                    <c:forEach items="${pageInfo.navigatepageNums}" var="page_num">
                        <c:if test="${page_num == pageInfo.pageNum}">
                            <li class="active"><a href="#">${page_num}</a></li>
                        </c:if>
                        <c:if test="${page_num != pageInfo.pageNum}">
                            <li><a href="${pageContext.request.contextPath}/video?pn=${page_num}">${page_num}</a></li>
                        </c:if>
                    </c:forEach>
 
                    <!--下一页-->
                    <li>
                        <c:if test="${pageInfo.hasNextPage}">
                            <a href="${pageContext.request.contextPath}/video?pn=${pageInfo.pageNum+1}"
                               aria-label="Next">
                                <span aria-hidden="true">»</span>
                            </a>
                        </c:if>
                    </li>
                    
                    <li><a href="${pageContext.request.contextPath}/video?pn=${pageInfo.pages}">尾页</a></li>
                </ul>
            </nav>
        </div>
 
    </div>
	
	<!-- 分页结束 -->
	<script src="js/jquery-1.8.3.js"></script>
	<!-- jQuery -->
<%-- 	<script src="<%=basePath%>js/jquery.min.js"></script> --%>


	<!-- Metis Menu Plugin JavaScript -->
	<script src="<%=basePath%>js/metisMenu.min.js"></script>

	<!-- DataTables JavaScript -->
	<script src="<%=basePath%>js/jquery.dataTables.min.js"></script>
	<script src="<%=basePath%>js/dataTables.bootstrap.min.js"></script>

	<!-- Custom Theme JavaScript -->
	<script src="<%=basePath%>js/sb-admin-2.js"></script>	
	
	
	<link href="<%=basePath%>css/bootstrap.min.css" rel="stylesheet"> 
	<!-- Custom CSS -->
	<link href="css/sb-admin-2.css" rel="stylesheet">
	
	<!--尾部-->
		<jsp:include page="footer.jsp"></jsp:include>
		

		<script>
			$(document).ready(function() {
			$('body').on("click",'.heart',function(){
			    var A=$(this).attr("id");
			    var B=A.split("like");
			    var messageID=B[1];
			    var C=parseInt($("#likeCount"+messageID).html());
			    var D=$(this).attr("rel");//如果为Like则执行动画
			    if(D =='like')
			    {      
			            $("#likeCount"+messageID).html(C+1);
			            $(this).addClass("heartAnimation").attr("rel","unlike");
			       		$(this).css("background-position","right");
			       		var count = 1;
			                //不加这句有bug，动画最后又会到了起点，点击后强制使图片停在最右边，
							       	 $.ajax({
											type:"get",
											async:true,
											url:"<%=basePath%>updateGoodCount?id="+messageID+"&count="+count,
											/* data:{"good":good},*/
											success:function(data){
												if(data=="ok"){
													console.log("收到了")	
													
												}else{
													console.log("没有收到")
													
												} 	
											}
											
										});
			                
			                
			                
			                
			    }
			    else
			    {
			    		
			            $("#likeCount"+messageID).html(C-1);
			            $(this).removeClass("heartAnimation").attr("rel","like");
			            $(this).css("background-position","left");
			               //点击后强制使红心变黑，否则显示悬=停状态的红色的心
			            var count = -1;  
			            $.ajax({
							type:"get",
							async:true,
							url:"<%=basePath%>updateGoodCount?id="+messageID+"&count="+count,
							
						});
			    }
			});
			});
</script>	

</body>


</html>