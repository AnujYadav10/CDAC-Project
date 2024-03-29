package com.app.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dao.Managerdao;
import com.app.dao.Sprintdao;
import com.app.dto.ApiResponse;
import com.app.dto.SprintDTO;
import com.app.entities.Manager;
import com.app.entities.Sprint;


@Service
@Transactional
public class Sprintserviceimp implements Sprintservice {

	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private Sprintdao sprintdao;
	
	@Autowired
	private Managerdao Managerdao;
		
	@Override
	public List<SprintDTO> getallaprintsfromman(Long ManId) {
		// TODO Auto-generated method stub
		List<Sprint> sprintlist = sprintdao.findByMang(ManId);
		
		return sprintlist.stream().map(emp -> mapper.map(emp, SprintDTO.class)).collect(Collectors.toList());
	}



	@Override
	public SprintDTO addNewSprint(SprintDTO sp) {
		// TODO Auto-generated method stub
		Manager man =  Managerdao.findById(sp.getManager_id())
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Manager Id!!!"));
		Sprint sprintentity = mapper.map(sp, Sprint.class);
		man.addSprint(sprintentity);
		Sprint savedsprint = sprintdao.save(sprintentity);
		return mapper.map(savedsprint, SprintDTO.class); 
	}


	@Override
	public SprintDTO updateSprint(Long sprintid ,SprintDTO sp) {
		// TODO Auto-generated method stub
		Sprint sp1 = sprintdao.findById(sprintid)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Sprint ID , Sprint not found !!!!"));
		Manager man1 = Managerdao.findById(sp.getManager_id())
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Manager Id!!!"));
		sp.setId(sprintid);
		mapper.map(sp, sp1);
		System.out.println("updated after mapping " + sp + " and " + sp1);
		man1.addSprint(sp1);
		sp.setId(sprintid);
		return sp;
	}


	@Override
	public ApiResponse deleteSprint(Long sprintid) {
		// TODO Auto-generated method stub
		Sprint sp2 = sprintdao.findById(sprintid).
				orElseThrow(() -> new ResourceNotFoundException("Invalid emp id"));
		sprintdao.delete(sp2);
		return new ApiResponse("Sprint Details of emp with ID " +  " deleted....");
	}

}
