package com.QuanLyDatBanNhaHang.demo.service;

import com.QuanLyDatBanNhaHang.demo.dto.request.ChiTietHoaDonRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.response.ChiTietHoaDonResponseDTO;
import com.QuanLyDatBanNhaHang.demo.entity.ChiTietHoaDonId;

import java.util.List;
import java.util.Optional;

public interface ChiTietHoaDonService {
    List<ChiTietHoaDonResponseDTO> getAll();
    List<ChiTietHoaDonResponseDTO> getByMaHD(String maHD);
    Optional<ChiTietHoaDonResponseDTO> getById(ChiTietHoaDonId id);
    ChiTietHoaDonResponseDTO create(ChiTietHoaDonRequestDTO requestDTO);
    Optional<ChiTietHoaDonResponseDTO> update(ChiTietHoaDonId id, ChiTietHoaDonRequestDTO requestDTO);
    void delete(ChiTietHoaDonId id);
}
