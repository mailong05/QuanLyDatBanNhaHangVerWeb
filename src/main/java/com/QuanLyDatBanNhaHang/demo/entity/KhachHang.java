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
@Table(name = "KhachHang")
public class KhachHang {

    @Id
    @Column(name = "maKH", length = 20)
    private String maKH;

    @Column(name = "hoTen", nullable = false, length = 100)
    private String hoTen;

    @Column(name = "sdt", nullable = false, length = 15)
    private String sdt;

    @Column(name = "diemTichLuy")
    private Integer diemTichLuy;

    @Column(name = "loaiThanhVien", nullable = false, length = 50)
    private String loaiThanhVien;

    @OneToMany(mappedBy = "khachHang", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PhieuDatBan> phieuDatBans;
}

