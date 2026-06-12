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
@Table(name = "Thue")
public class Thue {

    @Id
    @Column(name = "maThue", length = 20)
    private String maThue;

    @Column(name = "tenThue", nullable = false, length = 100)
    private String tenThue;

    @Column(name = "thueSuat", nullable = false)
    private Double thueSuat;

    @Column(name = "trangThai", nullable = false, length = 50)
    private String trangThai;

    @OneToMany(mappedBy = "thue", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HoaDon> hoaDons;
}

