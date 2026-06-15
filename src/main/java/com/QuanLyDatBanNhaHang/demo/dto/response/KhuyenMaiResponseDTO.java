package com.QuanLyDatBanNhaHang.demo.dto.response;

import com.QuanLyDatBanNhaHang.demo.enums.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KhuyenMaiResponseDTO {
    private String maKM;
    private String tenKM;
    private Double giaTriGiam;
    private LocalDate ngayBatDau;
    private LocalDate ngayKetThuc;
    private Double dieuKienToiThieu;
    private TrangThaiKhuyenMai trangThai;
}
