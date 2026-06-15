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
public class NhanVienResponseDTO {
    private String maNV;
    private String hoTen;
    private String sdt;
    private ChucVuNhanVien chucVu;
    private LocalDate ngayVaoLam;
    private Double luongCoBan;
    private TrangThaiNhanVien trangThai;
    // Không trả về đối tượng TaiKhoan hay thông tin mật khẩu vì lý do bảo mật
}
