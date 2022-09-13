window.onload = function () {
    NProgress.done();
};
http://localhost:8080/Blog/gutaicheng/articles/22
var cid = window.location.pathname.split('/')[4];
var uid
new Vue({
    el: "#app",
    data() {
        return {
            articles:{},
            author:{},
            columns:{}
        }
    },
    mounted(){
        this.getArticle();
        // if (performance.navigation.type !== 1) {
        //     axios({
        //         method: "get",
        //         url: "http://localhost:8080/Blog/viewsAddOne?aid=" + aid
        //     }).then(function (resp) {})
        // }
        // // this.getArticleDoc();
    },
    methods: {
        getArticle(){
            var _this = this;
            axios({
                method: "get",
                url: "http://localhost:8080/Blog/selectArticleByCid?cid=" + cid
            }).then(function (resp) {
                console.log(resp);
                _this.articles = resp.data;
                uid = _this.articles[0].uid;
                _this.getAuthor();
                _this.getUserColumns();
            })
        },
        getAuthor(){
            var _this = this;
            axios({
                method: "post",
                url: "http://localhost:8080/Blog/selectUserByUid",
                data: "uid="+uid
            }).then(function (resp) {
                console.log(resp);
                _this.author = resp.data;
            });
        },
        getUserColumns(){
            var _this = this;
            axios({
                method: "get",
                url: "http://localhost:8080/Blog/selectColumnByUid?uid=" + uid
            }).then(function (resp) {
                console.log(resp);
                _this.columns = resp.data;
            });
        }
        // getArticleDoc(){
        //     var _this = this;
        //     axios({
        //         method: "post",
        //         url: "http://localhost:8080/Blog/selectDocByAid",
        //         data: "aid="+aid
        //     }).then(function (resp) {
        //         console.log(resp);
        //         _this.articledoc = resp.data;
        //     })
        // }
    }
})