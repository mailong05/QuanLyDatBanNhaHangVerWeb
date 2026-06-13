package com.QuanLyDatBanNhaHang.demo.service;

import com.QuanLyDatBanNhaHang.demo.dto.request.HoaDonRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.response.HoaDonResponseDTO;

import java.util.List;
import java.util.Optional;

public interface HoaDonService {
    List<HoaDonResponseDTO> getAll();
    Optional<HoaDonResponseDTO> getById(String maHD);
    HoaDonResponseDTO create(HoaDonRequestDTO requestDTO);
    Optional<HoaDonResponseDTO> update(String maHD, HoaDonRequestDTO requestDTO);
    void delete(String maHD);
}
