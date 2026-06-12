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
@Table(name = "KhuVuc")
public class KhuVuc {

    @Id
    @Column(name = "maKhuVuc", length = 20)
    private String maKhuVuc;

    @Column(name = "tenKhuVuc", nullable = false, length = 100)
    private String tenKhuVuc;

    @OneToMany(mappedBy = "khuVuc", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BanAn> banAns;
}

