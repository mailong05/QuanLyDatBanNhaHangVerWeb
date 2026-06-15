package com.QuanLyDatBanNhaHang.demo.repository;

import com.QuanLyDatBanNhaHang.demo.entity.MonAn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

@Repository
public interface MonAnRepository extends JpaRepository<MonAn, Long> {
    
    Optional<MonAn> findByMaMonIgnoreCase(String maMon);
    List<MonAn> findByTenMonContainingIgnoreCase(String tenMon);
    Page<MonAn> findByTenMonContainingIgnoreCase(String tenMon, Pageable pageable);
    List<MonAn> findByTenLoai(String tenLoai);
    Page<MonAn> findByTenLoai(String tenLoai, Pageable pageable);
}
