package com.QuanLyDatBanNhaHang.demo.service;

import com.QuanLyDatBanNhaHang.demo.dto.request.CaLamViecCreateRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.request.CaLamViecUpdateRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.response.CaLamViecResponseDTO;
import java.util.List;
import java.util.stream.Collectors;

public interface CaLamViecService {
    List<CaLamViecResponseDTO> getAllCaLamViec();
    CaLamViecResponseDTO getCaLamViecById(String maCa);
    CaLamViecResponseDTO createCaLamViec(CaLamViecCreateRequestDTO requestDTO);
    CaLamViecResponseDTO updateCaLamViec(String maCa, CaLamViecUpdateRequestDTO requestDTO);
    void deleteCaLamViec(String maCa);
}
