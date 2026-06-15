package com.QuanLyDatBanNhaHang.demo.dto.request;

import com.QuanLyDatBanNhaHang.demo.enums.*;
import jakarta.validation.constraints.Pattern;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
public class BanAnUpdateRequestDTO {
    
    @NotNull(message = "Số ghế không được để trống")
    private Integer soGhe;

    private String viTri;

    @NotNull(message = "Trạng thái không được để trống")
    private TrangThaiBanAn trangThai;

    @NotBlank(message = "Mã khu vực không được để trống")
    @Pattern(regexp = "^[a-zA-Z0-9_]+$", message = "Mã không hợp lệ")
    private String maKhuVuc;
}
