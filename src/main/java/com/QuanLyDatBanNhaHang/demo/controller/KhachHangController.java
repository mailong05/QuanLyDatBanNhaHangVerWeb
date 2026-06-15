package com.QuanLyDatBanNhaHang.demo.controller;

import com.QuanLyDatBanNhaHang.demo.dto.request.KhachHangCreateRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.request.KhachHangUpdateRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.response.KhachHangResponseDTO;
import com.QuanLyDatBanNhaHang.demo.service.KhachHangService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/khach-hang")
@RequiredArgsConstructor
public class KhachHangController {

    private final KhachHangService khachHangService;

    @GetMapping
    public ResponseEntity<Page<KhachHangResponseDTO>> getAllKhachHang(
            @RequestParam(required = false) String search,
            Pageable pageable) {
        if (search != null && !search.trim().isEmpty()) {
            return ResponseEntity.ok(khachHangService.searchKhachHang(search, pageable));
        }
        return ResponseEntity.ok(khachHangService.getAllKhachHang(pageable));
    }

    @GetMapping("/{maKH}")
    public ResponseEntity<KhachHangResponseDTO> getKhachHangById(@PathVariable String maKH) {
        return ResponseEntity.ok(khachHangService.getKhachHangByMa(maKH));
    }

    @PostMapping
    public ResponseEntity<KhachHangResponseDTO> createKhachHang(@Valid @RequestBody KhachHangCreateRequestDTO requestDTO) {
        return new ResponseEntity<>(khachHangService.createKhachHang(requestDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{maKH}")
    public ResponseEntity<KhachHangResponseDTO> updateKhachHang(@PathVariable String maKH, @Valid @RequestBody KhachHangUpdateRequestDTO requestDTO) {
        return ResponseEntity.ok(khachHangService.updateKhachHang(maKH, requestDTO));
    }

    @DeleteMapping("/{maKH}")
    public ResponseEntity<Void> deleteKhachHang(@PathVariable String maKH) {
        khachHangService.deleteKhachHang(maKH);
        return ResponseEntity.noContent().build();
    }
}
