new Vue({
    el: "#app",
    data() {
        return {
            user: {},
            pendings:{}
        }
    },
    mounted() {
        this.getPendings();
    },
    methods: {
        getPendings(){
            var _this = this;
            axios({
                method: "get",
                url: "http://localhost:8080/Blog/selectPendingByUid?uid="+ getCookie("uid")
            }).then(function (resp) {
                console.log(resp);
                _this.pendings = resp.data;
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