package study.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import study.dto.ChildParentSalaryDto;
import study.dto.ParentDTO;
import study.model.Child;
import study.model.Parent;
import study.repository.ChildRepository;
import study.service.ParentService;

@RestController
public class ParentController {

	@Autowired
	private ParentService parentService;
	
	@Autowired
	private ChildRepository childRepository;
	
	@PostMapping("parent/create")
	public Parent createParent(@RequestBody Parent parent) {
		return parentService.createParent(parent);
	}
	
	@PostMapping("parent/addChild/{parentId}")
	public Parent addChild(@PathVariable long parentId, @RequestBody Child child) {
		return parentService.addChildToParent(parentId, child);
	}
	
	
	@GetMapping("parent/findAll")
	public List<ParentDTO> findAll(){
		return parentService.findAll();
	}
	
	@GetMapping("/parent/findById/{id}")
	public Parent findById(@PathVariable long id) {
		return parentService.findById(id);
	}

	@GetMapping("parent/findChildrenWithSalary<=/{salary}")
	public List<ChildParentSalaryDto> findChildrenWithSalaryLessthan(@PathVariable long salary){
		return childRepository.findChildrenWithSalaryLessthan(salary);
	}
	
	@GetMapping("parent/findChildrenWithSalary>=/{salary}")
	public List<ChildParentSalaryDto> findChildrenWithSalaryGreaterthan(@PathVariable long salary){
		return childRepository.findChildrenWithSalaryGreaterthan(salary);
	}
	
	
	
}