package com.QuanLyDatBanNhaHang.demo.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChiTietPhieuDatBanRequestDTO {
    private String maPhieuDat;
    private String maBan;
    private String ghiChu;
}
