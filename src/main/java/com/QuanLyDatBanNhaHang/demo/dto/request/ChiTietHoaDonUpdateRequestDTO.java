package com.QuanLyDatBanNhaHang.demo.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChiTietHoaDonUpdateRequestDTO {
    
    @NotBlank(message = "Mã hóa đơn không được để trống")
    private String maHD;

    @NotBlank(message = "Mã món không được để trống")
    private String maMon;

    @NotNull(message = "Số lượng không được để trống")
    private Integer soLuong;

    @NotNull(message = "Đơn giá lưu trữ không được để trống")
    private Double donGiaLuuTru;

    private String ghiChu;

    @NotNull(message = "Thành tiền không được để trống")
    private Double thanhTien;
}
