package com.QuanLyDatBanNhaHang.demo.dto.response;

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
public class TaiKhoanResponseDTO {
    private String username;
    private String quyenHan;
    
    // Flatten fields
    private String maNV;
    private String tenNV;
}
