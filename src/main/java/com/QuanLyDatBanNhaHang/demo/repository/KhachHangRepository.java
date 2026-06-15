package com.QuanLyDatBanNhaHang.demo.repository;

import com.QuanLyDatBanNhaHang.demo.entity.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

@Repository
public interface KhachHangRepository extends JpaRepository<KhachHang, Long> {
    
    Optional<KhachHang> findByMaKHIgnoreCase(String maKH);
    Optional<KhachHang> findBySdt(String sdt);
    List<KhachHang> findByHoTenContainingIgnoreCase(String hoTen);
    Page<KhachHang> findByHoTenContainingIgnoreCase(String hoTen, Pageable pageable);
}
