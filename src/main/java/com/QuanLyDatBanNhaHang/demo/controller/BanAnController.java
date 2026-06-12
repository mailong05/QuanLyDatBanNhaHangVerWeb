package com.QuanLyDatBanNhaHang.demo.controller;

import com.QuanLyDatBanNhaHang.demo.dto.request.BanAnRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.response.BanAnResponseDTO;
import com.QuanLyDatBanNhaHang.demo.service.BanAnService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller cho BanAn.
 * RESTful endpoints: GET, POST, PUT, DELETE.
 */
@RestController
@RequestMapping("/api/v1/ban-an")
@RequiredArgsConstructor
public class BanAnController {

    private final BanAnService banAnService;

    /**
     * GET /api/v1/ban-an - Lấy tất cả bàn ăn.
     */
    @GetMapping
    public ResponseEntity<List<BanAnResponseDTO>> getAll() {
        List<BanAnResponseDTO> result = banAnService.getAll();
        return ResponseEntity.ok(result);
    }

    /**
     * GET /api/v1/ban-an/{maBan} - Lấy bàn ăn theo ID.
     */
    @GetMapping("/{maBan}")
    public ResponseEntity<BanAnResponseDTO> getById(@PathVariable String maBan) {
        BanAnResponseDTO result = banAnService.getById(maBan);
        return ResponseEntity.ok(result);
    }

    /**
     * GET /api/v1/ban-an/by-trang-thai - Lấy bàn ăn theo trạng thái.
     */
    @GetMapping("/by-trang-thai")
    public ResponseEntity<List<BanAnResponseDTO>> getByTrangThai(
            @RequestParam String trangThai) {
        List<BanAnResponseDTO> result = banAnService.getByTrangThai(trangThai);
        return ResponseEntity.ok(result);
    }

    /**
     * GET /api/v1/ban-an/by-khu-vuc - Lấy bàn ăn theo khu vực.
     */
    @GetMapping("/by-khu-vuc")
    public ResponseEntity<List<BanAnResponseDTO>> getByKhuVuc(
            @RequestParam String maKhuVuc) {
        List<BanAnResponseDTO> result = banAnService.getByKhuVuc(maKhuVuc);
        return ResponseEntity.ok(result);
    }

    /**
     * POST /api/v1/ban-an - Tạo bàn ăn mới.
     */
    @PostMapping
    public ResponseEntity<BanAnResponseDTO> create(@RequestBody BanAnRequestDTO dto) {
        BanAnResponseDTO result = banAnService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    /**
     * PUT /api/v1/ban-an/{maBan} - Cập nhật bàn ăn.
     */
    @PutMapping("/{maBan}")
    public ResponseEntity<BanAnResponseDTO> update(
            @PathVariable String maBan,
            @RequestBody BanAnRequestDTO dto) {
        BanAnResponseDTO result = banAnService.update(maBan, dto);
        return ResponseEntity.ok(result);
    }

    /**
     * DELETE /api/v1/ban-an/{maBan} - Xóa bàn ăn.
     */
    @DeleteMapping("/{maBan}")
    public ResponseEntity<Void> delete(@PathVariable String maBan) {
        banAnService.delete(maBan);
        return ResponseEntity.noContent().build();
    }
}

