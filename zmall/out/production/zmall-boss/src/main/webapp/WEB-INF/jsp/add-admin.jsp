<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE public "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
    <meta name="keywords"
          content="admin, dashboard, bootstrap, template, flat, modern, theme, responsive, fluid, retina, backend, html5, css, css3">
    <meta name="description" content="">
    <meta name="author" content="ThemeBucket">
    <link rel="shortcut icon" href="#" type="image/png">

    <title>ZMALL后台管理系统</title>
    <!--common-->
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
                管理员管理
            </h3>
            <ul class="breadcrumb">
                <li>
                    <a href="#">管理员</a>
                </li>
                <li class="active">管理员新增</li>
            </ul>
        </div>
        <section class="wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <section class="panel">
                        <div class="panel-body">
                            <div class="form">
                                <form class="cmxform form-horizontal adminex-form" id="add-admin-form" method="post"
                                      action="../admin/addSubmit.action">
                                    <div class="form-group ">
                                        <label for="name" class="control-label col-lg-1">管理员姓名:</label>
                                        <div class="col-lg-4">
                                            <input class=" form-control" id="name" name="name" type="text"/>
                                        </div>
                                    </div>
                                    <div class="form-group ">
                                        <label for="phone" class="control-label col-lg-1">管理员电话:</label>
                                        <div class="col-lg-4">
                                            <input class=" form-control" id="phone" name="phone"/>
                                        </div>
                                    </div>
                                    <div class="form-group ">
                                        <label for="email" class="control-label col-lg-1">管理员邮箱:</label>
                                        <div class="col-lg-4">
                                            <input class=" form-control" id="email" name="email"/>
                                        </div>
                                    </div>
                                    <div class="form-group ">
                                        <label for="remark" class="control-label col-lg-1">备注:</label>
                                        <div class="col-lg-4">
                                            <textarea class=" form-control" id="remark" name="remark"></textarea>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="remark" class="control-label col-lg-1">所属角色:</label>
                                        <div class="col-lg-10">
                                            <c:if test="${roleList.size() > 0}">
                                                <c:forEach items="${roleList}" var="role" varStatus="roleStatus">
                                                    <span class="margr-25 width-100 inline-block">
                                                    <input type="checkbox" class="role_item" id="role_${role.id}" name="roleIds"
                                                           value="${role.id}"> <label
                                                            for="role_${role.id}">${role.name}</label>
                                                        </span>
                                                    <c:if test="${roleStatus.count % 10 == 0}">
                                                        <br/>
                                                    </c:if>
                                                </c:forEach>
                                            </c:if>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-lg-offset-2 col-lg-10">
                                            <input class="btn btn-primary" type="button"
                                                   onclick="addAdmin.formSubmit(this)" value="保存"/>
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
<script src="../public/js/zmall-validate.js"></script>

<!--common scripts for all pages-->
<script src="../public/js/scripts.js"></script>
<script type="text/javascript">
    var layer = layui.layer;
    var addAdmin = {
        validate: function () {
            var name = $.trim($("#name").val());
            var phone = $.trim($("#phone").val());
            var email = $.trim($("#email").val());
            var remark = $.trim($("#remark").val());
            if (name == null || name == '' || name == undefined) {
                layer.alert("管理员名称不能为空", {icon: 2}, function (index) {
                    layer.close(index);
                });
                return false;
            }
            if (phone == null || phone == '' || phone == undefined) {
                layer.alert("管理员电话不能为空", {icon: 2}, function (index) {
                    layer.close(index);
                });
                return false;
            }
            if (email == null || email == '' || email == undefined) {
                layer.alert("管理员邮箱不能为空", {icon: 2}, function (index) {
                    layer.close(index);
                });
                return false;
            }
            if (remark != null && remark != '' && remark != undefined && remark.length > 200) {
                layer.alert("备注不能多于200个字符", {icon: 2}, function (index) {
                    layer.close(index);
                });
                return false;
            }
            var roleIds = [];
            $(".role_item:checked").each(function(i,item){
                roleIds.push($(this).val());
            });
            if(roleIds.length <= 0){
                layer.alert("请至少选择一个角色", {icon: 2}, function (index) {
                    layer.close(index);
                });
                return false;
            }
            return true;
        },
        formSubmit: function (submitBtn) {
            $("#add-admin-form").ajaxSubmit({
                beforeSend: function () {
                    $(submitBtn).attr("disabled", "disabled");
                    $(submitBtn).addClass("disabled");
                    return addAdmin.validate();
                    ;
                },
                success: function (data) {
                    addAdmin.submitSuccess(data);
                },
                complete: function () {
                    $(submitBtn).removeAttr("disabled");
                    $(submitBtn).removeClass("disabled");
                }
            });
        },
        submitSuccess: function (result) {
            if (result.status == 200) {
                layer.alert("管理员新增成功", {icon: 1}, function (index) {
                    layer.close(index);
                    location.href = "../admin/list";
                })
            } else {
                var msg = result.message || "管理员新增失败";
                layer.alert(msg, {icon: 2}, function (index) {
                    layer.close(index)
                });
            }
        },
    };
    $(document).ready(function () {
        $("#add-admin-form").validate({
            rules: {
                name: {
                    required: true,
                    maxlength: 20
                },
                phone: {
                    required: true,
                    phone: true,
                    remote: {
                        url: "../admin/check.action",
                        type: "post",
                        data: {
                            account: function () {
                                var account = $.trim($("#phone").val());
                                if (account == undefined) {
                                    account = '';
                                }
                                return account;
                            },
                            type: 2
                        }
                    }
                },
                email: {
                    required: true,
                    email: true,
                    remote: {
                        url: "../admin/check.action",
                        type: "post",
                        data: {
                            account: function () {
                                var account = $.trim($("#email").val());
                                if (account == undefined) {
                                    account = '';
                                }
                                return account;
                            },
                            type: 3
                        }
                    }
                },
                remark: {
                    maxlength: 200
                }
            },
            messages: {
                name: {
                    required: "管理员名称不能为空",
                    remote: "该管理员已经存在"
                },
                phone: {
                    required: "管理员电话不能为空",
                    phone: "管理员电话格式不正确",
                    remote: "该电话已经被占用"
                },
                email: {
                    required: "管理员邮箱不能为空",
                    email: "管理员邮箱格式不正确",
                    remote: "该邮箱已经被占用"
                },
                remark: {
                    required: "Please enter a username",
                    maxlength: "最多200字符"
                }
            }
        })
    });
</script>
</body>


</html>