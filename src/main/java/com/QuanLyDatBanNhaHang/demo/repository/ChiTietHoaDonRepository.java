package com.QuanLyDatBanNhaHang.demo.repository;

import com.QuanLyDatBanNhaHang.demo.entity.ChiTietHoaDon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChiTietHoaDonRepository extends JpaRepository<ChiTietHoaDon, Long> {
    @Query("SELECT c FROM ChiTietHoaDon c JOIN FETCH c.hoaDon h JOIN FETCH c.monAn m")
    List<ChiTietHoaDon> findAllWithRelations();
}
