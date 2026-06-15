package com.QuanLyDatBanNhaHang.demo.repository;

import com.QuanLyDatBanNhaHang.demo.entity.KhuVuc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

@Repository
public interface KhuVucRepository extends JpaRepository<KhuVuc, String> {
    
    Optional<KhuVuc> findByMaKhuVucIgnoreCase(String maKhuVuc);
    List<KhuVuc> findByTenKhuVucContainingIgnoreCase(String tenKhuVuc);
    Page<KhuVuc> findByTenKhuVucContainingIgnoreCase(String tenKhuVuc, Pageable pageable);
}
