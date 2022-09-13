var username = window.location.pathname.split('/')[2];
new Vue({
    el: "#app",
    data() {
        return {
            user: {},
            columns:{},
            articles:{},
            downloads:{}
        }
    },
    mounted() {
        this.getUser();
    },
    methods: {
        getUser(){
            var _this = this;
            axios({
                method: "get",
                url: "http://localhost:8080/Blog/selectUserByUsername?username="+username
            }).then(function (resp) {
                console.log(resp);
                _this.user = resp.data;
                _this.getColumns(_this.user.uid);
                _this.getArticles(_this.user.uid);
                _this.getDownloads(_this.user.uid);
            });
        },
        getColumns(uid){
            var _this = this;
            axios({
                method: "get",
                url: "http://localhost:8080/Blog/selectColumnByUid?uid=" + uid
            }).then(function (resp) {
                console.log(resp);
                _this.columns = resp.data;
            });
        },
        getArticles(uid){
            var _this = this;
            axios({
                method: "get",
                url: "http://localhost:8080/Blog/selectAllArticlesByUid?uid=" + uid
            }).then(function (resp) {
                console.log(resp);
                _this.articles = resp.data;
            });
        },
        getDownloads(uid) {
            var _this = this;
            axios({
                method: "get",
                url: "http://localhost:8080/Blog/selectDownloadByUid?uid=" + uid
            }).then(function (resp) {
                console.log(resp);
                _this.downloads = resp.data;
            });
        }
    }
})