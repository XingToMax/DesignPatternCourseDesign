getMsgListRequest()

function getMsgListRequest() {
    post('msg/getMsgs',[],function (result) {
        listHtml = ''
        for (var i = 0; i < result.length; i++){
            listHtml += '<li class="list-group-item">'
            listHtml += '<span class="badge">'+result[i].name+'</span>'
            listHtml += result[i].content
            listHtml += '</li>'
        }
        $('#msg_list').html(listHtml)
    })
}

$('#msg_btn').on('click',function () {
    if (userId == -1){
        alert('留言请先登录')
    }else {
        var content = $('#msg_con').val()
        var param = {'content':content,'userId':userId}
        post('msg/addMsg',param,function (result) {
            alert(result.desc)
            getMsgListRequest()
        })
    }
})

$('#log').on('click',function () {
    if (userId == -1){
        window.location.href = 'login.jsp'
    }else {
        window.location.href = 'logout.jsp'
    }
})