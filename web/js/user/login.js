function go_to_register() {
    window.location.href = "register.jsp"
}
function loginAction() {
    var username = $('#username').val()
    var password = $('#password').val()
    var flag = $('#remb').is(':checked')
    var param = {username:username, password:password, flag:flag}
    post("login",param,function (result) {
        if (result == "200"){
            window.location.href = "index.jsp"
        }else if (result == "400"){
            alert("用户名或密码错误")
            window.location.href = "login.jsp"
        }else {
            //TODO:处理其他结果
        }
    });
}
