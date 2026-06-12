package com.QuanLyDatBanNhaHang.demo.service;

import com.QuanLyDatBanNhaHang.demo.dto.request.CaLamViecRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.response.CaLamViecResponseDTO;
import java.util.List;
import java.util.Optional;

public interface CaLamViecService {
    List<CaLamViecResponseDTO> getAll();
    Optional<CaLamViecResponseDTO> getById(String maCa);
    CaLamViecResponseDTO create(CaLamViecRequestDTO dto);
    Optional<CaLamViecResponseDTO> update(String maCa, CaLamViecRequestDTO dto);
    void delete(String maCa);
    List<CaLamViecResponseDTO> getByNhanVien(String maNV);
    List<CaLamViecResponseDTO> getByTrangThai(String trangThai);
}

