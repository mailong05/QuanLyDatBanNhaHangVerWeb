package com.QuanLyDatBanNhaHang.demo.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Response DTO cho KhachHang.
 * Flat structure: chỉ lấy các field cơ bản, không chứa object phức tạp.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KhachHangResponseDTO {
    private String maKH;
    private String hoTen;
    private String sdt;
    private Integer diemTichLuy;
    private String loaiThanhVien;
}

