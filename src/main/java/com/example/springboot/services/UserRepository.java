package com.example.springboot.services;

import com.example.springboot.models.Products;
import com.example.springboot.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository("usersRepository")
public interface UserRepository extends JpaRepository<Users, Long> {
    @Query(value = "SELECT * FROM users u where u.user_email = :email and u.user_password = :password", nativeQuery = true)
    List<Users> logUser(@Param("email") String email, @Param("password") String password);
}
