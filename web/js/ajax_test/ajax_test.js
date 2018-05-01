$("#send-ajax").on('click',function () {
   var param = {'name':'ToMax','signature':'hhh'}
   post('ajax_test',param,function (data) {
       alert(data.desc)
   })
});

$("#display-list").on('click',function () {
    post('get_list',[],function (data) {
        liHtml =  ""
        for (var i = 0; i<data.length; i++){
            liHtml += "<li>"
            liHtml += "code : "+data[i].code
            liHtml += ", desc : "+data[i].desc
            liHtml += "</li>"
        }
        $("#list").html(liHtml)
    })
});