package com.QuanLyDatBanNhaHang.demo.controller;

import com.QuanLyDatBanNhaHang.demo.dto.request.NhanVienCreateRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.request.NhanVienUpdateRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.response.NhanVienResponseDTO;
import com.QuanLyDatBanNhaHang.demo.service.NhanVienService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/nhan-vien")
@RequiredArgsConstructor
public class NhanVienController {

    private final NhanVienService nhanVienService;

    @GetMapping
    public ResponseEntity<Page<NhanVienResponseDTO>> getAllNhanVien(
            @RequestParam(required = false) String search,
            Pageable pageable) {
        if (search != null && !search.trim().isEmpty()) {
            return ResponseEntity.ok(nhanVienService.searchNhanVien(search, pageable));
        }
        return ResponseEntity.ok(nhanVienService.getAllNhanVien(pageable));
    }

    @GetMapping("/{maNV}")
    public ResponseEntity<NhanVienResponseDTO> getNhanVienById(@PathVariable String maNV) {
        return ResponseEntity.ok(nhanVienService.getNhanVienByMa(maNV));
    }

    @PostMapping
    public ResponseEntity<NhanVienResponseDTO> createNhanVien(@Valid @RequestBody NhanVienCreateRequestDTO requestDTO) {
        return new ResponseEntity<>(nhanVienService.createNhanVien(requestDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{maNV}")
    public ResponseEntity<NhanVienResponseDTO> updateNhanVien(@PathVariable String maNV, @Valid @RequestBody NhanVienUpdateRequestDTO requestDTO) {
        return ResponseEntity.ok(nhanVienService.updateNhanVien(maNV, requestDTO));
    }

    @DeleteMapping("/{maNV}")
    public ResponseEntity<Void> deleteNhanVien(@PathVariable String maNV) {
        nhanVienService.deleteNhanVien(maNV);
        return ResponseEntity.noContent().build();
    }
}
