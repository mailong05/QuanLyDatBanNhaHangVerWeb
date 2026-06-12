package com.QuanLyDatBanNhaHang.demo.service;

import com.QuanLyDatBanNhaHang.demo.dto.request.KhuyenMaiRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.response.KhuyenMaiResponseDTO;
import java.util.List;
import java.util.Optional;

public interface KhuyenMaiService {
    List<KhuyenMaiResponseDTO> getAll();
    Optional<KhuyenMaiResponseDTO> getById(String maKM);
    KhuyenMaiResponseDTO create(KhuyenMaiRequestDTO dto);
    Optional<KhuyenMaiResponseDTO> update(String maKM, KhuyenMaiRequestDTO dto);
    void delete(String maKM);
    List<KhuyenMaiResponseDTO> getByTrangThai(String trangThai);
}

