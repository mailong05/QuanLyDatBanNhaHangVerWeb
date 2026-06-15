package com.QuanLyDatBanNhaHang.demo.repository;

import com.QuanLyDatBanNhaHang.demo.entity.TaiKhoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

@Repository
public interface TaiKhoanRepository extends JpaRepository<TaiKhoan, String> {
    @Query("SELECT t FROM TaiKhoan t JOIN FETCH t.nhanVien n")
    List<TaiKhoan> findAllWithRelations();
    @Query(value = "SELECT x FROM TaiKhoan x JOIN FETCH x.nhanVien n", countQuery = "SELECT count(x) FROM TaiKhoan x")
    Page<TaiKhoan> findAllWithRelations(Pageable pageable);
    @Query("SELECT x FROM TaiKhoan x JOIN FETCH x.nhanVien n WHERE LOWER(x.username) = LOWER(:username)")
    Optional<TaiKhoan> findByUsernameIgnoreCase(@Param("username") String username);
}
