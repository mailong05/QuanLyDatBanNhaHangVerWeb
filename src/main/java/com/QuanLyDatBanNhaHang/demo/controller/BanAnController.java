package com.QuanLyDatBanNhaHang.demo.controller;

import com.QuanLyDatBanNhaHang.demo.dto.request.BanAnCreateRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.request.BanAnUpdateRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.response.BanAnResponseDTO;
import com.QuanLyDatBanNhaHang.demo.service.BanAnService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/ban-an")
@RequiredArgsConstructor
public class BanAnController {

    private final BanAnService banAnService;

    @GetMapping
    public ResponseEntity<Page<BanAnResponseDTO>> getAllBanAn(Pageable pageable) {
        return ResponseEntity.ok(banAnService.getAllBanAn(pageable));
    }

    @GetMapping("/{maBan}")
    public ResponseEntity<BanAnResponseDTO> getBanAnById(@PathVariable String maBan) {
        return ResponseEntity.ok(banAnService.getBanAnByMa(maBan));
    }

    @PostMapping
    public ResponseEntity<BanAnResponseDTO> createBanAn(@Valid @RequestBody BanAnCreateRequestDTO requestDTO) {
        return new ResponseEntity<>(banAnService.createBanAn(requestDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{maBan}")
    public ResponseEntity<BanAnResponseDTO> updateBanAn(@PathVariable String maBan, @Valid @RequestBody BanAnUpdateRequestDTO requestDTO) {
        return ResponseEntity.ok(banAnService.updateBanAn(maBan, requestDTO));
    }

    @DeleteMapping("/{maBan}")
    public ResponseEntity<Void> deleteBanAn(@PathVariable String maBan) {
        banAnService.deleteBanAn(maBan);
        return ResponseEntity.noContent().build();
    }
}
