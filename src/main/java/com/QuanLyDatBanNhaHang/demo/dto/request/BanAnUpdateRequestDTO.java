package com.QuanLyDatBanNhaHang.demo.dto.request;

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

    @NotBlank(message = "Trạng thái không được để trống")
    private String trangThai;

    @NotBlank(message = "Mã khu vực không được để trống")
    private String maKhuVuc;
}
