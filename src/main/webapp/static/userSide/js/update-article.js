var E = window.wangEditor
var editor = new E('#div1', '#div2') // 两个参数也可以传入 elem 对象，class 选择器
//开启debug模式
editor.customConfig.debug = true;
// 关闭粘贴内容中的样式
editor.customConfig.pasteFilterStyle = false
// 忽略粘贴内容中的图片
editor.customConfig.pasteIgnoreImg = false
// 使用 base64 保存图片
//editor.customConfig.uploadImgShowBase64 = true

// 上传图片到服务器
editor.customConfig.uploadFileName = 'myFile'; //设置文件上传的参数名称
editor.customConfig.uploadImgServer = '/Blog/uploadArticlePic'; //设置上传文件的服务器路径
editor.customConfig.uploadImgMaxSize = 3 * 1024 * 1024; // 将图片大小限制为 3M
//自定义上传图片事件
editor.customConfig.uploadImgHooks = {
    before: function (xhr, editor, files) {

    },
    success: function (xhr, editor, result) {
        console.log("上传成功");
    },
    fail: function (xhr, editor, result) {
        console.log("上传失败,原因是" + result);
        alert("上传失败,原因是" + result);
    },
    error: function (xhr, editor) {
        console.log("上传出错");
        alert("上传出错")
    },
    timeout: function (xhr, editor) {
        console.log("上传超时");
        alert("上传超时")
    }
}
editor.create();

var toAddTags=[];
var newArticleID = window.location.pathname.split('/')[3];

new Vue({
    el: "#app",
    data() {
        return {
            newArticle: {},
            tags:{},
            columns:{},
            oldArticle:{}
        }
    },
    mounted(){
        this.getTags();
        this.getColumn();
        this.getOldArticle();
    },
    methods: {
        getOldArticle(){
            var _this = this;
            axios({
                method: "get",
                url: "http://localhost:8080/Blog/selectArticleByAid?aid=" + newArticleID
            }).then(function (resp) {
                _this.oldArticle = resp.data;
                document.getElementById("title").value = _this.oldArticle.title
                editor.txt.html(_this.oldArticle.content);
            })
        },
        pushArticle() {
            var _this = this;
            axios({
                method: "post",
                url: "http://localhost:8080/Blog/updateArticleByAid",
                data: _this.newArticle
            }).then(function (resp) {
                newArticleID = 32;
                console.log(resp.data);
                _this.addArticleTags();
                _this.addArticleColumn();
            })
        },
        getArticleInfo(state){
            var _this = this;
            var imag= document.getElementById("articleCover").files[0]
            // console.log(imag)
            var forms = new FormData();
            var cover ;
            forms.append('myFile', imag);
            axios({
                method: "post",
                url: "http://localhost:8080/Blog/uploadArticlePic",
                headers: {
                    'Content-Type': 'multipart/form-data'
                },
                data: forms
            }).then(function (resp) {
                cover = resp.data.data[0]
                console.log(resp.data.data[0]);
                _this.newArticle.aid = newArticleID
                _this.newArticle.uid = getCookie("uid");
                _this.newArticle.title = document.getElementById("title").value;
                _this.newArticle.content = editor.txt.html();
                _this.newArticle.text = editor.txt.text();
                _this.newArticle.state = state;
                _this.newArticle.data = showTime();
                _this.newArticle.cover = cover
                _this.pushArticle();
            });
        },
        getTags(){
            var _this = this;
            axios({
                method: "get",
                url: "http://localhost:8080/Blog/selectAllTag"
            }).then(function (resp) {
                console.log(resp);
                _this.tags = resp.data;
            });
        },
        getColumn(){
            var _this = this;
            var uid = getCookie("uid");
            axios({
                method: "get",
                url: "http://localhost:8080/Blog/selectColumnByUid?uid=" + uid
            }).then(function (resp) {
                console.log(resp);
                _this.columns = resp.data;
            });
        },
        addArticleTags(){
            axios({
                method: "get",
                url: "http://localhost:8080/Blog/deleteArticleTagByAid?aid="+newArticleID
            }).then(function (resp) {
                toAddTags.forEach(function (item) {
                    // item数组中的当前项, index当前项的索引, array原始数组；
                    console.log(item);
                    axios({
                        method: "post",
                        url: "http://localhost:8080/Blog/addArticleTags",
                        data: "aid=" + newArticleID + "&tid=" + item
                    }).then(function (resp) {
                    })
                })
            })
        },
        addArticleColumn(){
            var articleColumn = document.getElementById("column").value;
            axios({
                method: "post",
                url: "http://localhost:8080/Blog/updateToColumnByAid",
                data: "cid=" + articleColumn + "&aid=" + newArticleID + "&uid=" + getCookie("uid")
            }).then(function (resp) {
            })
        },
        testqita(){
            alert(document.getElementById("column").value)
        }
    }
})

function changeTags() {
    var obj = document.getElementById("tag");
    toAddTags=[];
    for(var i=0;i<obj.options.length;i++){
        if(obj.options[i].selected){
            toAddTags.push(obj.options[i].value);// 收集选中项
        }
    }
    console.log(toAddTags);
}





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

// document.getElementById('publish').addEventListener('click', function () {
//     // 以html的形式获取输入的内容
//     var title = document.getElementById("title").value
//     console.log(editor.txt.html())
//     axios({
//         method: "post",
//         url: "http://localhost:8080/Blog/addArticle",
//         data: "uid=1&title=" + title + "&content=" + editor.txt.html() + "&text=" + editor.txt.text() + "&data=" + showTime() + "&state=1"
//     }).then(function (resp) {
//         alert("发布成功");
//     })
// }, false)
//
// document.getElementById('save').addEventListener('click', function () {
//     // 以文本的形式获取输入的内容
//     var title = document.getElementById("title").value
//     axios({
//         method: "post",
//         url: "http://localhost:8080/Blog/addArticle",
//         data: "uid=1&title=" + title + "&content=" + editor.txt.html() + "&text=" + editor.txt.text() + "&data=" + showTime() + "&state=2"
//     }).then(function (resp) {
//         alert("成功");
//     })
// }, false)

//获取当前时间
function showTime() {
    var now = new Date();
    var year = now.getFullYear(); //得到年份
    var month = now.getMonth() + 1;//得到月份
    var date = now.getDate();//得到日期
    var time = year + "-" + month + "-" + date;
    return time;
}



window.onload = function () {
    NProgress.done();
};