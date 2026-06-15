package com.QuanLyDatBanNhaHang.demo.repository;

import com.QuanLyDatBanNhaHang.demo.entity.KhuyenMai;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

@Repository
public interface KhuyenMaiRepository extends JpaRepository<KhuyenMai, String> {
    
    Optional<KhuyenMai> findByMaKMIgnoreCase(String maKM);
    List<KhuyenMai> findByTenKMContainingIgnoreCase(String tenKM);
    Page<KhuyenMai> findByTenKMContainingIgnoreCase(String tenKM, Pageable pageable);
}
