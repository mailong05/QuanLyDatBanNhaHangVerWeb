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

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MonAnCreateRequestDTO {
    
    @NotBlank(message = "Mã món không được để trống")
    @Pattern(regexp = "^[a-zA-Z0-9_]+$", message = "Mã không hợp lệ")
    private String maMon;

    @NotBlank(message = "Tên món không được để trống")
    private String tenMon;

    @NotNull(message = "Đơn giá không được để trống")
    private Double donGia;

    private String donViTinh;

    @NotNull(message = "Tên loại không được để trống")
    private String tenLoai;

    @NotNull(message = "Trạng thái không được để trống")
    private TrangThaiMonAn trangThai;

    private String urlHinhAnh;
}
