new Vue({
    el: "#app",
    data() {
        return {
            articles:{},
            pending:{}
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
                url: "http://localhost:8080/Blog/selectArticlesPending"
            }).then(function (resp) {
                console.log(resp);
                _this.articles = resp.data;
            });
        },
        updateArticleState(article, state){
            var _this = this;
            axios({
                method: "get",
                url: "http://localhost:8080/Blog/updateArticleState?aid=" + article.aid + "&state=" + state
            }).then(function (resp) {
                console.log(resp);
                _this.getArticles();

                _this.pending.uid = article.uid;
                _this.pending.ptitle = article.title;
                _this.pending.type = 1;
                _this.pending.paid = 1;
                if (state===1){
                    _this.pending.presult = 1;
                }else _this.pending.presult = 2;
                axios({
                    method: "post",
                    url: "http://localhost:8080/Blog/addPending",
                    data: _this.pending
                }).then(function (resp) {
                    console.log(resp);
                });
            });
        }
    }
})

function showTime() {
    var now = new Date();
    var year = now.getFullYear(); //得到年份
    var month = now.getMonth() + 1;//得到月份
    var date = now.getDate();//得到日期
    var time = year + "-" + month + "-" + date;
    return time;
}



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