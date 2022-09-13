new Vue({
    el: "#app",
    data() {
        return {
            articles:{}
        }
    },
    mounted() {
        this.getArticles();
    },
    methods: {
        getArticles(){
            var _this = this;
            axios({
                method: "get",
                url: "http://localhost:8080/Blog/selectAllArticles"
            }).then(function (resp) {
                console.log(resp);
                _this.articles = resp.data;
            });
        },
        deleteArticle(aid){
            var _this = this;
            axios({
                method: "get",
                url: "http://localhost:8080/Blog/deleteArticleByAid?aid=" +aid
            }).then(function (resp) {
                _this.getArticles();
                console.log(resp);
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