package com.project.vote.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.vote.Entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> 
{
 Admin findByUsername(String username);
}

