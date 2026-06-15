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
public class CaLamViecUpdateRequestDTO {
    
    @NotNull(message = "Thời gian vào ca không được để trống")
    private LocalDateTime thoiGianVaoCa;

    private LocalDateTime thoiGianKetCa;

    @NotNull(message = "Tiền đầu ca không được để trống")
    private Double tienDauCa;

    private Double tienKetCa;

    @NotNull(message = "Trạng thái không được để trống")
    private TrangThaiCaLamViec trangThai;

    private String ghiChu;

    @NotBlank(message = "Mã nhân viên không được để trống")
    @Pattern(regexp = "^[a-zA-Z0-9_]+$", message = "Mã không hợp lệ")
    private String maNV;
}
