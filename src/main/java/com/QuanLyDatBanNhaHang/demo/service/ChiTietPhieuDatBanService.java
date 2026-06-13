package com.QuanLyDatBanNhaHang.demo.service;

import com.QuanLyDatBanNhaHang.demo.dto.request.ChiTietPhieuDatBanCreateRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.request.ChiTietPhieuDatBanUpdateRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.response.ChiTietPhieuDatBanResponseDTO;
import com.QuanLyDatBanNhaHang.demo.entity.ChiTietPhieuDatBan;
import com.QuanLyDatBanNhaHang.demo.repository.ChiTietPhieuDatBanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ChiTietPhieuDatBanService {

    private final ChiTietPhieuDatBanRepository chiTietPhieuDatBanRepository;

    public List<ChiTietPhieuDatBanResponseDTO> getAllChiTietPhieuDatBan() {
        List<ChiTietPhieuDatBan> chiTiets = chiTietPhieuDatBanRepository.findAllWithRelations();
        return chiTiets.stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    public ChiTietPhieuDatBanResponseDTO getChiTietPhieuDatBanById(Long id) {
        ChiTietPhieuDatBan chiTiet = chiTietPhieuDatBanRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy Chi Tiết Phiếu Đặt Bàn với ID: " + id));
        return convertToResponseDTO(chiTiet);
    }

    public ChiTietPhieuDatBanResponseDTO createChiTietPhieuDatBan(ChiTietPhieuDatBanCreateRequestDTO requestDTO) {
        ChiTietPhieuDatBan chiTiet = ChiTietPhieuDatBan.builder()
                .maPhieuDat(requestDTO.getMaPhieuDat())
                .maBan(requestDTO.getMaBan())
                .ghiChu(requestDTO.getGhiChu())
                .build();

        ChiTietPhieuDatBan saved = chiTietPhieuDatBanRepository.save(chiTiet);
        return convertToResponseDTO(saved);
    }

    public ChiTietPhieuDatBanResponseDTO updateChiTietPhieuDatBan(Long id, ChiTietPhieuDatBanUpdateRequestDTO requestDTO) {
        ChiTietPhieuDatBan chiTiet = chiTietPhieuDatBanRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy Chi Tiết Phiếu Đặt Bàn với ID: " + id));

        chiTiet.setMaPhieuDat(requestDTO.getMaPhieuDat());
        chiTiet.setMaBan(requestDTO.getMaBan());
        chiTiet.setGhiChu(requestDTO.getGhiChu());

        ChiTietPhieuDatBan updated = chiTietPhieuDatBanRepository.save(chiTiet);
        return convertToResponseDTO(updated);
    }

    public void deleteChiTietPhieuDatBan(Long id) {
        chiTietPhieuDatBanRepository.deleteById(id);
    }

    private ChiTietPhieuDatBanResponseDTO convertToResponseDTO(ChiTietPhieuDatBan chiTiet) {
        return ChiTietPhieuDatBanResponseDTO.builder()
                .id(chiTiet.getId())
                .maPhieuDat(chiTiet.getMaPhieuDat())
                .maBan(chiTiet.getMaBan())
                .ghiChu(chiTiet.getGhiChu())
                // Assuming BanAn entity has no specific field needed here or you can add if needed.
                .build();
    }
}
