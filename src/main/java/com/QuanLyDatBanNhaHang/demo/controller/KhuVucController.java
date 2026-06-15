package com.QuanLyDatBanNhaHang.demo.controller;

import com.QuanLyDatBanNhaHang.demo.dto.request.KhuVucCreateRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.request.KhuVucUpdateRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.response.KhuVucResponseDTO;
import com.QuanLyDatBanNhaHang.demo.service.KhuVucService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/khu-vuc")
@RequiredArgsConstructor
public class KhuVucController {

    private final KhuVucService khuVucService;

    @GetMapping
    public ResponseEntity<Page<KhuVucResponseDTO>> getAllKhuVuc(Pageable pageable) {
        return ResponseEntity.ok(khuVucService.getAllKhuVuc(pageable));
    }

    @GetMapping("/{maKhuVuc}")
    public ResponseEntity<KhuVucResponseDTO> getKhuVucById(@PathVariable String maKhuVuc) {
        return ResponseEntity.ok(khuVucService.getKhuVucByMa(maKhuVuc));
    }

    @PostMapping
    public ResponseEntity<KhuVucResponseDTO> createKhuVuc(@Valid @RequestBody KhuVucCreateRequestDTO requestDTO) {
        return new ResponseEntity<>(khuVucService.createKhuVuc(requestDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{maKhuVuc}")
    public ResponseEntity<KhuVucResponseDTO> updateKhuVuc(@PathVariable String maKhuVuc, @Valid @RequestBody KhuVucUpdateRequestDTO requestDTO) {
        return ResponseEntity.ok(khuVucService.updateKhuVuc(maKhuVuc, requestDTO));
    }

    @DeleteMapping("/{maKhuVuc}")
    public ResponseEntity<Void> deleteKhuVuc(@PathVariable String maKhuVuc) {
        khuVucService.deleteKhuVuc(maKhuVuc);
        return ResponseEntity.noContent().build();
    }
}
