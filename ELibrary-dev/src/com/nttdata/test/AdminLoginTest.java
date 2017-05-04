package com.nttdata.test;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

import org.junit.Test;

import com.nttdata.beans.LibrarianBean;
import com.nttdata.dao.LibrarianDao;

public class AdminLoginTest {
	
	  @Test
	  public void testAdminLoginSucusess() throws SQLException {
	      String user = "admin@jtp.com";
	      String pwd = "admin123";
	      LibrarianBean bean = new LibrarianBean(103, "Kousik", "koushik.shesadri@nttdata.com", "aabcd1234", 12345678);
	      
		int status = LibrarianDao.save(bean);
	      assertEquals(0,status);
	   }
}
