package com.project.vote.service;

import java.util.List;

import com.project.vote.Entity.Admin;

public interface AdminService 
{
	void saveAdmin(Admin admin);
	List<Admin> getAllAdmins();
	Admin getAdminById(Long id);
	void updateAdmin(Admin admin);
	void deleteAdminById(Long id); 
}

