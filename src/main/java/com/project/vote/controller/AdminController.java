package com.project.vote.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.vote.Entity.Admin;
import com.project.vote.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) 
    {
        this.adminService = adminService;
    }
   
    // Create Admin
    @PostMapping("/create")
    public ResponseEntity<String> createAdmin(@RequestBody Admin admin) 
    {
        adminService.saveAdmin(admin);
        return new ResponseEntity<>("Admin created successfully", HttpStatus.CREATED);
    }

  // Read All Admins
    @GetMapping("/all")
    public ResponseEntity<List<Admin>> getAllAdmins() 
    {
        List<Admin> admins = adminService.getAllAdmins();
        return new ResponseEntity<>(admins, HttpStatus.OK);
    }

    // Read Admin by ID
    @GetMapping("/id")
    public ResponseEntity<Admin> getAdminById(@PathVariable Long id) 
    {
        Admin admin = adminService.getAdminById(id);
        if (admin != null) {
            return new ResponseEntity<>(admin, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Update Admin
    @PutMapping("/update")
    public ResponseEntity<String> updateAdmin(@RequestBody Admin admin) 
    {
        adminService.updateAdmin(admin);
        return new ResponseEntity<>("Admin updated successfully", HttpStatus.OK);
    }

    // Delete Admin
    @DeleteMapping("/delete/id")
    public ResponseEntity<String> deleteAdmin(@PathVariable Long id) 
    {
        adminService.deleteAdminById(id);
        return new ResponseEntity<>("Admin deleted successfully", HttpStatus.OK);
    }

}
