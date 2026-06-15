package com.QuanLyDatBanNhaHang.demo.repository;

import com.QuanLyDatBanNhaHang.demo.entity.CaLamViec;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

@Repository
public interface CaLamViecRepository extends JpaRepository<CaLamViec, String> {
    @Query("SELECT c FROM CaLamViec c JOIN FETCH c.nhanVien n")
    List<CaLamViec> findAllWithRelations();
    @Query(value = "SELECT x FROM CaLamViec x JOIN FETCH x.nhanVien n", countQuery = "SELECT count(x) FROM CaLamViec x")
    Page<CaLamViec> findAllWithRelations(Pageable pageable);
    @Query("SELECT x FROM CaLamViec x JOIN FETCH x.nhanVien n WHERE LOWER(x.maCa) = LOWER(:maCa)")
    Optional<CaLamViec> findByMaCaIgnoreCase(@Param("maCa") String maCa);

}
