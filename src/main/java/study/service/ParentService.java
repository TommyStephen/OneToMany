package study.service;

import java.util.List;

import study.dto.ParentDTO;
import study.model.Child;
import study.model.Parent;

public interface ParentService {

	List<ParentDTO> findAll();

	Parent createParent(Parent parent);

	Parent findById(long id);

	Parent addChildToParent(long parentId,Child child);

}
