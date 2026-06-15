package com.QuanLyDatBanNhaHang.demo.service.impl;

import com.QuanLyDatBanNhaHang.demo.dto.request.KhuyenMaiCreateRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.request.KhuyenMaiUpdateRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.response.KhuyenMaiResponseDTO;
import com.QuanLyDatBanNhaHang.demo.entity.KhuyenMai;
import com.QuanLyDatBanNhaHang.demo.exception.DuplicateResourceException;
import com.QuanLyDatBanNhaHang.demo.exception.ResourceNotFoundException;
import com.QuanLyDatBanNhaHang.demo.repository.KhuyenMaiRepository;
import com.QuanLyDatBanNhaHang.demo.service.KhuyenMaiService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KhuyenMaiServiceImpl implements KhuyenMaiService {

    private final KhuyenMaiRepository khuyenMaiRepository;

    @Override
    public Page<KhuyenMaiResponseDTO> getAllKhuyenMai(Pageable pageable) {
        return khuyenMaiRepository.findAll(pageable).map(this::convertToResponseDTO);
    }

    @Override
    public KhuyenMaiResponseDTO getKhuyenMaiByMa(String maKM) {
        KhuyenMai km = khuyenMaiRepository.findByMaKMIgnoreCase(maKM)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy Khuyến mãi với mã: " + maKM));
        return convertToResponseDTO(km);
    }

    @Override
    public KhuyenMaiResponseDTO createKhuyenMai(KhuyenMaiCreateRequestDTO requestDTO) {
        if (khuyenMaiRepository.findByMaKMIgnoreCase(requestDTO.getMaKM()).isPresent()) {
            throw new DuplicateResourceException("Mã khuyến mãi đã tồn tại");
        }
        
        KhuyenMai km = KhuyenMai.builder()
                .maKM(requestDTO.getMaKM())
                .tenKM(requestDTO.getTenKM())
                .giaTriGiam(requestDTO.getGiaTriGiam())
                .ngayBatDau(requestDTO.getNgayBatDau())
                .ngayKetThuc(requestDTO.getNgayKetThuc())
                .dieuKienToiThieu(requestDTO.getDieuKienToiThieu())
                .trangThai(requestDTO.getTrangThai())
                .build();
                
        return convertToResponseDTO(khuyenMaiRepository.save(km));
    }

    @Override
    public KhuyenMaiResponseDTO updateKhuyenMai(String maKM, KhuyenMaiUpdateRequestDTO requestDTO) {
        KhuyenMai km = khuyenMaiRepository.findByMaKMIgnoreCase(maKM)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy Khuyến mãi với mã: " + maKM));
                
        km.setTenKM(requestDTO.getTenKM());
        km.setGiaTriGiam(requestDTO.getGiaTriGiam());
        km.setNgayBatDau(requestDTO.getNgayBatDau());
        km.setNgayKetThuc(requestDTO.getNgayKetThuc());
        km.setDieuKienToiThieu(requestDTO.getDieuKienToiThieu());
        km.setTrangThai(requestDTO.getTrangThai());

        return convertToResponseDTO(khuyenMaiRepository.save(km));
    }

    @Override
    public void deleteKhuyenMai(String maKM) {
        KhuyenMai km = khuyenMaiRepository.findByMaKMIgnoreCase(maKM)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy Khuyến mãi với mã: " + maKM));
        khuyenMaiRepository.delete(km);
    }

    private KhuyenMaiResponseDTO convertToResponseDTO(KhuyenMai km) {
        return KhuyenMaiResponseDTO.builder()
                .id(km.getId())
                .maKM(km.getMaKM())
                .tenKM(km.getTenKM())
                .giaTriGiam(km.getGiaTriGiam())
                .ngayBatDau(km.getNgayBatDau())
                .ngayKetThuc(km.getNgayKetThuc())
                .dieuKienToiThieu(km.getDieuKienToiThieu())
                .trangThai(km.getTrangThai())
                .build();
    }
}
