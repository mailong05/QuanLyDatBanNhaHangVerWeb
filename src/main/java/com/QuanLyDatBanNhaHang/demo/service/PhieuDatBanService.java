package com.QuanLyDatBanNhaHang.demo.service;

import com.QuanLyDatBanNhaHang.demo.dto.response.PhieuDatBanDTO;
import com.QuanLyDatBanNhaHang.demo.entity.PhieuDatBan;
import com.QuanLyDatBanNhaHang.demo.repository.PhieuDatBanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service cho PhieuDatBan.
 *
 * Trách nhiệm:
 * 1. Gọi Repository để lấy dữ liệu (với JOIN FETCH để tránh N+1)
 * 2. Chuyển đổi Entity sang DTO (bốc thông tin cần thiết)
 * 3. Trả DTO cho Controller
 *
 * Lợi ích:
 * - Tách biệt Entity (internal model) khỏi API response
 * - Không expose toàn bộ dữ liệu nhạy cảm
 * - Tránh StackOverflow do recursion (Entity có quan hệ 2 chiều)
 * - Tránh N+1 query bằng JOIN FETCH
 */
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PhieuDatBanService {

    private final PhieuDatBanRepository phieuDatBanRepository;

    /**
     * Lấy tất cả phiếu đặt bàn kèm thông tin khách hàng/nhân viên.
     *
     * Luồng:
     * 1. Repository query (1 lần duy nhất với JOIN FETCH)
     * 2. Map Entity -> DTO
     * 3. Trả list DTO cho controller
     *
     * @return List DTO phiếu đặt bàn
     */
    public List<PhieuDatBanDTO> getAllPhieuDatBan() {
        // Query tối ưu: 1 lần duy nhất, JOIN FETCH khachHang + nhanVien
        List<PhieuDatBan> phieus = phieuDatBanRepository.findAllWithRelations();

        // Chuyển Entity -> DTO (an toàn, không trả toàn bộ entity)
        return phieus.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    /**
     * Lấy phiếu đặt bàn theo ID.
     *
     * @param maPhieuDat ID phiếu
     * @return DTO phiếu (nếu tồn tại)
     */
    public Optional<PhieuDatBanDTO> getPhieuDatBanById(String maPhieuDat) {
        // Query tối ưu: JOIN FETCH liên quan
        return phieuDatBanRepository.findByIdWithRelations(maPhieuDat)
                .map(this::convertToDTO);
    }

    /**
     * Lấy danh sách phiếu của một khách hàng cụ thể.
     *
     * @param maKH ID khách hàng
     * @return List DTO phiếu của khách
     */
    public List<PhieuDatBanDTO> getPhieuByKhachHang(String maKH) {
        List<PhieuDatBan> phieus = phieuDatBanRepository.findByKhachHangWithRelations(maKH);
        return phieus.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    /**
     * Lấy danh sách phiếu đang chờ (chưa hoàn thành).
     * Trường hợp: cần lấy danh sách phiếu để chuẩn bị lập hóa đơn.
     *
     * @return List DTO phiếu chờ/đang sử dụng
     */
    public List<PhieuDatBanDTO> getPendingPhieuDatBan() {
        List<PhieuDatBan> phieus = phieuDatBanRepository.findAllPendingWithRelations();
        return phieus.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    /**
     * Chuyển đổi Entity PhieuDatBan sang DTO.
     *
     * Đây là "nồi lẩu" (Entity) được bốc sang "khay thức ăn" (DTO).
     * Chỉ lấy thông tin cần thiết, không trả toàn bộ entity.
     *
     * @param phieu Entity PhieuDatBan
     * @return DTO phiếu đặt bàn
     */
    private PhieuDatBanDTO convertToDTO(PhieuDatBan phieu) {
        return PhieuDatBanDTO.builder()
                .maPhieuDat(phieu.getMaPhieuDat())
                .ngayLapPhieu(phieu.getNgayLapPhieu())
                .thoiGianDen(phieu.getThoiGianDen())
                .soLuongNguoi(phieu.getSoLuongNguoi())
                .ghiChu(phieu.getGhiChu())
                .trangThai(phieu.getTrangThai())
                .tienDatCoc(phieu.getTienDatCoc())
                // Bốc thông tin khách hàng từ quan hệ
                .maKH(phieu.getKhachHang() != null ? phieu.getKhachHang().getMaKH() : null)
                .tenKH(phieu.getKhachHang() != null ? phieu.getKhachHang().getHoTen() : null)
                .sdtKH(phieu.getKhachHang() != null ? phieu.getKhachHang().getSdt() : null)
                // Bốc thông tin nhân viên từ quan hệ
                .maNV(phieu.getNhanVien() != null ? phieu.getNhanVien().getMaNV() : null)
                .hoTenNV(phieu.getNhanVien() != null ? phieu.getNhanVien().getHoTen() : null)
                .build();
    }
}

