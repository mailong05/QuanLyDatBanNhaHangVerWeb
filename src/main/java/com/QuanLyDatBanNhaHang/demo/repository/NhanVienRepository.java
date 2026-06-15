package com.QuanLyDatBanNhaHang.demo.repository;

import com.QuanLyDatBanNhaHang.demo.entity.NhanVien;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NhanVienRepository extends JpaRepository<NhanVien, String> {
    
    Optional<NhanVien> findByMaNVIgnoreCase(String maNV);
    
    List<NhanVien> findByHoTenContainingIgnoreCase(String hoTen);
    
    Page<NhanVien> findByHoTenContainingIgnoreCase(String hoTen, Pageable pageable);
}
