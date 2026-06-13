package com.QuanLyDatBanNhaHang.demo.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChiTietHoaDonRequestDTO {
    private String maHD;
    private String maMon;
    private Integer soLuong;
    private Double donGiaLuuTru;
    private String ghiChu;
    private Double thanhTien;
}
