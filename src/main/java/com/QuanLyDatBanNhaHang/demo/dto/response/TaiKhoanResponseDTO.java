package com.QuanLyDatBanNhaHang.demo.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TaiKhoanResponseDTO {
    private String username;
    private String quyenHan;
    private String maNV;
    private String tenNV; // Thêm tên nhân viên nếu cần
}
