package com.QuanLyDatBanNhaHang.demo.repository;

import com.QuanLyDatBanNhaHang.demo.entity.KhuVuc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository cho KhuVuc.
 */
@Repository
public interface KhuVucRepository extends JpaRepository<KhuVuc, String> {

    /**
     * Tìm tất cả khu vực kèm theo danh sách bàn ăn (để tránh lỗi N+1 Query).
     */
    @Query("SELECT DISTINCT k FROM KhuVuc k LEFT JOIN FETCH k.banAns")
    List<KhuVuc> findAllWithRelations();

    /**
     * Tìm khu vực theo ID kèm theo danh sách bàn ăn.
     */
    @Query("SELECT DISTINCT k FROM KhuVuc k LEFT JOIN FETCH k.banAns WHERE k.maKhuVuc = ?1")
    Optional<KhuVuc> findByIdWithRelations(String maKhuVuc);
}
