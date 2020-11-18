var prefix = "/pd/info";

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
            std: {
                required: true
            },
            quality: {
                required: true
            },
            model: {
                required: true
            },
            size: {
                required: true
            },
            cMin: {
                required: true
            },
            cMax: {
                required: true
            },
        },
        messages: {
            std: {
                required: icon + "请选择执行标准"
            },
            quality: {
                required: icon + "请选择质量等级"
            },
            model: {
                required: icon + "请选择型号"
            },
            size: {
                required: icon + "请选择尺寸"
            },
            cMin: {
                required: icon + "请输入容量起"
            },
            cMax: {
                required: icon + "请输入容量止"
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
    $("#temperature").chosen({
        maxHeight: 200,
        // search_contains: true,
        no_results_text: "未找到",
    });
    $("#voltage").chosen({
        maxHeight: 200,
        // search_contains: true,
        no_results_text: "未找到",
    });
    $("#tolerance").chosen({
        maxHeight: 200,
        // search_contains: true,
        no_results_text: "未找到",
    });
    $("#outlet").chosen({
        maxHeight: 200,
        // search_contains: true,
        no_results_text: "未找到",
    });
    $("#cMin").chosen({
        maxHeight: 200,
        // search_contains: true,
        no_results_text: "未找到",
    });
    $("#cMax").chosen({
        maxHeight: 200,
        // search_contains: true,
        no_results_text: "未找到",
    });
    $("#outlet").chosen({
        maxHeight: 200,
        // search_contains: true,
        no_results_text: "未找到",
    });
    $("#elecCode").chosen({
        maxHeight: 200,
        // search_contains: true,
        no_results_text: "未找到",
    });
    $("#capNum").chosen({
        maxHeight: 200,
        // search_contains: true,
        no_results_text: "未找到",
    });
    $("#elecType").chosen({
        maxHeight: 200,
        // search_contains: true,
        no_results_text: "未找到",
    });
    $("#temperRange").chosen({
        maxHeight: 200,
        // search_contains: true,
        no_results_text: "未找到",
    });
    $("#wireMa").chosen({
        maxHeight: 200,
        // search_contains: true,
        no_results_text: "未找到",
    });
    $("#wireSize").chosen({
        maxHeight: 200,
        // search_contains: true,
        no_results_text: "未找到",
    });
    $("#elecSer").chosen({
        maxHeight: 200,
        // search_contains: true,
        no_results_text: "未找到",
    });
    $("#socStr").chosen({
        maxHeight: 200,
        // search_contains: true,
        no_results_text: "未找到",
    });
    $("#packType").chosen({
        maxHeight: 200,
        // search_contains: true,
        no_results_text: "未找到",
    });
    $("#pin").chosen({
        maxHeight: 200,
        // search_contains: true,
        no_results_text: "未找到",
    });

    var arr = $('#htolerance').val().split(',');
    for (var i = 0; i < arr.length; i++) {
        $("#tolerance option[value='" + arr[i] + "']").attr('selected', 'selected');
    }

    var arr = $('#houtlet').val().split(',');
    for (var i = 0; i < arr.length; i++) {
        $("#outlet option[value='" + arr[i] + "']").attr('selected', 'selected');
    }

    var arr = $('#hwireMa').val().split(',');
    for (var i = 0; i < arr.length; i++) {
        $("#wireMa option[value='" + arr[i] + "']").attr('selected', 'selected');
    }

    var arr = $('#hwireSize').val().split(',');
    for (var i = 0; i < arr.length; i++) {
        $("#wireSize option[value='" + arr[i] + "']").attr('selected', 'selected');
    }

    var arr = $('#hpin').val().split(',');
    for (var i = 0; i < arr.length; i++) {
        $("#pin option[value='" + arr[i] + "']").attr('selected', 'selected');
    }

    $("#tolerance").trigger("chosen:updated");
    $("#outlet").trigger("chosen:updated");
    $("#wireMa").trigger("chosen:updated");
    $("#wireSize").trigger("chosen:updated");
    $("#pin").trigger("chosen:updated");

    $('#cMin').on('change', function(e, params) {
        var value = params.selected;
        var text = $("#cMin").find("option[value="+ value +"]").text();
        $("#capacityMinIdx").val(value);
        $("#capacityMin").val(text);
    });

    $('#cMax').on('change', function(e, params) {
        var value = params.selected;
        var text = $("#cMax").find("option[value="+ value +"]").text();
        $("#capacityMaxIdx").val(value);
        $("#capacityMax").val(text);
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