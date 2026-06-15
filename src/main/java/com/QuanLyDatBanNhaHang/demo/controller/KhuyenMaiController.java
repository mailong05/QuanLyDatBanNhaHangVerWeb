package com.QuanLyDatBanNhaHang.demo.controller;

import com.QuanLyDatBanNhaHang.demo.dto.request.KhuyenMaiCreateRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.request.KhuyenMaiUpdateRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.response.KhuyenMaiResponseDTO;
import com.QuanLyDatBanNhaHang.demo.service.KhuyenMaiService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/khuyen-mai")
@RequiredArgsConstructor
public class KhuyenMaiController {

    private final KhuyenMaiService khuyenMaiService;

    @GetMapping
    public ResponseEntity<Page<KhuyenMaiResponseDTO>> getAllKhuyenMai(Pageable pageable) {
        return ResponseEntity.ok(khuyenMaiService.getAllKhuyenMai(pageable));
    }

    @GetMapping("/{maKM}")
    public ResponseEntity<KhuyenMaiResponseDTO> getKhuyenMaiById(@PathVariable String maKM) {
        return ResponseEntity.ok(khuyenMaiService.getKhuyenMaiByMa(maKM));
    }

    @PostMapping
    public ResponseEntity<KhuyenMaiResponseDTO> createKhuyenMai(@Valid @RequestBody KhuyenMaiCreateRequestDTO requestDTO) {
        return new ResponseEntity<>(khuyenMaiService.createKhuyenMai(requestDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{maKM}")
    public ResponseEntity<KhuyenMaiResponseDTO> updateKhuyenMai(@PathVariable String maKM, @Valid @RequestBody KhuyenMaiUpdateRequestDTO requestDTO) {
        return ResponseEntity.ok(khuyenMaiService.updateKhuyenMai(maKM, requestDTO));
    }

    @DeleteMapping("/{maKM}")
    public ResponseEntity<Void> deleteKhuyenMai(@PathVariable String maKM) {
        khuyenMaiService.deleteKhuyenMai(maKM);
        return ResponseEntity.noContent().build();
    }
}
