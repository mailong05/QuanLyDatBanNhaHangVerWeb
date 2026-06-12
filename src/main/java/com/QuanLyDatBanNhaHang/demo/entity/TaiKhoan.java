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
@Table(name = "TaiKhoan")
public class TaiKhoan {

    @Id
    @Column(name = "username", length = 50)
    private String username;

    @Column(name = "password", nullable = false, length = 255)
    private String password;

    @Column(name = "quyenHan", nullable = false, length = 50)
    private String quyenHan;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "maNV", nullable = false, unique = true)
    private NhanVien nhanVien;
}

