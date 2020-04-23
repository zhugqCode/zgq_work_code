<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <!--inline styles related to this page-->
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>admin</title>
</head>
<body>
<form action="/user/userLogin.do" method="post" id="loginForm">
    <input type="hidden" name="method" value="login">
    <div class="control-group">
        <div class="controls">
            <div class="input-icon left">
                <i class="icon-user"></i>
                <input class="m-wrap placeholder-no-fix" type="text" placeholder="user_name" id="username" name="username">
            </div>
        </div>
    </div>
    <div class="control-group">
        <div class="controls">
            <div class="input-icon left">
                <i class="icon-lock"></i> <input class="m-wrap placeholder-no-fix"
                                                 type="password" placeholder="password" id="password" name="password">
            </div>
        </div>
    </div>
    <div class="relogin">
        <!-- 单击登录 -->
        <button type="submit" id="login-submit-btn" class="btn green"
                style="margin-left: 20px">
            login <i class="m-icon-swapright m-icon-white"></i>
        </button>
    </div>
</form>

</body>

</html>