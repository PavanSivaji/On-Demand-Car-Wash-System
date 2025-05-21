package com.Project.Security.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Project.Security.entity.UserInfo;

import java.util.Optional;

public interface UserInfoRepository extends JpaRepository<UserInfo, Integer> {
    Optional<UserInfo> findByName(String username);

}
