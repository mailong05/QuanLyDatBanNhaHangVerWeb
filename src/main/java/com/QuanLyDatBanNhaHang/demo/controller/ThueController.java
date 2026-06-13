package com.QuanLyDatBanNhaHang.demo.controller;

import com.QuanLyDatBanNhaHang.demo.dto.request.ThueCreateRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.request.ThueUpdateRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.response.ThueResponseDTO;
import com.QuanLyDatBanNhaHang.demo.service.ThueService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/thue")
@RequiredArgsConstructor
public class ThueController {

    private final ThueService thueService;

    @GetMapping
    public ResponseEntity<List<ThueResponseDTO>> getAllThue() {
        return ResponseEntity.ok(thueService.getAllThue());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ThueResponseDTO> getThueById(@PathVariable String id) {
        return ResponseEntity.ok(thueService.getThueById(id));
    }

    @PostMapping
    public ResponseEntity<ThueResponseDTO> createThue(@Valid @RequestBody ThueCreateRequestDTO requestDTO) {
        return new ResponseEntity<>(thueService.createThue(requestDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ThueResponseDTO> updateThue(@PathVariable String id, @Valid @RequestBody ThueUpdateRequestDTO requestDTO) {
        return ResponseEntity.ok(thueService.updateThue(id, requestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteThue(@PathVariable String id) {
        thueService.deleteThue(id);
        return ResponseEntity.noContent().build();
    }
}
