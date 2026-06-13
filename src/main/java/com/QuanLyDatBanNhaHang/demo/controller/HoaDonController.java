package com.QuanLyDatBanNhaHang.demo.controller;

import com.QuanLyDatBanNhaHang.demo.dto.request.HoaDonCreateRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.request.HoaDonUpdateRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.response.HoaDonResponseDTO;
import com.QuanLyDatBanNhaHang.demo.service.HoaDonService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/hoa-don")
@RequiredArgsConstructor
public class HoaDonController {

    private final HoaDonService hoaDonService;

    @GetMapping
    public ResponseEntity<List<HoaDonResponseDTO>> getAllHoaDon() {
        return ResponseEntity.ok(hoaDonService.getAllHoaDon());
    }

    @GetMapping("/{id}")
    public ResponseEntity<HoaDonResponseDTO> getHoaDonById(@PathVariable String id) {
        return ResponseEntity.ok(hoaDonService.getHoaDonById(id));
    }

    @PostMapping
    public ResponseEntity<HoaDonResponseDTO> createHoaDon(@Valid @RequestBody HoaDonCreateRequestDTO requestDTO) {
        return new ResponseEntity<>(hoaDonService.createHoaDon(requestDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HoaDonResponseDTO> updateHoaDon(@PathVariable String id, @Valid @RequestBody HoaDonUpdateRequestDTO requestDTO) {
        return ResponseEntity.ok(hoaDonService.updateHoaDon(id, requestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHoaDon(@PathVariable String id) {
        hoaDonService.deleteHoaDon(id);
        return ResponseEntity.noContent().build();
    }
}
