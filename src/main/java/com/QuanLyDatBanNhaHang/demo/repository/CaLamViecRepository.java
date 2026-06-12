package com.QuanLyDatBanNhaHang.demo.repository;

import com.QuanLyDatBanNhaHang.demo.entity.CaLamViec;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CaLamViecRepository extends JpaRepository<CaLamViec, String> {

    @Query("SELECT DISTINCT c FROM CaLamViec c JOIN FETCH c.nhanVien")
    List<CaLamViec> findAllWithRelations();

    @Query("SELECT DISTINCT c FROM CaLamViec c JOIN FETCH c.nhanVien WHERE c.maCa = ?1")
    Optional<CaLamViec> findByIdWithRelations(String maCa);

    @Query("SELECT DISTINCT c FROM CaLamViec c JOIN FETCH c.nhanVien WHERE c.nhanVien.maNV = ?1")
    List<CaLamViec> findByNhanVien(String maNV);

    @Query("SELECT DISTINCT c FROM CaLamViec c JOIN FETCH c.nhanVien WHERE c.trangThai = ?1")
    List<CaLamViec> findByTrangThai(String trangThai);
}

