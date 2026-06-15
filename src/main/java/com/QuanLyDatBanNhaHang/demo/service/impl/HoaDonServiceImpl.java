package com.QuanLyDatBanNhaHang.demo.service.impl;

import com.QuanLyDatBanNhaHang.demo.service.HoaDonService;

import com.QuanLyDatBanNhaHang.demo.dto.request.HoaDonCreateRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.request.HoaDonUpdateRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.response.HoaDonResponseDTO;
import com.QuanLyDatBanNhaHang.demo.entity.HoaDon;
import com.QuanLyDatBanNhaHang.demo.entity.KhuyenMai;
import com.QuanLyDatBanNhaHang.demo.entity.NhanVien;
import com.QuanLyDatBanNhaHang.demo.entity.PhieuDatBan;
import com.QuanLyDatBanNhaHang.demo.entity.Thue;
import com.QuanLyDatBanNhaHang.demo.repository.HoaDonRepository;
import com.QuanLyDatBanNhaHang.demo.repository.KhuyenMaiRepository;
import com.QuanLyDatBanNhaHang.demo.repository.NhanVienRepository;
import com.QuanLyDatBanNhaHang.demo.repository.PhieuDatBanRepository;
import com.QuanLyDatBanNhaHang.demo.repository.ThueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import com.QuanLyDatBanNhaHang.demo.exception.ResourceNotFoundException;

@Service
@RequiredArgsConstructor
public class HoaDonServiceImpl implements HoaDonService {

    private final HoaDonRepository hoaDonRepository;
    private final PhieuDatBanRepository phieuDatBanRepository;
    private final NhanVienRepository nhanVienRepository;
    private final KhuyenMaiRepository khuyenMaiRepository;
    private final ThueRepository thueRepository;

