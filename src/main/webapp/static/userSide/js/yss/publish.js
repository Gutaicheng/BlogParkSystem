new Vue({
    el: "#app",
    data() {
        return {
            download:{}
        }
    },
    methods: {
        addDownload(){
            var _this = this;
            var down = document.getElementById("myfile").files[0]
            console.log(down)
            var forms = new FormData();
            var dfile ;
            forms.append('myfile', down);
            axios({
                method: "post",
                url: "http://localhost:8080/Blog/addDownload",
                headers: {
                    'Content-Type': 'multipart/form-data'
                },
                data: forms
            }).then(function (resp) {
                dfile = resp.data
                console.log(dfile);
                _this.download.uid = getCookie("uid");
                _this.download.dname = document.getElementById("title").value;
                _this.download.dmiaoshu = document.getElementById("dmiaoshu").value;
                _this.download.loadtime = showTime();
                _this.download.dfile = dfile;
                _this.download.dformat = dfile.split('.')[1];
                axios({
                    method: "post",
                    url: "http://localhost:8080/Blog/uploadDownload",
                    data: _this.download
                }).then(function (resp) {

                })
                window.location.href="http://localhost:8080/Blog/downloadControl";
            })
        }
    }
})

//获取当前时间
function showTime() {
    var now = new Date();
    var year = now.getFullYear(); //得到年份
    var month = now.getMonth() + 1;//得到月份
    var date = now.getDate();//得到日期
    var time = year + "-" + month + "-" + date;
    return time;
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