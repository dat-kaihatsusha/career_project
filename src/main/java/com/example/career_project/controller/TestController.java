package com.example.career_project.controller;

import com.example.career_project.entity.Job;
import com.example.career_project.repository.JobRepository;
import com.example.career_project.service.RunningToolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

  @Autowired
  JobRepository jobRepository;
  @Autowired
  RunningToolService runningToolService;

  @GetMapping("test-controller")
  public ResponseEntity<?> testController(){
    System.out.println(jobRepository.findAll().toString());
    List<Job> jobs = jobRepository.findAll();
    jobs.parallelStream().forEach(el -> System.out.println(el.getJobId()));
    System.out.println("----------------------------------");
    jobs.forEach(el -> System.out.println(el.getJobId()));
    return new ResponseEntity<>("success DatNT", HttpStatus.OK);
  }

  @GetMapping("run-tool")
  public ResponseEntity<?> runTool(){
    runningToolService.runningTool();
    return new ResponseEntity<>("success", HttpStatus.OK);
  }
}
