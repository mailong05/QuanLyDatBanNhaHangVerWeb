package com.QuanLyDatBanNhaHang.demo.repository;

import com.QuanLyDatBanNhaHang.demo.entity.CaLamViec;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CaLamViecRepository extends JpaRepository<CaLamViec, String> {
    @Query("SELECT c FROM CaLamViec c JOIN FETCH c.nhanVien n")
    List<CaLamViec> findAllWithRelations();
}
