var prefix = "/pd/param/size";

var gp;
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
                queryParams: function (params) {
                    return {
                        pageNum: params.pageNumber,
                        pageSize: params.pageSize,
                        gp: gp,
                        code: $('#code').val() ? $('#code').val() : undefined,
                        type: '封装及外形尺寸',
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
                        title: '尺寸',
                        valign: 'center',
                        field: 'code',
                        width: '10%'
                    },
                    {
                        title: '执行标准',
                        valign: 'center',
                        field: 'rel',
                        width: '20%'
                    },
                    {
                        title: '描述',
                        valign: 'center',
                        field: 'name',
                        width: '35%'
                    },
                    {
                        title: '备注',
                        valign: 'center',
                        field: 'gp',
                        width: '15%'
                    },
                    {
                        title: '序号',
                        valign: 'center',
                        width: '5%',
                        field: 'idx'
                    },
                    {
                        title: '操作',
                        field: 'id',
                        align: 'center',
                        valign: 'center',
                        formatter: function (value, row, index) {
                            var e = '<a class="btn btn-primary btn-sm" href="#" mce_href="#" title="编辑" onclick="edit(' + row.id + ')"><i class="fa fa-edit"></i></a>';
                            var d = '<a class="btn btn-warning btn-sm " href="#" title="删除"  mce_href="#" onclick="del(' + row.id + ')"><i class="fa fa-remove"></i></a>';
                            return e + d;
                        }
                    }
                ]
            });
}

function add() {
    var win = layer.open({
        type: 2,
        title: '增加封装及外形尺寸',
        maxmin: true,
        shadeClose: false,
        area: ['800px', '520px'],
        content: prefix + '/add',
    });
    layer.full(win);
}

function edit(id) {
    var win = layer.open({
        type: 2,
        title: '修改封装及外形尺寸',
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
        gp = data.selected[0];
        $('#dataTable').bootstrapTable('refresh');
    }
});

