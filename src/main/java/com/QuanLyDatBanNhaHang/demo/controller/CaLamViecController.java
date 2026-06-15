package com.QuanLyDatBanNhaHang.demo.controller;

import com.QuanLyDatBanNhaHang.demo.dto.request.CaLamViecCreateRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.request.CaLamViecUpdateRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.response.CaLamViecResponseDTO;
import com.QuanLyDatBanNhaHang.demo.service.CaLamViecService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/ca-lam-viec")
@RequiredArgsConstructor
public class CaLamViecController {

    private final CaLamViecService caLamViecService;

    @GetMapping
    public ResponseEntity<Page<CaLamViecResponseDTO>> getAllCaLamViec(Pageable pageable) {
        return ResponseEntity.ok(caLamViecService.getAllCaLamViec(pageable));
    }

    @GetMapping("/{maCa}")
    public ResponseEntity<CaLamViecResponseDTO> getCaLamViecById(@PathVariable String maCa) {
        return ResponseEntity.ok(caLamViecService.getCaLamViecByMa(maCa));
    }

    @PostMapping
    public ResponseEntity<CaLamViecResponseDTO> createCaLamViec(@Valid @RequestBody CaLamViecCreateRequestDTO requestDTO) {
        return new ResponseEntity<>(caLamViecService.createCaLamViec(requestDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{maCa}")
    public ResponseEntity<CaLamViecResponseDTO> updateCaLamViec(@PathVariable String maCa, @Valid @RequestBody CaLamViecUpdateRequestDTO requestDTO) {
        return ResponseEntity.ok(caLamViecService.updateCaLamViec(maCa, requestDTO));
    }

    @DeleteMapping("/{maCa}")
    public ResponseEntity<Void> deleteCaLamViec(@PathVariable String maCa) {
        caLamViecService.deleteCaLamViec(maCa);
        return ResponseEntity.noContent().build();
    }
}
