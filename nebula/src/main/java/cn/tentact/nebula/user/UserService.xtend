package cn.tentact.nebula.user

import java.util.Map
import cn.tentact.nebula.db.dao.I_UserDao
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * 用户模块实现
 */
@Service
class UserService implements I_UserService{
	
	@Autowired
	I_UserDao userDao;
	
	override login(Map map) {
		var count=userDao.login(map);
		
		if(count==1){
			return true;
		}else{
			return false;
		}
	}
	
}