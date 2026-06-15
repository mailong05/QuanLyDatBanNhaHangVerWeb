package com.QuanLyDatBanNhaHang.demo.service;

import com.QuanLyDatBanNhaHang.demo.dto.request.KhuyenMaiCreateRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.request.KhuyenMaiUpdateRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.response.KhuyenMaiResponseDTO;
import java.util.List;
import java.util.stream.Collectors;

public interface KhuyenMaiService {
    List<KhuyenMaiResponseDTO> getAllKhuyenMai();
    KhuyenMaiResponseDTO getKhuyenMaiById(String maKM);
    KhuyenMaiResponseDTO createKhuyenMai(KhuyenMaiCreateRequestDTO requestDTO);
    KhuyenMaiResponseDTO updateKhuyenMai(String maKM, KhuyenMaiUpdateRequestDTO requestDTO);
    void deleteKhuyenMai(String maKM);
}
