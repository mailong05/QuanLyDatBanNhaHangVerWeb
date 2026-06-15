package com.QuanLyDatBanNhaHang.demo.dto.request;

import com.QuanLyDatBanNhaHang.demo.enums.*;
import jakarta.validation.constraints.Pattern;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
public class HoaDonUpdateRequestDTO {
    
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
    private PhuongThucThanhToanHoaDon phuongThucTT;

    @NotNull(message = "Trạng thái thanh toán không được để trống")
    private TrangThaiThanhToanHoaDon trangThaiThanhToan;

    @NotBlank(message = "Mã phiếu đặt không được để trống")
    @Pattern(regexp = "^[a-zA-Z0-9_]+$", message = "Mã không hợp lệ")
    private String maPhieuDat;

    @NotBlank(message = "Mã nhân viên không được để trống")
    private String maNV;

    @Pattern(regexp = "^[a-zA-Z0-9_]+$", message = "Mã không hợp lệ")
    private String maKM;

    @NotBlank(message = "Mã thuế không được để trống")
    private String maThue;
}
