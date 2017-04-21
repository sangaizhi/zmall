<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
<meta name="description" content="">
<meta name="author" content="ThemeBucket">
<link rel="shortcut icon" href="#" type="image/png">

<title>Login</title>

<link href="../public/css/style.css" rel="stylesheet">
<link href="../public/css/style-responsive.css" rel="stylesheet">
</head>

<body class="login-body">
	<div class="container">
		<form class="form-signin"
			action="../user/login.action" method="POST">
			<div class="form-signin-heading text-center">
				<h1 class="sign-title">Sign In</h1>
				<img src="images/login-logo.png" alt="" />
			</div>
			<div class="login-wrap">
				<div class="form-group ">
					<label for="name" class="control-label col-lg-3 col-md-3 col-sm-3 col-xs-3 padl0 text-r">账号</label>
					<div class=" col-lg-9 col-md-9 col-sm-9 col-xs-9">
						<input type="text" id="account" name="account" autofocus=""
							   placeholder="用户名/手机号" class="form-control">
					</div>
				</div>
				<div class="form-group ">
					<label for="password" class="control-label col-lg-3 col-md-3 col-sm-3 col-xs-3 padl0 text-r">密码</label>
					<div class="col-lg-9 col-md-9 col-sm-9 col-xs-9">
						<input type="password" id="password" name="password"
							   placeholder="密码" class="form-control">
					</div>
				</div>
				<button type="submit" id="submit"
						class="btn btn-lg btn-login btn-block" disabled
						onclick="register.addSubmit()">
					<i class="fa fa-check"></i>
				</button>
				<label class="checkbox"> <input type="checkbox"
					value="remember-me"> Remember me <span class="pull-right">
						<a data-toggle="modal" href="#myModal"> Forgot Password?</a>
				</span>
				</label>
			</div>

			<!-- Modal -->
			<div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog"
				tabindex="-1" id="myModal" class="modal fade">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">&times;</button>
							<h4 class="modal-title">Forgot Password ?</h4>
						</div>
						<div class="modal-body">
							<p>Enter your e-mail address below to reset your password.</p>
							<input type="text" name="email" placeholder="Email"
								autocomplete="off" class="form-control placeholder-no-fix">

						</div>
						<div class="modal-footer">
							<button data-dismiss="modal" class="btn btn-default"
								type="button">Cancel</button>
							<button class="btn btn-primary" type="button">Submit</button>
						</div>
					</div>
				</div>
			</div>
			<!-- modal -->

		</form>

	</div>
	<!-- Placed js at the end of the document so the pages load faster -->
	<!-- Placed js at the end of the document so the pages load faster -->
	<script src="../public/js/jquery-1.10.2.min.js"></script>
	<script src="../publicjs/bootstrap.min.js"></script>

</body>
</html>