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

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NhanVienCreateRequestDTO {
    
    @NotBlank(message = "Mã nhân viên không được để trống")
    @Pattern(regexp = "^[a-zA-Z0-9_]+$", message = "Mã không hợp lệ")
    private String maNV;

    @NotBlank(message = "Họ tên không được để trống")
    private String hoTen;

    private String sdt;

    @NotNull(message = "Chức vụ không được để trống")
    private ChucVuNhanVien chucVu;

    @NotNull(message = "Ngày vào làm không được để trống")
    private LocalDate ngayVaoLam;

    @NotNull(message = "Lương cơ bản không được để trống")
    private Double luongCoBan;

    @NotNull(message = "Trạng thái không được để trống")
    private TrangThaiNhanVien trangThai;
}
