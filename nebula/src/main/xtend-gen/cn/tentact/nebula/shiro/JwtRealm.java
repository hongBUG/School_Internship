package cn.tentact.nebula.shiro;

import cn.tentact.nebula.shiro.JwtToken;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * JWT的Realm类
 */
@SuppressWarnings("all")
public class JwtRealm extends AuthorizingRealm {
  /**
   * 大坑！，必须重写此方法，不然Shiro会报错
   */
  @Override
  public boolean supports(final AuthenticationToken token) {
    return (token instanceof JwtToken);
  }
  
  /**
   * 授权方法
   * 只有当需要检测用户权限的时候才会调用此方法，例如checkRole,checkPermission之类的
   */
  @Override
  public AuthorizationInfo doGetAuthorizationInfo(final PrincipalCollection principals) {
    return null;
  }
  
  /**
   * 认证方法
   * 默认使用此方法进行用户名正确与否验证，错误抛出异常即可。
   */
  @Override
  public AuthenticationInfo doGetAuthenticationInfo(final AuthenticationToken auth) throws AuthenticationException {
    return null;
  }
}
