<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE public "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
    <META HTTP-EQUIV="Pragma" CONTENT="no-cache">
    <META HTTP-EQUIV="Cache-Control" CONTENT="no-cache">
    <META HTTP-EQUIV="Expires" CONTENT="0">
    <link rel="shortcut icon" href="#" type="image/png">

    <title>ZMALL后台管理系统</title>
    <!--common-->
    <link href="../public/css/clndr.css" rel="stylesheet">
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
                    <a href="#">管理员</a>
                </li>
                <li class="active">管理员列表</li>
            </ul>
        </div>
        <div class="wrapper">
            <div class="row">
                <div class="col-sm-12">
                    <section class="panel">
                        <div class="panel-body">
                            <div class="adv-table editable-table ">
                                <div class="clearfix">
                                    <div class="btn-group">
                                        <a href="../admin/add.html" id="editable-sample_new" class="btn btn-primary">
                                            新增
                                        </a>
                                    </div>
                                    <div class="space15"></div>
                                    <table class="table table-striped table-hover table-bordered" id="editable-sample">
                                        <thead>
                                        <tr>
                                            <th>操作</th>
                                            <th>名称</th>
                                            <th>电话</th>
                                            <th>邮箱</th>
                                            <th>状态</th>
                                            <th>头像</th>
                                            <th>创建人</th>
                                            <th>创建时间</th>
                                            <th>编辑人</th>
                                            <th>编辑时间</th>
                                            <th>备注</th>
                                        </tr>
                                        </thead>
                                        <tbody id="role-list-tbody">
                                        <c:if test="${list.size() > 0}">
                                            <c:forEach items="${list}" var="admin">
                                                <tr>
                                                    <td></td>
                                                    <td>${admin.name}</td>
                                                    <td>${admin.phone}</td>
                                                    <td>${admin.email}</td>
                                                    <td>${admin.status}</td>
                                                    <td>${admin.userImg}</td>
                                                    <td>${null != admin.createUser ? admin.createUser.name : ''}</td>
                                                    <td><fmt:formatDate value="${admin.createTime}"
                                                                        pattern="yyyy-MM-dd hh:mm:ss"/></td>
                                                    <td>${null != admin.modifyUser ? admin.modifyUser.name : ''}</td>
                                                    <td><fmt:formatDate value="${admin.lastModifyTime}"
                                                                        pattern="yyyy-MM-dd hh:mm:ss"/></td>
                                                    <td>${admin.remark}</td>
                                                </tr>
                                            </c:forEach>
                                        </c:if>
                                        </tbody>
                                    </table>
                                    <div id="pager">
                                    </div>
                                </div>
                            </div>
                    </section>
                </div>
            </div>
        </div>
    </div>
    <!-- main content end-->
</section>


</body>

<script src="../public/js/jquery-1.10.2.min.js"></script>
<script src="../public/js/jquery-ui-1.9.2.custom.min.js"></script>
<script src="../public/js/jquery-migrate-1.2.1.min.js"></script>
<script src="../public/js/bootstrap.min.js"></script>
<script src="../public/js/bootstrap-paginator.js"></script>
<script src="../public/js/modernizr.min.js"></script>
<script src="../public/js/jquery.nicescroll.js"></script>


<!-- jQuery Flot Chart-->
<!--common scripts for all pages-->
<script src="../public/js/scripts.js"></script>
<script src="../public/js/editable-table.js"></script>
<script src="../public/js/zmall-common.js"></script>
<script src="../public/js/zmall-page.js"></script>
<input type="hidden" id="pageNum" value="${page.pageNum}">
<script>
    var options = {
        currentPage: ${page.pageNum},
        totalPages: ${page.pageCount},
        alignment: 'right',
        pageUrl: function (type, page, current) {
            return "javascript:zmallPage.jumpPageByGet(" + page + ",10)";
        }
    }

    $('#pager').bootstrapPaginator(options);
</script>
</html>