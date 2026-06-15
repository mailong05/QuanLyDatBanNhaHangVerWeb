package com.QuanLyDatBanNhaHang.demo.repository;

import com.QuanLyDatBanNhaHang.demo.entity.BanAn;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BanAnRepository extends JpaRepository<BanAn, String> {
    
    @Query("SELECT b FROM BanAn b JOIN FETCH b.khuVuc k")
    List<BanAn> findAllWithRelations();
    
    @Query(value = "SELECT b FROM BanAn b JOIN FETCH b.khuVuc k",
           countQuery = "SELECT count(b) FROM BanAn b")
    Page<BanAn> findAllWithRelations(Pageable pageable);

    @Query("SELECT b FROM BanAn b JOIN FETCH b.khuVuc k WHERE LOWER(b.maBan) = LOWER(:maBan)")
    Optional<BanAn> findByMaBanIgnoreCase(@Param("maBan") String maBan);
}
