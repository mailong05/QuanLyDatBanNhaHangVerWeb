package com.QuanLyDatBanNhaHang.demo.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HoaDonResponseDTO {
    private String maHD;
    private Double thueSuat;
    private Double tienThue;
    private Double tyLePhiDV;
    private Double tienPhiDV;
    private LocalDateTime ngayTao;
    private LocalTime gioVao;
    private LocalTime gioRa;
    private Double tongTienGoc;
    private Double tienGiamGia;
    private Double tongThanhToan;
    private String phuongThucTT;
    private String trangThaiThanhToan;
    
    // Flatten fields
    private String maPhieuDat;
    private String hoTenNV;
    private String maKM;
    private String maThue;
}
