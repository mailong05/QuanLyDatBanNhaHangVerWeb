package com.QuanLyDatBanNhaHang.demo.controller;

import com.QuanLyDatBanNhaHang.demo.dto.request.NhanVienCreateRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.request.NhanVienUpdateRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.response.NhanVienResponseDTO;
import com.QuanLyDatBanNhaHang.demo.service.NhanVienService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/nhan-vien")
@RequiredArgsConstructor
public class NhanVienController {

    private final NhanVienService nhanVienService;

    @GetMapping
    public ResponseEntity<List<NhanVienResponseDTO>> getAllNhanVien() {
        return ResponseEntity.ok(nhanVienService.getAllNhanVien());
    }

    @GetMapping("/{id}")
    public ResponseEntity<NhanVienResponseDTO> getNhanVienById(@PathVariable String id) {
        return ResponseEntity.ok(nhanVienService.getNhanVienById(id));
    }

    @PostMapping
    public ResponseEntity<NhanVienResponseDTO> createNhanVien(@Valid @RequestBody NhanVienCreateRequestDTO requestDTO) {
        return new ResponseEntity<>(nhanVienService.createNhanVien(requestDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<NhanVienResponseDTO> updateNhanVien(@PathVariable String id, @Valid @RequestBody NhanVienUpdateRequestDTO requestDTO) {
        return ResponseEntity.ok(nhanVienService.updateNhanVien(id, requestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNhanVien(@PathVariable String id) {
        nhanVienService.deleteNhanVien(id);
        return ResponseEntity.noContent().build();
    }
}
