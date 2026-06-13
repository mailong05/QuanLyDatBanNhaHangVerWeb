package com.QuanLyDatBanNhaHang.demo.repository;

import com.QuanLyDatBanNhaHang.demo.entity.ChiTietPhieuDatBan;
import com.QuanLyDatBanNhaHang.demo.entity.ChiTietPhieuDatBanId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChiTietPhieuDatBanRepository extends JpaRepository<ChiTietPhieuDatBan, ChiTietPhieuDatBanId> {
    List<ChiTietPhieuDatBan> findByMaPhieuDat(String maPhieuDat);
}
