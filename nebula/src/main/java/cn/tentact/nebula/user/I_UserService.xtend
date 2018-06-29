package cn.tentact.nebula.user

import java.util.Map

/**
 * 用户模块的业务接口
 */

interface I_UserService {
	/**
	 * 用户登录
	 */
	def boolean login(Map map);
}