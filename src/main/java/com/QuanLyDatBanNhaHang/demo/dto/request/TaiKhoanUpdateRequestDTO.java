package com.QuanLyDatBanNhaHang.demo.dto.request;

import jakarta.validation.constraints.NotBlank;
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
public class TaiKhoanUpdateRequestDTO {
    
    // For update, password might be optional. If not blank, update it.
    private String password;

    @NotBlank(message = "Quyền hạn không được để trống")
    private String quyenHan;

    @NotBlank(message = "Mã nhân viên không được để trống")
    private String maNV;
}
