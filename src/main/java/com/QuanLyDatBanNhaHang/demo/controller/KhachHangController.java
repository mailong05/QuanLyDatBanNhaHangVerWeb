package com.QuanLyDatBanNhaHang.demo.controller;

import com.QuanLyDatBanNhaHang.demo.dto.request.KhachHangRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.response.KhachHangResponseDTO;
import com.QuanLyDatBanNhaHang.demo.service.KhachHangService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/khach-hang")
@RequiredArgsConstructor
public class KhachHangController {

    private final KhachHangService khachHangService;

    @GetMapping
    public ResponseEntity<List<KhachHangResponseDTO>> getAll() {
        List<KhachHangResponseDTO> result = khachHangService.getAll();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{maKH}")
    public ResponseEntity<KhachHangResponseDTO> getById(@PathVariable String maKH) {
        return khachHangService.getById(maKH)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/loai-thanh-vien/{loaiThanhVien}")
    public ResponseEntity<List<KhachHangResponseDTO>> getByLoaiThanhVien(
            @PathVariable String loaiThanhVien) {
        List<KhachHangResponseDTO> result = khachHangService.getByLoaiThanhVien(loaiThanhVien);
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<KhachHangResponseDTO> create(@RequestBody KhachHangRequestDTO dto) {
        KhachHangResponseDTO result = khachHangService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @PutMapping("/{maKH}")
    public ResponseEntity<KhachHangResponseDTO> update(
            @PathVariable String maKH,
            @RequestBody KhachHangRequestDTO dto) {
        return khachHangService.update(maKH, dto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{maKH}")
    public ResponseEntity<Void> delete(@PathVariable String maKH) {
        khachHangService.delete(maKH);
        return ResponseEntity.noContent().build();
    }
}

