package com.buyacar.repository;

import com.buyacar.model.LookUp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LookUpRepository extends JpaRepository<LookUp, Long> {
}
