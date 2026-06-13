package com.QuanLyDatBanNhaHang.demo.entity;

import jakarta.persistence.*;
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
@Entity
@Table(name = "ChiTietHoaDon")
public class ChiTietHoaDon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "maHD", length = 20)
    private String maHD;

    @Column(name = "maMon", length = 20)
    private String maMon;

    @Column(name = "soLuong", nullable = false)
    private Integer soLuong;

    @Column(name = "donGiaLuuTru", nullable = false)
    private Double donGiaLuuTru;

    @Column(name = "ghiChu", length = 255)
    private String ghiChu;

    @Column(name = "thanhTien", nullable = false)
    private Double thanhTien;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "maHD", insertable = false, updatable = false)
    private HoaDon hoaDon;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "maMon", insertable = false, updatable = false)
    private MonAn monAn;
}

