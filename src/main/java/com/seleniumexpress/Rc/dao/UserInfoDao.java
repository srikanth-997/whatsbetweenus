package com.seleniumexpress.Rc.dao;

import com.seleniumexpress.Rc.api.UserInfoDto;

public interface UserInfoDao {
	
	void saveUserData(String userName, String othersName, String appResult);
	
}
