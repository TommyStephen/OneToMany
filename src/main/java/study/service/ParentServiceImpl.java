package study.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import study.dto.ParentDTO;
import study.mapper.ParentToParentDtoMapper;
import study.model.Child;
import study.model.Parent;
import study.repository.ParentRepository;

@Service
public class ParentServiceImpl implements ParentService {

	@Autowired
	private ParentRepository parentRepository;
	
	@Override
	public List<ParentDTO> findAll() {
		List<Parent> list = parentRepository.findAll();
		return list.stream().map(ParentToParentDtoMapper::fromParent).
				collect(Collectors.toList());
	}

		
	@Override
	public Parent createParent(Parent parent) {
		
		for (Child child : parent.getChildren()) {
            child.setParent(parent); // Ensure each child has the parent set
        }
		return parentRepository.save(parent);
	}

	@Override
	public Parent findById(long id) {
		return parentRepository.findById(id).get();	
	}
	
	@Override
	public Parent addChildToParent(long parentId, Child child) {
		//get the parent from the repository
		Parent parent = parentRepository.findById(parentId).orElseThrow();
		//set parent into the child object
		child.setParent(parent);
		//add child to the children list of the parent object
		parent.getChildren().add(child);
		//save the parent into the repository
		return parentRepository.save(parent);
				
	}
}
