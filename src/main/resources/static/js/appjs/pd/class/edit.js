var prefix = "/pd/class"

$(function () {
    validate();
});

$.validator.setDefaults({
    submitHandler: function () {
        save();
    }
});

function save() {
    var data = new FormData($('#dataForm')[0]);
    $.ajax({
        cache: false,
        type: "POST",
        url: prefix + "/save",
        data: data,
        async: false,
        contentType: false,
        processData: false,
        error: function (data) {
            layer.alert("Connection error");
        },
        success: function (data) {
            if (data.code == 0) {
                parent.layer.msg("保存成功");
                parent.reLoad();
                var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
                parent.layer.close(index);
            } else {
                layer.alert(data.msg)
            }
        }
    });

}

function validate() {
    var icon = "<i class='fa fa-times-circle'></i> ";
    $("#dataForm").validate({
        rules: {
            name: {
                required: true
            },
            showName: {
                required: true,
            },
            // qaGp:{
            //     required:true,
            // },
            idx: {
                required: true,
                number: true,
            }

        },
        messages: {
            name: {
                required: icon + "请输入名称"
            },
            showName: {
                required: icon + "请输入显示名称"
            },
            // qaGp: {
            //     required: icon + "请选择二级分类-等级"
            // },
            idx: {
                required: icon + "请输入序号",
                number: icon + "请输入数字",
            }
        }
    })
}