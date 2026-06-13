package com.QuanLyDatBanNhaHang.demo.service;

import com.QuanLyDatBanNhaHang.demo.dto.request.ChiTietHoaDonCreateRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.request.ChiTietHoaDonUpdateRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.response.ChiTietHoaDonResponseDTO;
import com.QuanLyDatBanNhaHang.demo.entity.ChiTietHoaDon;
import com.QuanLyDatBanNhaHang.demo.repository.ChiTietHoaDonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ChiTietHoaDonService {

    private final ChiTietHoaDonRepository chiTietHoaDonRepository;

    public List<ChiTietHoaDonResponseDTO> getAllChiTietHoaDon() {
        List<ChiTietHoaDon> chiTiets = chiTietHoaDonRepository.findAllWithRelations();
        return chiTiets.stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    public ChiTietHoaDonResponseDTO getChiTietHoaDonById(Long id) {
        ChiTietHoaDon chiTiet = chiTietHoaDonRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy Chi Tiết Hóa Đơn với ID: " + id));
        return convertToResponseDTO(chiTiet);
    }

    public ChiTietHoaDonResponseDTO createChiTietHoaDon(ChiTietHoaDonCreateRequestDTO requestDTO) {
        ChiTietHoaDon chiTiet = ChiTietHoaDon.builder()
                .maHD(requestDTO.getMaHD())
                .maMon(requestDTO.getMaMon())
                .soLuong(requestDTO.getSoLuong())
                .donGiaLuuTru(requestDTO.getDonGiaLuuTru())
                .ghiChu(requestDTO.getGhiChu())
                .thanhTien(requestDTO.getThanhTien())
                .build();

        ChiTietHoaDon saved = chiTietHoaDonRepository.save(chiTiet);
        return convertToResponseDTO(saved);
    }

    public ChiTietHoaDonResponseDTO updateChiTietHoaDon(Long id, ChiTietHoaDonUpdateRequestDTO requestDTO) {
        ChiTietHoaDon chiTiet = chiTietHoaDonRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy Chi Tiết Hóa Đơn với ID: " + id));

        chiTiet.setMaHD(requestDTO.getMaHD());
        chiTiet.setMaMon(requestDTO.getMaMon());
        chiTiet.setSoLuong(requestDTO.getSoLuong());
        chiTiet.setDonGiaLuuTru(requestDTO.getDonGiaLuuTru());
        chiTiet.setGhiChu(requestDTO.getGhiChu());
        chiTiet.setThanhTien(requestDTO.getThanhTien());

        ChiTietHoaDon updated = chiTietHoaDonRepository.save(chiTiet);
        return convertToResponseDTO(updated);
    }

    public void deleteChiTietHoaDon(Long id) {
        chiTietHoaDonRepository.deleteById(id);
    }

    private ChiTietHoaDonResponseDTO convertToResponseDTO(ChiTietHoaDon chiTiet) {
        return ChiTietHoaDonResponseDTO.builder()
                .id(chiTiet.getId())
                .maHD(chiTiet.getMaHD())
                .maMon(chiTiet.getMaMon())
                .soLuong(chiTiet.getSoLuong())
                .donGiaLuuTru(chiTiet.getDonGiaLuuTru())
                .ghiChu(chiTiet.getGhiChu())
                .thanhTien(chiTiet.getThanhTien())
                .tenMon(chiTiet.getMonAn() != null ? chiTiet.getMonAn().getTenMon() : null)
                .build();
    }
}
