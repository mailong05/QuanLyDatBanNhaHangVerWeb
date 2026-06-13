package com.QuanLyDatBanNhaHang.demo.repository;

import com.QuanLyDatBanNhaHang.demo.entity.ChiTietHoaDon;
import com.QuanLyDatBanNhaHang.demo.entity.ChiTietHoaDonId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChiTietHoaDonRepository extends JpaRepository<ChiTietHoaDon, ChiTietHoaDonId> {
    List<ChiTietHoaDon> findByMaHD(String maHD);
}
