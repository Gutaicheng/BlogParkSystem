window.onload = function () {
    NProgress.done();
};
var aid = window.location.pathname.split('/')[4];
new Vue({
    el: "#app",
    data() {
        return {
            article:{},
            articledoc:{},
            author:{},
            tags:{},
            otherArticles:{},
            columns:{},
            messages:{},
            user:{}
        }
    },
    mounted(){
        this.getArticle();
        if (performance.navigation.type !== 1) {
            axios({
                method: "get",
                url: "http://localhost:8080/Blog/viewsAddOne?aid=" + aid
            }).then(function (resp) {})
        }
        // this.getArticleDoc();
    },
    methods: {
        getArticle(){
            var _this = this;
            axios({
                method: "post",
                url: "http://localhost:8080/Blog/selectArticleByAid",
                data: "aid="+aid
            }).then(function (resp) {
                console.log(resp);
                _this.article = resp.data;
                _this.getAuthor();
                _this.getTag();
                _this.getOtherArticles();
                _this.getUserColumns();
                _this.getMessages();
            })
        },
        getAuthor(){
            var _this = this;
            axios({
                method: "post",
                url: "http://localhost:8080/Blog/selectUserByUid",
                data: "uid="+_this.article.uid
            }).then(function (resp) {
                console.log(resp);
                _this.author = resp.data;
            });
        },
        getTag(){
            var _this = this;
            axios({
                method: "get",
                url: "http://localhost:8080/Blog/selectTagByAid?aid="+_this.article.aid
            }).then(function (resp) {
                console.log(resp);
                _this.tags = resp.data;
            });
        },
        getOtherArticles(){
            var _this = this;
            axios({
                method: "get",
                url: "http://localhost:8080/Blog/selectUserTopFiveArticlesByUid?uid="+_this.article.uid+"&aid="+_this.article.aid
            }).then(function (resp) {
                console.log(resp);
                _this.otherArticles = resp.data;
            });
        },
        getUserColumns(){
            var _this = this;
            axios({
                method: "get",
                url: "http://localhost:8080/Blog/selectColumnByUid?uid=" + _this.article.uid
            }).then(function (resp) {
                console.log(resp);
                _this.columns = resp.data;
            });
        },
        getMessages(){
            var _this = this;
            axios({
                method: "get",
                url: "http://localhost:8080/Blog/selectMessageByAid?aid=" + _this.article.aid
            }).then(function (resp) {
                console.log(resp);
                _this.messages = resp.data;
            });
        },
        sendMessage(){
            var _this = this;
            var newMessage={}
            newMessage.uid = getCookie("uid");
            newMessage.aid = _this.article.aid;
            newMessage.content = document.getElementById("content").value
            axios({
                method: "post",
                url: "http://localhost:8080/Blog/addMessage",
                data:newMessage
            }).then(function (resp) {
                console.log(resp);
                _this.getMessages();
            });
        }
    }
})

function getCookie(cname)
{
    var name = cname + "=";
    var ca = document.cookie.split(';');
    for(var i=0; i<ca.length; i++)
    {
        var c = ca[i].trim();
        if (c.indexOf(name)==0) return c.substring(name.length,c.length);
    }
    return "";
}