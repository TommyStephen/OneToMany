package study.mapper;

import study.dto.ParentDTO;
import study.model.Parent;

public interface ParentToParentDtoMapper {

	public static ParentDTO fromParent(Parent parent){
		
		ParentDTO parentDTO = new ParentDTO();
		
		if(parent!=null) {
			parentDTO.setId(parent.getId());
			parentDTO.setName(parent.getName());
			parentDTO.setEmail(parent.getEmail());
			if(parent.getChildren()!=null) {
				
				parentDTO.setChildren(parent.getChildren());
			}
		}
		return parentDTO;
	}
}
