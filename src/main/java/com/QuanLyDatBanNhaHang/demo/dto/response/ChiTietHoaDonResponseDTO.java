package com.QuanLyDatBanNhaHang.demo.dto.response;

import com.QuanLyDatBanNhaHang.demo.enums.*;

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
public class ChiTietHoaDonResponseDTO {
    private Long id;
    private String maHD;
    private String maMon;
    private Integer soLuong;
    private Double donGiaLuuTru;
    private String ghiChu;
    private Double thanhTien;
    
    // Flatten fields
    private String tenMon;
}
