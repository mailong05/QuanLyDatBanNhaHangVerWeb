package com.QuanLyDatBanNhaHang.demo.controller;

import com.QuanLyDatBanNhaHang.demo.dto.request.MonAnRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.response.MonAnResponseDTO;
import com.QuanLyDatBanNhaHang.demo.service.MonAnService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/mon-an")
@RequiredArgsConstructor
public class MonAnController {

    private final MonAnService monAnService;

    @GetMapping
    public ResponseEntity<List<MonAnResponseDTO>> getAll() {
        List<MonAnResponseDTO> result = monAnService.getAll();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{maMon}")
    public ResponseEntity<MonAnResponseDTO> getById(@PathVariable String maMon) {
        return monAnService.getById(maMon)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/loai/{tenLoai}")
    public ResponseEntity<List<MonAnResponseDTO>> getByTenLoai(@PathVariable String tenLoai) {
        List<MonAnResponseDTO> result = monAnService.getByTenLoai(tenLoai);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/trang-thai/{trangThai}")
    public ResponseEntity<List<MonAnResponseDTO>> getByTrangThai(@PathVariable String trangThai) {
        List<MonAnResponseDTO> result = monAnService.getByTrangThai(trangThai);
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<MonAnResponseDTO> create(@RequestBody MonAnRequestDTO dto) {
        MonAnResponseDTO result = monAnService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @PutMapping("/{maMon}")
    public ResponseEntity<MonAnResponseDTO> update(
            @PathVariable String maMon,
            @RequestBody MonAnRequestDTO dto) {
        return monAnService.update(maMon, dto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{maMon}")
    public ResponseEntity<Void> delete(@PathVariable String maMon) {
        monAnService.delete(maMon);
        return ResponseEntity.noContent().build();
    }
}

