package com.QuanLyDatBanNhaHang.demo.controller;

import com.QuanLyDatBanNhaHang.demo.dto.request.GiaoCaCreateRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.request.GiaoCaUpdateRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.response.GiaoCaResponseDTO;
import com.QuanLyDatBanNhaHang.demo.service.GiaoCaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/giao-ca")
@RequiredArgsConstructor
public class GiaoCaController {

    private final GiaoCaService giaoCaService;

    @GetMapping
    public ResponseEntity<Page<GiaoCaResponseDTO>> getAllGiaoCa(Pageable pageable) {
        return ResponseEntity.ok(giaoCaService.getAllGiaoCa(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GiaoCaResponseDTO> getGiaoCaById(@PathVariable Long id) {
        return ResponseEntity.ok(giaoCaService.getGiaoCaById(id));
    }

    @PostMapping
    public ResponseEntity<GiaoCaResponseDTO> createGiaoCa(@Valid @RequestBody GiaoCaCreateRequestDTO requestDTO) {
        return new ResponseEntity<>(giaoCaService.createGiaoCa(requestDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GiaoCaResponseDTO> updateGiaoCa(@PathVariable Long id, @Valid @RequestBody GiaoCaUpdateRequestDTO requestDTO) {
        return ResponseEntity.ok(giaoCaService.updateGiaoCa(id, requestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGiaoCa(@PathVariable Long id) {
        giaoCaService.deleteGiaoCa(id);
        return ResponseEntity.noContent().build();
    }
}
