package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.User;
@Repository
public interface userrepo extends JpaRepository<User,Integer> {
	@Query("Select s from User s where s.username=?1")
	public User findByUsername(String username);
}
