package com.QuanLyDatBanNhaHang.demo.repository;

import com.QuanLyDatBanNhaHang.demo.entity.KhuyenMai;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface KhuyenMaiRepository extends JpaRepository<KhuyenMai, String> {

    @Query("SELECT DISTINCT k FROM KhuyenMai k LEFT JOIN FETCH k.hoaDons")
    List<KhuyenMai> findAllWithRelations();

    @Query("SELECT DISTINCT k FROM KhuyenMai k LEFT JOIN FETCH k.hoaDons WHERE k.maKM = ?1")
    Optional<KhuyenMai> findByIdWithRelations(String maKM);

    @Query("SELECT DISTINCT k FROM KhuyenMai k LEFT JOIN FETCH k.hoaDons WHERE k.trangThai = ?1")
    List<KhuyenMai> findByTrangThai(String trangThai);
}

