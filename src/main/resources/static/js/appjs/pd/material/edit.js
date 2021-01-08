var prefix = "/pd/material";

$().ready(function () {
    loadSelect();
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
        ignore: ":hidden:not(select)",
        rules: {
            tag: {
                required: true
            },
            tag2:{
                required: true
            }

        },
        messages: {

            tag:{
                required: icon + "请选择一级材料类型"
            },
            tag2:{
                required: icon + "请选择二级材料类型"
            },


        }
    })
}

function loadSelect() {
    $("#quality").chosen({
        maxHeight: 200,
        // search_contains: true,
        no_results_text: "未找到",
    });
    $("#size").chosen({
        maxHeight: 200,
        // search_contains: true,
        no_results_text: "未找到",
    });

}

function resetSize(){
    // $("#pdSizeId").val('');
    $("#size").val('');
    var html = '<option value="">' + '请选择尺寸' + '</option>';
    // if (sizes[$("#pdClassId").val()] && sizes[$("#pdClassId").val()][$("#std").val()]) {
    var data = sizes[$("#std").val()];
    if (data && Array.isArray(data)) {
        for (var i = 0; i < data.length; i++) {
            html += '<option value="' + data[i].code + '">' + data[i].code + '</option>'
        }
    }
    $("#size").html(html);
    // $('#pdSizeId').on('change', function(e, params) {
    //     // var text = $("#pdSizeId").find("option:selected").text();
    //     var text = $("#pdSizeId").find("option[value="+ params.selected +"]").text();
    //     $("#size").val(text);
    // });
    $("#size").trigger("chosen:updated");
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

openModel = function () {
    var win = layer.open({
        type: 2,
        title: "选择产品型号",
        maxmin: true,
        area: ['1200px', '600px'],
        content: "/pd/model?mode=win"
    })
    // layer.full(win);
}

function setQa(code) {
    // alert($('#tolerance').val());
    // alert($('#outlet').val());
}

function setStd(code) {
    $("#std").val(code);
    resetSize();
    // setQa();
}

function setModel(id, code, pdClassId) {
    $("#pdModelId").val(id);
    $("#model").val(code.split("|")[0]);
    $("#pdClassId").val(pdClassId);
}