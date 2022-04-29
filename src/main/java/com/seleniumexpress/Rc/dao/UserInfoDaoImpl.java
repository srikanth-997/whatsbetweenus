package com.seleniumexpress.Rc.dao;

import org.hibernate.HibernateException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.seleniumexpress.Rc.api.UserInfoEntity;

@Transactional
@Repository("userInfoDaoImpl")
public class UserInfoDaoImpl implements UserInfoDao {

	@Autowired
	private SessionFactory sessionFactory;
	private Session currentSession;
	

	@Override

	public void saveUserData(String userName, String othersName, String appResult) {

		System.out.println(userName + " " + othersName + "  " + appResult);
		UserInfoEntity useInfoEntity =new UserInfoEntity();
		useInfoEntity.setUserName(userName);
		useInfoEntity.setOthersName(othersName);
		useInfoEntity.setAppResult(appResult);
		currentSession = sessionFactory.getCurrentSession();
		currentSession.save(useInfoEntity);
	}

}
