package study.service;

import study.dto.ChildParentSalaryDto;

import java.util.List;

public interface ChildService {

    public List<ChildParentSalaryDto> findBySalaryLessThan(long salary);
}
