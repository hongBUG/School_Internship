package cn.tentact.nebula.user

import cn.tentact.nebula.web.ResponseBean

/**
 * 用户模块网络接口
 */

interface I_UserController {
	
	/**
	 * 
	 */
	 def ResponseBean login(String username,String password);
}