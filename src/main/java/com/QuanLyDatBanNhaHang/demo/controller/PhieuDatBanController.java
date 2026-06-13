package com.QuanLyDatBanNhaHang.demo.controller;

import com.QuanLyDatBanNhaHang.demo.dto.request.PhieuDatBanCreateRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.request.PhieuDatBanUpdateRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.response.PhieuDatBanResponseDTO;
import com.QuanLyDatBanNhaHang.demo.service.PhieuDatBanService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/phieu-dat-ban")
@RequiredArgsConstructor
public class PhieuDatBanController {

    private final PhieuDatBanService phieuDatBanService;

    @GetMapping
    public ResponseEntity<List<PhieuDatBanResponseDTO>> getAllPhieuDatBan() {
        return ResponseEntity.ok(phieuDatBanService.getAllPhieuDatBan());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PhieuDatBanResponseDTO> getPhieuDatBanById(@PathVariable String id) {
        return ResponseEntity.ok(phieuDatBanService.getPhieuDatBanById(id));
    }

    @PostMapping
    public ResponseEntity<PhieuDatBanResponseDTO> createPhieuDatBan(@Valid @RequestBody PhieuDatBanCreateRequestDTO requestDTO) {
        return new ResponseEntity<>(phieuDatBanService.createPhieuDatBan(requestDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PhieuDatBanResponseDTO> updatePhieuDatBan(@PathVariable String id, @Valid @RequestBody PhieuDatBanUpdateRequestDTO requestDTO) {
        return ResponseEntity.ok(phieuDatBanService.updatePhieuDatBan(id, requestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePhieuDatBan(@PathVariable String id) {
        phieuDatBanService.deletePhieuDatBan(id);
        return ResponseEntity.noContent().build();
    }
}
