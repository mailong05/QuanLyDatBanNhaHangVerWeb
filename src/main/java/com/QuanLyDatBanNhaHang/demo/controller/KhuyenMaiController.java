package com.QuanLyDatBanNhaHang.demo.controller;

import com.QuanLyDatBanNhaHang.demo.dto.request.KhuyenMaiCreateRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.request.KhuyenMaiUpdateRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.response.KhuyenMaiResponseDTO;
import com.QuanLyDatBanNhaHang.demo.service.KhuyenMaiService;
import jakarta.validation.Valid;
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
    public ResponseEntity<List<KhuyenMaiResponseDTO>> getAllKhuyenMai() {
        return ResponseEntity.ok(khuyenMaiService.getAllKhuyenMai());
    }

    @GetMapping("/{id}")
    public ResponseEntity<KhuyenMaiResponseDTO> getKhuyenMaiById(@PathVariable String id) {
        return ResponseEntity.ok(khuyenMaiService.getKhuyenMaiById(id));
    }

    @PostMapping
    public ResponseEntity<KhuyenMaiResponseDTO> createKhuyenMai(@Valid @RequestBody KhuyenMaiCreateRequestDTO requestDTO) {
        return new ResponseEntity<>(khuyenMaiService.createKhuyenMai(requestDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<KhuyenMaiResponseDTO> updateKhuyenMai(@PathVariable String id, @Valid @RequestBody KhuyenMaiUpdateRequestDTO requestDTO) {
        return ResponseEntity.ok(khuyenMaiService.updateKhuyenMai(id, requestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteKhuyenMai(@PathVariable String id) {
        khuyenMaiService.deleteKhuyenMai(id);
        return ResponseEntity.noContent().build();
    }
}
