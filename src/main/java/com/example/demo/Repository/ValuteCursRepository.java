package com.example.demo.Repository;

import com.example.demo.Entity.ValuteCursEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ValuteCursRepository extends JpaRepository<ValuteCursEntity, Long> {

    @Query("select distinct valuteCursEntity from ValuteCursEntity valuteCursEntity")
    List<ValuteCursEntity> findEntities();
}
