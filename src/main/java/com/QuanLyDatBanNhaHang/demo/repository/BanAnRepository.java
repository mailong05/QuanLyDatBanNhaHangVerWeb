package com.QuanLyDatBanNhaHang.demo.repository;

import com.QuanLyDatBanNhaHang.demo.entity.BanAn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BanAnRepository extends JpaRepository<BanAn, String> {
    @Query("SELECT b FROM BanAn b JOIN FETCH b.khuVuc k")
    List<BanAn> findAllWithRelations();
}
