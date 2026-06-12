package com.QuanLyDatBanNhaHang.demo.service;

import com.QuanLyDatBanNhaHang.demo.dto.request.KhuVucRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.response.KhuVucResponseDTO;
import java.util.List;
import java.util.Optional;

/**
 * Interface cho KhuVucService.
 */
public interface KhuVucService {
    List<KhuVucResponseDTO> getAll();
    Optional<KhuVucResponseDTO> getById(String maKhuVuc);
    KhuVucResponseDTO create(KhuVucRequestDTO dto);
    Optional<KhuVucResponseDTO> update(String maKhuVuc, KhuVucRequestDTO dto);
    void delete(String maKhuVuc);
}

