package com.QuanLyDatBanNhaHang.demo.repository;

import com.QuanLyDatBanNhaHang.demo.entity.MonAn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MonAnRepository extends JpaRepository<MonAn, String> {

    @Query("SELECT DISTINCT m FROM MonAn m LEFT JOIN FETCH m.chiTietHoaDons")
    List<MonAn> findAllWithRelations();

    @Query("SELECT DISTINCT m FROM MonAn m LEFT JOIN FETCH m.chiTietHoaDons WHERE m.maMon = ?1")
    Optional<MonAn> findByIdWithRelations(String maMon);

    @Query("SELECT DISTINCT m FROM MonAn m LEFT JOIN FETCH m.chiTietHoaDons WHERE m.tenLoai = ?1")
    List<MonAn> findByTenLoai(String tenLoai);

    @Query("SELECT DISTINCT m FROM MonAn m LEFT JOIN FETCH m.chiTietHoaDons WHERE m.trangThai = ?1")
    List<MonAn> findByTrangThai(String trangThai);
}

