package com.QuanLyDatBanNhaHang.demo.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TaiKhoanRequestDTO {
    private String username;
    private String password;
    private String quyenHan;
    private String maNV;
}
