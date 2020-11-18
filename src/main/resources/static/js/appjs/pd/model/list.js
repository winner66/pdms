var prefix = "/pd/model";

var pcId = 0;
$(document).ready(function () {
    load();
    loadClassTree();
});

function reLoad() {
    $('#dataTable').bootstrapTable('refresh');
}

var load = function () {
    $('#dataTable')
        .bootstrapTable(
            {
                method: "GET",
                url: prefix + '/list',
                iconSize: 'outline',
                striped: true,
                cache: false,
                pagination: true,
                pageNumber: 1,
                pageSize: 10,
                pageList: [10, 25, 50, 100],
                showColumns: true,
                showRefresh: true,
                sidePagination: "server",
                queryParamsType: '',
                // height: 650,
                clickToSelect: $('#mode').val() == "page" ? false : true,
                onDblClickRow: function (row) {
                    select(row.id, row.code, row.pdClassId);
                },
                queryParams: function (params) {
                    // return {
                    //     pageNum: (params.offset / params.limit) + 1,
                    //     pageSize: params.limit,
                    //     name: $('#name').val() ? $('#name').val() : undefined,
                    //     // deptId : deptId
                    // };
                    return {
                        pageNum: params.pageNumber,
                        pageSize: params.pageSize,
                        name: $('#name').val() ? $('#name').val() : undefined,
                        pcId: pcId,
                    };
                },
                columns: [
                    {
                        title: '编号',
                        field: 'id',
                        align: 'center',
                        valign: 'center',
                        width: '5%'
                    },
                    {
                        title: '产品分类',
                        valign: 'center',
                        field: 'pcName',
                        width: '25%'
                    },
                    {
                        title: '产品名称',
                        valign: 'center',
                        field: 'name',
                        width: '25%'
                    },
                    {
                        title: '产品型号',
                        valign: 'center',
                        field: 'code',
                        width: '25%'
                    },
                    {
                        title: '质量等级',
                        valign: 'center',
                        field: 'superQaCode',
                        width: '10%'
                    },
                    {
                        title: '操作',
                        field: 'id',
                        align: 'center',
                        valign: 'center',
                        width: '10%',
                        formatter: function (value, row, index) {
                            if ($('#mode').val() == "page") {
                                var e = '<a class="btn btn-primary btn-sm" href="#" mce_href="#" title="编辑" onclick="edit(' + row.id + ')"><i class="fa fa-edit"></i></a>';
                                var d = '<a class="btn btn-warning btn-sm " href="#" title="删除"  mce_href="#" onclick="del(' + row.id + ')"><i class="fa fa-remove"></i></a>';
                                return e + d;
                            }else{
                                var d = '<a class="btn btn-primary btn-sm " href="#" title="选择"  mce_href="#" onclick="select(' + row.id + ', \'' + row.code + '\',\''+ row.pdClassId + '\')">选择</a>';
                                return d;
                            }
                        }
                    }
                ]
            });
}

function add() {
    var win = layer.open({
        type: 2,
        title: '增加产品型号',
        maxmin: true,
        shadeClose: false,
        area: ['800px', '520px'],
        content: prefix + '/add/' + pcId,
    });
    layer.full(win);
}

function edit(id) {
    var win = layer.open({
        type: 2,
        title: '修改产品型号',
        maxmin: true,
        shadeClose: false,
        area: ['800px', '520px'],
        content: prefix + '/get/' + id,
    });
    layer.full(win);
}

function del(id) {
    layer.confirm('确定要删除选中的记录？', {
        btn: ['确定', '取消']
    }, function () {
        $.ajax({
            url: prefix + "/delete",
            type: "post",
            data: {
                'id': id
            },
            success: function (data) {
                if (data.code == 0) {
                    layer.msg("删除成功");
                    reLoad();
                } else {
                    layer.msg(data.msg);
                }
            }
        });
    })
}

function loadClassTree() {
    $.ajax({
        type: "GET",
        url: "/pd/class/tree",
        success: function (tree) {
            loadTree(tree);
        }
    });
}

function loadTree(tree) {
    $('#classTree').jstree({
        'core': {
            'data': tree,
            "themes": {
                "icons": false
            }
        },
    });
}

$('#classTree').on("changed.jstree", function (e, data) {
    if (data.node.parent != '#') {
        pcId = data.selected[0];
        var opt = {
            query: {
                pcId: pcId,
            }
        }
        $('#dataTable').bootstrapTable('refresh', opt);
    }
});

function select(id, code, pdClassId){
    parent.setModel(id, code, pdClassId);
    var index = parent.layer.getFrameIndex(window.name);
    parent.layer.close(index);
}

