function go_to_login() {
    window.location.href = "login.jsp"
}

$("#reg_btn").on('click',function () {
    var username = $('#username').val()
    var password = $('#password').val()
    var param = {'name':username,'password':password}
    post('user/register',param,function (result) {
        if (result.code == '200'){
            alert(result.desc)
            window.location.href = "login.jsp"
        }else {
            alert(result.desc)
            window.location.href = "register.jsp"
        }
    })
})