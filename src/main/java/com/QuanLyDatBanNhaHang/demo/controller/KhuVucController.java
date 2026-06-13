package com.QuanLyDatBanNhaHang.demo.controller;

import com.QuanLyDatBanNhaHang.demo.dto.request.KhuVucCreateRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.request.KhuVucUpdateRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.response.KhuVucResponseDTO;
import com.QuanLyDatBanNhaHang.demo.service.KhuVucService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/khu-vuc")
@RequiredArgsConstructor
public class KhuVucController {

    private final KhuVucService khuVucService;

    @GetMapping
    public ResponseEntity<List<KhuVucResponseDTO>> getAllKhuVuc() {
        return ResponseEntity.ok(khuVucService.getAllKhuVuc());
    }

    @GetMapping("/{id}")
    public ResponseEntity<KhuVucResponseDTO> getKhuVucById(@PathVariable String id) {
        return ResponseEntity.ok(khuVucService.getKhuVucById(id));
    }

    @PostMapping
    public ResponseEntity<KhuVucResponseDTO> createKhuVuc(@Valid @RequestBody KhuVucCreateRequestDTO requestDTO) {
        return new ResponseEntity<>(khuVucService.createKhuVuc(requestDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<KhuVucResponseDTO> updateKhuVuc(@PathVariable String id, @Valid @RequestBody KhuVucUpdateRequestDTO requestDTO) {
        return ResponseEntity.ok(khuVucService.updateKhuVuc(id, requestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteKhuVuc(@PathVariable String id) {
        khuVucService.deleteKhuVuc(id);
        return ResponseEntity.noContent().build();
    }
}
