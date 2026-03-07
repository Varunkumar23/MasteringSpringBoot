package com.lpu.UserManagementSystem.repository;

import com.lpu.UserManagementSystem.dto.UserResponse;
import com.lpu.UserManagementSystem.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    boolean existsByEmail(String email);

    Optional<User> findByName(String name);
    Optional<User> findByEmail(String email);


    @Transactional
    @Query("SELECT u FROM User u WHERE u.role=:role") //JPQL because we are dealinlg with the entities itself
    List<User> getUsersByRole(@Param("role") String role);


    //Native Query means SQL because we are dealing with the tables
    @Query(value = "SELECT * FROM users WHERE role = :role", nativeQuery = true)
    List<User> findUsersByRoleNative(@Param("role") String role);

    @Transactional
    @Modifying
    @Query("UPDATE User u SET u.role = :role WHERE u.id = :id")
    void updateUserRole(@Param("id") Long id, @Param("role") String role);

    @Transactional
    @Query(value = "select * from users u where u.name like %:ch%",nativeQuery = true)
    List<User> getUsersContainInName(@Param("ch") String ch);
}

