package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.JobModel;
import com.example.demo.repository.JobRepo;

@Service
public class JobService {
    private JobRepo repo;
    @Autowired
	public void setRepo(JobRepo repo) {
		this.repo = repo;
	}
	@Autowired
    
	public List<JobModel> getJobs() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}
	public void save(JobModel job) {
		// TODO Auto-generated method stub
		repo.save(job);
	}
	public Optional<JobModel> getJobs(int id)  {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}
	public void delete(int id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}
	public void update(int id,JobModel model) throws Exception{
		// TODO Auto-generated method stub
        
		JobModel existingJob = repo.findById(id)
                .orElseThrow(() -> new Exception("Job with ID " + id + " not found"));
		
		existingJob.setPostDesc(model.getPostDesc());
		existingJob.setPostId(model.getPostId());
		existingJob.setPostProfile(model.getPostProfile());
		existingJob.setPostTechStack(model.getPostTechStack());
		existingJob.setReqExperience(model.getReqExperience());
		repo.save(existingJob);
	}

}
