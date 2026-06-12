package com.QuanLyDatBanNhaHang.demo.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO response cho bàn ăn.
 * Flat structure: chỉ chứa scalar fields + tên từ object liên quan.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BanAnResponseDTO {

    private String maBan;

    private Integer soGhe;

    private String viTri;

    private String trangThai;

    // Lấy từ quan hệ KhuVuc (flat: không chứa object KhuVuc)
    private String maKhuVuc;

    private String tenKhuVuc;
}

