package com.app.service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.app.dto.ApiResponse;
import com.app.dto.SprintDTO;
import com.app.entities.Sprint;

public interface Sprintservice {

	List<SprintDTO> getallaprintsfromman(Long manid);
	SprintDTO addNewSprint(SprintDTO sp);
	SprintDTO updateSprint(Long sprintid,SprintDTO sp);
	ApiResponse deleteSprint(Long sprintid);
}
