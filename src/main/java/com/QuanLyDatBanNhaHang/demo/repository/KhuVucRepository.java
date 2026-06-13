package com.QuanLyDatBanNhaHang.demo.repository;

import com.QuanLyDatBanNhaHang.demo.entity.KhuVuc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KhuVucRepository extends JpaRepository<KhuVuc, String> {
    // No ManyToOne relationships, standard JpaRepository methods are sufficient
}
