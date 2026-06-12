package com.QuanLyDatBanNhaHang.demo.service.impl;

import com.QuanLyDatBanNhaHang.demo.dto.response.PhieuDatBanDTO;
import com.QuanLyDatBanNhaHang.demo.entity.PhieuDatBan;
import com.QuanLyDatBanNhaHang.demo.repository.PhieuDatBanRepository;
import com.QuanLyDatBanNhaHang.demo.service.PhieuDatBanServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Implementation của PhieuDatBanService.
 *
 * Trách nhiệm:
 * 1. Gọi Repository để lấy dữ liệu (với JOIN FETCH để tránh N+1)
 * 2. Chuyển đổi Entity sang DTO (bốc thông tin cần thiết)
 * 3. Trả DTO cho Controller
 */
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PhieuDatBanServiceImpl implements PhieuDatBanServiceInterface {

    private final PhieuDatBanRepository phieuDatBanRepository;

    @Override
    public List<PhieuDatBanDTO> getAllPhieuDatBan() {
        List<PhieuDatBan> phieus = phieuDatBanRepository.findAllWithRelations();
        return phieus.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<PhieuDatBanDTO> getPhieuDatBanById(String maPhieuDat) {
        return phieuDatBanRepository.findByIdWithRelations(maPhieuDat)
                .map(this::convertToDTO);
    }

    @Override
    public List<PhieuDatBanDTO> getPhieuByKhachHang(String maKH) {
        List<PhieuDatBan> phieus = phieuDatBanRepository.findByKhachHangWithRelations(maKH);
        return phieus.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<PhieuDatBanDTO> getPendingPhieuDatBan() {
        List<PhieuDatBan> phieus = phieuDatBanRepository.findAllPendingWithRelations();
        return phieus.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private PhieuDatBanDTO convertToDTO(PhieuDatBan phieu) {
        return PhieuDatBanDTO.builder()
                .maPhieuDat(phieu.getMaPhieuDat())
                .ngayLapPhieu(phieu.getNgayLapPhieu())
                .thoiGianDen(phieu.getThoiGianDen())
                .soLuongNguoi(phieu.getSoLuongNguoi())
                .ghiChu(phieu.getGhiChu())
                .trangThai(phieu.getTrangThai())
                .tienDatCoc(phieu.getTienDatCoc())
                .maKH(phieu.getKhachHang() != null ? phieu.getKhachHang().getMaKH() : null)
                .tenKH(phieu.getKhachHang() != null ? phieu.getKhachHang().getHoTen() : null)
                .sdtKH(phieu.getKhachHang() != null ? phieu.getKhachHang().getSdt() : null)
                .maNV(phieu.getNhanVien() != null ? phieu.getNhanVien().getMaNV() : null)
                .hoTenNV(phieu.getNhanVien() != null ? phieu.getNhanVien().getHoTen() : null)
                .build();
    }
}

