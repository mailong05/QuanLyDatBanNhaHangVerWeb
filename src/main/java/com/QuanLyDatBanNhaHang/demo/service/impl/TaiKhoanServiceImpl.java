package com.QuanLyDatBanNhaHang.demo.service.impl;

import com.QuanLyDatBanNhaHang.demo.dto.request.TaiKhoanRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.response.TaiKhoanResponseDTO;
import com.QuanLyDatBanNhaHang.demo.entity.NhanVien;
import com.QuanLyDatBanNhaHang.demo.entity.TaiKhoan;
import com.QuanLyDatBanNhaHang.demo.repository.NhanVienRepository;
import com.QuanLyDatBanNhaHang.demo.repository.TaiKhoanRepository;
import com.QuanLyDatBanNhaHang.demo.service.TaiKhoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaiKhoanServiceImpl implements TaiKhoanService {

    private final TaiKhoanRepository taiKhoanRepository;
    private final NhanVienRepository nhanVienRepository;

    @Override
    public List<TaiKhoanResponseDTO> getAll() {
        return taiKhoanRepository.findAll().stream()
                .map(this::mapToResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<TaiKhoanResponseDTO> getById(String username) {
        return taiKhoanRepository.findById(username).map(this::mapToResponseDTO);
    }

    @Override
    @Transactional
    public TaiKhoanResponseDTO create(TaiKhoanRequestDTO requestDTO) {
        TaiKhoan entity = mapToEntity(requestDTO);
        TaiKhoan saved = taiKhoanRepository.save(entity);
        return mapToResponseDTO(saved);
    }

    @Override
    @Transactional
    public Optional<TaiKhoanResponseDTO> update(String username, TaiKhoanRequestDTO requestDTO) {
        return taiKhoanRepository.findById(username).map(existing -> {
            existing.setPassword(requestDTO.getPassword());
            existing.setQuyenHan(requestDTO.getQuyenHan());
            
            if (requestDTO.getMaNV() != null) {
                NhanVien nv = nhanVienRepository.findById(requestDTO.getMaNV())
                    .orElseThrow(() -> new RuntimeException("NhanVien not found"));
                existing.setNhanVien(nv);
            }
            
            TaiKhoan updated = taiKhoanRepository.save(existing);
            return mapToResponseDTO(updated);
        });
    }

    @Override
    @Transactional
    public void delete(String username) {
        if (taiKhoanRepository.existsById(username)) {
            taiKhoanRepository.deleteById(username);
        }
    }

    private TaiKhoanResponseDTO mapToResponseDTO(TaiKhoan entity) {
        return TaiKhoanResponseDTO.builder()
                .username(entity.getUsername())
                .quyenHan(entity.getQuyenHan())
                .maNV(entity.getNhanVien() != null ? entity.getNhanVien().getMaNV() : null)
                .tenNV(entity.getNhanVien() != null ? entity.getNhanVien().getHoTen() : null)
                .build();
    }

    private TaiKhoan mapToEntity(TaiKhoanRequestDTO dto) {
        TaiKhoan entity = TaiKhoan.builder()
                .username(dto.getUsername())
                .password(dto.getPassword())
                .quyenHan(dto.getQuyenHan())
                .build();

        if (dto.getMaNV() != null) {
            NhanVien nv = nhanVienRepository.findById(dto.getMaNV())
                .orElseThrow(() -> new RuntimeException("NhanVien not found"));
            entity.setNhanVien(nv);
        }

        return entity;
    }
}
