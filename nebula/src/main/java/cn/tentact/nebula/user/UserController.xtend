package cn.tentact.nebula.user

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.beans.factory.annotation.Autowired
import cn.tentact.nebula.web.ResponseBean

/**
 * 
 */
@RestController
@RequestMapping("/user")
class UserController implements I_UserController{
	
	@Autowired
	I_UserService userService;
	
	@RequestMapping("/login")
	override login(String username, String password) {
		var bool=userService.login(#{"username"->username,"password"->password});
		
		if(bool){
			return new ResponseBean(200,"登陆成功",bool,null);
		}else{
			return new ResponseBean(200,"登陆失败",bool,null);
		}
	}
	
}