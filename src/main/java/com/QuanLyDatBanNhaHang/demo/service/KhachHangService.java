package com.QuanLyDatBanNhaHang.demo.service;

import com.QuanLyDatBanNhaHang.demo.dto.request.KhachHangCreateRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.request.KhachHangUpdateRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.response.KhachHangResponseDTO;
import java.util.List;
import java.util.stream.Collectors;

public interface KhachHangService {
    List<KhachHangResponseDTO> getAllKhachHang();
    KhachHangResponseDTO getKhachHangById(String maKH);
    KhachHangResponseDTO createKhachHang(KhachHangCreateRequestDTO requestDTO);
    KhachHangResponseDTO updateKhachHang(String maKH, KhachHangUpdateRequestDTO requestDTO);
    void deleteKhachHang(String maKH);
}
