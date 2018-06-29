mui.ready(function(){
	new Vue({
		el:"#app",
		data:{
			showPanel:"login",
			login:{
				username: "",
				password: ""
			},
			registe:{
				username: "",
				password: "",
				repassword: ""
			}
		},
		methods:{
			showLoginPanel:function(){
				this.showPanel="login";
			},
			showRegistePanel:function(){
				this.showPanel="registe";
			},
			loginSystem:function(){
				var bool=checkUsername(this.login.username);
				bool=checkPassword(this.login.password) && bool;
				if(bool) {
					var ref = this;
					$.ajax({
						type:"post",
						url:"https://192.168.0.136:8000/user/login",
						async:true,
						data:{
							username: ref.login.username,
							password: ref.login.password
						}, success:function(json){
							if(json.code == 200 && json.resule == true) {
								mui.toast(json.msg);
								localStorage.setItem("token", json.data.token);   // 保存令牌
							} else {
								mui.toast(json.msg);
							}
						}, error:function(error) {
							console.error(error);
							mui.toast("执行错误");
						}
});
				} else {
					mui.toast("请注意输入格式")
				}
			}
			
		},
		filters:{
			
		}
	});
});

mui.plusReady(function(){
	plus.navigator.setStatusBarBackground("#00799FF"); // OS顶部状态栏背景色
	plus.navigator.setStatusBarStyle("light"); // OS顶部文字颜色
	plus.screen.lockOrientation("portrait-primary"); // 禁止横屏
	// 隐藏滚动条
	plus.webview.currentWebview().setStyle({
		scrollIndicator: 'none'
	})
});

mui.init();
