<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type="text/javascript">
        function addUser() {
            document.getElementById("addUser").style.display = "block";
        }

        function updateUser(id,name,address,phone) {
            $("#id").val(id);
            $("#name").val(name);
            $("#address").val(address);
            $("#phone").val(phone);
            document.getElementById("updateUser").style.display = "block";
        }

        function deleteUser(id) {
            $.ajax({
                url: '/user/deleteUser.do',
                type: 'POST',
                data: {id:id},
                dataType: 'json',
                success: function (data) {
                    window.location.reload();
                }
            })
        }
    </script>
</head>
<body>
<div>
    <a href="#" onclick="addUser()">新增</a>
</div>
<table border="1">
    <tbody>
    <c:forEach var="item" items="${list}">
        <tr>
            <td>${item.id}</td>
            <td>${item.name}</td>
            <td>${item.address}</td>
            <td>${item.phone}</td>
            <td><a href="#" onclick="updateUser('${item.id}','${item.name}','${item.address}','${item.phone}')">修改</a></td>
            <td><a href="#" onclick="deleteUser(${item.id})">删除</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<div id="addUser" style="display:none;">
    <form action="/user/addUser.do" method="post" id="loginForm">

        <div class="control-group">
            <input type="text" placeholder="user_name"  name="name">
        </div>
        <div class="control-group">
            <input type="text" placeholder="address" name="address">
        </div>
        <div class="control-group">
            <input type="text" placeholder="phone"  name="phone">
        </div>
        <div class="relogin">
            <button type="submit" id="login-submit-btn" class="btn green" style="margin-left: 20px">
                submit
            </button>
        </div>
    </form>
</div>

<div id="updateUser" style="display:none;">
    <form action="/user/addUser.do" method="post" >
        <div class="control-group">
            <input hidden="hidden" class="m-wrap placeholder-no-fix" type="text" placeholder="id" id="id" name="id">
        </div>
        <div class="control-group">
            <input class="m-wrap placeholder-no-fix" type="text" placeholder="user_name" id="name"  name="name">
        </div>
        <div class="control-group">
            <input class="m-wrap placeholder-no-fix" type="text" placeholder="address"  id="address" name="address">
        </div>
        <div class="control-group">
            <input class="m-wrap placeholder-no-fix" type="text" placeholder="phone" id="phone" name="phone">
        </div>
        <div class="relogin">
            <button type="submit" class="btn green"
                    style="margin-left: 20px">
                update <i class="m-icon-swapright m-icon-white"></i>
            </button>
        </div>
    </form>
</div>

</body>
</html>
