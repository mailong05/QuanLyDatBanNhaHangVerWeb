package com.QuanLyDatBanNhaHang.demo.service.impl;

import com.QuanLyDatBanNhaHang.demo.service.NhanVienService;

import com.QuanLyDatBanNhaHang.demo.dto.request.NhanVienCreateRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.request.NhanVienUpdateRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.response.NhanVienResponseDTO;
import com.QuanLyDatBanNhaHang.demo.entity.NhanVien;
import com.QuanLyDatBanNhaHang.demo.exception.ResourceNotFoundException;
import com.QuanLyDatBanNhaHang.demo.repository.NhanVienRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NhanVienServiceImpl implements NhanVienService {

    private final NhanVienRepository nhanVienRepository;

    public List<NhanVienResponseDTO> getAllNhanVien() {
        return nhanVienRepository.findAll().stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    public NhanVienResponseDTO getNhanVienById(String maNV) {
        NhanVien nhanVien = nhanVienRepository.findByMaNVIgnoreCase(maNV)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy Nhân Viên với mã: " + maNV));
        return convertToResponseDTO(nhanVien);
    }

    public NhanVienResponseDTO createNhanVien(NhanVienCreateRequestDTO requestDTO) {
        NhanVien nhanVien = NhanVien.builder()
                .maNV(requestDTO.getMaNV())
                .hoTen(requestDTO.getHoTen())
                .sdt(requestDTO.getSdt())
                .chucVu(requestDTO.getChucVu())
                .ngayVaoLam(requestDTO.getNgayVaoLam())
                .luongCoBan(requestDTO.getLuongCoBan())
                .trangThai(requestDTO.getTrangThai())
                .build();

        NhanVien saved = nhanVienRepository.save(nhanVien);
        return convertToResponseDTO(saved);
    }

    public NhanVienResponseDTO updateNhanVien(String maNV, NhanVienUpdateRequestDTO requestDTO) {
        NhanVien nhanVien = nhanVienRepository.findByMaNVIgnoreCase(maNV)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy Nhân Viên với mã: " + maNV));

        nhanVien.setHoTen(requestDTO.getHoTen());
        nhanVien.setSdt(requestDTO.getSdt());
        nhanVien.setChucVu(requestDTO.getChucVu());
        nhanVien.setNgayVaoLam(requestDTO.getNgayVaoLam());
        nhanVien.setLuongCoBan(requestDTO.getLuongCoBan());
        nhanVien.setTrangThai(requestDTO.getTrangThai());

        NhanVien updated = nhanVienRepository.save(nhanVien);
        return convertToResponseDTO(updated);
    }

    public void deleteNhanVien(String maNV) {
        NhanVien nhanVien = nhanVienRepository.findByMaNVIgnoreCase(maNV).orElseThrow(() -> new ResourceNotFoundException("Khong tim thay"));
        nhanVienRepository.delete(nhanVien);
    }

    private NhanVienResponseDTO convertToResponseDTO(NhanVien nhanVien) {
        return NhanVienResponseDTO.builder()
                .maNV(nhanVien.getMaNV())
                .hoTen(nhanVien.getHoTen())
                .sdt(nhanVien.getSdt())
                .chucVu(nhanVien.getChucVu())
                .ngayVaoLam(nhanVien.getNgayVaoLam())
                .luongCoBan(nhanVien.getLuongCoBan())
                .trangThai(nhanVien.getTrangThai())
                .build();
    }
}
