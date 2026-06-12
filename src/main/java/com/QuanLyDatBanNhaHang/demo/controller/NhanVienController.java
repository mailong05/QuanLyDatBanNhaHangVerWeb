package com.QuanLyDatBanNhaHang.demo.controller;

import com.QuanLyDatBanNhaHang.demo.dto.request.NhanVienRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.response.NhanVienResponseDTO;
import com.QuanLyDatBanNhaHang.demo.service.NhanVienService;
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
    public ResponseEntity<List<NhanVienResponseDTO>> getAll() {
        List<NhanVienResponseDTO> result = nhanVienService.getAll();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{maNV}")
    public ResponseEntity<NhanVienResponseDTO> getById(@PathVariable String maNV) {
        return nhanVienService.getById(maNV)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/chuc-vu/{chucVu}")
    public ResponseEntity<List<NhanVienResponseDTO>> getByChucVu(@PathVariable String chucVu) {
        List<NhanVienResponseDTO> result = nhanVienService.getByChucVu(chucVu);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/trang-thai/{trangThai}")
    public ResponseEntity<List<NhanVienResponseDTO>> getByTrangThai(@PathVariable String trangThai) {
        List<NhanVienResponseDTO> result = nhanVienService.getByTrangThai(trangThai);
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<NhanVienResponseDTO> create(@RequestBody NhanVienRequestDTO dto) {
        NhanVienResponseDTO result = nhanVienService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @PutMapping("/{maNV}")
    public ResponseEntity<NhanVienResponseDTO> update(
            @PathVariable String maNV,
            @RequestBody NhanVienRequestDTO dto) {
        return nhanVienService.update(maNV, dto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{maNV}")
    public ResponseEntity<Void> delete(@PathVariable String maNV) {
        nhanVienService.delete(maNV);
        return ResponseEntity.noContent().build();
    }
}

