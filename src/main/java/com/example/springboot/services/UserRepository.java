package com.example.springboot.services;

import com.example.springboot.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface UserRepository extends CrudRepository<Users, Long> {
  /*  @Modifying(clearAutomatically = true)
    @Query(value = "Delete from users c WHERE c.id=:id")
    void deleteById(@Param("id") int id);*/
}
