package com.QuanLyDatBanNhaHang.demo.dto.response;

import com.QuanLyDatBanNhaHang.demo.enums.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CaLamViecResponseDTO {
    private String maCa;
    private LocalDateTime thoiGianVaoCa;
    private LocalDateTime thoiGianKetCa;
    private Double tienDauCa;
    private Double tienKetCa;
    private TrangThaiCaLamViec trangThai;
    private String ghiChu;
    
    // Flatten fields
    private String maNV;
    private String hoTenNV;
}
