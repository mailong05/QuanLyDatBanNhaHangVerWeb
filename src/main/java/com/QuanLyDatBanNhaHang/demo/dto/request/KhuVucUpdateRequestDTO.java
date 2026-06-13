package com.QuanLyDatBanNhaHang.demo.dto.request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class KhuVucUpdateRequestDTO {
    // Không có maKhuVuc ở đây nữa!

    @NotBlank(message = "Tên khu vực bắt buộc phải nhập")
    @Size(min = 5, message = "Tên khu vực phải dài ít nhất 5 ký tự")
    private String tenKhuVuc;
}