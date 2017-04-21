<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html ../public "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
    <meta name="keywords" content="admin, dashboard, bootstrap, template, flat, modern, theme, responsive, fluid, retina, backend, html5, css, css3">
    <meta name="description" content="">
    <meta name="author" content="ThemeBucket">
    <link rel="shortcut icon" href="#" type="image/png">

    <title>ZMALL后台管理系统</title>
    <!--common-->
    <link href="../public/js/iCheck/skins/minimal/minimal.css" rel="stylesheet">
    <link href="../public/js/iCheck/skins/square/square.css" rel="stylesheet">
    <link href="../public/js/iCheck/skins/square/red.css" rel="stylesheet">
    <link href="../public/js/iCheck/skins/square/blue.css" rel="stylesheet">
    <link href="../public/css/clndr.css" rel="stylesheet">
    <link href="../public/js/layui/css/layui.css" rel="stylesheet">
    <link href="../public/css/style.css" rel="stylesheet">
    <link href="../public/css/style-responsive.css" rel="stylesheet">
</head>
<body class="sticky-header">

<section>
    <!-- left side start-->
    <jsp:include page="navigation.jsp"></jsp:include>
    <!-- left side end-->

    <!-- main content start-->
    <div class="main-content">

        <!-- header section start-->
        <jsp:include page="header.jsp"></jsp:include>
        <!-- header section end-->


        <!--body wrapper start-->

        <div class="page-heading">
            <h3>
                人事管理
            </h3>
            <ul class="breadcrumb">
                <li>
                    <a href="#">角色</a>
                </li>
                <li class="active">角色新增</li>
            </ul>
        </div>
        <section class="wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <section class="panel">
                        <div class="panel-body">
                            <div class="form">
                                <form class="cmxform form-horizontal adminex-form" id="add-role-form" method="post" action="../role/addSubmit.action">
                                    <div class="form-group ">
                                        <label for="name" class="control-label col-lg-1">角色名称:</label>
                                        <div class="col-lg-10">
                                            <input class=" form-control" id="name" name="name" type="text" />
                                        </div>
                                    </div>
                                    <div class="form-group ">
                                        <label for="remark" class="control-label col-lg-1">备注:</label>
                                        <div class="col-lg-10">
                                            <textarea class=" form-control" id="remark" name="remark"></textarea>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-lg-offset-2 col-lg-10">
                                            <input  class="btn btn-primary" type="button" onclick="addRole.formSubmit(this)" value="保存"/>
                                            <button class="btn btn-default" type="reset">清空</button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </section>
                </div>
            </div>
        </section>
    </div>
    <!-- main content end-->
</section>
<script src="../public/js/jquery-1.10.2.min.js"></script>
<script src="../public/js/jquery-ui-1.9.2.custom.min.js"></script>
<script src="../public/js/jquery-migrate-1.2.1.min.js"></script>
<script src="../public/js/bootstrap.min.js"></script>
<script src="../public/js/modernizr.min.js"></script>
<script src="../public/js/jquery.nicescroll.js"></script>

<script type="text/javascript" src="../public/js/jquery.validate.min.js"></script>
<script src="../public/js/layui/lay/dest/layui.all.js"/>
<script src="../public/js/validation-init.js"></script>
<script src="../public/js/form.ajax.plugin.js"></script>
<!--common scripts for all pages-->
<script src="../public/js/scripts.js"></script>
<script type="text/javascript">
    var layer = layui.layer;
    var addRole={
        validate:function(){
            var name = $.trim($("#name").val());
            var remark = $.trim($("#remark").val());
            if(name == null || name == '' || name== undefined){
                layer.alert("角色名称不能为空",{icon:2},function(index){
                    layer.close(index);
                });
                return false;
            }
            if(remark != null && remark != '' && remark != undefined && remark.length > 200){
                layer.alert("备注不能多于200个字符",{icon:2},function(index){
                    layer.close(index);
                });
                return false;
            }
            return true;
        },
        formSubmit:function(submitBtn){
            $("#add-role-form").ajaxSubmit({
                beforeSend:function(){
                    $(submitBtn).attr("disabled", "disabled");
                    $(submitBtn).addClass("disabled");
                    return addRole.validate();;
                },
                success:function(data){
                    addRole.submitSuccess(data);
                },
                complete:function(){
                    $(submitBtn).removeAttr("disabled");
                    $(submitBtn).removeClass("disabled");
                }
            });
        },
        submitSuccess: function (result) {
            if (result.status == 200) {
                layer.alert("角色新增成功",{icon:1},function(index){
                    layer.close(index);
                    location.href="../role/list";
                })
            } else {
                var msg = result.message || "角色新增失败";
                layer.alert(msg, {icon: 2}, function (index) {
                    layer.close(index)
                });
            }
        },
    };
    $(document).ready(function(){
        $("#add-role-form").validate({
            rules: {
                name: {
                    required:true,
                    remote:{
                        url: "../role/check.action",
                        type: "post",
                        data: {
                            name: function () {
                                var name = $.trim($("#name").val());
                                if (name == undefined) {
                                    name = '';
                                }
                                return name;
                            }
                        }
                    }
                },
                remark: {
                    maxlength: 200
                }
            },
            messages: {
                name: {
                    required:"角色名称不能为空",
                    remote:"该角色已经存在"
                },
                remark: {
                    maxlength: "最多200字符"
                }
            }
        })
    });
</script>
</body>


</html>