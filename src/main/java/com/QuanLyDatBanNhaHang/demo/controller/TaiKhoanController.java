package com.QuanLyDatBanNhaHang.demo.controller;

import com.QuanLyDatBanNhaHang.demo.dto.request.TaiKhoanCreateRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.request.TaiKhoanUpdateRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.response.TaiKhoanResponseDTO;
import com.QuanLyDatBanNhaHang.demo.service.TaiKhoanService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tai-khoan")
@RequiredArgsConstructor
public class TaiKhoanController {

    private final TaiKhoanService taiKhoanService;

    @GetMapping
    public ResponseEntity<List<TaiKhoanResponseDTO>> getAllTaiKhoan() {
        return ResponseEntity.ok(taiKhoanService.getAllTaiKhoan());
    }

    @GetMapping("/{username}")
    public ResponseEntity<TaiKhoanResponseDTO> getTaiKhoanById(@PathVariable String username) {
        return ResponseEntity.ok(taiKhoanService.getTaiKhoanById(username));
    }

    @PostMapping
    public ResponseEntity<TaiKhoanResponseDTO> createTaiKhoan(@Valid @RequestBody TaiKhoanCreateRequestDTO requestDTO) {
        return new ResponseEntity<>(taiKhoanService.createTaiKhoan(requestDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{username}")
    public ResponseEntity<TaiKhoanResponseDTO> updateTaiKhoan(@PathVariable String username, @Valid @RequestBody TaiKhoanUpdateRequestDTO requestDTO) {
        return ResponseEntity.ok(taiKhoanService.updateTaiKhoan(username, requestDTO));
    }

    @DeleteMapping("/{username}")
    public ResponseEntity<Void> deleteTaiKhoan(@PathVariable String username) {
        taiKhoanService.deleteTaiKhoan(username);
        return ResponseEntity.noContent().build();
    }
}
