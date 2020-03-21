package com.itmuch.could.jpa;

import com.itmuch.could.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserJpa extends JpaRepository<User,Integer>{

    public User getById(Integer id);

    @Query(value = "select * from t_user t where t.username=?1", nativeQuery = true)
    public User findUserByParam(String username);

}
