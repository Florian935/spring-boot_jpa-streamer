package com.florian935.jpastreamer.service.implementation;

import com.florian935.jpastreamer.domain.Employee;
import com.florian935.jpastreamer.domain.Job;
import com.florian935.jpastreamer.dto.JobDto;
import com.florian935.jpastreamer.repository.JobRepository;
import com.florian935.jpastreamer.service.JobService;
import com.speedment.jpastreamer.application.JPAStreamer;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class JobServiceImpl implements JobService {

    JPAStreamer jpaStreamer;

    @Override
    public List<Job> findAll() {

        return jpaStreamer.stream(Job.class).toList();
    }

    @Override
    public List<JobDto> findAllFormatted() {

        return jpaStreamer.stream(Job.class)
                .toList()
                .stream()
                .map(JobDto::new)
                .toList();
    }

    @Override
    public Job findById(Integer integer) {
        return null;
    }

    @Override
    public Job saveOne(Job job) {
        return null;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public Job updateOne(Integer integer, Job job) {
        return null;
    }
}
