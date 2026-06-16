package com.QuanLyDatBanNhaHang.demo.controller;

import com.QuanLyDatBanNhaHang.demo.dto.request.WebBookingRequestDTO;
import com.QuanLyDatBanNhaHang.demo.service.WebBookingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/web/booking")
@RequiredArgsConstructor
public class WebBookingController {

    private final WebBookingService webBookingService;

    @PostMapping
    public ResponseEntity<?> createBooking(@Valid @RequestBody WebBookingRequestDTO request) {
        webBookingService.createWebBooking(request);
        return ResponseEntity.ok("Đặt bàn thành công! Hệ thống đang xử lý và chờ xác nhận.");
    }
}
