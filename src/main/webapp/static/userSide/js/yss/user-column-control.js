new Vue({
    el: "#app",
    data() {
        return {
            columns:{}
        }
    },
    mounted() {
        this.getColumns();
    },
    methods: {
        getColumns() {
            var _this = this;
            axios({
                method: "get",
                url: "http://localhost:8080/Blog/selectColumnByUid?uid=" + getCookie("uid")
            }).then(function (resp) {
                console.log(resp);
                _this.columns = resp.data;
            });
        },
        editFunction(cid){
            var newcname = prompt("请输入修改后的专栏名", "");
            if (newcname!=null && newcname!=""){
                var newColums={}
                newColums.cid = cid;
                newColums.cname = newcname;
                var _this = this;
                axios({
                    method: "post",
                    url: "http://localhost:8080/Blog/updateColumnNameByCid",
                    data:newColums
                }).then(function (resp) {
                    _this.getColumns();
                });
            }
        },
        addColumn(){
            var newcname = prompt("请输入新建的专栏名", "");
            if (newcname!=null && newcname!=""){
                var newColums={};
                newColums.cname = newcname;
                newColums.uid = getCookie("uid");
                var _this = this;
                axios({
                    method: "post",
                    url: "http://localhost:8080/Blog/addNewColumn",
                    data:newColums
                }).then(function (resp) {
                    _this.getColumns();
                });
            }
        },
        deleteColumn(cid) {
            var _this = this;
            axios({
                method: "post",
                url: "http://localhost:8080/Blog/deleteColumnByCid?cid=" + cid
            }).then(function (resp) {
                _this.getColumns();
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