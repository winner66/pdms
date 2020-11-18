var prefix = "/pd/param/size";

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
            code: {
                required: true
            },
            stdName: {
                required: true
            },
            idx : {
                required : true,
                number: true
            },
        },
        messages: {
            code: {
                required: icon + "请输入产品尺寸"
            },
            className: {
                required: icon + "请选择执行标准"
            },
            idx : {
                required : icon + "请输入序号",
                number: icon + "请输入数字",
            },
        }
    })
}

var openClass = function () {
    layer.open({
        type: 2,
        title: "选择产品分类",
        maxmin: true,
        area: ['1200px', '600px'],
        content: "/pd/class/tree-view"
    })
}

var openStd = function () {
    var win = layer.open({
        type: 2,
        title: "选择执行标准",
        maxmin: true,
        area: ['1200px', '600px'],
        content: "/pd/param/std?mode=win"
    })
    // layer.full(win);
}

function setClass(gp, className) {
    $("#gp").val(gp);
    $("#className").val(className);
}

function setStd(code) {
    $("#rel").val(code);
    $("#stdName").val(code);
}
