new Vue({
    el: "#app",
    data() {
        return {
            tags: {},
            operateTag:{}
        }
    },
    mounted() {
        this.getTags();
    },
    methods: {
        getTags() {
            var _this = this;
            axios({
                method: "get",
                url: "http://localhost:8080/Blog/getAllTags"
            }).then(function (resp) {
                console.log(resp);
                _this.tags = resp.data;
            });
        },
        deleteTag(tid){
            var _this = this;
            axios({
                method: "get",
                url: "http://localhost:8080/Blog/deleteTagByTid?tid=" +tid
            }).then(function (resp) {
                _this.getTags();
                console.log(resp);
            });
        },
        addTag(){
            var _this = this;
            axios({
                method: "post",
                url: "http://localhost:8080/Blog/addTag",
                data: _this.operateTag
            }).then(function (resp) {
                _this.getTags();
                console.log(resp);
            });
        },
        toUpdateTag(tag){
            this.operateTag = tag
        },
        updateTag(){
            var _this = this;
            axios({
                method: "post",
                url: "http://localhost:8080/Blog/updateTag",
                data: _this.operateTag
            }).then(function (resp) {
                _this.getTags();
                console.log(resp);
            });
        }
    }
})

jQuery(document).ready(function($)
{
    var table = $("#table-2").dataTable({
        "sPaginationType": "bootstrap",
        "aLengthMenu": [[10, 25, 50, -1], [10, 25, 50, "All"]],
        "bStateSave": true
    });

    table.columnFilter({
        "sPlaceHolder" : "head:after"
    });
});