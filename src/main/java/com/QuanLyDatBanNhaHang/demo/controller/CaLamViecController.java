package com.QuanLyDatBanNhaHang.demo.controller;

import com.QuanLyDatBanNhaHang.demo.dto.request.CaLamViecCreateRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.request.CaLamViecUpdateRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.response.CaLamViecResponseDTO;
import com.QuanLyDatBanNhaHang.demo.service.CaLamViecService;
import jakarta.validation.Valid;
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
    public ResponseEntity<List<CaLamViecResponseDTO>> getAllCaLamViec() {
        return ResponseEntity.ok(caLamViecService.getAllCaLamViec());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CaLamViecResponseDTO> getCaLamViecById(@PathVariable String id) {
        return ResponseEntity.ok(caLamViecService.getCaLamViecById(id));
    }

    @PostMapping
    public ResponseEntity<CaLamViecResponseDTO> createCaLamViec(@Valid @RequestBody CaLamViecCreateRequestDTO requestDTO) {
        return new ResponseEntity<>(caLamViecService.createCaLamViec(requestDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CaLamViecResponseDTO> updateCaLamViec(@PathVariable String id, @Valid @RequestBody CaLamViecUpdateRequestDTO requestDTO) {
        return ResponseEntity.ok(caLamViecService.updateCaLamViec(id, requestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCaLamViec(@PathVariable String id) {
        caLamViecService.deleteCaLamViec(id);
        return ResponseEntity.noContent().build();
    }
}
