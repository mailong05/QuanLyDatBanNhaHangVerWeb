package com.QuanLyDatBanNhaHang.demo.controller;

import com.QuanLyDatBanNhaHang.demo.dto.request.HoaDonCreateRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.request.HoaDonUpdateRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.response.HoaDonResponseDTO;
import com.QuanLyDatBanNhaHang.demo.service.HoaDonService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/hoa-don")
@RequiredArgsConstructor
public class HoaDonController {

    private final HoaDonService hoaDonService;

    @GetMapping
    public ResponseEntity<Page<HoaDonResponseDTO>> getAllHoaDon(Pageable pageable) {
        return ResponseEntity.ok(hoaDonService.getAllHoaDon(pageable));
    }

    @GetMapping("/{maHD}")
    public ResponseEntity<HoaDonResponseDTO> getHoaDonById(@PathVariable String maHD) {
        return ResponseEntity.ok(hoaDonService.getHoaDonByMa(maHD));
    }

    @PostMapping
    public ResponseEntity<HoaDonResponseDTO> createHoaDon(@Valid @RequestBody HoaDonCreateRequestDTO requestDTO) {
        return new ResponseEntity<>(hoaDonService.createHoaDon(requestDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{maHD}")
    public ResponseEntity<HoaDonResponseDTO> updateHoaDon(@PathVariable String maHD, @Valid @RequestBody HoaDonUpdateRequestDTO requestDTO) {
        return ResponseEntity.ok(hoaDonService.updateHoaDon(maHD, requestDTO));
    }

    @DeleteMapping("/{maHD}")
    public ResponseEntity<Void> deleteHoaDon(@PathVariable String maHD) {
        hoaDonService.deleteHoaDon(maHD);
        return ResponseEntity.noContent().build();
    }
}
