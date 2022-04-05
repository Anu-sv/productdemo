package site.com.example.site.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import site.com.example.site.model.User;


@Repository
public interface UserDao extends CrudRepository<User, String>{

}
