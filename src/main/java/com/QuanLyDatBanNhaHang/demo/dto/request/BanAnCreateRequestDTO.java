package com.QuanLyDatBanNhaHang.demo.dto.request;

import com.QuanLyDatBanNhaHang.demo.enums.TrangThaiBanAn;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
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
public class BanAnCreateRequestDTO {
    
    @NotBlank(message = "Mã bàn không được để trống")
    @Pattern(regexp = "^[a-zA-Z0-9_]+$", message = "Mã không hợp lệ")
    private String maBan;

    private Integer soGhe;
    private String viTri;

    @NotNull(message = "Trạng thái không được để trống")
    private TrangThaiBanAn trangThai;

    private String maKhuVuc;
}
