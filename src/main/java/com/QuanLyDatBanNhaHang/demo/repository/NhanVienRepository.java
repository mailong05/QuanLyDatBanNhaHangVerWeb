package com.QuanLyDatBanNhaHang.demo.repository;

import com.QuanLyDatBanNhaHang.demo.entity.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NhanVienRepository extends JpaRepository<NhanVien, String> {

    /**
     * Tìm tất cả nhân viên (LEFT JOIN FETCH không bắt buộc nhưng consistent).
     */
    @Query("SELECT DISTINCT n FROM NhanVien n LEFT JOIN FETCH n.caLamViecs LEFT JOIN FETCH n.phieuDatBans LEFT JOIN FETCH n.hoaDons")
    List<NhanVien> findAllWithRelations();

    /**
     * Tìm nhân viên theo ID.
     */
    @Query("SELECT DISTINCT n FROM NhanVien n LEFT JOIN FETCH n.caLamViecs LEFT JOIN FETCH n.phieuDatBans LEFT JOIN FETCH n.hoaDons WHERE n.maNV = ?1")
    Optional<NhanVien> findByIdWithRelations(String maNV);

    /**
     * Tìm tất cả nhân viên theo chức vụ (PHUC_VU, THU_NGAN, BEP, QUAN_LY).
     */
    @Query("SELECT DISTINCT n FROM NhanVien n LEFT JOIN FETCH n.caLamViecs LEFT JOIN FETCH n.phieuDatBans LEFT JOIN FETCH n.hoaDons WHERE n.chucVu = ?1")
    List<NhanVien> findByChucVu(String chucVu);

    /**
     * Tìm tất cả nhân viên theo trạng thái.
     */
    @Query("SELECT DISTINCT n FROM NhanVien n LEFT JOIN FETCH n.caLamViecs LEFT JOIN FETCH n.phieuDatBans LEFT JOIN FETCH n.hoaDons WHERE n.trangThai = ?1")
    List<NhanVien> findByTrangThai(String trangThai);
}

