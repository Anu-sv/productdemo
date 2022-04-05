package site.com.example.site.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import site.com.example.site.model.Role;
import site.com.example.site.repository.RoleDao;


@RestController("/role/")
public class RoleController {

    @Autowired
    private RoleDao roleDao;

    @PostMapping({"/createNewRole"})
    public Role createNewRole(@RequestBody Role role) {
    	return roleDao.save(role);
       // return roleDao.createNewRole(role);
    }
 
}
