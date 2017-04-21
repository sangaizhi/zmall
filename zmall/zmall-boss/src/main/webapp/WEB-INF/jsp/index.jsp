<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
    <link href="public/css/clndr.css" rel="stylesheet">
    <link href="public/css/style.css" rel="stylesheet">
    <link href="public/css/style-responsive.css" rel="stylesheet">
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

            <iframe src="" id="content-iframe" style="width:100%;height:100%; bottom:0px;top:51px;position:fixed;"></iframe>

        <!--body wrapper end-->

        <!--footer section start-->
        <%--<jsp:include page="footer.jsp"></jsp:include>--%>
        <!--footer section end-->


    </div>
    <!-- main content end-->
</section>


</body>

<script src="public/js/jquery-1.10.2.min.js"></script>
<script src="public/js/jquery-ui-1.9.2.custom.min.js"></script>
<script src="public/js/jquery-migrate-1.2.1.min.js"></script>
<script src="public/js/jquery.jsonp.js"></script>
<script src="public/js/bootstrap.min.js"></script>
<script src="public/js/jquery.nicescroll.js"></script>


<!--easy pie chart-->

<!--Sparkline Chart-->

<!--icheck -->

<!-- jQuery Flot Chart-->
<!--common scripts for all pages-->
<script src="public/js/scripts.js"></script>
<script type="text/javascript">
</script>
</html>