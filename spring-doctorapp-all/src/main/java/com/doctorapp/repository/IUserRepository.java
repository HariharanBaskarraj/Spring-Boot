package com.doctorapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.doctorapp.model.AppUser;

@Repository
public interface IUserRepository extends JpaRepository<AppUser, Integer>{
	AppUser findByUsername(String username);
}
