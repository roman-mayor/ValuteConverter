package com.example.demo.Repository;

import com.example.demo.Entity.ConvertHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ConvertHistoryRepository extends JpaRepository<ConvertHistoryEntity, Long> {
}
