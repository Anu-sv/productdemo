package site.com.example.site.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import site.com.example.site.model.User;
@Repository
public interface UserRepo extends JpaRepository<User,String>{

	User findByUserId(String userId);

}
