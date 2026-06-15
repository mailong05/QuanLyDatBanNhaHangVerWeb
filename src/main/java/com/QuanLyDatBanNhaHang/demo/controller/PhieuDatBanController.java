package com.QuanLyDatBanNhaHang.demo.controller;

import com.QuanLyDatBanNhaHang.demo.dto.request.PhieuDatBanCreateRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.request.PhieuDatBanUpdateRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.response.PhieuDatBanResponseDTO;
import com.QuanLyDatBanNhaHang.demo.service.PhieuDatBanService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/phieu-dat-ban")
@RequiredArgsConstructor
public class PhieuDatBanController {

    private final PhieuDatBanService phieuDatBanService;

    @GetMapping
    public ResponseEntity<Page<PhieuDatBanResponseDTO>> getAllPhieuDatBan(Pageable pageable) {
        return ResponseEntity.ok(phieuDatBanService.getAllPhieuDatBan(pageable));
    }

    @GetMapping("/{maPhieuDat}")
    public ResponseEntity<PhieuDatBanResponseDTO> getPhieuDatBanById(@PathVariable String maPhieuDat) {
        return ResponseEntity.ok(phieuDatBanService.getPhieuDatBanByMa(maPhieuDat));
    }

    @PostMapping
    public ResponseEntity<PhieuDatBanResponseDTO> createPhieuDatBan(@Valid @RequestBody PhieuDatBanCreateRequestDTO requestDTO) {
        return new ResponseEntity<>(phieuDatBanService.createPhieuDatBan(requestDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{maPhieuDat}")
    public ResponseEntity<PhieuDatBanResponseDTO> updatePhieuDatBan(@PathVariable String maPhieuDat, @Valid @RequestBody PhieuDatBanUpdateRequestDTO requestDTO) {
        return ResponseEntity.ok(phieuDatBanService.updatePhieuDatBan(maPhieuDat, requestDTO));
    }

    @DeleteMapping("/{maPhieuDat}")
    public ResponseEntity<Void> deletePhieuDatBan(@PathVariable String maPhieuDat) {
        phieuDatBanService.deletePhieuDatBan(maPhieuDat);
        return ResponseEntity.noContent().build();
    }
}
