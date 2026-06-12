package com.QuanLyDatBanNhaHang.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "NhanVien")
public class NhanVien {

    @Id
    @Column(name = "maNV", length = 20)
    private String maNV;

    @Column(name = "hoTen", nullable = false, length = 100)
    private String hoTen;

    @Column(name = "sdt", length = 15)
    private String sdt;

    @Column(name = "chucVu", nullable = false, length = 50)
    private String chucVu;

    @Column(name = "ngayVaoLam", nullable = false)
    private LocalDate ngayVaoLam;

    @Column(name = "luongCoBan", nullable = false)
    private Double luongCoBan;

    @Column(name = "trangThai", nullable = false, length = 50)
    private String trangThai;

    @OneToMany(mappedBy = "nhanVien", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CaLamViec> caLamViecs;

    @OneToMany(mappedBy = "nhanVien", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PhieuDatBan> phieuDatBans;

    @OneToMany(mappedBy = "nhanVien", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HoaDon> hoaDons;

    @OneToOne(mappedBy = "nhanVien", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private TaiKhoan taiKhoan;
}

