package com.QuanLyDatBanNhaHang.demo.dto.request;

import jakarta.validation.constraints.NotBlank;
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
public class HoaDonCreateRequestDTO {
    
    @NotBlank(message = "Mã hóa đơn không được để trống")
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

    @NotBlank(message = "Trạng thái thanh toán không được để trống")
    private String trangThaiThanhToan;

    @NotBlank(message = "Mã phiếu đặt không được để trống")
    private String maPhieuDat;

    @NotBlank(message = "Mã nhân viên không được để trống")
    private String maNV;

    private String maKM;

    @NotBlank(message = "Mã thuế không được để trống")
    private String maThue;
}
