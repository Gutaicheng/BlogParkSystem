new Vue({
    el:"#app",
    data(){
        return{
            users: {},
            operateId:0,
            operateUser: {},
            addUser:{"username":"","password":"","checkpassword":"","email":"","tel":"","registeredTime":"","status":0}
        }
    },
    mounted(){
        this.selectAllUsers();
    },
    methods:{
        selectAllUsers(){
            var _this = this;
            axios({
                method:"get",
                url:"http://localhost:8080/Blog/selectAllUser"
            }).then(function (resp){
                _this.users = resp.data;
            })
        },
        ToDeleteUserByUid(uid){
            this.operateId = uid;
        },
        ToEditUser(user){
            this.operateUser = user;
            console.log(user)
        },
        deleteUserByUid(){
            var _this = this;
            axios({
                method:"post",
                url:"http://localhost:8080/Blog/deleteUserByUid",
                data:"uid="+this.operateId
            }).then(function (resp){
                alert("id="+ this.operateId +"删除成功");
                _this.selectAllUsers();
            })
        },
        editUserInfo(){
            axios({
                method:"post",
                url:"http://localhost:8080/Blog/editUserInfo",
                data:this.operateUser
            }).then(function (resp){
                alert("id="+ this.operateUser +"修改成功");
            })
        },
        enableOrDisableUser(user){
            this.operateUser = user;
            var _this = this;
            console.log(user);
            axios({
                method:"post",
                url:"http://localhost:8080/Blog/enableOrDisableUser",
                data:user
            }).then(function (resp){
                _this.selectAllUsers();
            })
        },
        addUserInfo(){
            console.log(this.addUser);
            var _this = this;
            axios({
                method:"post",
                url:"http://localhost:8080/Blog/addUser",
                data:_this.addUser
            }).then(function (resp){
                _this.selectAllUsers();
                _this.addUser={"username":"","password":"","checkpassword":"","email":"","tel":"","status":0}
            })
        },
        isExist(){
            alert("失去焦点了");
        }
    }
})

jQuery(document).ready(function($)
{
    var table = $("#table-3").dataTable({
        "sPaginationType": "bootstrap",
        "aLengthMenu": [[10, 25, 50, -1], [10, 25, 50, "All"]],
        "bStateSave": true
    });

    table.columnFilter({
        "sPlaceHolder" : "head:after"
    });
});


function checkboxOnclick(checkbox){
    if ( checkbox.checked === true){
        alert("选中")
        console.log("gaibian")
    }else{
        alert("未选")
        console.log("gaibian")
    }

}


