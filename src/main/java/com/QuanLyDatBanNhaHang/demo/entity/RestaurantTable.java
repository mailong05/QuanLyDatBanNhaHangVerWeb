package com.QuanLyDatBanNhaHang.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Ban") // Điền chính xác tên bảng trong SQL Server của em vào đây
@Getter
@Setter
@NoArgsConstructor
public class RestaurantTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Nếu khóa chính trong DB tự tăng (Identity)
    private Long id;

    @Column(name = "maBan") // Tên cột trong DB
    private String tableNumber;

    @Column(name = "soGhe")
    private Integer capacity;

    @Column(name = "trangThai")
    private String status; // Ví dụ: AVAILABLE, BOOKED
}