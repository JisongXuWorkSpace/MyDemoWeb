package com.jisong.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jisong.demo.loginInfo.User;

@Repository
public interface UserRepository extends JpaRepository<User ,Long>{
	//User JPA semantic
	User findByUsernameAndPassword(String username, String password);

}
