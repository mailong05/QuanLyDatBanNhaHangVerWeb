package com.QuanLyDatBanNhaHang.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "MonAn")
public class MonAn {

    @Id
    @Column(name = "maMon", length = 20)
    private String maMon;

    @Column(name = "tenMon", nullable = false, length = 100)
    private String tenMon;

    @Column(name = "donGia", nullable = false)
    private Double donGia;

    @Column(name = "donViTinh", length = 50)
    private String donViTinh;

    @Column(name = "tenLoai", nullable = false, length = 50)
    private String tenLoai;

    @Column(name = "trangThai", nullable = false, length = 50)
    private String trangThai;

    @Column(name = "urlHinhAnh", length = 255)
    private String urlHinhAnh;

    @OneToMany(mappedBy = "monAn", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ChiTietHoaDon> chiTietHoaDons;
}

