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
@Table(name = "BanAn")
public class BanAn {

    @Id
    @Column(name = "maBan", length = 20)
    private String maBan;

    @Column(name = "soGhe")
    private Integer soGhe;

    @Column(name = "viTri", length = 100)
    private String viTri;

    @Column(name = "trangThai", nullable = false, length = 50)
    private String trangThai;

    // SỬA Ở ĐÂY
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "maKhuVuc")
    private KhuVuc khuVuc;

    @OneToMany(mappedBy = "banAn", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ChiTietPhieuDatBan> chiTietPhieuDatBans;
}