    public List<HoaDonResponseDTO> getAllHoaDon() {
        List<HoaDon> hoaDons = hoaDonRepository.findAllWithRelations();
        return hoaDons.stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    public HoaDonResponseDTO getHoaDonById(String id) {
        HoaDon hoaDon = hoaDonRepository.findByMaHDIgnoreCase(id)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy Hóa Đơn với ID: " + id));
        return convertToResponseDTO(hoaDon);
    }

    public HoaDonResponseDTO createHoaDon(HoaDonCreateRequestDTO requestDTO) {
        PhieuDatBan phieuDatBan = phieuDatBanRepository.findById(requestDTO.getMaPhieuDat())
                .orElseThrow(() -> new ResourceNotFoundException("Phiếu đặt bàn không tồn tại"));
        NhanVien nhanVien = nhanVienRepository.findById(requestDTO.getMaNV())
                .orElseThrow(() -> new ResourceNotFoundException("Nhân viên không tồn tại"));
        Thue thue = thueRepository.findById(requestDTO.getMaThue())
                .orElseThrow(() -> new ResourceNotFoundException("Thuế không tồn tại"));
        
        KhuyenMai khuyenMai = null;
        if (requestDTO.getMaKM() != null && !requestDTO.getMaKM().isEmpty()) {
            khuyenMai = khuyenMaiRepository.findById(requestDTO.getMaKM())
                    .orElseThrow(() -> new ResourceNotFoundException("Khuyến mãi không tồn tại"));
        }

        HoaDon hoaDon = HoaDon.builder()
                .maHD(requestDTO.getMaHD())
                .thueSuat(requestDTO.getThueSuat())
                .tienThue(requestDTO.getTienThue())
                .tyLePhiDV(requestDTO.getTyLePhiDV())
                .tienPhiDV(requestDTO.getTienPhiDV())
                .ngayTao(requestDTO.getNgayTao())
                .gioVao(requestDTO.getGioVao())
                .gioRa(requestDTO.getGioRa())
                .tongTienGoc(requestDTO.getTongTienGoc())
                .tienGiamGia(requestDTO.getTienGiamGia())
                .tongThanhToan(requestDTO.getTongThanhToan())
                .phuongThucTT(requestDTO.getPhuongThucTT())
                .trangThaiThanhToan(requestDTO.getTrangThaiThanhToan())
                .phieuDatBan(phieuDatBan)
                .nhanVien(nhanVien)
                .khuyenMai(khuyenMai)
                .thue(thue)
                .build();

        HoaDon saved = hoaDonRepository.save(hoaDon);
        return convertToResponseDTO(saved);
    }

    public HoaDonResponseDTO updateHoaDon(String id, HoaDonUpdateRequestDTO requestDTO) {
        HoaDon hoaDon = hoaDonRepository.findByMaHDIgnoreCase(id)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy Hóa Đơn với ID: " + id));

        PhieuDatBan phieuDatBan = phieuDatBanRepository.findById(requestDTO.getMaPhieuDat())
                .orElseThrow(() -> new ResourceNotFoundException("Phiếu đặt bàn không tồn tại"));
        NhanVien nhanVien = nhanVienRepository.findById(requestDTO.getMaNV())
                .orElseThrow(() -> new ResourceNotFoundException("Nhân viên không tồn tại"));
        Thue thue = thueRepository.findById(requestDTO.getMaThue())
                .orElseThrow(() -> new ResourceNotFoundException("Thuế không tồn tại"));
        
        KhuyenMai khuyenMai = null;
        if (requestDTO.getMaKM() != null && !requestDTO.getMaKM().isEmpty()) {
            khuyenMai = khuyenMaiRepository.findById(requestDTO.getMaKM())
                    .orElseThrow(() -> new ResourceNotFoundException("Khuyến mãi không tồn tại"));
        }

        hoaDon.setThueSuat(requestDTO.getThueSuat());
        hoaDon.setTienThue(requestDTO.getTienThue());
        hoaDon.setTyLePhiDV(requestDTO.getTyLePhiDV());
        hoaDon.setTienPhiDV(requestDTO.getTienPhiDV());
        hoaDon.setNgayTao(requestDTO.getNgayTao());
        hoaDon.setGioVao(requestDTO.getGioVao());
        hoaDon.setGioRa(requestDTO.getGioRa());
        hoaDon.setTongTienGoc(requestDTO.getTongTienGoc());
        hoaDon.setTienGiamGia(requestDTO.getTienGiamGia());
        hoaDon.setTongThanhToan(requestDTO.getTongThanhToan());
        hoaDon.setPhuongThucTT(requestDTO.getPhuongThucTT());
        hoaDon.setTrangThaiThanhToan(requestDTO.getTrangThaiThanhToan());
        hoaDon.setPhieuDatBan(phieuDatBan);
        hoaDon.setNhanVien(nhanVien);
        hoaDon.setKhuyenMai(khuyenMai);
        hoaDon.setThue(thue);

        HoaDon updated = hoaDonRepository.save(hoaDon);
        return convertToResponseDTO(updated);
    }

    public void deleteHoaDon(String id) {
        hoaDonRepository.deleteById(id);
    }

    private HoaDonResponseDTO convertToResponseDTO(HoaDon hoaDon) {
        return HoaDonResponseDTO.builder()
                .maHD(hoaDon.getMaHD())
                .thueSuat(hoaDon.getThueSuat())
                .tienThue(hoaDon.getTienThue())
                .tyLePhiDV(hoaDon.getTyLePhiDV())
                .tienPhiDV(hoaDon.getTienPhiDV())
                .ngayTao(hoaDon.getNgayTao())
                .gioVao(hoaDon.getGioVao())
                .gioRa(hoaDon.getGioRa())
                .tongTienGoc(hoaDon.getTongTienGoc())
                .tienGiamGia(hoaDon.getTienGiamGia())
                .tongThanhToan(hoaDon.getTongThanhToan())
                .phuongThucTT(hoaDon.getPhuongThucTT())
                .trangThaiThanhToan(hoaDon.getTrangThaiThanhToan())
                .maPhieuDat(hoaDon.getPhieuDatBan() != null ? hoaDon.getPhieuDatBan().getMaPhieuDat() : null)
                .hoTenNV(hoaDon.getNhanVien() != null ? hoaDon.getNhanVien().getHoTen() : null)
                .maKM(hoaDon.getKhuyenMai() != null ? hoaDon.getKhuyenMai().getMaKM() : null)
                .maThue(hoaDon.getThue() != null ? hoaDon.getThue().getMaThue() : null)
                .build();
    }
}
