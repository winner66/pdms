var prefix = "/pd/param/std";

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
            name : {
                required : true
            },
            code : {
                required : true
            },
            // gp : {
            //     required : true
            // },
            idx : {
                required : true,
                number: true
            },
        },
        messages : {
            name : {
                required : icon + "请输入名称"
            },
            code : {
                required : icon + "请输入代码"
            },
            // gp : {
            //     required : icon + "请选择分类"
            // },
            idx : {
                required : icon + "请输入序号",
                number: icon + "请输入数字",
            },
        }
    })
}