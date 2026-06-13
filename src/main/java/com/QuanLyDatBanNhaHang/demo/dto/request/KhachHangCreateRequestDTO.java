package com.QuanLyDatBanNhaHang.demo.dto.request;

import jakarta.validation.constraints.NotBlank;
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
public class KhachHangCreateRequestDTO {
    
    @NotBlank(message = "Mã khách hàng không được để trống")
    private String maKH;

    @NotBlank(message = "Họ tên không được để trống")
    private String hoTen;

    @NotBlank(message = "Số điện thoại không được để trống")
    private String sdt;

    private Integer diemTichLuy;

    @NotBlank(message = "Loại thành viên không được để trống")
    private String loaiThanhVien;
}
