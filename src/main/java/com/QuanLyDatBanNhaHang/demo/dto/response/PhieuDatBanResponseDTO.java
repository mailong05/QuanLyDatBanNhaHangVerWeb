package com.QuanLyDatBanNhaHang.demo.dto.response;

import com.QuanLyDatBanNhaHang.demo.enums.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PhieuDatBanResponseDTO {
    private String maPhieuDat;
    private LocalDateTime ngayLapPhieu;
    private LocalDateTime thoiGianDen;
    private Integer soLuongNguoi;
    private String ghiChu;
    private TrangThaiPhieuDatBan trangThai;
    private Double tienDatCoc;

    // Flatten fields cho KhachHang
    private String maKH;
    private String hoTenKH;

    // Flatten fields cho NhanVien
    private String maNV;
    private String hoTenNV;
}
