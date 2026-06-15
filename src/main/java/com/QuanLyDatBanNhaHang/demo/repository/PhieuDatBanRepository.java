package com.QuanLyDatBanNhaHang.demo.repository;

import com.QuanLyDatBanNhaHang.demo.entity.PhieuDatBan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

@Repository
public interface PhieuDatBanRepository extends JpaRepository<PhieuDatBan, Long> {
    @Query("SELECT p FROM PhieuDatBan p LEFT JOIN FETCH p.khachHang k JOIN FETCH p.nhanVien n")
    List<PhieuDatBan> findAllWithRelations();
    @Query(value = "SELECT x FROM PhieuDatBan x LEFT JOIN FETCH x.khachHang k JOIN FETCH x.nhanVien n", countQuery = "SELECT count(x) FROM PhieuDatBan x")
    Page<PhieuDatBan> findAllWithRelations(Pageable pageable);
    @Query("SELECT x FROM PhieuDatBan x LEFT JOIN FETCH x.khachHang k JOIN FETCH x.nhanVien n WHERE LOWER(x.maPhieuDat) = LOWER(:maPhieuDat)")
    Optional<PhieuDatBan> findByMaPhieuDatIgnoreCase(@Param("maPhieuDat") String maPhieuDat);
}
