package com.QuanLyDatBanNhaHang.demo.repository;

import com.QuanLyDatBanNhaHang.demo.entity.HoaDon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HoaDonRepository extends JpaRepository<HoaDon, String> {
    @Query("SELECT DISTINCT h FROM HoaDon h " +
           "JOIN FETCH h.phieuDatBan p " +
           "JOIN FETCH h.nhanVien n " +
           "LEFT JOIN FETCH h.khuyenMai k " +
           "JOIN FETCH h.thue t")
    List<HoaDon> findAllWithRelations();
}
