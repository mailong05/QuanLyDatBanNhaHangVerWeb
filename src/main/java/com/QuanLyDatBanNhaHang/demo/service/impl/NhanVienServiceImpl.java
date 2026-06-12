package com.QuanLyDatBanNhaHang.demo.service.impl;

import com.QuanLyDatBanNhaHang.demo.dto.request.NhanVienRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.response.NhanVienResponseDTO;
import com.QuanLyDatBanNhaHang.demo.entity.NhanVien;
import com.QuanLyDatBanNhaHang.demo.repository.NhanVienRepository;
import com.QuanLyDatBanNhaHang.demo.service.NhanVienService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class NhanVienServiceImpl implements NhanVienService {

    private final NhanVienRepository nhanVienRepository;

    @Override
    public List<NhanVienResponseDTO> getAll() {
        return nhanVienRepository.findAllWithRelations().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<NhanVienResponseDTO> getById(String maNV) {
        return nhanVienRepository.findByIdWithRelations(maNV)
                .map(this::convertToDTO);
    }

    @Override
    @Transactional
    public NhanVienResponseDTO create(NhanVienRequestDTO dto) {
        NhanVien nhanVien = NhanVien.builder()
                .maNV(dto.getMaNV())
                .hoTen(dto.getHoTen())
                .sdt(dto.getSdt())
                .chucVu(dto.getChucVu())
                .ngayVaoLam(dto.getNgayVaoLam())
                .luongCoBan(dto.getLuongCoBan())
                .trangThai(dto.getTrangThai())
                .build();
        NhanVien saved = nhanVienRepository.save(nhanVien);
        return convertToDTO(saved);
    }

    @Override
    @Transactional
    public Optional<NhanVienResponseDTO> update(String maNV, NhanVienRequestDTO dto) {
        return nhanVienRepository.findById(maNV).map(nhanVien -> {
            nhanVien.setHoTen(dto.getHoTen());
            nhanVien.setSdt(dto.getSdt());
            nhanVien.setChucVu(dto.getChucVu());
            nhanVien.setNgayVaoLam(dto.getNgayVaoLam());
            nhanVien.setLuongCoBan(dto.getLuongCoBan());
            nhanVien.setTrangThai(dto.getTrangThai());
            NhanVien updated = nhanVienRepository.save(nhanVien);
            return convertToDTO(updated);
        });
    }

    @Override
    @Transactional
    public void delete(String maNV) {
        nhanVienRepository.deleteById(maNV);
    }

    @Override
    public List<NhanVienResponseDTO> getByChucVu(String chucVu) {
        return nhanVienRepository.findByChucVu(chucVu).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<NhanVienResponseDTO> getByTrangThai(String trangThai) {
        return nhanVienRepository.findByTrangThai(trangThai).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private NhanVienResponseDTO convertToDTO(NhanVien nhanVien) {
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

