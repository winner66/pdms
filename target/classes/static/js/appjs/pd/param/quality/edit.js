var prefix = "/pd/param/quality";

$().ready(function () {
    validateRule();
});

$.validator.setDefaults({
    submitHandler: function () {
        save();
    }
});

function save() {
    $('#name').val($('#gp').val());
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
            code: {
                required: true
            },
            gp: {
                required: true
            },
            idx: {
                required: true,
                number: true,
            },
        },
        messages: {
            name: {
                required: icon + "请输入质量等级"
            },
            code: {
                required: icon + "请输入分组"
            },
            pcName: {
                required: icon + "清输入序号",
                number: icon + "清输入数字"
            },
        }
    })
}