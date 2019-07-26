package com.db.employeemanagementsystem.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.db.employeemanagementsystem.bean.LoginBean;

class LoginDAOImplTest {

	@Test
	void testAuthenticate(){
		LoginBean login = new LoginBean("admin", "root");
		LoginDAOImpl loginDAOImpl = new LoginDAOImpl();
		boolean result = loginDAOImpl.authenticate(login);
		Assertions.assertTrue(result, "Result should be true");
	}

}
