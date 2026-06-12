package com.QuanLyDatBanNhaHang.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "HoaDon")
public class HoaDon {

    @Id
    @Column(name = "maHD", length = 20)
    private String maHD;

    @Column(name = "thueSuat")
    private Double thueSuat;

    @Column(name = "tienThue")
    private Double tienThue;

    @Column(name = "tyLePhiDV")
    private Double tyLePhiDV;

    @Column(name = "tienPhiDV")
    private Double tienPhiDV;

    @Column(name = "ngayTao")
    private LocalDateTime ngayTao;

    @Column(name = "gioVao")
    private LocalTime gioVao;

    @Column(name = "gioRa")
    private LocalTime gioRa;

    @Column(name = "tongTienGoc")
    private Double tongTienGoc;

    @Column(name = "tienGiamGia")
    private Double tienGiamGia;

    @Column(name = "tongThanhToan")
    private Double tongThanhToan;

    @Column(name = "phuongThucTT", length = 50)
    private String phuongThucTT;

    @Column(name = "trangThaiThanhToan", nullable = false, length = 50)
    private String trangThaiThanhToan;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "maPhieuDat", nullable = false)
    private PhieuDatBan phieuDatBan;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "maNV", nullable = false)
    private NhanVien nhanVien;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "maKM")
    private KhuyenMai khuyenMai;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "maThue", nullable = false)
    private Thue thue;

    @OneToMany(mappedBy = "hoaDon", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ChiTietHoaDon> chiTietHoaDons;
}

