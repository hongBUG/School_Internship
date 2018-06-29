package cn.tentact.nebula.user;

import java.util.Map;

/**
 * 用户模块的业务接口
 */
@SuppressWarnings("all")
public interface I_UserService {
  /**
   * 用户登录
   */
  public abstract boolean login(final Map map);
}
