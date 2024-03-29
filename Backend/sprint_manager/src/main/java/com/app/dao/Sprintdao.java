package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.entities.Manager;
import com.app.entities.Sprint;

public interface Sprintdao extends JpaRepository<Sprint, Long> {

	@Query(value="select * from SPRINT where manager_id =:id",nativeQuery=true)
	List<Sprint> findByMang(@Param("id") Long id);
	
}
