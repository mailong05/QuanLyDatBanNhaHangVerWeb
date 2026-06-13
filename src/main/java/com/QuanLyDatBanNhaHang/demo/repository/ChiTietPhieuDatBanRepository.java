package com.QuanLyDatBanNhaHang.demo.repository;

import com.QuanLyDatBanNhaHang.demo.entity.ChiTietPhieuDatBan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChiTietPhieuDatBanRepository extends JpaRepository<ChiTietPhieuDatBan, Long> {
    @Query("SELECT c FROM ChiTietPhieuDatBan c JOIN FETCH c.phieuDatBan p JOIN FETCH c.banAn b")
    List<ChiTietPhieuDatBan> findAllWithRelations();
}
