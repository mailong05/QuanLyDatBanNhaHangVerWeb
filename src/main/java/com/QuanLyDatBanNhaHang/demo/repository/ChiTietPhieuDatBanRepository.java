package com.QuanLyDatBanNhaHang.demo.repository;

import com.QuanLyDatBanNhaHang.demo.entity.ChiTietPhieuDatBan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

@Repository
public interface ChiTietPhieuDatBanRepository extends JpaRepository<ChiTietPhieuDatBan, Long> {
    @Query("SELECT c FROM ChiTietPhieuDatBan c JOIN FETCH c.phieuDatBan p JOIN FETCH c.banAn b")
    List<ChiTietPhieuDatBan> findAllWithRelations();
    @Query(value = "SELECT x FROM ChiTietPhieuDatBan x JOIN FETCH x.phieuDatBan p JOIN FETCH x.banAn b", countQuery = "SELECT count(x) FROM ChiTietPhieuDatBan x")
    Page<ChiTietPhieuDatBan> findAllWithRelations(Pageable pageable);
    @Query("SELECT x FROM ChiTietPhieuDatBan x JOIN FETCH x.phieuDatBan p JOIN FETCH x.banAn b WHERE x.id = :id")
    Optional<ChiTietPhieuDatBan> findByIdWithRelations(@Param("id") Long id);
}
