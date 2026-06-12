package com.QuanLyDatBanNhaHang.demo.service;

import com.QuanLyDatBanNhaHang.demo.dto.request.ThueRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.response.ThueResponseDTO;
import java.util.List;
import java.util.Optional;

public interface ThueService {
    List<ThueResponseDTO> getAll();
    Optional<ThueResponseDTO> getById(String maThue);
    ThueResponseDTO create(ThueRequestDTO dto);
    Optional<ThueResponseDTO> update(String maThue, ThueRequestDTO dto);
    void delete(String maThue);
    List<ThueResponseDTO> getByTrangThai(String trangThai);
}

