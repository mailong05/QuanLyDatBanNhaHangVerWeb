package com.QuanLyDatBanNhaHang.demo.service;

import com.QuanLyDatBanNhaHang.demo.dto.request.PhieuDatBanCreateRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.request.PhieuDatBanUpdateRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.response.PhieuDatBanResponseDTO;
import java.util.List;
import java.util.stream.Collectors;

public interface PhieuDatBanService {
    List<PhieuDatBanResponseDTO> getAllPhieuDatBan();
    PhieuDatBanResponseDTO getPhieuDatBanById(String maPhieuDat);
    PhieuDatBanResponseDTO createPhieuDatBan(PhieuDatBanCreateRequestDTO requestDTO);
    PhieuDatBanResponseDTO updatePhieuDatBan(String maPhieuDat, PhieuDatBanUpdateRequestDTO requestDTO);
    void deletePhieuDatBan(String maPhieuDat);
}
