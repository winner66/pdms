var prefix = "/pd/class";
$(document).ready(function () {
    load();
});
var load = function () {
    $('#dataTable')
        .bootstrapTreeTable(
            {
                id: 'id',
                code: 'id',
                parentCode: 'pId',
                type: "GET",
                url: prefix + '/list',
                ajaxParams: {},
                expandColumn: '1',
                striped: true,
                bordered: true,
                expandAll: true,
                showColumns: true,
                showRefresh: true,
                // height: 650,
                columns: [
                    {
                        title: '编号',
                        field: 'id',
                        visible: false,
                        align: 'center',
                        valign: 'center',
                        width: '5%'
                    },
                    {
                        title: '名称',
                        valign: 'center',
                        field: 'name',
                        width: '25%'
                    },
                    {
                        title: '显示名称',
                        valign: 'center',
                        field: 'showName',
                        width: '25%'
                    },
                    {
                        title: '层级 ',
                        valign: 'center',
                        width: '5%',
                        field: 'level'
                    },
                    // {
                    //                     //     title: '类型',
                    //                     //     field: 'type',
                    //                     //     align: 'center',
                    //                     //     valign: 'center',
                    //                     //     width: '10%',
                    //                     //     formatter: function (item, index) {
                    //                     //         if (item.pId === 0) {
                    //                     //             return '目录';
                    //                     //         } else {
                    //                     //             return '分类';
                    //                     //         }
                    //                     //     }
                    //                     // },
                    {
                        title: '二级分类-等级',
                        valign: 'center',
                        field: 'qaGp',
                        width: '10%'
                    },
                    {
                        title: '图标',
                        field: 'icon',
                        align: 'center',
                        valign: 'center',
                        width: '5%',
                        formatter: function (item, index) {
                            return item.iconUrl == null || item.iconUrl == '' ? ''
                                : '<img src="' + item.iconUrl + '" style="width:30px;height:30px">';
                        }
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
                        formatter: function (item, index) {
                            var e = '<a class="btn btn-primary btn-sm" href="#" mce_href="#" title="编辑" onclick="get(' + item.id + ')"><i class="fa fa-edit"></i></a> ';
                            var p = '';
                            if (item.level < 3){
                                p = '<a class="btn btn-success btn-sm" href="#" mce_href="#" title="添加子分类" onclick="add(' + item.id + ')"><i class="fa fa-plus"></i></a> ';
                            }
                            var d = '<a class="btn btn-warning btn-sm " href="#" title="删除"  mce_href="#" onclick="del(' + item.id + ')"><i class="fa fa-remove"></i></a> ';
                            return e + d + p;
                        }
                    }
                ]
            });
}

function reLoad() {
    load();
}

function add(pId) {
    layer.open({
        type: 2,
        title: '增加产品分类',
        maxmin: true,
        shadeClose: false,
        area: ['800px', '550px'],
        content: prefix + '/add/' + pId
    });
}

function get(id) {
    layer.open({
        type: 2,
        title: '修改产品分类',
        maxmin: true,
        shadeClose: false,
        area: ['800px', '550px'],
        content: prefix + '/get/' + id
    });
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

