package study.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import study.dto.ChildParentSalaryDto;
import study.model.Child;
import study.repository.ChildRepository;
import study.specification.ChildParentSpecification;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChildServiceImpl implements ChildService {

    @Autowired
    private ChildRepository childRepository;


    @Override
    public List<ChildParentSalaryDto> findBySalaryLessThan(long salary) {

        Specification<Child> spec = ChildParentSpecification.findBySalaryLessThan(salary);

        return childRepository.findAll(spec).stream()
                .map(child -> new ChildParentSalaryDto(
                        child.getId(),
                        child.getName(),
                        child.getSalary(),
                        child.getParent() != null ? child.getParent().getName() : null
                ))
                .collect(Collectors.toList());
    }
}
