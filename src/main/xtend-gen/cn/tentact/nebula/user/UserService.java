package cn.tentact.nebula.user;

import cn.tentact.nebula.db.dao.I_UserDao;
import cn.tentact.nebula.user.I_UserService;
import java.util.Map;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户模块实现
 */
@Service
@SuppressWarnings("all")
public class UserService implements I_UserService {
  @Autowired
  private I_UserDao userDao;
  
  @Override
  public boolean login(final Map map) {
    InputOutput.<Object>println(map.get("username"));
    InputOutput.<Object>println(map.get("password"));
    long count = this.userDao.login(map);
    if ((count == 1)) {
      return true;
    } else {
      return false;
    }
  }
}
