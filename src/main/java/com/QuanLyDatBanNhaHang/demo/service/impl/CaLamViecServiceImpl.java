package com.QuanLyDatBanNhaHang.demo.service.impl;

import com.QuanLyDatBanNhaHang.demo.service.CaLamViecService;

import com.QuanLyDatBanNhaHang.demo.dto.request.CaLamViecCreateRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.request.CaLamViecUpdateRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.response.CaLamViecResponseDTO;
import com.QuanLyDatBanNhaHang.demo.entity.CaLamViec;
import com.QuanLyDatBanNhaHang.demo.entity.NhanVien;
import com.QuanLyDatBanNhaHang.demo.repository.CaLamViecRepository;
import com.QuanLyDatBanNhaHang.demo.repository.NhanVienRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import com.QuanLyDatBanNhaHang.demo.exception.ResourceNotFoundException;

@Service
@RequiredArgsConstructor
public class CaLamViecServiceImpl implements CaLamViecService {

    private final CaLamViecRepository caLamViecRepository;
    private final NhanVienRepository nhanVienRepository;

    public List<CaLamViecResponseDTO> getAllCaLamViec() {
        return caLamViecRepository.findAllWithRelations().stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    public CaLamViecResponseDTO getCaLamViecById(String maCa) {
        CaLamViec caLamViec = caLamViecRepository.findByMaCaIgnoreCase(maCa)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy Ca Làm Việc với mã: " + maCa));
        return convertToResponseDTO(caLamViec);
    }

    public CaLamViecResponseDTO createCaLamViec(CaLamViecCreateRequestDTO requestDTO) {
        NhanVien nhanVien = nhanVienRepository.findById(requestDTO.getMaNV())
                .orElseThrow(() -> new ResourceNotFoundException("Nhân viên không tồn tại"));

        CaLamViec caLamViec = CaLamViec.builder()
                .maCa(requestDTO.getMaCa())
                .thoiGianVaoCa(requestDTO.getThoiGianVaoCa())
                .thoiGianKetCa(requestDTO.getThoiGianKetCa())
                .tienDauCa(requestDTO.getTienDauCa())
                .tienKetCa(requestDTO.getTienKetCa())
                .trangThai(requestDTO.getTrangThai())
                .ghiChu(requestDTO.getGhiChu())
                .nhanVien(nhanVien)
                .build();

        CaLamViec saved = caLamViecRepository.save(caLamViec);
        return convertToResponseDTO(saved);
    }

    public CaLamViecResponseDTO updateCaLamViec(String maCa, CaLamViecUpdateRequestDTO requestDTO) {
        CaLamViec caLamViec = caLamViecRepository.findByMaCaIgnoreCase(maCa)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy Ca Làm Việc với mã: " + maCa));

        NhanVien nhanVien = nhanVienRepository.findById(requestDTO.getMaNV())
                .orElseThrow(() -> new ResourceNotFoundException("Nhân viên không tồn tại"));

        caLamViec.setThoiGianVaoCa(requestDTO.getThoiGianVaoCa());
        caLamViec.setThoiGianKetCa(requestDTO.getThoiGianKetCa());
        caLamViec.setTienDauCa(requestDTO.getTienDauCa());
        caLamViec.setTienKetCa(requestDTO.getTienKetCa());
        caLamViec.setTrangThai(requestDTO.getTrangThai());
        caLamViec.setGhiChu(requestDTO.getGhiChu());
        caLamViec.setNhanVien(nhanVien);

        CaLamViec updated = caLamViecRepository.save(caLamViec);
        return convertToResponseDTO(updated);
    }

    public void deleteCaLamViec(String maCa) {
        caLamViecRepository.deleteById(maCa);
    }

    private CaLamViecResponseDTO convertToResponseDTO(CaLamViec caLamViec) {
        return CaLamViecResponseDTO.builder()
                .maCa(caLamViec.getMaCa())
                .thoiGianVaoCa(caLamViec.getThoiGianVaoCa())
                .thoiGianKetCa(caLamViec.getThoiGianKetCa())
                .tienDauCa(caLamViec.getTienDauCa())
                .tienKetCa(caLamViec.getTienKetCa())
                .trangThai(caLamViec.getTrangThai())
                .ghiChu(caLamViec.getGhiChu())
                .maNV(caLamViec.getNhanVien() != null ? caLamViec.getNhanVien().getMaNV() : null)
                .hoTenNV(caLamViec.getNhanVien() != null ? caLamViec.getNhanVien().getHoTen() : null)
                .build();
    }
}
