var prefix = "/cm/contact";

$().ready(function () {
    validateRule();
});

$.validator.setDefaults({
    submitHandler: function () {
        save();
    }
});

function save() {
    $.ajax({
        cache: false,
        type: "POST",
        url: prefix + "/save",
        data: serializeNotNull($('#dataForm').serialize()),
        async: false,
        error: function (request) {
            alert("Connection error");
        },
        success: function (data) {
            if (data.code == 0) {
                parent.layer.msg(data.msg);
                parent.reLoad();
                var index = parent.layer.getFrameIndex(window.name);
                parent.layer.close(index);
            } else {
                parent.layer.msg(data.msg);
            }
        }
    });
}

function validateRule() {
    var icon = "<i class='fa fa-times-circle'></i> ";
    $("#dataForm").validate({
        rules: {
            name: {
                required: true
            },
            // address: {
            //     required: true,
            // },
            type:{
                required:true,
            }
        },
        messages: {
            name: {
                required: icon + "请输入名称"
            },
            // address: {
            //     required: icon + "请输入地址"
            // },
            type: {
                required: icon + "请选择类型"
            }
        }
    })
}
