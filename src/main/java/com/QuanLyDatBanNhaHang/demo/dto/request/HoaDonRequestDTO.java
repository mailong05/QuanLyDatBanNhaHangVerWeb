package com.QuanLyDatBanNhaHang.demo.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HoaDonRequestDTO {
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
    
    private String maPhieuDat;
    private String maNV;
    private String maKM;
    private String maThue;
}
