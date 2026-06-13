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
public class ChiTietPhieuDatBanResponseDTO {
    private Long id;
    private String maPhieuDat;
    private String maBan;
    private String ghiChu;
}
