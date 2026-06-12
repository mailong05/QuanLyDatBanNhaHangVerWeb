package com.QuanLyDatBanNhaHang.demo.controller;

import com.QuanLyDatBanNhaHang.demo.dto.request.KhuyenMaiRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.response.KhuyenMaiResponseDTO;
import com.QuanLyDatBanNhaHang.demo.service.KhuyenMaiService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/khuyen-mai")
@RequiredArgsConstructor
public class KhuyenMaiController {

    private final KhuyenMaiService khuyenMaiService;

    @GetMapping
    public ResponseEntity<List<KhuyenMaiResponseDTO>> getAll() {
        List<KhuyenMaiResponseDTO> result = khuyenMaiService.getAll();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{maKM}")
    public ResponseEntity<KhuyenMaiResponseDTO> getById(@PathVariable String maKM) {
        return khuyenMaiService.getById(maKM)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/trang-thai/{trangThai}")
    public ResponseEntity<List<KhuyenMaiResponseDTO>> getByTrangThai(@PathVariable String trangThai) {
        List<KhuyenMaiResponseDTO> result = khuyenMaiService.getByTrangThai(trangThai);
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<KhuyenMaiResponseDTO> create(@RequestBody KhuyenMaiRequestDTO dto) {
        KhuyenMaiResponseDTO result = khuyenMaiService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @PutMapping("/{maKM}")
    public ResponseEntity<KhuyenMaiResponseDTO> update(
            @PathVariable String maKM,
            @RequestBody KhuyenMaiRequestDTO dto) {
        return khuyenMaiService.update(maKM, dto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{maKM}")
    public ResponseEntity<Void> delete(@PathVariable String maKM) {
        khuyenMaiService.delete(maKM);
        return ResponseEntity.noContent().build();
    }
}

