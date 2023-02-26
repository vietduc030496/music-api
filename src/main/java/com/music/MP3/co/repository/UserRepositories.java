package com.music.MP3.co.repository;

import com.music.MP3.co.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositories extends JpaRepository<User, Long> {

    User findByUsername(String username);

    boolean existsByUsername(String username);

}
