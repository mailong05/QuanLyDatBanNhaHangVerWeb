package com.QuanLyDatBanNhaHang.demo.controller;

import com.QuanLyDatBanNhaHang.demo.dto.request.ChiTietPhieuDatBanCreateRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.request.ChiTietPhieuDatBanUpdateRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.response.ChiTietPhieuDatBanResponseDTO;
import com.QuanLyDatBanNhaHang.demo.service.ChiTietPhieuDatBanService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/chi-tiet-phieu-dat-ban")
@RequiredArgsConstructor
public class ChiTietPhieuDatBanController {

    private final ChiTietPhieuDatBanService chiTietPhieuDatBanService;

    @GetMapping
    public ResponseEntity<List<ChiTietPhieuDatBanResponseDTO>> getAllChiTietPhieuDatBan() {
        return ResponseEntity.ok(chiTietPhieuDatBanService.getAllChiTietPhieuDatBan());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChiTietPhieuDatBanResponseDTO> getChiTietPhieuDatBanById(@PathVariable Long id) {
        return ResponseEntity.ok(chiTietPhieuDatBanService.getChiTietPhieuDatBanById(id));
    }

    @PostMapping
    public ResponseEntity<ChiTietPhieuDatBanResponseDTO> createChiTietPhieuDatBan(@Valid @RequestBody ChiTietPhieuDatBanCreateRequestDTO requestDTO) {
        return new ResponseEntity<>(chiTietPhieuDatBanService.createChiTietPhieuDatBan(requestDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ChiTietPhieuDatBanResponseDTO> updateChiTietPhieuDatBan(@PathVariable Long id, @Valid @RequestBody ChiTietPhieuDatBanUpdateRequestDTO requestDTO) {
        return ResponseEntity.ok(chiTietPhieuDatBanService.updateChiTietPhieuDatBan(id, requestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteChiTietPhieuDatBan(@PathVariable Long id) {
        chiTietPhieuDatBanService.deleteChiTietPhieuDatBan(id);
        return ResponseEntity.noContent().build();
    }
}
