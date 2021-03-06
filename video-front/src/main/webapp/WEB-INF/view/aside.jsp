<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>侧栏</title>
<!-- 页面meta -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <title>数据 - AdminLTE2定制版</title>
    <meta name="description" content="AdminLTE2定制版">
    <meta name="keywords" content="AdminLTE2定制版">

    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no" name="viewport">

    <link rel="stylesheet" href="./plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="./plugins/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="./plugins/ionicons/css/ionicons.min.css">
    <link rel="stylesheet" href="./plugins/iCheck/square/blue.css">
    <link rel="stylesheet" href="./plugins/morris/morris.css">
    <link rel="stylesheet" href="./plugins/jvectormap/jquery-jvectormap-1.2.2.css">
    <link rel="stylesheet" href="./plugins/datepicker/datepicker3.css">
    <link rel="stylesheet" href="./plugins/daterangepicker/daterangepicker.css">
    <link rel="stylesheet" href="./plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
    <link rel="stylesheet" href="./plugins/datatables/dataTables.bootstrap.css">
    <link rel="stylesheet" href="./plugins/treeTable/jquery.treetable.css">
    <link rel="stylesheet" href="./plugins/treeTable/jquery.treetable.theme.default.css">
    <link rel="stylesheet" href="./plugins/select2/select2.css">
    <link rel="stylesheet" href="./plugins/colorpicker/bootstrap-colorpicker.min.css">
    <link rel="stylesheet" href="./plugins/bootstrap-markdown/css/bootstrap-markdown.min.css">
    <link rel="stylesheet" href="./plugins/adminLTE/css/AdminLTE.css">
    <link rel="stylesheet" href="./plugins/adminLTE/css/skins/_all-skins.min.css">
    <link rel="stylesheet" href="./css/style.css">
    <link rel="stylesheet" href="./plugins/ionslider/ion.rangeSlider.css">
    <link rel="stylesheet" href="./plugins/ionslider/ion.rangeSlider.skinNice.css">
    <link rel="stylesheet" href="./plugins/bootstrap-slider/slider.css">
    <link rel="stylesheet" href="./plugins/bootstrap-datetimepicker/bootstrap-datetimepicker.css">
