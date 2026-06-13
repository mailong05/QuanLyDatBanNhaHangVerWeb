package com.QuanLyDatBanNhaHang.demo.repository;

import com.QuanLyDatBanNhaHang.demo.entity.MonAn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonAnRepository extends JpaRepository<MonAn, String> {
    // No ManyToOne relationships, standard JpaRepository methods are sufficient
}
