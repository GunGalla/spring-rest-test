package com.gungalla.springresttask.web.mappers;

import com.gungalla.springresttask.domain.task.Task;
import com.gungalla.springresttask.web.dto.task.TaskDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskMapper extends Mappable<Task, TaskDto>{
}
