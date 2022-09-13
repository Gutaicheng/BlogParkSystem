new Vue({
    el: "#app",
    data() {
        return {
            pendings:{}
        }
    },
    mounted() {
        this.getPendings();
    },
    methods: {
        getPendings(){
            var _this = this;
            axios({
                method: "get",
                url: "http://localhost:8080/Blog/selectAllPending"
            }).then(function (resp) {
                console.log(resp);
                _this.pendings = resp.data;
            });
        }
    }
})

jQuery(document).ready(function($)
{
    var table = $("#table-1").dataTable({
        "sPaginationType": "bootstrap",
        "aLengthMenu": [[10, 25, 50, -1], [10, 25, 50, "All"]],
        "bStateSave": true
    });

    table.columnFilter({
        "sPlaceHolder" : "head:after"
    });
});