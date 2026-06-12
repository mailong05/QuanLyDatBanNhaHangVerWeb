package com.QuanLyDatBanNhaHang.demo.repository;

import com.QuanLyDatBanNhaHang.demo.entity.BanAn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository cho BanAn.
 * N+1 Query Prevention: Sử dụng LEFT JOIN FETCH để load KhuVuc cùng lúc.
 */
@Repository
public interface BanAnRepository extends JpaRepository<BanAn, String> {

    /**
     * Lấy tất cả bàn ăn kèm thông tin khu vực (tránh N+1 query).
     */
    @Query("SELECT DISTINCT b FROM BanAn b " +
           "LEFT JOIN FETCH b.khuVuc")
    List<BanAn> findAllWithRelations();

    /**
     * Lấy bàn ăn theo ID kèm thông tin khu vực.
     */
    @Query("SELECT b FROM BanAn b " +
           "LEFT JOIN FETCH b.khuVuc " +
           "WHERE b.maBan = :maBan")
    Optional<BanAn> findByIdWithRelations(@Param("maBan") String maBan);

    /**
     * Lấy tất cả bàn ăn theo trạng thái.
     */
    @Query("SELECT DISTINCT b FROM BanAn b " +
           "LEFT JOIN FETCH b.khuVuc " +
           "WHERE b.trangThai = :trangThai")
    List<BanAn> findByTrangThaiWithRelations(@Param("trangThai") String trangThai);

    /**
     * Lấy tất cả bàn ăn của một khu vực.
     */
    @Query("SELECT DISTINCT b FROM BanAn b " +
           "LEFT JOIN FETCH b.khuVuc " +
           "WHERE b.khuVuc.maKhuVuc = :maKhuVuc")
    List<BanAn> findByKhuVucWithRelations(@Param("maKhuVuc") String maKhuVuc);
}

