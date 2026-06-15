package com.QuanLyDatBanNhaHang.demo.controller;

import com.QuanLyDatBanNhaHang.demo.dto.request.PhanCongCreateRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.request.PhanCongUpdateRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.response.PhanCongResponseDTO;
import com.QuanLyDatBanNhaHang.demo.service.PhanCongService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/phan-cong")
@RequiredArgsConstructor
public class PhanCongController {

    private final PhanCongService phanCongService;

    @GetMapping
    public ResponseEntity<Page<PhanCongResponseDTO>> getAllPhanCong(Pageable pageable) {
        return ResponseEntity.ok(phanCongService.getAllPhanCong(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PhanCongResponseDTO> getPhanCongById(@PathVariable Long id) {
        return ResponseEntity.ok(phanCongService.getPhanCongById(id));
    }

    @PostMapping
    public ResponseEntity<PhanCongResponseDTO> createPhanCong(@Valid @RequestBody PhanCongCreateRequestDTO requestDTO) {
        return new ResponseEntity<>(phanCongService.createPhanCong(requestDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PhanCongResponseDTO> updatePhanCong(@PathVariable Long id, @Valid @RequestBody PhanCongUpdateRequestDTO requestDTO) {
        return ResponseEntity.ok(phanCongService.updatePhanCong(id, requestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePhanCong(@PathVariable Long id) {
        phanCongService.deletePhanCong(id);
        return ResponseEntity.noContent().build();
    }
}
