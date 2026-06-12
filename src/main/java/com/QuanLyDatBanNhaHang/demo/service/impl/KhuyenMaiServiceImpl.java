package com.QuanLyDatBanNhaHang.demo.service.impl;

import com.QuanLyDatBanNhaHang.demo.dto.request.KhuyenMaiRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.response.KhuyenMaiResponseDTO;
import com.QuanLyDatBanNhaHang.demo.entity.KhuyenMai;
import com.QuanLyDatBanNhaHang.demo.repository.KhuyenMaiRepository;
import com.QuanLyDatBanNhaHang.demo.service.KhuyenMaiService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class KhuyenMaiServiceImpl implements KhuyenMaiService {

    private final KhuyenMaiRepository khuyenMaiRepository;

    @Override
    public List<KhuyenMaiResponseDTO> getAll() {
        return khuyenMaiRepository.findAllWithRelations().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<KhuyenMaiResponseDTO> getById(String maKM) {
        return khuyenMaiRepository.findByIdWithRelations(maKM)
                .map(this::convertToDTO);
    }

    @Override
    @Transactional
    public KhuyenMaiResponseDTO create(KhuyenMaiRequestDTO dto) {
        KhuyenMai khuyenMai = KhuyenMai.builder()
                .maKM(dto.getMaKM())
                .tenKM(dto.getTenKM())
                .giaTriGiam(dto.getGiaTriGiam())
                .ngayBatDau(dto.getNgayBatDau())
                .ngayKetThuc(dto.getNgayKetThuc())
                .dieuKienToiThieu(dto.getDieuKienToiThieu())
                .trangThai(dto.getTrangThai())
                .build();
        KhuyenMai saved = khuyenMaiRepository.save(khuyenMai);
        return convertToDTO(saved);
    }

    @Override
    @Transactional
    public Optional<KhuyenMaiResponseDTO> update(String maKM, KhuyenMaiRequestDTO dto) {
        return khuyenMaiRepository.findById(maKM).map(khuyenMai -> {
            khuyenMai.setTenKM(dto.getTenKM());
            khuyenMai.setGiaTriGiam(dto.getGiaTriGiam());
            khuyenMai.setNgayBatDau(dto.getNgayBatDau());
            khuyenMai.setNgayKetThuc(dto.getNgayKetThuc());
            khuyenMai.setDieuKienToiThieu(dto.getDieuKienToiThieu());
            khuyenMai.setTrangThai(dto.getTrangThai());
            KhuyenMai updated = khuyenMaiRepository.save(khuyenMai);
            return convertToDTO(updated);
        });
    }

    @Override
    @Transactional
    public void delete(String maKM) {
        khuyenMaiRepository.deleteById(maKM);
    }

    @Override
    public List<KhuyenMaiResponseDTO> getByTrangThai(String trangThai) {
        return khuyenMaiRepository.findByTrangThai(trangThai).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private KhuyenMaiResponseDTO convertToDTO(KhuyenMai khuyenMai) {
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

