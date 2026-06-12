package com.QuanLyDatBanNhaHang.demo.service;

import com.QuanLyDatBanNhaHang.demo.dto.request.MonAnRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.response.MonAnResponseDTO;
import java.util.List;
import java.util.Optional;

/**
 * Interface cho MonAnService.
 */
public interface MonAnService {
    List<MonAnResponseDTO> getAll();
    Optional<MonAnResponseDTO> getById(String maMon);
    MonAnResponseDTO create(MonAnRequestDTO dto);
    Optional<MonAnResponseDTO> update(String maMon, MonAnRequestDTO dto);
    void delete(String maMon);
    List<MonAnResponseDTO> getByTenLoai(String tenLoai);
    List<MonAnResponseDTO> getByTrangThai(String trangThai);
}

