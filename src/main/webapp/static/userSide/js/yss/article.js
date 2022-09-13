
var article = {};
article.Init = function ($) {
    //var $ = layui.jquery,
    var slider = 0;
    blogtype();
    //类别导航开关点击事件
    $('.category-toggle').click(function (e) {
        e.stopPropagation();    //阻止事件冒泡
        categroyIn();
    });
    //类别导航点击事件，用来关闭类别导航
    $('.article-category').click(function () {
        categoryOut();
    });
    //遮罩点击事件
    $('.blog-mask').click(function () {
        categoryOut();
    });
    $('.f-qq').on('click', function () {
        window.open('http://connect.qq.com/widget/shareqq/index.html?url=' + $(this).attr("href") + '&sharesource=qzone&title=' + $(this).attr("title") + '&pics=' + $(this).attr("cover") + '&summary=' + $(this).attr("desc") + '&desc=你的分享简述' + $(this).attr("desc"));
    });
    $("body").delegate(".fa-times", "click", function () {
        $(".search-result").hide().empty(); $("#searchtxt").val("");
        $(".search-icon i").removeClass("fa-times").addClass("fa-search");
    });
    //显示类别导航
    function categroyIn() {
        $('.category-toggle').addClass('layui-hide');
        $('.article-category').unbind('webkitAnimationEnd mozAnimationEnd MSAnimationEnd oanimationend animationend');
        $('.blog-mask').unbind('webkitAnimationEnd mozAnimationEnd MSAnimationEnd oanimationend animationend');
        $('.blog-mask').removeClass('maskOut').addClass('maskIn');
        $('.blog-mask').removeClass('layui-hide').addClass('layui-show');
        $('.article-category').removeClass('categoryOut').addClass('categoryIn');
        $('.article-category').addClass('layui-show');
    }
    //隐藏类别导航
    function categoryOut() {
        $('.blog-mask').on('webkitAnimationEnd mozAnimationEnd MSAnimationEnd oanimationend animationend', function () {
            $('.blog-mask').addClass('layui-hide');
        });
        $('.article-category').on('webkitAnimationEnd mozAnimationEnd MSAnimationEnd oanimationend animationend', function () {
            $('.article-category').removeClass('layui-show');
            $('.category-toggle').removeClass('layui-hide');
        });
        $('.blog-mask').removeClass('maskIn').addClass('maskOut').removeClass('layui-show');
        $('.article-category').removeClass('categoryIn').addClass('categoryOut');
    }
    function blogtype() {
        $('#category li').hover(function () {
            $(this).addClass('current');
            var num = $(this).attr('data-index');
            $('.slider').css({ 'top': ((parseInt(num) - 1) * 40) + 'px' });
        }, function () {
            $(this).removeClass('current');
            $('.slider').css({ 'top': slider });
        });
        $(window).scroll(function (event) {
            var winPos = $(window).scrollTop();
            if (winPos > 750)
                $('#categoryandsearch').addClass('fixed');
            else
                $('#categoryandsearch').removeClass('fixed');
        });
    }
};

new Vue({
    el: "#app",
    data() {
        return {
            isLogged:0,
            user: {},
            topTenArticles:{},
            tags:{}
        }
    },
    mounted(){
        this.getLogged();
        this.getTopTenArticles();
        this.getArticleTags();
    },
    methods: {
        getLogged(){
            var uid = getCookie("uid");
            var _this = this;
            axios({
                method: "post",
                url: "http://localhost:8080/Blog/selectUserByUid",
                data: "uid="+uid
            }).then(function (resp) {
                console.log(resp);
                _this.isLogged = 1;
                _this.user = resp.data;
                _this.user.headshot = "/Blog/"+_this.user.headshot
                axios({
                    method: "post",
                    url: "http://localhost:8080/Blog/userLogin",
                    data: _this.user
                }).then(function (resp){
                    console.log(resp.data)
                })
            });
        },
        signOut(){
            this.isLogged = 0;
            document.cookie = "uid=; password=; username=; expires=Thu, 01 Jan 1970 00:00:00 GMT";
            axios({
                method: "get",
                url: "http://localhost:8080/Blog/userSignOut"
            }).then(function (resp){
                console.log(resp.data)
            })
            window.location.reload()
        },
        getTopTenArticles(){
            var _this = this;
            axios({
                method: "get",
                url: "http://localhost:8080/Blog/topTenArticle"
            }).then(function (resp){
                console.log(resp.data);
                _this.topTenArticles = resp.data;
            })
        },
        getNewTenArticles(){
            var _this = this;
            axios({
                method: "get",
                url: "http://localhost:8080/Blog/newTenArticle"
            }).then(function (resp){
                _this.topTenArticles = resp.data;
            })
        },
        getArticleTags(){
            var _this = this;
            axios({
                method: "get",
                url: "http://localhost:8080/Blog/selectAllTag"
            }).then(function (resp){
                _this.tags = resp.data;
            })
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

