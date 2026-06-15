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
public class BanAnResponseDTO {
    private String maBan;
    private Integer soGhe;
    private String viTri;
    private TrangThaiBanAn trangThai;
    
    // Flatten fields
    private String maKhuVuc;
    private String tenKhuVuc;
}
