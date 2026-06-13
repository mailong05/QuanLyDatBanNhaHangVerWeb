package com.QuanLyDatBanNhaHang.demo.controller;

import com.QuanLyDatBanNhaHang.demo.dto.request.KhuVucRequestDTO;
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
    public ResponseEntity<List<KhuVucResponseDTO>> getAll() {
        List<KhuVucResponseDTO> result = khuVucService.getAll();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{maKhuVuc}")
    public ResponseEntity<KhuVucResponseDTO> getById(@PathVariable String maKhuVuc) {
        return khuVucService.getById(maKhuVuc)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<KhuVucResponseDTO> create(@Valid @RequestBody KhuVucRequestDTO dto) {
        KhuVucResponseDTO result = khuVucService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @PutMapping("/{maKhuVuc}")
    public ResponseEntity<KhuVucResponseDTO> update(
            @PathVariable String maKhuVuc,
          @Valid  @RequestBody KhuVucUpdateRequestDTO dto) {
        return khuVucService.update(maKhuVuc, dto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{maKhuVuc}")
    public ResponseEntity<Void> delete(@PathVariable String maKhuVuc) {
        khuVucService.delete(maKhuVuc);
        return ResponseEntity.noContent().build();
    }
}

