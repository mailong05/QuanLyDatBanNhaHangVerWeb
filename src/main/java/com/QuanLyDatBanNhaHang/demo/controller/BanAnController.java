package com.QuanLyDatBanNhaHang.demo.controller;

import com.QuanLyDatBanNhaHang.demo.dto.request.BanAnCreateRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.request.BanAnUpdateRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.response.BanAnResponseDTO;
import com.QuanLyDatBanNhaHang.demo.service.BanAnService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/ban-an")
@RequiredArgsConstructor
public class BanAnController {

    private final BanAnService banAnService;

    @GetMapping
    public ResponseEntity<List<BanAnResponseDTO>> getAllBanAn() {
        return ResponseEntity.ok(banAnService.getAllBanAn());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BanAnResponseDTO> getBanAnById(@PathVariable String id) {
        return ResponseEntity.ok(banAnService.getBanAnById(id));
    }

    @PostMapping
    public ResponseEntity<BanAnResponseDTO> createBanAn(@Valid @RequestBody BanAnCreateRequestDTO requestDTO) {
        return new ResponseEntity<>(banAnService.createBanAn(requestDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BanAnResponseDTO> updateBanAn(@PathVariable String id, @Valid @RequestBody BanAnUpdateRequestDTO requestDTO) {
        return ResponseEntity.ok(banAnService.updateBanAn(id, requestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBanAn(@PathVariable String id) {
        banAnService.deleteBanAn(id);
        return ResponseEntity.noContent().build();
    }
}
