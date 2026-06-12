package com.QuanLyDatBanNhaHang.demo.service.impl;

import com.QuanLyDatBanNhaHang.demo.dto.request.CaLamViecRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.response.CaLamViecResponseDTO;
import com.QuanLyDatBanNhaHang.demo.entity.CaLamViec;
import com.QuanLyDatBanNhaHang.demo.repository.CaLamViecRepository;
import com.QuanLyDatBanNhaHang.demo.repository.NhanVienRepository;
import com.QuanLyDatBanNhaHang.demo.service.CaLamViecService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CaLamViecServiceImpl implements CaLamViecService {

    private final CaLamViecRepository caLamViecRepository;
    private final NhanVienRepository nhanVienRepository;

    @Override
    public List<CaLamViecResponseDTO> getAll() {
        return caLamViecRepository.findAllWithRelations().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<CaLamViecResponseDTO> getById(String maCa) {
        return caLamViecRepository.findByIdWithRelations(maCa)
                .map(this::convertToDTO);
    }

    @Override
    @Transactional
    public CaLamViecResponseDTO create(CaLamViecRequestDTO dto) {
        return nhanVienRepository.findById(dto.getMaNV()).map(nhanVien -> {
            CaLamViec caLamViec = CaLamViec.builder()
                    .maCa(dto.getMaCa())
                    .nhanVien(nhanVien)
                    .thoiGianVaoCa(dto.getThoiGianVaoCa())
                    .thoiGianKetCa(dto.getThoiGianKetCa())
                    .tienDauCa(dto.getTienDauCa())
                    .tienKetCa(dto.getTienKetCa())
                    .trangThai(dto.getTrangThai())
                    .ghiChu(dto.getGhiChu())
                    .build();
            CaLamViec saved = caLamViecRepository.save(caLamViec);
            return convertToDTO(saved);
        }).orElseThrow(() -> new RuntimeException("NhanVien not found: " + dto.getMaNV()));
    }

    @Override
    @Transactional
    public Optional<CaLamViecResponseDTO> update(String maCa, CaLamViecRequestDTO dto) {
        return caLamViecRepository.findById(maCa).map(caLamViec -> {
            caLamViec.setThoiGianVaoCa(dto.getThoiGianVaoCa());
            caLamViec.setThoiGianKetCa(dto.getThoiGianKetCa());
            caLamViec.setTienDauCa(dto.getTienDauCa());
            caLamViec.setTienKetCa(dto.getTienKetCa());
            caLamViec.setTrangThai(dto.getTrangThai());
            caLamViec.setGhiChu(dto.getGhiChu());
            CaLamViec updated = caLamViecRepository.save(caLamViec);
            return convertToDTO(updated);
        });
    }

    @Override
    @Transactional
    public void delete(String maCa) {
        caLamViecRepository.deleteById(maCa);
    }

    @Override
    public List<CaLamViecResponseDTO> getByNhanVien(String maNV) {
        return caLamViecRepository.findByNhanVien(maNV).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<CaLamViecResponseDTO> getByTrangThai(String trangThai) {
        return caLamViecRepository.findByTrangThai(trangThai).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private CaLamViecResponseDTO convertToDTO(CaLamViec caLamViec) {
        return CaLamViecResponseDTO.builder()
                .maCa(caLamViec.getMaCa())
                .maNV(caLamViec.getNhanVien().getMaNV())
                .hoTenNV(caLamViec.getNhanVien().getHoTen())
                .thoiGianVaoCa(caLamViec.getThoiGianVaoCa())
                .thoiGianKetCa(caLamViec.getThoiGianKetCa())
                .tienDauCa(caLamViec.getTienDauCa())
                .tienKetCa(caLamViec.getTienKetCa())
                .trangThai(caLamViec.getTrangThai())
                .ghiChu(caLamViec.getGhiChu())
                .build();
    }
}

