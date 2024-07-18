package com.mikeV.URLShortener.repositories;

import com.mikeV.URLShortener.model.UserInput;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<UserInput, Long> {
}
