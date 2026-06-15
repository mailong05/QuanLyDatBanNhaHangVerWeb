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

    @NotNull(message = "Trạng thái không được để trống")
    private TrangThaiPhieuDatBan trangThai;

    private Double tienDatCoc;

    @Pattern(regexp = "^[a-zA-Z0-9_]+$", message = "Mã không hợp lệ")
    private String maKH;

    @NotBlank(message = "Mã nhân viên không được để trống")
    private String maNV;
}
