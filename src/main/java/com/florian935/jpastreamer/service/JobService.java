package com.florian935.jpastreamer.service;

import com.florian935.jpastreamer.domain.Job;
import com.florian935.jpastreamer.dto.JobDto;

import java.util.List;

public interface JobService extends CrudService<Job, Integer> {

    List<JobDto> findAllFormatted();
}
