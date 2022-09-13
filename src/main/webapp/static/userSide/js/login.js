new Vue({
    el: "#app",
    data() {
        return {
            user: {}
        }
    },
    methods: {
        userLogin() {
            var _this = this;
            axios({
                method: "post",
                url: "http://localhost:8080/Blog/userLogin",
                data: _this.user
            }).then(function (resp) {
                if (resp.data.uid != null) {
                    console.log(resp.data);
                    window.location.href = "http://localhost:8080/Blog/homepage";
                } else {
                    alert("账号或密码错误")
                }
            })
        }
    }
})

window.addEventListener('load', () => {
    // 我们需要获取两个切换按钮 因此需要到html结构中 定义特殊类名或id名
    const goSignIn = document.querySelector('#goSignIn');
    const goSignUp = document.querySelector('#goSignUp');
    // 获取被切换的样式类
    const container = document.querySelector('.container');
    // 添加点击事件
    goSignIn.addEventListener('click', () => {
        container.classList.remove('switch');
    })
    goSignUp.addEventListener('click', () => {
        container.classList.add('switch');
    })
})
