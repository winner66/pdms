var prefix = "/pd/param/temperature";

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
        rules : {
            code : {
                required : true
            },
            name : {
                required : true
            },
            idx : {
                required : true,
                number: true
            },
        },
        messages : {
            code : {
                required : icon + "请输入温度特性/系数"
            },
            name : {
                required : icon + "请输入描述"
            },
            idx : {
                required : icon + "请输入序号",
                number: icon + "请输入数字",
            },
        }
    })
}