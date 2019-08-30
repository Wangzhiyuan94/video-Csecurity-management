<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <!-- 页面meta -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">




    <title>数据 - AdminLTE2定制版</title>
    <meta name="description" content="AdminLTE2定制版">
    <meta name="keywords" content="AdminLTE2定制版">




    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no" name="viewport">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/ionicons/css/ionicons.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/iCheck/square/blue.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/morris/morris.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/jvectormap/jquery-jvectormap-1.2.2.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/datepicker/datepicker3.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/daterangepicker/daterangepicker.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/datatables/dataTables.bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/treeTable/jquery.treetable.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/treeTable/jquery.treetable.theme.default.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/select2/select2.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/colorpicker/bootstrap-colorpicker.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/bootstrap-markdown/css/bootstrap-markdown.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/adminLTE/css/AdminLTE.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/adminLTE/css/skins/_all-skins.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/ionslider/ion.rangeSlider.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/ionslider/ion.rangeSlider.skinNice.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/bootstrap-slider/slider.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/bootstrap-datetimepicker/bootstrap-datetimepicker.css">
</head>

<body class="hold-transition skin-purple sidebar-mini">

    <div class="wrapper">

        <!-- 页面头部 -->
        <jsp:include page="header.jsp"></jsp:include>
        <!-- 页面头部 /-->

        <!-- 导航侧栏 -->
        <jsp:include page="aside.jsp"></jsp:include>
        <!-- 导航侧栏 /-->

               <!-- 内容区域 -->
        <div class="content-wrapper">

            <!-- 内容头部 -->
            <section class="content-header">
                <h1>
                    视频管理
                    <small>视频表单</small>
                </h1>
                <ol class="breadcrumb">
                    <li><a href="all-admin-index.html"><i class="fa fa-dashboard"></i> 首页</a></li>
                    <li><a href="all-order-manage-list.html"> 视频管理</a></li>
                    <li class="active">视频表单</li>
                </ol>
            </section>
            <!-- 内容头部 /-->
            
		<form action="${pageContext.request.contextPath}/save" method="post">
            <!-- 正文区域 -->
            <section class="content">

                <!--订单信息-->
                <div class="panel panel-default">
                    <div class="panel-heading">视频信息</div>
                    <div class="row data-type">

                        <div class="col-md-2 title">视频名称</div>
                        <div class="col-md-4 data">
                            <input type="text" class="form-control" placeholder="视频名称" value="${videos[0].videoName }" name="videoName" readonly="readonly">
                        </div>

                        <div class="col-md-2 title">上传时间</div>
                        <div class="col-md-4 data">
                            <div class="input-group date">
                                <div class="input-group-addon">
                                    <i class="fa fa-calendar"></i>
                                </div>
                                <input type="text" class="form-control pull-right form_datetime " id="datepicker-a3" data-date-format="yyyy-mm-dd HH:mm:SS" name="upLoadTime" value="${videos[0].upLoadTime }">
                            </div>
                        </div>
                        <div class="col-md-2 title">视频作者</div>
                        <div class="col-md-4 data">
                            <input type="text" class="form-control" placeholder="视频作者" value="${videos[0].user.name }" <!-- readonly="readonly" --> name="uid">
                        </div>

                        <div class="col-md-2 title">视频类型</div>
                        <div class="col-md-4 data">
                            <select class="form-control select2" style="width: 100%;" >
                        <option value="" selected="selected" disabled="disabled">Alabama</option>
                        <option value="">Alaska</option>
                        <option value="">California</option>
                        <option value="">Delaware</option>
                        <option value="">Tennessee</option>
                        <option value="">Texas</option>
                        <option value="">Washington</option>
                    </select>
                        </div>

                        <div class="col-md-2 title">视频路径</div>
                        <div class="col-md-4 data">
                            <input type="text" class="form-control" placeholder="视频路径" value="${videos[0].path }" readonly="readonly" name="path">
                        </div>
                        
                        
                        <div class="col-md-2 title">点赞数</div>
                        <div class="col-md-4 data">
                            <input type="text" class="form-control" placeholder="点赞数" value="${videos[0].goodCount }" readonly="readonly" name="goodCount">
                        </div>

                        <div class="col-md-2 title rowHeight2x">详细描述</div>
                        <div class="col-md-10 data rowHeight2x">
                            <textarea class="form-control" rows="3" placeholder="其他信息" name="description" >${videos[0].description }</textarea>
                        </div>

                    </div>
                </div>
                <!--订单信息/-->

                <!--游客信息-->
                <div class="panel panel-default">
                    <div class="panel-heading">作者信息</div>
                    <!--数据列表-->
                    <table id="dataList" class="table table-bordered table-striped table-hover dataTable">
                        <thead>
                            <tr>
                                <th class="">作者类别</th>
                                <th class="">作者姓名</th>
                                <th class="">性别</th>
                                <th class="">邮箱</th>
                                <th class="">手机号</th>
                                <th class="">生日</th>
                            </tr>
                        </thead>
                        <tbody>

                            <tr>
                                <td>成人</td>
                                <td><input type="text" size="10" value=""></td>
                                <td>
                                    <select class="form-control" style="height:28px">
                        <option>男</option>
                        <option>女</option>
                    </select>
                                </td>
                                <td><input type="text" size="20" value="${videos[0].user.user_email }" readonly="readonly"></td>
                                <td><input type="text" size="15" value="${videos[0].user.user_tel }" readonly="readonly"></td>
                                <td><input type="text" size="28" value="${videos[0].user.user_birthday }" readonly="readonly"></td>
                            </tr>

                            <tr>
                                <td>儿童</td>
                                <td><input type="text" size="10" value="姓名"></td>
                                <td>
                                    <select class="form-control" style="height:28px">
                        <option>男</option>
                        <option>女</option>
                    </select>
                                </td>
                                <td><input type="text" size="20" value="13301131116"></td>
                                <td><input type="text" size="15" value="身份证"></td>
                                <td><input type="text" size="28" value="13063519900417081X"></td>
                            </tr>

                        </tbody>
                    </table>
                    <!--数据列表/-->
                </div>
                <!--游客信息/-->


                <!--操作日志-->
                <div class="panel panel-default">
                    <div class="panel-heading">操作日志</div>
                    <!--数据列表-->
                    <table id="dataList" class="table table-bordered table-striped table-hover dataTable">
                        <thead>
                            <tr>
                                <th class="">管理员</th>
                                <th class="">内容</th>
                                <th class="">IP</th>
                                <th class="">时间</th>
                            </tr>
                        </thead>
                        <tbody>

                            <tr>
                                <td>-</td>
                                <td>-</td>
                                <td>-</td>
                                <td>-</td>
                            </tr>

                            <tr>
                                <td>-</td>
                                <td>-</td>
                                <td>-</td>
                                <td>-</td>
                            </tr>

                            <tr>
                                <td>-</td>
                                <td>-</td>
                                <td>-</td>
                                <td>-</td>
                            </tr>

                        </tbody>
                    </table>
                    <!--数据列表/-->
                </div>
                <!--操作日志/-->

                <!--工具栏-->
                 <div class="box-tools text-center">
                    <!-- <button type="submit" class="btn bg-maroon">保存</button> -->
                    <button type="button" class="btn bg-default" onclick="history.back(-1);">返回</button>
                </div> 
                <!--工具栏/-->

            </section>
            <!-- 正文区域 /-->
			</form>
        </div>
        <!-- 内容区域 /-->

        <!-- 底部导航 -->
        <footer class="main-footer">
            <div class="pull-right hidden-xs">
                <b>Version</b> 1.0.8
            </div>
            <strong>Copyright &copy; 2014-2017 <a href="http://www.itcast.cn">研究院研发部</a>.</strong> All rights reserved.
        </footer>
        <!-- 底部导航 /-->

    </div>


    <script src="${pageContext.request.contextPath}/plugins/jQuery/jquery-2.2.3.min.js"></script>
    <script src="${pageContext.request.contextPath}/plugins/jQueryUI/jquery-ui.min.js"></script>
    <script>
        $.widget.bridge('uibutton', $.ui.button);
    </script>
    <script src="${pageContext.request.contextPath}/plugins/bootstrap/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/plugins/raphael/raphael-min.js"></script>
    <script src="${pageContext.request.contextPath}/plugins/morris/morris.min.js"></script>
    <script src="${pageContext.request.contextPath}/plugins/sparkline/jquery.sparkline.min.js"></script>
    <script src="${pageContext.request.contextPath}/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
    <script src="${pageContext.request.contextPath}/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
    <script src="${pageContext.request.contextPath}/plugins/knob/jquery.knob.js"></script>
    <script src="${pageContext.request.contextPath}/plugins/daterangepicker/moment.min.js"></script>
    <script src="${pageContext.request.contextPath}/plugins/daterangepicker/daterangepicker.js"></script>
    <script src="${pageContext.request.contextPath}/plugins/daterangepicker/daterangepicker.zh-CN.js"></script>
    <script src="${pageContext.request.contextPath}/plugins/datepicker/bootstrap-datepicker.js"></script>
    <script src="${pageContext.request.contextPath}/plugins/datepicker/locales/bootstrap-datepicker.zh-CN.js"></script>
    <script src="${pageContext.request.contextPath}/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
    <script src="${pageContext.request.contextPath}/plugins/slimScroll/jquery.slimscroll.min.js"></script>
    <script src="${pageContext.request.contextPath}/plugins/fastclick/fastclick.js"></script>
    <script src="${pageContext.request.contextPath}/plugins/iCheck/icheck.min.js"></script>
    <script src="${pageContext.request.contextPath}/plugins/adminLTE/js/app.min.js"></script>
    <script src="${pageContext.request.contextPath}/plugins/treeTable/jquery.treetable.js"></script>
    <script src="${pageContext.request.contextPath}/plugins/select2/select2.full.min.js"></script>
    <script src="${pageContext.request.contextPath}/plugins/colorpicker/bootstrap-colorpicker.min.js"></script>
    <script src="${pageContext.request.contextPath}/plugins/bootstrap-wysihtml5/bootstrap-wysihtml5.zh-CN.js"></script>
    <script src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/js/bootstrap-markdown.js"></script>
    <script src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/locale/bootstrap-markdown.zh.js"></script>
    <script src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/js/markdown.js"></script>
    <script src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/js/to-markdown.js"></script>
    <script src="${pageContext.request.contextPath}/plugins/ckeditor/ckeditor.js"></script>
    <script src="${pageContext.request.contextPath}/plugins/input-mask/jquery.inputmask.js"></script>
    <script src="${pageContext.request.contextPath}/plugins/input-mask/jquery.inputmask.date.extensions.js"></script>
    <script src="${pageContext.request.contextPath}/plugins/input-mask/jquery.inputmask.extensions.js"></script>
    <script src="${pageContext.request.contextPath}/plugins/datatables/jquery.dataTables.min.js"></script>
    <script src="${pageContext.request.contextPath}/plugins/datatables/dataTables.bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/plugins/chartjs/Chart.min.js"></script>
    <script src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.min.js"></script>
    <script src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.resize.min.js"></script>
    <script src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.pie.min.js"></script>
    <script src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.categories.min.js"></script>
    <script src="${pageContext.request.contextPath}/plugins/ionslider/ion.rangeSlider.min.js"></script>
    <script src="${pageContext.request.contextPath}/plugins/bootstrap-slider/bootstrap-slider.js"></script>
    <script src="${pageContext.request.contextPath}/plugins/bootstrap-datetimepicker/bootstrap-datetimepicker.js"></script>
    <script src="${pageContext.request.contextPath}/plugins/bootstrap-datetimepicker/locales/bootstrap-datetimepicker.zh-CN.js"></script>
    <script>
        $(document).ready(function() {
            // 选择框
            $(".select2").select2();

            // WYSIHTML5编辑器
            $(".textarea").wysihtml5({
                locale: 'zh-CN'
            });
        });


        // 设置激活菜单
        function setSidebarActive(tagUri) {
            var liObj = $("#" + tagUri);
            if (liObj.length > 0) {
                liObj.parent().parent().addClass("active");
                liObj.addClass("active");
            }
        }


        $(document).ready(function() {

            // 激活导航位置
            setSidebarActive("admin-datalist");

            // 列表按钮 
            $("#dataList td input[type='checkbox']").iCheck({
                checkboxClass: 'icheckbox_square-blue',
                increaseArea: '20%'
            });
            // 全选操作 
            $("#selall").click(function() {
                var clicks = $(this).is(':checked');
                if (!clicks) {
                    $("#dataList td input[type='checkbox']").iCheck("uncheck");
                } else {
                    $("#dataList td input[type='checkbox']").iCheck("check");
                }
                $(this).data("clicks", !clicks);
            });
        });
        
        $(document).ready(function() {
            $('#datepicker-a3').datetimepicker({
                autoclose: true,
                /*  language: 'zh-CN', */
                format: "yyyy-mm-dd hh_ii:ss"
            });
        });
    </script>
</body>

</html>