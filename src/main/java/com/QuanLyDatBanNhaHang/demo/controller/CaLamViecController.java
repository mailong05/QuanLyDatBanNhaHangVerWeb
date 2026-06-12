package com.QuanLyDatBanNhaHang.demo.controller;

import com.QuanLyDatBanNhaHang.demo.dto.request.CaLamViecRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.response.CaLamViecResponseDTO;
import com.QuanLyDatBanNhaHang.demo.service.CaLamViecService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/ca-lam-viec")
@RequiredArgsConstructor
public class CaLamViecController {

    private final CaLamViecService caLamViecService;

    @GetMapping
    public ResponseEntity<List<CaLamViecResponseDTO>> getAll() {
        List<CaLamViecResponseDTO> result = caLamViecService.getAll();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{maCa}")
    public ResponseEntity<CaLamViecResponseDTO> getById(@PathVariable String maCa) {
        return caLamViecService.getById(maCa)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/nhan-vien/{maNV}")
    public ResponseEntity<List<CaLamViecResponseDTO>> getByNhanVien(@PathVariable String maNV) {
        List<CaLamViecResponseDTO> result = caLamViecService.getByNhanVien(maNV);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/trang-thai/{trangThai}")
    public ResponseEntity<List<CaLamViecResponseDTO>> getByTrangThai(@PathVariable String trangThai) {
        List<CaLamViecResponseDTO> result = caLamViecService.getByTrangThai(trangThai);
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<CaLamViecResponseDTO> create(@RequestBody CaLamViecRequestDTO dto) {
        CaLamViecResponseDTO result = caLamViecService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @PutMapping("/{maCa}")
    public ResponseEntity<CaLamViecResponseDTO> update(
            @PathVariable String maCa,
            @RequestBody CaLamViecRequestDTO dto) {
        return caLamViecService.update(maCa, dto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{maCa}")
    public ResponseEntity<Void> delete(@PathVariable String maCa) {
        caLamViecService.delete(maCa);
        return ResponseEntity.noContent().build();
    }
}

