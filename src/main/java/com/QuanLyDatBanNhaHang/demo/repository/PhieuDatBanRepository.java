package com.QuanLyDatBanNhaHang.demo.repository;

import com.QuanLyDatBanNhaHang.demo.entity.PhieuDatBan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository cho PhieuDatBan - dùng JOIN FETCH để tránh N+1 query.
 *
 * Các query đặc biệt:
 * - findAllWithRelations(): Load tất cả phiếu kèm khachHang và nhanVien ngay (JOIN FETCH)
 * - findByIdWithRelations(): Load 1 phiếu kèm quan hệ liên quan
 */
@Repository
public interface PhieuDatBanRepository extends JpaRepository<PhieuDatBan, String> {

    /**
     * Tìm tất cả Phiếu Đặt Bàn với thông tin KhachHang và NhanVien (JOIN FETCH).
     * Giải pháp: 1 query duy nhất thay vì 1 + N.
     *
     * Tránh:
     * - N+1 query: không phải chạy N query phụ để lấy khachHang/nhanVien
     * - Lazy exception khi access quan hệ ngoài session
     *
     * @return List các PhieuDatBan đầy đủ thông tin (eager loaded)
     */
    @Query("SELECT DISTINCT p FROM PhieuDatBan p " +
            "LEFT JOIN FETCH p.khachHang k " +
            "LEFT JOIN FETCH p.nhanVien n")
    List<PhieuDatBan> findAllWithRelations();

    /**
     * Tìm Phiếu Đặt Bàn theo ID kèm quan hệ liên quan.
     *
     * @param maPhieuDat ID của phiếu
     * @return Optional chứa phiếu (nếu tồn tại) với dữ liệu liên quan đã load
     */
    @Query("SELECT p FROM PhieuDatBan p " +
           "JOIN FETCH p.khachHang k " +
           "JOIN FETCH p.nhanVien n " +
           "WHERE p.maPhieuDat = :maPhieuDat")
    Optional<PhieuDatBan> findByIdWithRelations(@Param("maPhieuDat") String maPhieuDat);

    /**
     * Tìm tất cả phiếu của một khách hàng cụ thể (kèm thông tin NhanVien).
     * Tránh N+1 khi load danh sách phiếu của khách.
     *
     * @param maKH ID khách hàng
     * @return List phiếu của khách
     */
    @Query("SELECT p FROM PhieuDatBan p " +
           "JOIN FETCH p.nhanVien n " +
           "WHERE p.khachHang.maKH = :maKH")
    List<PhieuDatBan> findByKhachHangWithRelations(@Param("maKH") String maKH);

    /**
     * Tìm tất cả phiếu đang chờ (chưa có hóa đơn).
     * Trường hợp: cần lấy danh sách phiếu ChuẩnBị để lập hóa đơn.
     *
     * @return List phiếu chờ
     */
    @Query("SELECT p FROM PhieuDatBan p " +
           "JOIN FETCH p.khachHang k " +
           "JOIN FETCH p.nhanVien n " +
           "WHERE p.trangThai IN ('DANG_CHO', 'DANG_SU_DUNG')")
    List<PhieuDatBan> findAllPendingWithRelations();
}

