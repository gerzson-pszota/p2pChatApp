package com.greenfoxacademy.p2pchat.Repositories;

import com.greenfoxacademy.p2pchat.Models.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends JpaRepository<Log, Long> {
}
