package com.QuanLyDatBanNhaHang.demo.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
public class NhanVienUpdateRequestDTO {
    
    @NotBlank(message = "Họ tên không được để trống")
    private String hoTen;

    private String sdt;

    @NotBlank(message = "Chức vụ không được để trống")
    private String chucVu;

    @NotNull(message = "Ngày vào làm không được để trống")
    private LocalDate ngayVaoLam;

    @NotNull(message = "Lương cơ bản không được để trống")
    private Double luongCoBan;

    @NotBlank(message = "Trạng thái không được để trống")
    private String trangThai;
}
