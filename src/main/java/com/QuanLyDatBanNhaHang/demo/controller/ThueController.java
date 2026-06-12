package com.QuanLyDatBanNhaHang.demo.controller;

import com.QuanLyDatBanNhaHang.demo.dto.request.ThueRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.response.ThueResponseDTO;
import com.QuanLyDatBanNhaHang.demo.service.ThueService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/thue")
@RequiredArgsConstructor
public class ThueController {

    private final ThueService thueService;

    @GetMapping
    public ResponseEntity<List<ThueResponseDTO>> getAll() {
        List<ThueResponseDTO> result = thueService.getAll();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{maThue}")
    public ResponseEntity<ThueResponseDTO> getById(@PathVariable String maThue) {
        return thueService.getById(maThue)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/trang-thai/{trangThai}")
    public ResponseEntity<List<ThueResponseDTO>> getByTrangThai(@PathVariable String trangThai) {
        List<ThueResponseDTO> result = thueService.getByTrangThai(trangThai);
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<ThueResponseDTO> create(@RequestBody ThueRequestDTO dto) {
        ThueResponseDTO result = thueService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @PutMapping("/{maThue}")
    public ResponseEntity<ThueResponseDTO> update(
            @PathVariable String maThue,
            @RequestBody ThueRequestDTO dto) {
        return thueService.update(maThue, dto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{maThue}")
    public ResponseEntity<Void> delete(@PathVariable String maThue) {
        thueService.delete(maThue);
        return ResponseEntity.noContent().build();
    }
}

