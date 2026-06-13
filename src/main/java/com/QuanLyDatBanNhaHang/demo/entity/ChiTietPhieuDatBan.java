package com.QuanLyDatBanNhaHang.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "ChiTietPhieuDatBan")
public class ChiTietPhieuDatBan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "maPhieuDat", length = 20)
    private String maPhieuDat;

    @Column(name = "maBan", length = 20)
    private String maBan;

    @Column(name = "ghiChu", length = 255)
    private String ghiChu;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "maPhieuDat", insertable = false, updatable = false)
    private PhieuDatBan phieuDatBan;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "maBan", insertable = false, updatable = false)
    private BanAn banAn;
}

