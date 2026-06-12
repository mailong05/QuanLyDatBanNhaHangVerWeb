package com.QuanLyDatBanNhaHang.demo.repository;

import com.QuanLyDatBanNhaHang.demo.entity.KhuVuc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository cho KhuVuc.
 */
@Repository
public interface KhuVucRepository extends JpaRepository<KhuVuc, String> {
}

