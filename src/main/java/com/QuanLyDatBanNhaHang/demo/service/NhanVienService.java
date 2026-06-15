package com.QuanLyDatBanNhaHang.demo.service;

import com.QuanLyDatBanNhaHang.demo.dto.request.NhanVienCreateRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.request.NhanVienUpdateRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.response.NhanVienResponseDTO;
import java.util.List;
import java.util.stream.Collectors;

public interface NhanVienService {
    List<NhanVienResponseDTO> getAllNhanVien();
    NhanVienResponseDTO getNhanVienById(String maNV);
    NhanVienResponseDTO createNhanVien(NhanVienCreateRequestDTO requestDTO);
    NhanVienResponseDTO updateNhanVien(String maNV, NhanVienUpdateRequestDTO requestDTO);
    void deleteNhanVien(String maNV);
}
