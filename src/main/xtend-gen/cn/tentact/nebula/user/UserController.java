package cn.tentact.nebula.user;

import cn.tentact.nebula.shiro.JwtUtil;
import cn.tentact.nebula.user.I_UserController;
import cn.tentact.nebula.user.I_UserService;
import cn.tentact.nebula.web.ResponseBean;
import java.util.Collections;
import java.util.concurrent.TimeUnit;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@SuppressWarnings("all")
public class UserController implements I_UserController {
  @Autowired
  private I_UserService userService;
  
  @Autowired
  @Qualifier("redisTemplate")
  private RedisTemplate redis;
  
  @RequestMapping("/login")
  @Override
  public ResponseBean login(final String username, final String password) {
    InputOutput.<String>println("进来了");
    Pair<String, String> _mappedTo = Pair.<String, String>of("username", username);
    Pair<String, String> _mappedTo_1 = Pair.<String, String>of("password", password);
    boolean bool = this.userService.login(Collections.<String, String>unmodifiableMap(CollectionLiterals.<String, String>newHashMap(_mappedTo, _mappedTo_1)));
    if (bool) {
      String token = JwtUtil.sign(username, password);
      Pair<String, String> _mappedTo_2 = Pair.<String, String>of("password", password);
      Pair<String, String> _mappedTo_3 = Pair.<String, String>of("token", token);
      this.redis.<Object, Object>opsForHash().putAll(username, Collections.<String, String>unmodifiableMap(CollectionLiterals.<String, String>newHashMap(_mappedTo_2, _mappedTo_3)));
      this.redis.expire(username, JwtUtil.EXPIRE_TIME, TimeUnit.MILLISECONDS);
      Pair<String, String> _mappedTo_4 = Pair.<String, String>of("token", token);
      return new ResponseBean(200, "登陆成功", bool, Collections.<String, String>unmodifiableMap(CollectionLiterals.<String, String>newHashMap(_mappedTo_4)));
    } else {
      return new ResponseBean(200, "登陆失败", bool, null);
    }
  }
}
