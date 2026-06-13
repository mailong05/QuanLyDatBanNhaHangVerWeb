package com.QuanLyDatBanNhaHang.demo.service;

import com.QuanLyDatBanNhaHang.demo.dto.request.ChiTietPhieuDatBanRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.response.ChiTietPhieuDatBanResponseDTO;
import com.QuanLyDatBanNhaHang.demo.entity.ChiTietPhieuDatBanId;

import java.util.List;
import java.util.Optional;

public interface ChiTietPhieuDatBanService {
    List<ChiTietPhieuDatBanResponseDTO> getAll();
    List<ChiTietPhieuDatBanResponseDTO> getByMaPhieuDat(String maPhieuDat);
    Optional<ChiTietPhieuDatBanResponseDTO> getById(ChiTietPhieuDatBanId id);
    ChiTietPhieuDatBanResponseDTO create(ChiTietPhieuDatBanRequestDTO requestDTO);
    Optional<ChiTietPhieuDatBanResponseDTO> update(ChiTietPhieuDatBanId id, ChiTietPhieuDatBanRequestDTO requestDTO);
    void delete(ChiTietPhieuDatBanId id);
}
