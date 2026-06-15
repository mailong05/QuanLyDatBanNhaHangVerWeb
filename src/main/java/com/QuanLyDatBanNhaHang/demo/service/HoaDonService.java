package com.QuanLyDatBanNhaHang.demo.service;

import com.QuanLyDatBanNhaHang.demo.dto.request.HoaDonCreateRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.request.HoaDonUpdateRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.response.HoaDonResponseDTO;
import java.util.List;
import java.util.stream.Collectors;

public interface HoaDonService {
    List<HoaDonResponseDTO> getAllHoaDon();
    HoaDonResponseDTO getHoaDonById(String id);
    HoaDonResponseDTO createHoaDon(HoaDonCreateRequestDTO requestDTO);
    HoaDonResponseDTO updateHoaDon(String id, HoaDonUpdateRequestDTO requestDTO);
    void deleteHoaDon(String id);
}
