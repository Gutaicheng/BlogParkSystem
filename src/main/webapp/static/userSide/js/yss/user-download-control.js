new Vue({
    el: "#app",
    data() {
        return {
            downloads:{}
        }
    },
    mounted() {
        this.getDownloads();
    },
    methods: {
        getDownloads() {
            var _this = this;
            axios({
                method: "get",
                url: "http://localhost:8080/Blog/selectDownloadByUid?uid=" + getCookie("uid")
            }).then(function (resp) {
                console.log(resp);
                _this.downloads = resp.data;
            });
        },
        deleteDownload(did){
            var _this = this;
            axios({
                method: "get",
                url: "http://localhost:8080/Blog/deleteDownloadByDid?did=" + did
            }).then(function (resp) {
                _this.getDownloads();
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