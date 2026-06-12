package com.QuanLyDatBanNhaHang.demo.service;

import com.QuanLyDatBanNhaHang.demo.dto.request.KhachHangRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.response.KhachHangResponseDTO;
import java.util.List;
import java.util.Optional;

/**
 * Interface cho KhachHangService.
 */
public interface KhachHangService {
    List<KhachHangResponseDTO> getAll();
    Optional<KhachHangResponseDTO> getById(String maKH);
    KhachHangResponseDTO create(KhachHangRequestDTO dto);
    Optional<KhachHangResponseDTO> update(String maKH, KhachHangRequestDTO dto);
    void delete(String maKH);
    List<KhachHangResponseDTO> getByLoaiThanhVien(String loaiThanhVien);
}

