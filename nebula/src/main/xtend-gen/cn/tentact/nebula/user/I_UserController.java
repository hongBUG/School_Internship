package cn.tentact.nebula.user;

import cn.tentact.nebula.web.ResponseBean;

/**
 * 用户模块网络接口
 */
@SuppressWarnings("all")
public interface I_UserController {
  public abstract ResponseBean login(final String username, final String password);
}
