var prefix = "/fpd/V2/fpdSeries";

$(document).ready(function () {
    load();
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
                        name: $('#name').val() ? $('#name').val() : undefined,
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
                        title: '国内/外厂家',
                        valign: 'center',
                        field: 'fFactorys',
                        width: '10%'
                    },
                    {
                        title: '国内/外系列',
                        valign: 'center',
                        field: 'fSeries',
                        width: '10%'
                    },
                    {
                        title: '宏科系列',
                        valign: 'center',
                        field: 'hkSeries',
                        width: '10%'
                    },
                    {
                        title: '特定的尺寸',
                        valign: 'center',
                        field: 'size',
                        width: '5%'
                    },
                    {
                        title: '特定的温度特性',
                        valign: 'center',
                        field: 'temperature',
                        width: '5%'
                    },
                    {
                        title: '特定的引出端',
                        valign: 'center',
                        field: 'outlet',
                        width: '5%'
                    },
                    {
                        title: '特定的电压',
                        valign: 'center',
                        field: 'voltage',
                        width: '5%'
                    },
                    {
                        title: '精度偏差',
                        valign: 'center',
                        field: 'tolerance',
                        width: '5%'
                    },
                    {
                        title: '端头结构',
                        valign: 'center',
                        field: 'socStr',
                        width: '5%'
                    },
                    {
                        title: '电极材料代码',
                        valign: 'center',
                        field: 'elecCode',
                        width: '5%'
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
        title: '增加',
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
        title: '修改',
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