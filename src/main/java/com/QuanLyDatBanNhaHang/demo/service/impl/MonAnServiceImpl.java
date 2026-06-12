package com.QuanLyDatBanNhaHang.demo.service.impl;

import com.QuanLyDatBanNhaHang.demo.dto.request.MonAnRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.response.MonAnResponseDTO;
import com.QuanLyDatBanNhaHang.demo.entity.MonAn;
import com.QuanLyDatBanNhaHang.demo.repository.MonAnRepository;
import com.QuanLyDatBanNhaHang.demo.service.MonAnService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MonAnServiceImpl implements MonAnService {

    private final MonAnRepository monAnRepository;

    @Override
    public List<MonAnResponseDTO> getAll() {
        return monAnRepository.findAllWithRelations().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<MonAnResponseDTO> getById(String maMon) {
        return monAnRepository.findByIdWithRelations(maMon)
                .map(this::convertToDTO);
    }

    @Override
    @Transactional
    public MonAnResponseDTO create(MonAnRequestDTO dto) {
        MonAn monAn = MonAn.builder()
                .maMon(dto.getMaMon())
                .tenMon(dto.getTenMon())
                .donGia(dto.getDonGia())
                .donViTinh(dto.getDonViTinh())
                .tenLoai(dto.getTenLoai())
                .trangThai(dto.getTrangThai())
                .urlHinhAnh(dto.getUrlHinhAnh())
                .build();
        MonAn saved = monAnRepository.save(monAn);
        return convertToDTO(saved);
    }

    @Override
    @Transactional
    public Optional<MonAnResponseDTO> update(String maMon, MonAnRequestDTO dto) {
        return monAnRepository.findById(maMon).map(monAn -> {
            monAn.setTenMon(dto.getTenMon());
            monAn.setDonGia(dto.getDonGia());
            monAn.setDonViTinh(dto.getDonViTinh());
            monAn.setTenLoai(dto.getTenLoai());
            monAn.setTrangThai(dto.getTrangThai());
            monAn.setUrlHinhAnh(dto.getUrlHinhAnh());
            MonAn updated = monAnRepository.save(monAn);
            return convertToDTO(updated);
        });
    }

    @Override
    @Transactional
    public void delete(String maMon) {
        monAnRepository.deleteById(maMon);
    }

    @Override
    public List<MonAnResponseDTO> getByTenLoai(String tenLoai) {
        return monAnRepository.findByTenLoai(tenLoai).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<MonAnResponseDTO> getByTrangThai(String trangThai) {
        return monAnRepository.findByTrangThai(trangThai).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private MonAnResponseDTO convertToDTO(MonAn monAn) {
        return MonAnResponseDTO.builder()
                .maMon(monAn.getMaMon())
                .tenMon(monAn.getTenMon())
                .donGia(monAn.getDonGia())
                .donViTinh(monAn.getDonViTinh())
                .tenLoai(monAn.getTenLoai())
                .trangThai(monAn.getTrangThai())
                .urlHinhAnh(monAn.getUrlHinhAnh())
                .build();
    }
}

