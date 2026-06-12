package com.QuanLyDatBanNhaHang.demo.service;

import com.QuanLyDatBanNhaHang.demo.dto.request.NhanVienRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.response.NhanVienResponseDTO;
import java.util.List;
import java.util.Optional;

/**
 * Interface cho NhanVienService.
 */
public interface NhanVienService {
    List<NhanVienResponseDTO> getAll();
    Optional<NhanVienResponseDTO> getById(String maNV);
    NhanVienResponseDTO create(NhanVienRequestDTO dto);
    Optional<NhanVienResponseDTO> update(String maNV, NhanVienRequestDTO dto);
    void delete(String maNV);
    List<NhanVienResponseDTO> getByChucVu(String chucVu);
    List<NhanVienResponseDTO> getByTrangThai(String trangThai);
}

