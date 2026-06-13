package com.QuanLyDatBanNhaHang.demo.controller;

import com.QuanLyDatBanNhaHang.demo.dto.request.KhachHangCreateRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.request.KhachHangUpdateRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.response.KhachHangResponseDTO;
import com.QuanLyDatBanNhaHang.demo.service.KhachHangService;
import jakarta.validation.Valid;
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
    public ResponseEntity<List<KhachHangResponseDTO>> getAllKhachHang() {
        return ResponseEntity.ok(khachHangService.getAllKhachHang());
    }

    @GetMapping("/{id}")
    public ResponseEntity<KhachHangResponseDTO> getKhachHangById(@PathVariable String id) {
        return ResponseEntity.ok(khachHangService.getKhachHangById(id));
    }

    @PostMapping
    public ResponseEntity<KhachHangResponseDTO> createKhachHang(@Valid @RequestBody KhachHangCreateRequestDTO requestDTO) {
        return new ResponseEntity<>(khachHangService.createKhachHang(requestDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<KhachHangResponseDTO> updateKhachHang(@PathVariable String id, @Valid @RequestBody KhachHangUpdateRequestDTO requestDTO) {
        return ResponseEntity.ok(khachHangService.updateKhachHang(id, requestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteKhachHang(@PathVariable String id) {
        khachHangService.deleteKhachHang(id);
        return ResponseEntity.noContent().build();
    }
}
