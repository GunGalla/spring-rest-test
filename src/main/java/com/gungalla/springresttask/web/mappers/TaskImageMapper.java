package com.gungalla.springresttask.web.mappers;

import com.gungalla.springresttask.domain.task.TaskImage;
import com.gungalla.springresttask.web.dto.task.TaskImageDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaskImageMapper extends Mappable<TaskImage, TaskImageDto> {
}
