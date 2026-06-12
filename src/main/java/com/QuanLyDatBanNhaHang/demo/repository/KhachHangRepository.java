package com.QuanLyDatBanNhaHang.demo.repository;

import com.QuanLyDatBanNhaHang.demo.entity.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface KhachHangRepository extends JpaRepository<KhachHang, String> {

    /**
     * Tìm tất cả khách hàng (không có quan hệ cần fetch, nhưng thêm để consistent).
     */
    @Query("SELECT DISTINCT k FROM KhachHang k LEFT JOIN FETCH k.phieuDatBans")
    List<KhachHang> findAllWithRelations();

    /**
     * Tìm khách hàng theo ID.
     */
    @Query("SELECT DISTINCT k FROM KhachHang k LEFT JOIN FETCH k.phieuDatBans WHERE k.maKH = ?1")
    Optional<KhachHang> findByIdWithRelations(String maKH);

    /**
     * Tìm khách hàng theo loại thành viên (VIP, BAC, v.v).
     */
    @Query("SELECT DISTINCT k FROM KhachHang k LEFT JOIN FETCH k.phieuDatBans WHERE k.loaiThanhVien = ?1")
    List<KhachHang> findByLoaiThanhVien(String loaiThanhVien);
}

