package com.QuanLyDatBanNhaHang.demo.service;

import com.QuanLyDatBanNhaHang.demo.dto.request.MonAnCreateRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.request.MonAnUpdateRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.response.MonAnResponseDTO;
import com.QuanLyDatBanNhaHang.demo.entity.MonAn;
import com.QuanLyDatBanNhaHang.demo.repository.MonAnRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MonAnService {

    private final MonAnRepository monAnRepository;

    public List<MonAnResponseDTO> getAllMonAn() {
        return monAnRepository.findAll().stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    public MonAnResponseDTO getMonAnById(String maMon) {
        MonAn monAn = monAnRepository.findById(maMon)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy Món Ăn với mã: " + maMon));
        return convertToResponseDTO(monAn);
    }

    public MonAnResponseDTO createMonAn(MonAnCreateRequestDTO requestDTO) {
        MonAn monAn = MonAn.builder()
                .maMon(requestDTO.getMaMon())
                .tenMon(requestDTO.getTenMon())
                .donGia(requestDTO.getDonGia())
                .donViTinh(requestDTO.getDonViTinh())
                .tenLoai(requestDTO.getTenLoai())
                .trangThai(requestDTO.getTrangThai())
                .urlHinhAnh(requestDTO.getUrlHinhAnh())
                .build();

        MonAn saved = monAnRepository.save(monAn);
        return convertToResponseDTO(saved);
    }

    public MonAnResponseDTO updateMonAn(String maMon, MonAnUpdateRequestDTO requestDTO) {
        MonAn monAn = monAnRepository.findById(maMon)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy Món Ăn với mã: " + maMon));

        monAn.setTenMon(requestDTO.getTenMon());
        monAn.setDonGia(requestDTO.getDonGia());
        monAn.setDonViTinh(requestDTO.getDonViTinh());
        monAn.setTenLoai(requestDTO.getTenLoai());
        monAn.setTrangThai(requestDTO.getTrangThai());
        monAn.setUrlHinhAnh(requestDTO.getUrlHinhAnh());

        MonAn updated = monAnRepository.save(monAn);
        return convertToResponseDTO(updated);
    }

    public void deleteMonAn(String maMon) {
        monAnRepository.deleteById(maMon);
    }

    private MonAnResponseDTO convertToResponseDTO(MonAn monAn) {
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
