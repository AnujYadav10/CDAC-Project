package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dao.Managerdao;
import com.app.dto.ManagerDTO;
import com.app.entities.Manager;


@Service
@Transactional
public class ManagerServiceImp implements ManagerService {

	@Autowired
	private Managerdao Managerdao;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public ManagerDTO getmanbyid(Long manid) {
		// TODO Auto-generated method stub
		ManagerDTO man= mapper.map(Managerdao.findById(manid)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Dept Id !!!!"))
				,ManagerDTO.class);
		
		System.out.println( "works "+man);
		
		return man;
	}

	@Override
	public ManagerDTO findbyemail(String email) {
		// TODO Auto-generated method stub
		return mapper.map(Managerdao.findByEmail(email)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid email Id !!!!"))
				,ManagerDTO.class);
	}
	

	@Override
	public ManagerDTO addmanager(Manager man) {
		// TODO Auto-generated method stub
		Manager persistanceman = Managerdao.save(man);
		return mapper.map(persistanceman, ManagerDTO.class);
	}

}
