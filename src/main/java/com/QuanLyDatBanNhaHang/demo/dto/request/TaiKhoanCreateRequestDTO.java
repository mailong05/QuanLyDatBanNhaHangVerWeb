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
public class TaiKhoanCreateRequestDTO {
    
    @NotBlank(message = "Username không được để trống")
    @Pattern(regexp = "^[a-zA-Z0-9_]+$", message = "Mã không hợp lệ")
    private String username;

    @NotNull(message = "Password không được để trống")
    private String password;

    @NotNull(message = "Quyền hạn không được để trống")
    private QuyenHanTaiKhoan quyenHan;

    @NotBlank(message = "Mã nhân viên không được để trống")
    @Pattern(regexp = "^[a-zA-Z0-9_]+$", message = "Mã không hợp lệ")
    private String maNV;
}
