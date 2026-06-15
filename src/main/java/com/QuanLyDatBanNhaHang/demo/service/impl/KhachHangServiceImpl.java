package com.QuanLyDatBanNhaHang.demo.service.impl;

import com.QuanLyDatBanNhaHang.demo.service.KhachHangService;

import com.QuanLyDatBanNhaHang.demo.dto.request.KhachHangCreateRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.request.KhachHangUpdateRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.response.KhachHangResponseDTO;
import com.QuanLyDatBanNhaHang.demo.entity.KhachHang;
import com.QuanLyDatBanNhaHang.demo.repository.KhachHangRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import com.QuanLyDatBanNhaHang.demo.exception.ResourceNotFoundException;

@Service
@RequiredArgsConstructor
public class KhachHangServiceImpl implements KhachHangService {

    private final KhachHangRepository khachHangRepository;

    public List<KhachHangResponseDTO> getAllKhachHang() {
        return khachHangRepository.findAll().stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    public KhachHangResponseDTO getKhachHangById(String maKH) {
        KhachHang khachHang = khachHangRepository.findByMaKHIgnoreCase(maKH)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy Khách Hàng với mã: " + maKH));
        return convertToResponseDTO(khachHang);
    }

    public KhachHangResponseDTO createKhachHang(KhachHangCreateRequestDTO requestDTO) {
        KhachHang khachHang = KhachHang.builder()
                .maKH(requestDTO.getMaKH())
                .hoTen(requestDTO.getHoTen())
                .sdt(requestDTO.getSdt())
                .diemTichLuy(requestDTO.getDiemTichLuy())
                .loaiThanhVien(requestDTO.getLoaiThanhVien())
                .build();

        KhachHang saved = khachHangRepository.save(khachHang);
        return convertToResponseDTO(saved);
    }

    public KhachHangResponseDTO updateKhachHang(String maKH, KhachHangUpdateRequestDTO requestDTO) {
        KhachHang khachHang = khachHangRepository.findByMaKHIgnoreCase(maKH)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy Khách Hàng với mã: " + maKH));

        khachHang.setHoTen(requestDTO.getHoTen());
        khachHang.setSdt(requestDTO.getSdt());
        khachHang.setDiemTichLuy(requestDTO.getDiemTichLuy());
        khachHang.setLoaiThanhVien(requestDTO.getLoaiThanhVien());

        KhachHang updated = khachHangRepository.save(khachHang);
        return convertToResponseDTO(updated);
    }

    public void deleteKhachHang(String maKH) {
        KhachHang khachHang = khachHangRepository.findByMaKHIgnoreCase(maKH).orElseThrow(() -> new ResourceNotFoundException("Khong tim thay"));
        khachHangRepository.delete(khachHang);
    }

    private KhachHangResponseDTO convertToResponseDTO(KhachHang khachHang) {
        return KhachHangResponseDTO.builder()
                .maKH(khachHang.getMaKH())
                .hoTen(khachHang.getHoTen())
                .sdt(khachHang.getSdt())
                .diemTichLuy(khachHang.getDiemTichLuy())
                .loaiThanhVien(khachHang.getLoaiThanhVien())
                .build();
    }
}
