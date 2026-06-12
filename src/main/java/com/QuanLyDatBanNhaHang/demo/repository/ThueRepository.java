package com.QuanLyDatBanNhaHang.demo.repository;

import com.QuanLyDatBanNhaHang.demo.entity.Thue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ThueRepository extends JpaRepository<Thue, String> {

    @Query("SELECT DISTINCT t FROM Thue t LEFT JOIN FETCH t.hoaDons")
    List<Thue> findAllWithRelations();

    @Query("SELECT DISTINCT t FROM Thue t LEFT JOIN FETCH t.hoaDons WHERE t.maThue = ?1")
    Optional<Thue> findByIdWithRelations(String maThue);

    @Query("SELECT DISTINCT t FROM Thue t LEFT JOIN FETCH t.hoaDons WHERE t.trangThai = ?1")
    List<Thue> findByTrangThai(String trangThai);
}