</head>
<body>
	<!-- 导航侧栏 /-->
	<aside class="main-sidebar">
            <!-- sidebar: style can be found in sidebar.less -->
            <section class="sidebar">
                <!-- Sidebar user panel -->
                <div class="user-panel">
                    <div class="pull-left image">
                        <img src="./img/user2-160x160.jpg" class="img-circle" alt="User Image">
                    </div>
                    <div class="pull-left info">
                        <p>张猿猿</p>
                        <a href="#"><i class="fa fa-circle text-success"></i> 在线</a>
                    </div>
                </div>
                <!-- search form -->
                <!--<form action="#" method="get" class="sidebar-form">
            <div class="input-group">
                <input type="text" name="q" class="form-control" placeholder="搜索...">
                <span class="input-group-btn">
                <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i>
                </button>
              </span>
            </div>
        </form>-->
                <!-- /.search form -->


                <!-- sidebar menu: : style can be found in sidebar.less -->
                <ul class="sidebar-menu">
                    <li class="header">菜单</li>

                    <li id="admin-index"><a href="all-admin-index.html"><i class="fa fa-dashboard"></i> <span>首页</span></a></li>

                    <!-- 菜单 -->



                    <li class="treeview">
                        <a href="#">
                    <i class="fa fa-folder"></i> <span>系统管理</span>
                    <span class="pull-right-container">
                        <i class="fa fa-angle-left pull-right"></i>
                    </span>
                </a>
                        <ul class="treeview-menu">

                            <li id="admin-login">
                                <a href="all-admin-login.html">
                            <i class="fa fa-circle-o"></i> 用户管理
                        </a>
                            </li>

                            <li id="admin-register">
                                <a href="all-admin-register.html">
                            <i class="fa fa-circle-o"></i> 角色管理
                        </a>
                            </li>
                            
                            <li id="admin-register">
                                <a href="all-admin-register.html">
                            <i class="fa fa-circle-o"></i> 订单管理
                            </li>


                        </ul>
                    </li>



                    <li class="treeview">
                        <a href="#">
                    <i class="fa fa-pie-chart"></i> <span>基础数据</span>
                    <span class="pull-right-container">
                        <i class="fa fa-angle-left pull-right"></i>
                    </span>
                </a>
                        <ul class="treeview-menu">

                            <li id="charts-chartjs">
                                <a href="all-charts-chartjs.html">
                            <i class="fa fa-circle-o"></i> 商品管理
                        </a>
                            </li>

                            <li id="charts-morris">
                                <a href="${pageContext.request.contextPath}/videoList">
                            <i class="fa fa-circle-o"></i> 订单管理
                        </a>
                            </li>

                        </ul>
                    </li>



                    <li class="treeview">
                        <a href="#">
                    <i class="fa fa-laptop"></i> <span>UI界面元素</span>
                    <span class="pull-right-container">
                        <i class="fa fa-angle-left pull-right"></i>
                    </span>
                </a>
                        <ul class="treeview-menu">

                            <li id="elements-general">
                                <a href="all-elements-general.html">
                            <i class="fa fa-circle-o"></i> 标准 General
                        </a>
                            </li>

                            <li id="elements-icons">
                                <a href="all-elements-icons.html">
                            <i class="fa fa-circle-o"></i> 图标 Icons
                        </a>
                            </li>

                            <li id="elements-buttons">
                                <a href="all-elements-buttons.html">
                            <i class="fa fa-circle-o"></i> 按钮 Buttons
                        </a>
                            </li>

                            <li id="elements-sliders">
                                <a href="all-elements-sliders.html">
                            <i class="fa fa-circle-o"></i> 滑块 Sliders
                        </a>
                            </li>

                            <li id="elements-timeline">
                                <a href="all-elements-timeline.html">
                            <i class="fa fa-circle-o"></i> 时间线 Timeline
                        </a>
                            </li>

                            <li id="elements-modals">
                                <a href="all-elements-modals.html">
                            <i class="fa fa-circle-o"></i> 对话框样式 Modals
                        </a>
                            </li>

                            <li id="elements-widgets">
                                <a href="all-elements-widgets.html">
                            <i class="fa fa-circle-o"></i> 窗体小部件 widgets
                        </a>
                            </li>

                        </ul>
                    </li>




                </ul>
            </section>
            <!-- /.sidebar -->
        </aside>
        <!-- 导航侧栏 /-->
        
            <script src="./plugins/jQuery/jquery-2.2.3.min.js"></script>
    <script src="./plugins/jQueryUI/jquery-ui.min.js"></script>
    <script>
        $.widget.bridge('uibutton', $.ui.button);
    </script>
    <script src="./plugins/bootstrap/js/bootstrap.min.js"></script>
    <script src="./plugins/raphael/raphael-min.js"></script>
    <script src="./plugins/morris/morris.min.js"></script>
    <script src="./plugins/sparkline/jquery.sparkline.min.js"></script>
    <script src="./plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
    <script src="./plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
    <script src="./plugins/knob/jquery.knob.js"></script>
    <script src="./plugins/daterangepicker/moment.min.js"></script>
    <script src="./plugins/daterangepicker/daterangepicker.js"></script>
    <script src="./plugins/daterangepicker/daterangepicker.zh-CN.js"></script>
    <script src="./plugins/datepicker/bootstrap-datepicker.js"></script>
    <script src="./plugins/datepicker/locales/bootstrap-datepicker.zh-CN.js"></script>
    <script src="./plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
    <script src="./plugins/slimScroll/jquery.slimscroll.min.js"></script>
    <script src="./plugins/fastclick/fastclick.js"></script>
    <script src="./plugins/iCheck/icheck.min.js"></script>
    <script src="./plugins/adminLTE/js/app.min.js"></script>
    <script src="./plugins/treeTable/jquery.treetable.js"></script>
    <script src="./plugins/select2/select2.full.min.js"></script>
    <script src="./plugins/colorpicker/bootstrap-colorpicker.min.js"></script>
    <script src="./plugins/bootstrap-wysihtml5/bootstrap-wysihtml5.zh-CN.js"></script>
    <script src="./plugins/bootstrap-markdown/js/bootstrap-markdown.js"></script>
    <script src="./plugins/bootstrap-markdown/locale/bootstrap-markdown.zh.js"></script>
    <script src="./plugins/bootstrap-markdown/js/markdown.js"></script>
    <script src="./plugins/bootstrap-markdown/js/to-markdown.js"></script>
    <script src="./plugins/ckeditor/ckeditor.js"></script>
    <script src="./plugins/input-mask/jquery.inputmask.js"></script>
    <script src="./plugins/input-mask/jquery.inputmask.date.extensions.js"></script>
    <script src="./plugins/input-mask/jquery.inputmask.extensions.js"></script>
    <script src="./plugins/datatables/jquery.dataTables.min.js"></script>
    <script src="./plugins/datatables/dataTables.bootstrap.min.js"></script>
    <script src="./plugins/chartjs/Chart.min.js"></script>
    <script src="./plugins/flot/jquery.flot.min.js"></script>
    <script src="./plugins/flot/jquery.flot.resize.min.js"></script>
    <script src="./plugins/flot/jquery.flot.pie.min.js"></script>
    <script src="./plugins/flot/jquery.flot.categories.min.js"></script>
    <script src="./plugins/ionslider/ion.rangeSlider.min.js"></script>
    <script src="./plugins/bootstrap-slider/bootstrap-slider.js"></script>
    <script src="./plugins/bootstrap-datetimepicker/bootstrap-datetimepicker.js"></script>
    <script src="./plugins/bootstrap-datetimepicker/locales/bootstrap-datetimepicker.zh-CN.js"></script>
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
    </script>
</body>
</html>