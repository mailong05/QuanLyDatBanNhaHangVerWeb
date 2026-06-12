package com.QuanLyDatBanNhaHang.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "PhieuDatBan")
public class PhieuDatBan {

    @Id
    @Column(name = "maPhieuDat", length = 20)
    private String maPhieuDat;

    @Column(name = "ngayLapPhieu")
    private LocalDateTime ngayLapPhieu;

    @Column(name = "thoiGianDen", nullable = false)
    private LocalDateTime thoiGianDen;

    @Column(name = "soLuongNguoi")
    private Integer soLuongNguoi;

    @Column(name = "ghiChu", length = 255)
    private String ghiChu;

    @Column(name = "trangThai", nullable = false, length = 50)
    private String trangThai;

    @Column(name = "tienDatCoc")
    private Double tienDatCoc;

    // SỬA Ở ĐÂY: Thêm LAZY và chặn đệ quy
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "maKH")
    private KhachHang khachHang;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "maNV", nullable = false)
    private NhanVien nhanVien;

    @OneToMany(mappedBy = "phieuDatBan", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ChiTietPhieuDatBan> chiTietPhieuDatBans;

    @OneToMany(mappedBy = "phieuDatBan", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HoaDon> hoaDons;
}