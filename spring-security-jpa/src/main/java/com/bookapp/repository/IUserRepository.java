package com.bookapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookapp.model.AppUser;

@Repository
public interface IUserRepository extends JpaRepository<AppUser, Integer>{
	AppUser findByUsername(String username);
}
