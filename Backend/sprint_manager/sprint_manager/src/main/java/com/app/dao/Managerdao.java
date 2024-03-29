package com.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.entities.Manager;

public interface Managerdao extends JpaRepository<Manager, Long> {

	Optional<Manager> findByEmail(String email);

}
