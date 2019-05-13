package com.company.web;

public class Job {
    private int id;
    private String job_name;
    private Float salary;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the job_name
     */
    public String getJob_name() {
        return job_name;
    }

    /**
     * @param job_name the job_name to set
     */
    public void setJob_name(String job_name) {
        this.job_name = job_name;
    }

    /**
     * @return the salary
     */
    public Float getSalary() {
        return salary;
    }

    /**
     * @param salary the salary to set
     */
    public void setSalary(Float salary) {
        this.salary = salary;
    }
}