var prefix = "/cm/user";

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
                        startDate:$('#startDate').val() ? $('#startDate').val() : undefined,
                        endDate:$('#endDate').val() ? $('#endDate').val() : undefined,
                    };
                },
                columns: [
                    {
                        title: '编号',
                        field: 'id',
                        align: 'center',
                        valign: 'center',
                        width: '20%'
                    },
                    {
                        title: 'OPENID',
                        valign: 'center',
                        field: 'openId',
                        width: '20%'
                    },
                    {
                        title: 'TOKEN',
                        valign: 'center',
                        field: 'token',
                        width: '20%'
                    },
                    {
                        title: '创建日期',
                        valign: 'center',
                        width: '20%',
                        field: 'createTime',
                        formatter:function (value) {
                            return dateFormat(new Date(value), 'yyyy-MM-dd');
                        }
                    },
                ]
            });
}
