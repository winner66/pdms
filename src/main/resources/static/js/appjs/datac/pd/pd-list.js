var prefix = "/datac/pd";

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
                        title: '产品',
                        valign: 'center',
                        field: 'data',
                        width: '70%'
                    },
                    {
                        title: '查看次数',
                        valign: 'center',
                        field: 'total',
                        width: '30%'
                    }
                ]
            });
}