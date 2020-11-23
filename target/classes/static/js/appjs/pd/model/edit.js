var prefix = "/pd/model";

$().ready(function () {

    validateRule();
    loadSelect();
    initOrderRuleSelect();
    initOrderRuleSelect2();
});
// int res = permissionService.searchPermission(staff.getId(),permissionName);
// model.addAttribute("res",res)

// var testdata=[[${model}]];
// console.log(testdata);



$.validator.setDefaults({
    submitHandler: function () {
        save();
    }
});

function save() {
    // var data = serializeNotNull($('#dataForm').serialize());
    //空字段都是""
    var data = new FormData($('#dataForm')[0]);

    $.ajax({
        cache: false,
        type: "POST",
        url: prefix + "/save",
        data: data,
        async: false,
        contentType: false,
        processData: false,
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
            name: {
                required: true
            },
            code: {
                required: true
            },
            qaCode:{
                required:true
            },
            pcName: {
                required: true
            },
        },
        messages: {
            name: {
                required: icon + "请输入产品名称"
            },
            code: {
                required: icon + "请输入产品型号"
            },
            qaCode: {
                required: icon + "请选择质量等级"
            },
            pcName: {
                required: icon + "请选择产品分类"
            },
        }
    })
}

var openClass = function () {
    layer.open({
        type: 2,
        title: "选择产品分类",
        area: ['500px', '600px'],
        content: "/pd/class/tree-view"
    })
}

function loadSelect(){

    $("#qaCode").chosen({
        maxHeight: 200,
        // search_contains: true,
        no_results_text: "未找到",
    });

    var arr = $('#hqaCode').val().split(',');
    for (var i = 0; i < arr.length; i++) {
        $("#qaCode option[value='" + arr[i] + "']").attr('selected', 'selected');
    }
    $("#qaCode").trigger("chosen:updated");
}

function setClass(pcId, pcName) {
    $("#pdClassId").val(pcId);
    $("#pcName").val(pcName);
}

function initOrderRuleSelect() {
    $("select[name='or']").on('change', function (e) {
        // var v = e.target.value;
        var val = "";
        var formatVal = "";
        $("select[name='or']").each(function () {
            // console.log($(this).value());
            var v = $(this).val();
            var t = $(this).val();
            if ($(this).attr('class').indexOf("_type") != -1) {
                t = $(this).find("option:selected").text();
            }
            val += (v) + "|";
            formatVal += (t);
        })
        var i = val.length;
        for (; i >= 0; i--) {
            var v = val[i - 1];
            if (v != '|' && v != '-' && v != ' ') {
                break;
            }
        }
        val = val.substring(0, i);
        $('#orderRule').val(val);
        $('#formatOR').val(formatVal);
        console.debug(val);
        console.debug(formatVal);
        console.log(formatVal);
    });
}

function initOrderRuleSelect2() {
    $("select[name='or2']").on('change', function (e) {
        // var v = e.target.value;
        var val = "";
        var formatVal = "";
        $("select[name='or2']").each(function () {
            // console.log($(this).value());
            var v = $(this).val();
            var t = $(this).val();
            if ($(this).attr('class').indexOf("_type") != -1) {
                t = $(this).find("option:selected").text();
            }
            val += (v) + "|";
            formatVal += (t);
        })
        var i = val.length;
        for (; i >= 0; i--) {
            var v = val[i - 1];
            if (v != '|' && v != '-' && v != ' ') {
                break;
            }
        }
        val = val.substring(0, i);
        $('#orderRule2').val(val);
        $('#formatOR2').val(formatVal);
    });
}