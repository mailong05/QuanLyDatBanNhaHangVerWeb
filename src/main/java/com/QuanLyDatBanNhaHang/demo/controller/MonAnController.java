package com.QuanLyDatBanNhaHang.demo.controller;

import com.QuanLyDatBanNhaHang.demo.dto.request.MonAnCreateRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.request.MonAnUpdateRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.response.MonAnResponseDTO;
import com.QuanLyDatBanNhaHang.demo.service.MonAnService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/mon-an")
@RequiredArgsConstructor
public class MonAnController {

    private final MonAnService monAnService;

    @GetMapping
    public ResponseEntity<Page<MonAnResponseDTO>> getAllMonAn(Pageable pageable) {
        return ResponseEntity.ok(monAnService.getAllMonAn(pageable));
    }

    @GetMapping("/{maMon}")
    public ResponseEntity<MonAnResponseDTO> getMonAnById(@PathVariable String maMon) {
        return ResponseEntity.ok(monAnService.getMonAnByMa(maMon));
    }

    @PostMapping
    public ResponseEntity<MonAnResponseDTO> createMonAn(@Valid @RequestBody MonAnCreateRequestDTO requestDTO) {
        return new ResponseEntity<>(monAnService.createMonAn(requestDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{maMon}")
    public ResponseEntity<MonAnResponseDTO> updateMonAn(@PathVariable String maMon, @Valid @RequestBody MonAnUpdateRequestDTO requestDTO) {
        return ResponseEntity.ok(monAnService.updateMonAn(maMon, requestDTO));
    }

    @DeleteMapping("/{maMon}")
    public ResponseEntity<Void> deleteMonAn(@PathVariable String maMon) {
        monAnService.deleteMonAn(maMon);
        return ResponseEntity.noContent().build();
    }
}
