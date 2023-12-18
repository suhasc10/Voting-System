package com.project.vote.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.vote.Entity.Admin;
import com.project.vote.Repository.AdminRepository;
import com.project.vote.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService 
{

 private final AdminRepository adminRepository;

 @Autowired
 public AdminServiceImpl(AdminRepository adminRepository) 
 {
     this.adminRepository = adminRepository;
 }

 @Override
 public void saveAdmin(Admin admin) 
 {
     adminRepository.save(admin);
 }

 @Override
 public List<Admin> getAllAdmins() 
 {
     return adminRepository.findAll();
 }

 @Override
 public Admin getAdminById(Long id) 
 {
     return adminRepository.findById(id).orElse(null);
 }

 @Override
 public void updateAdmin(Admin admin) 
 {
     adminRepository.save(admin);
 }

 @Override
 public void deleteAdminById(Long id) 
 {
     adminRepository.deleteById(id);
 }
}

