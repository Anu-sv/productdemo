package site.com.example.site.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import site.com.example.site.model.Role;


@Repository
public interface RoleDao extends CrudRepository<Role, String>{

}
