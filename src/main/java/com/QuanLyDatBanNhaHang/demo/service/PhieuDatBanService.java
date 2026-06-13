package com.QuanLyDatBanNhaHang.demo.service;

import com.QuanLyDatBanNhaHang.demo.dto.request.PhieuDatBanCreateRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.request.PhieuDatBanUpdateRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.response.PhieuDatBanResponseDTO;
import com.QuanLyDatBanNhaHang.demo.entity.KhachHang;
import com.QuanLyDatBanNhaHang.demo.entity.NhanVien;
import com.QuanLyDatBanNhaHang.demo.entity.PhieuDatBan;
import com.QuanLyDatBanNhaHang.demo.repository.KhachHangRepository;
import com.QuanLyDatBanNhaHang.demo.repository.NhanVienRepository;
import com.QuanLyDatBanNhaHang.demo.repository.PhieuDatBanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PhieuDatBanService {

    private final PhieuDatBanRepository phieuDatBanRepository;
    private final KhachHangRepository khachHangRepository;
    private final NhanVienRepository nhanVienRepository;

    public List<PhieuDatBanResponseDTO> getAllPhieuDatBan() {
        return phieuDatBanRepository.findAllWithRelations().stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    public PhieuDatBanResponseDTO getPhieuDatBanById(String maPhieuDat) {
        PhieuDatBan phieuDatBan = phieuDatBanRepository.findById(maPhieuDat)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy Phiếu Đặt Bàn với mã: " + maPhieuDat));
        return convertToResponseDTO(phieuDatBan);
    }

    public PhieuDatBanResponseDTO createPhieuDatBan(PhieuDatBanCreateRequestDTO requestDTO) {
        NhanVien nhanVien = nhanVienRepository.findById(requestDTO.getMaNV())
                .orElseThrow(() -> new RuntimeException("Nhân viên không tồn tại"));

        KhachHang khachHang = null;
        if (requestDTO.getMaKH() != null && !requestDTO.getMaKH().isEmpty()) {
            khachHang = khachHangRepository.findById(requestDTO.getMaKH())
                    .orElseThrow(() -> new RuntimeException("Khách hàng không tồn tại"));
        }

        PhieuDatBan phieuDatBan = PhieuDatBan.builder()
                .maPhieuDat(requestDTO.getMaPhieuDat())
                .ngayLapPhieu(requestDTO.getNgayLapPhieu())
                .thoiGianDen(requestDTO.getThoiGianDen())
                .soLuongNguoi(requestDTO.getSoLuongNguoi())
                .ghiChu(requestDTO.getGhiChu())
                .trangThai(requestDTO.getTrangThai())
                .tienDatCoc(requestDTO.getTienDatCoc())
                .khachHang(khachHang)
                .nhanVien(nhanVien)
                .build();

        PhieuDatBan saved = phieuDatBanRepository.save(phieuDatBan);
        return convertToResponseDTO(saved);
    }

    public PhieuDatBanResponseDTO updatePhieuDatBan(String maPhieuDat, PhieuDatBanUpdateRequestDTO requestDTO) {
        PhieuDatBan phieuDatBan = phieuDatBanRepository.findById(maPhieuDat)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy Phiếu Đặt Bàn với mã: " + maPhieuDat));

        NhanVien nhanVien = nhanVienRepository.findById(requestDTO.getMaNV())
                .orElseThrow(() -> new RuntimeException("Nhân viên không tồn tại"));

        KhachHang khachHang = null;
        if (requestDTO.getMaKH() != null && !requestDTO.getMaKH().isEmpty()) {
            khachHang = khachHangRepository.findById(requestDTO.getMaKH())
                    .orElseThrow(() -> new RuntimeException("Khách hàng không tồn tại"));
        }

        phieuDatBan.setNgayLapPhieu(requestDTO.getNgayLapPhieu());
        phieuDatBan.setThoiGianDen(requestDTO.getThoiGianDen());
        phieuDatBan.setSoLuongNguoi(requestDTO.getSoLuongNguoi());
        phieuDatBan.setGhiChu(requestDTO.getGhiChu());
        phieuDatBan.setTrangThai(requestDTO.getTrangThai());
        phieuDatBan.setTienDatCoc(requestDTO.getTienDatCoc());
        phieuDatBan.setKhachHang(khachHang);
        phieuDatBan.setNhanVien(nhanVien);

        PhieuDatBan updated = phieuDatBanRepository.save(phieuDatBan);
        return convertToResponseDTO(updated);
    }

    public void deletePhieuDatBan(String maPhieuDat) {
        phieuDatBanRepository.deleteById(maPhieuDat);
    }

    private PhieuDatBanResponseDTO convertToResponseDTO(PhieuDatBan phieuDatBan) {
        return PhieuDatBanResponseDTO.builder()
                .maPhieuDat(phieuDatBan.getMaPhieuDat())
                .ngayLapPhieu(phieuDatBan.getNgayLapPhieu())
                .thoiGianDen(phieuDatBan.getThoiGianDen())
                .soLuongNguoi(phieuDatBan.getSoLuongNguoi())
                .ghiChu(phieuDatBan.getGhiChu())
                .trangThai(phieuDatBan.getTrangThai())
                .tienDatCoc(phieuDatBan.getTienDatCoc())
                .maKH(phieuDatBan.getKhachHang() != null ? phieuDatBan.getKhachHang().getMaKH() : null)
                .hoTenKH(phieuDatBan.getKhachHang() != null ? phieuDatBan.getKhachHang().getHoTen() : null)
                .maNV(phieuDatBan.getNhanVien() != null ? phieuDatBan.getNhanVien().getMaNV() : null)
                .hoTenNV(phieuDatBan.getNhanVien() != null ? phieuDatBan.getNhanVien().getHoTen() : null)
                .build();
    }
}
