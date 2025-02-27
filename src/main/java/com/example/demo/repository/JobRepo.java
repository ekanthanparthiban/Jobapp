package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.JobModel;

public interface JobRepo extends JpaRepository<JobModel,Integer> {

}
