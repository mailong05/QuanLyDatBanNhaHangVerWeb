package com.QuanLyDatBanNhaHang.demo.repository;

import java.util.List;
import com.QuanLyDatBanNhaHang.demo.entity.Thue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import java.util.Optional;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

@Repository
public interface ThueRepository extends JpaRepository<Thue, String> {
    
    Optional<Thue> findByMaThueIgnoreCase(String maThue);
    List<Thue> findByTenThueContainingIgnoreCase(String tenThue);
    Page<Thue> findByTenThueContainingIgnoreCase(String tenThue, Pageable pageable);
}
