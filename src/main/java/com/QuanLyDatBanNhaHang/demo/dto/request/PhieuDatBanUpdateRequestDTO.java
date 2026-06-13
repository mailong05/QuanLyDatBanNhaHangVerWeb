package com.QuanLyDatBanNhaHang.demo.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
public class PhieuDatBanUpdateRequestDTO {
    
    private LocalDateTime ngayLapPhieu;

    @NotNull(message = "Thời gian đến không được để trống")
    private LocalDateTime thoiGianDen;

    private Integer soLuongNguoi;

    private String ghiChu;

    @NotBlank(message = "Trạng thái không được để trống")
    private String trangThai;

    private Double tienDatCoc;

    private String maKH;

    @NotBlank(message = "Mã nhân viên không được để trống")
    private String maNV;
}
