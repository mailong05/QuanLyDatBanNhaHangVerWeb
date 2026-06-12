package com.QuanLyDatBanNhaHang.demo.service.impl;

import com.QuanLyDatBanNhaHang.demo.dto.request.KhachHangRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.response.KhachHangResponseDTO;
import com.QuanLyDatBanNhaHang.demo.entity.KhachHang;
import com.QuanLyDatBanNhaHang.demo.repository.KhachHangRepository;
import com.QuanLyDatBanNhaHang.demo.service.KhachHangService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class KhachHangServiceImpl implements KhachHangService {

    private final KhachHangRepository khachHangRepository;

    @Override
    public List<KhachHangResponseDTO> getAll() {
        return khachHangRepository.findAllWithRelations().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<KhachHangResponseDTO> getById(String maKH) {
        return khachHangRepository.findByIdWithRelations(maKH)
                .map(this::convertToDTO);
    }

    @Override
    @Transactional
    public KhachHangResponseDTO create(KhachHangRequestDTO dto) {
        KhachHang khachHang = KhachHang.builder()
                .maKH(dto.getMaKH())
                .hoTen(dto.getHoTen())
                .sdt(dto.getSdt())
                .diemTichLuy(dto.getDiemTichLuy() != null ? dto.getDiemTichLuy() : 0)
                .loaiThanhVien(dto.getLoaiThanhVien())
                .build();
        KhachHang saved = khachHangRepository.save(khachHang);
        return convertToDTO(saved);
    }

    @Override
    @Transactional
    public Optional<KhachHangResponseDTO> update(String maKH, KhachHangRequestDTO dto) {
        return khachHangRepository.findById(maKH).map(khachHang -> {
            khachHang.setHoTen(dto.getHoTen());
            khachHang.setSdt(dto.getSdt());
            if (dto.getDiemTichLuy() != null) {
                khachHang.setDiemTichLuy(dto.getDiemTichLuy());
            }
            khachHang.setLoaiThanhVien(dto.getLoaiThanhVien());
            KhachHang updated = khachHangRepository.save(khachHang);
            return convertToDTO(updated);
        });
    }

    @Override
    @Transactional
    public void delete(String maKH) {
        khachHangRepository.deleteById(maKH);
    }

    @Override
    public List<KhachHangResponseDTO> getByLoaiThanhVien(String loaiThanhVien) {
        return khachHangRepository.findByLoaiThanhVien(loaiThanhVien).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private KhachHangResponseDTO convertToDTO(KhachHang khachHang) {
        return KhachHangResponseDTO.builder()
                .maKH(khachHang.getMaKH())
                .hoTen(khachHang.getHoTen())
                .sdt(khachHang.getSdt())
                .diemTichLuy(khachHang.getDiemTichLuy())
                .loaiThanhVien(khachHang.getLoaiThanhVien())
                .build();
    }
}

