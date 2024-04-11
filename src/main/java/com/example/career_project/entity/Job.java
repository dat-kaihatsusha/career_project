package com.example.career_project.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "jobs", schema = "hr")
public class Job {
  @Id
  @Column(name = "job_id")
  private String jobId;

  @Column(name = "job_title")
  private String jobTitle;

  @Column(name = "max_salary")
  private String maxSalary;
}
