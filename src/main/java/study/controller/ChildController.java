package study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import study.dto.ChildParentSalaryDto;
import study.service.ChildService;

import java.util.List;

@RestController
public class ChildController {

    @Autowired
    public ChildService childService;

    @GetMapping("child/findBySalaryLessThan/{salary}")
    public List<ChildParentSalaryDto> findBySalaryLessThan(@PathVariable long salary){
        return childService.findBySalaryLessThan(salary);
    }
}
