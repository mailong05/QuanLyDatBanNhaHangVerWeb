package com.QuanLyDatBanNhaHang.demo.controller;

import com.QuanLyDatBanNhaHang.demo.dto.request.MonAnCreateRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.request.MonAnUpdateRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.response.MonAnResponseDTO;
import com.QuanLyDatBanNhaHang.demo.service.MonAnService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/mon-an")
@RequiredArgsConstructor
public class MonAnController {

    private final MonAnService monAnService;

    @GetMapping
    public ResponseEntity<List<MonAnResponseDTO>> getAllMonAn() {
        return ResponseEntity.ok(monAnService.getAllMonAn());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MonAnResponseDTO> getMonAnById(@PathVariable String id) {
        return ResponseEntity.ok(monAnService.getMonAnById(id));
    }

    @PostMapping
    public ResponseEntity<MonAnResponseDTO> createMonAn(@Valid @RequestBody MonAnCreateRequestDTO requestDTO) {
        return new ResponseEntity<>(monAnService.createMonAn(requestDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MonAnResponseDTO> updateMonAn(@PathVariable String id, @Valid @RequestBody MonAnUpdateRequestDTO requestDTO) {
        return ResponseEntity.ok(monAnService.updateMonAn(id, requestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMonAn(@PathVariable String id) {
        monAnService.deleteMonAn(id);
        return ResponseEntity.noContent().build();
    }
}
