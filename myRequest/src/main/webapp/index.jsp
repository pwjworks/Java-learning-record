<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>登录</h2>
<div style="text-align: center">
    <form action="${pageContext.request.contextPath}/login" method="post">
        <label>
            用户名：<input type="text" name="username">
        </label><br>
        <label>
            密码：<input type="password" name="password">
        </label><br>
        <label>
            <input type="checkbox" name="hobby" value="sing">
            唱歌
        </label>
        <label>
            <input type="checkbox" name="hobby" value="dance">
            跳舞
        </label>
        <input type="submit">
    </form>
</div>
</body>
</html>
