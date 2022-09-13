new Vue({
    el: "#app",
    data() {
        return {
            columns: {},
            operateColumn:{},
            deleteColumnCid:0
        }
    },
    mounted() {
        this.getColumns();
    },
    methods: {
        getColumns() {
            var _this = this;
            axios({
                method: "get",
                url: "http://localhost:8080/Blog/selectAllColumns"
            }).then(function (resp) {
                console.log(resp);
                _this.columns = resp.data;
            });
        },
        ToUpdateColumn(column){
            this.operateColumn = column;
        },
        TodeleteColumn(cid){
            this.deleteColumnCid = cid;
        },
        updateColumn(){
            var _this = this;
            axios({
                method: "post",
                url: "http://localhost:8080/Blog/updateColumnNameByCid",
                data: _this.operateColumn
            }).then(function (resp) {
                console.log(resp);
                _this.getColumns();
            });
        },
        deleteColumn(){
            var _this = this;
            axios({
                method: "get",
                url: "http://localhost:8080/Blog/deleteColumnByCid?cid=" + _this.deleteColumnCid
            }).then(function (resp) {
                console.log(resp);
                _this.getColumns();
            });
        }
    }
})

jQuery(document).ready(function($)
{
    var table = $("#table-4").dataTable({
        "sPaginationType": "bootstrap",
        "aLengthMenu": [[10, 25, 50, -1], [10, 25, 50, "All"]],
        "bStateSave": true
    });

    table.columnFilter({
        "sPlaceHolder" : "head:after"
    });
});