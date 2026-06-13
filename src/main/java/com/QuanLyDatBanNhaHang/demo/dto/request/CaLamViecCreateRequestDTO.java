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
public class CaLamViecCreateRequestDTO {
    
    @NotBlank(message = "Mã ca không được để trống")
    private String maCa;

    @NotNull(message = "Thời gian vào ca không được để trống")
    private LocalDateTime thoiGianVaoCa;

    private LocalDateTime thoiGianKetCa;

    @NotNull(message = "Tiền đầu ca không được để trống")
    private Double tienDauCa;

    private Double tienKetCa;

    @NotBlank(message = "Trạng thái không được để trống")
    private String trangThai;

    private String ghiChu;

    @NotBlank(message = "Mã nhân viên không được để trống")
    private String maNV;
}
