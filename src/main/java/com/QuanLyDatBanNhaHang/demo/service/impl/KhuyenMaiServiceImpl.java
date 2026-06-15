package com.QuanLyDatBanNhaHang.demo.service.impl;

import com.QuanLyDatBanNhaHang.demo.service.KhuyenMaiService;

import com.QuanLyDatBanNhaHang.demo.dto.request.KhuyenMaiCreateRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.request.KhuyenMaiUpdateRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.response.KhuyenMaiResponseDTO;
import com.QuanLyDatBanNhaHang.demo.entity.KhuyenMai;
import com.QuanLyDatBanNhaHang.demo.repository.KhuyenMaiRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import com.QuanLyDatBanNhaHang.demo.exception.ResourceNotFoundException;

@Service
@RequiredArgsConstructor
public class KhuyenMaiServiceImpl implements KhuyenMaiService {

    private final KhuyenMaiRepository khuyenMaiRepository;

    public List<KhuyenMaiResponseDTO> getAllKhuyenMai() {
        return khuyenMaiRepository.findAll().stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    public KhuyenMaiResponseDTO getKhuyenMaiById(String maKM) {
        KhuyenMai khuyenMai = khuyenMaiRepository.findByMaKMIgnoreCase(maKM)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy Khuyến Mãi với mã: " + maKM));
        return convertToResponseDTO(khuyenMai);
    }

    public KhuyenMaiResponseDTO createKhuyenMai(KhuyenMaiCreateRequestDTO requestDTO) {
        KhuyenMai khuyenMai = KhuyenMai.builder()
                .maKM(requestDTO.getMaKM())
                .tenKM(requestDTO.getTenKM())
                .giaTriGiam(requestDTO.getGiaTriGiam())
                .ngayBatDau(requestDTO.getNgayBatDau())
                .ngayKetThuc(requestDTO.getNgayKetThuc())
                .dieuKienToiThieu(requestDTO.getDieuKienToiThieu())
                .trangThai(requestDTO.getTrangThai())
                .build();

        KhuyenMai saved = khuyenMaiRepository.save(khuyenMai);
        return convertToResponseDTO(saved);
    }

    public KhuyenMaiResponseDTO updateKhuyenMai(String maKM, KhuyenMaiUpdateRequestDTO requestDTO) {
        KhuyenMai khuyenMai = khuyenMaiRepository.findByMaKMIgnoreCase(maKM)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy Khuyến Mãi với mã: " + maKM));

        khuyenMai.setTenKM(requestDTO.getTenKM());
        khuyenMai.setGiaTriGiam(requestDTO.getGiaTriGiam());
        khuyenMai.setNgayBatDau(requestDTO.getNgayBatDau());
        khuyenMai.setNgayKetThuc(requestDTO.getNgayKetThuc());
        khuyenMai.setDieuKienToiThieu(requestDTO.getDieuKienToiThieu());
        khuyenMai.setTrangThai(requestDTO.getTrangThai());

        KhuyenMai updated = khuyenMaiRepository.save(khuyenMai);
        return convertToResponseDTO(updated);
    }

    public void deleteKhuyenMai(String maKM) {
        khuyenMaiRepository.deleteById(maKM);
    }

    private KhuyenMaiResponseDTO convertToResponseDTO(KhuyenMai khuyenMai) {
        return KhuyenMaiResponseDTO.builder()
                .maKM(khuyenMai.getMaKM())
                .tenKM(khuyenMai.getTenKM())
                .giaTriGiam(khuyenMai.getGiaTriGiam())
                .ngayBatDau(khuyenMai.getNgayBatDau())
                .ngayKetThuc(khuyenMai.getNgayKetThuc())
                .dieuKienToiThieu(khuyenMai.getDieuKienToiThieu())
                .trangThai(khuyenMai.getTrangThai())
                .build();
    }
}
