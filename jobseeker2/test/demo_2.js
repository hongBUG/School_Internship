mui.ready(function(){
	new Vue({
		el:"#app", // #按照ID查找
		data:{
			address:"大连市甘井子区金虹东路生态科技城D1一层腾泰科技",
			username: null,
			city: null,
			role:[] ,
			age:null,
			student:[{name:"李强",gender:"男",age:"11"},
			{name:"张丽",gender:"女",age:"12"},
			{name:"谢强",gender:"男",age:"15"}],
			level:"警告消息"
		},
		methods:{
			sayHello:function(){
				alert("HelloWorld!");
			}
		},
		filters:{
			hideName:function(name){
				var firstName=name.charAt(0);
				for(var i=0;i<name.length-1; i++){
					firstName+="*";
				}
				return firstName;
			}
		}
	})
});

mui.plusReady(function(){
	
});

mui.init();
