package com.QuanLyDatBanNhaHang.demo.repository;

import com.QuanLyDatBanNhaHang.demo.entity.PhieuDatBan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhieuDatBanRepository extends JpaRepository<PhieuDatBan, String> {
    @Query("SELECT p FROM PhieuDatBan p LEFT JOIN FETCH p.khachHang k JOIN FETCH p.nhanVien n")
    List<PhieuDatBan> findAllWithRelations();
}
