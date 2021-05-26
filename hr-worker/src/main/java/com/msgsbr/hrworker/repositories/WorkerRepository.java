package com.msgsbr.hrworker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.msgsbr.hrworker.entities.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long>{

}
