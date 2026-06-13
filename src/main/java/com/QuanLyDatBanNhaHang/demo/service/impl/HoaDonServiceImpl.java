package com.QuanLyDatBanNhaHang.demo.service.impl;

import com.QuanLyDatBanNhaHang.demo.dto.request.HoaDonRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.response.HoaDonResponseDTO;
import com.QuanLyDatBanNhaHang.demo.entity.*;
import com.QuanLyDatBanNhaHang.demo.repository.*;
import com.QuanLyDatBanNhaHang.demo.service.HoaDonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HoaDonServiceImpl implements HoaDonService {

    private final HoaDonRepository hoaDonRepository;
    private final PhieuDatBanRepository phieuDatBanRepository;
    private final NhanVienRepository nhanVienRepository;
    private final KhuyenMaiRepository khuyenMaiRepository;
    private final ThueRepository thueRepository;

    @Override
    public List<HoaDonResponseDTO> getAll() {
        return hoaDonRepository.findAll().stream()
                .map(this::mapToResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<HoaDonResponseDTO> getById(String maHD) {
        return hoaDonRepository.findById(maHD).map(this::mapToResponseDTO);
    }

    @Override
    @Transactional
    public HoaDonResponseDTO create(HoaDonRequestDTO dto) {
        HoaDon entity = mapToEntity(dto);
        HoaDon saved = hoaDonRepository.save(entity);
        return mapToResponseDTO(saved);
    }

    @Override
    @Transactional
    public Optional<HoaDonResponseDTO> update(String maHD, HoaDonRequestDTO dto) {
        return hoaDonRepository.findById(maHD).map(existing -> {
            existing.setThueSuat(dto.getThueSuat());
            existing.setTienThue(dto.getTienThue());
            existing.setTyLePhiDV(dto.getTyLePhiDV());
            existing.setTienPhiDV(dto.getTienPhiDV());
            existing.setNgayTao(dto.getNgayTao());
            existing.setGioVao(dto.getGioVao());
            existing.setGioRa(dto.getGioRa());
            existing.setTongTienGoc(dto.getTongTienGoc());
            existing.setTienGiamGia(dto.getTienGiamGia());
            existing.setTongThanhToan(dto.getTongThanhToan());
            existing.setPhuongThucTT(dto.getPhuongThucTT());
            existing.setTrangThaiThanhToan(dto.getTrangThaiThanhToan());

            if (dto.getMaPhieuDat() != null) {
                PhieuDatBan phieu = phieuDatBanRepository.findById(dto.getMaPhieuDat()).orElseThrow();
                existing.setPhieuDatBan(phieu);
            }
            if (dto.getMaNV() != null) {
                NhanVien nv = nhanVienRepository.findById(dto.getMaNV()).orElseThrow();
                existing.setNhanVien(nv);
            }
            if (dto.getMaKM() != null) {
                KhuyenMai km = khuyenMaiRepository.findById(dto.getMaKM()).orElse(null);
                existing.setKhuyenMai(km);
            }
            if (dto.getMaThue() != null) {
                Thue thue = thueRepository.findById(dto.getMaThue()).orElseThrow();
                existing.setThue(thue);
            }

            HoaDon updated = hoaDonRepository.save(existing);
            return mapToResponseDTO(updated);
        });
    }

    @Override
    @Transactional
    public void delete(String maHD) {
        if (hoaDonRepository.existsById(maHD)) {
            hoaDonRepository.deleteById(maHD);
        }
    }

    private HoaDonResponseDTO mapToResponseDTO(HoaDon entity) {
        return HoaDonResponseDTO.builder()
                .maHD(entity.getMaHD())
                .thueSuat(entity.getThueSuat())
                .tienThue(entity.getTienThue())
                .tyLePhiDV(entity.getTyLePhiDV())
                .tienPhiDV(entity.getTienPhiDV())
                .ngayTao(entity.getNgayTao())
                .gioVao(entity.getGioVao())
                .gioRa(entity.getGioRa())
                .tongTienGoc(entity.getTongTienGoc())
                .tienGiamGia(entity.getTienGiamGia())
                .tongThanhToan(entity.getTongThanhToan())
                .phuongThucTT(entity.getPhuongThucTT())
                .trangThaiThanhToan(entity.getTrangThaiThanhToan())
                .maPhieuDat(entity.getPhieuDatBan() != null ? entity.getPhieuDatBan().getMaPhieuDat() : null)
                .maNV(entity.getNhanVien() != null ? entity.getNhanVien().getMaNV() : null)
                .maKM(entity.getKhuyenMai() != null ? entity.getKhuyenMai().getMaKM() : null)
                .maThue(entity.getThue() != null ? entity.getThue().getMaThue() : null)
                .build();
    }

    private HoaDon mapToEntity(HoaDonRequestDTO dto) {
        HoaDon entity = HoaDon.builder()
                .maHD(dto.getMaHD())
                .thueSuat(dto.getThueSuat())
                .tienThue(dto.getTienThue())
                .tyLePhiDV(dto.getTyLePhiDV())
                .tienPhiDV(dto.getTienPhiDV())
                .ngayTao(dto.getNgayTao())
                .gioVao(dto.getGioVao())
                .gioRa(dto.getGioRa())
                .tongTienGoc(dto.getTongTienGoc())
                .tienGiamGia(dto.getTienGiamGia())
                .tongThanhToan(dto.getTongThanhToan())
                .phuongThucTT(dto.getPhuongThucTT())
                .trangThaiThanhToan(dto.getTrangThaiThanhToan())
                .build();

        if (dto.getMaPhieuDat() != null) {
            PhieuDatBan phieu = phieuDatBanRepository.findById(dto.getMaPhieuDat()).orElseThrow();
            entity.setPhieuDatBan(phieu);
        }
        if (dto.getMaNV() != null) {
            NhanVien nv = nhanVienRepository.findById(dto.getMaNV()).orElseThrow();
            entity.setNhanVien(nv);
        }
        if (dto.getMaKM() != null) {
            KhuyenMai km = khuyenMaiRepository.findById(dto.getMaKM()).orElse(null);
            entity.setKhuyenMai(km);
        }
        if (dto.getMaThue() != null) {
            Thue thue = thueRepository.findById(dto.getMaThue()).orElseThrow();
            entity.setThue(thue);
        }
        return entity;
    }
}
