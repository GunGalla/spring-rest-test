package com.gungalla.springresttask.service.impl;

import com.gungalla.springresttask.domain.task.TaskImage;
import com.gungalla.springresttask.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {

    @Override
    public String upload(TaskImage image) {
        return null;
    }

}
