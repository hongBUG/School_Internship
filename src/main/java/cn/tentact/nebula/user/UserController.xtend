package cn.tentact.nebula.user

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.beans.factory.annotation.Autowired
import cn.tentact.nebula.web.ResponseBean
import org.springframework.data.redis.core.RedisTemplate
import cn.tentact.nebula.shiro.JwtUtil
import java.util.concurrent.TimeUnit
import org.springframework.beans.factory.annotation.Qualifier

/**
 * 
 */
@RestController
@RequestMapping("/user")
class UserController implements I_UserController{
	
	@Autowired
	I_UserService userService;
	
	@Autowired
	@Qualifier("redisTemplate")
	RedisTemplate redis;
	
	@RequestMapping("/login")
	override login(String username, String password) {
		println("进来了");
		var bool=userService.login(#{"username"->username,"password"->password});
		
		if(bool){
			var token = JwtUtil.sign(username, password);
			// 缓存令牌到redis中
			redis.opsForHash.putAll(username, #{"password" -> password, "token" -> token});
			// 设置过期时间(15分钟）
			redis.expire(username, JwtUtil.EXPIRE_TIME, TimeUnit.MILLISECONDS);
			return new ResponseBean(200,"登陆成功",bool, #{"token" -> token});
		}else{
			return new ResponseBean(200,"登陆失败",bool,null);
		}
	}
	
}