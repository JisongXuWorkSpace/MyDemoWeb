package com.jisong.demo.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.jisong.demo.loginInfo.User;
import com.jisong.demo.repo.UserRepository;

@Component
public class LoginDAO {
	
	@Autowired JdbcTemplate jdbcTemplate ;
	@Autowired UserRepository userRepo;
	public Optional<User> getLoginInfo(String username , String password) {
		 try {
			 
//			 
//			 List<?> reList =  jdbcTemplate.queryForList("SELECT * FROM t_user ");
//			 if(!reList.isEmpty()) {
//				 System.err.println("Select succuse "+ reList.get(0));
//			 }else {
//				 jdbcTemplate.execute("INSERT INTO t_user (id , name , age) VALUES ('1' , 'jisong ', '31')");
//			 }

			return Optional.ofNullable(userRepo.findByUsernameAndPassword(username,password));
		} catch (Exception e) {
			e.fillInStackTrace();
		}
		 return Optional.empty();
	}
}
