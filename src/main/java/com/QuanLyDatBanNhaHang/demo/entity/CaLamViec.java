package com.QuanLyDatBanNhaHang.demo.entity;

import jakarta.persistence.*;
import com.QuanLyDatBanNhaHang.demo.enums.*;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "CaLamViec")
public class CaLamViec extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "maCa", length = 20, unique = true, nullable = false, updatable = false)
    private String maCa;

    @Column(name = "thoiGianVaoCa", nullable = false)
    private LocalDateTime thoiGianVaoCa;

    @Column(name = "thoiGianKetCa")
    private LocalDateTime thoiGianKetCa;

    @Column(name = "tienDauCa", nullable = false)
    private Double tienDauCa;

    @Column(name = "tienKetCa")
    private Double tienKetCa;

    @Enumerated(EnumType.STRING)
    @Column(name = "trangThai", nullable = false, length = 50)
    private TrangThaiCaLamViec trangThai;

    @Column(name = "ghiChu", length = 255)
    private String ghiChu;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "maNV", nullable = false)
    private NhanVien nhanVien;
}

