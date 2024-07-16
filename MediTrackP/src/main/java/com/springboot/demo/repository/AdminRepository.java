package com.springboot.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.demo.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer>{

	Admin findByAdminNameAndPassword(String adminName, String password);

}
