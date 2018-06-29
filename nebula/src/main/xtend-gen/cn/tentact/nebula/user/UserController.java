package cn.tentact.nebula.user;

import cn.tentact.nebula.user.I_UserController;
import cn.tentact.nebula.user.I_UserService;
import cn.tentact.nebula.web.ResponseBean;
import java.util.Collections;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@SuppressWarnings("all")
public class UserController implements I_UserController {
  @Autowired
  private I_UserService userService;
  
  @RequestMapping("/login")
  @Override
  public ResponseBean login(final String username, final String password) {
    Pair<String, String> _mappedTo = Pair.<String, String>of("username", username);
    Pair<String, String> _mappedTo_1 = Pair.<String, String>of("password", password);
    boolean bool = this.userService.login(Collections.<String, String>unmodifiableMap(CollectionLiterals.<String, String>newHashMap(_mappedTo, _mappedTo_1)));
    if (bool) {
      return new ResponseBean(200, "登陆成功", bool, null);
    } else {
      return new ResponseBean(200, "登陆失败", bool, null);
    }
  }
}
