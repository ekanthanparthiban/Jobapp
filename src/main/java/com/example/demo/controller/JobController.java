package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.JobModel;
import com.example.demo.services.JobService;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class JobController {
  private JobService ser;
  @Autowired
  public void setSer(JobService ser) {
	  this.ser = ser;
  }
  
  @GetMapping("/posts")
  public List<JobModel> setPosts() {
	return ser.getJobs();
  }

  @GetMapping("/posts/{jobId}")
  public ResponseEntity<JobModel> setPosts(@PathVariable("jobId") int id) {
	 return ResponseEntity.of(ser.getJobs(id));
  }
 
  @PostMapping("/jobPost")
  public void postJob(@RequestBody JobModel job) {
	ser.save(job);
  }
  @DeleteMapping("/jobPost/{jobId}")
  public void deleteJob(@PathVariable("jobId") int id) {
		ser.delete(id);
	  }
  @PutMapping("/jobPost/{jobId}")
  public void putJob(@PathVariable("jobId") int id,@RequestBody JobModel job) {
	  try {
	       ser.update(id,job);
          }
	  catch(Exception e) {
		  System.out.println("exception occured");
	  }
  }
}
