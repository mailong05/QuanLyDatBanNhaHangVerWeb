package com.QuanLyDatBanNhaHang.demo.controller;

import com.QuanLyDatBanNhaHang.demo.dto.request.ThueCreateRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.request.ThueUpdateRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.response.ThueResponseDTO;
import com.QuanLyDatBanNhaHang.demo.service.ThueService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/thue")
@RequiredArgsConstructor
public class ThueController {

    private final ThueService thueService;

    @GetMapping
    public ResponseEntity<Page<ThueResponseDTO>> getAllThue(Pageable pageable) {
        return ResponseEntity.ok(thueService.getAllThue(pageable));
    }

    @GetMapping("/{maThue}")
    public ResponseEntity<ThueResponseDTO> getThueById(@PathVariable String maThue) {
        return ResponseEntity.ok(thueService.getThueByMa(maThue));
    }

    @PostMapping
    public ResponseEntity<ThueResponseDTO> createThue(@Valid @RequestBody ThueCreateRequestDTO requestDTO) {
        return new ResponseEntity<>(thueService.createThue(requestDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{maThue}")
    public ResponseEntity<ThueResponseDTO> updateThue(@PathVariable String maThue, @Valid @RequestBody ThueUpdateRequestDTO requestDTO) {
        return ResponseEntity.ok(thueService.updateThue(maThue, requestDTO));
    }

    @DeleteMapping("/{maThue}")
    public ResponseEntity<Void> deleteThue(@PathVariable String maThue) {
        thueService.deleteThue(maThue);
        return ResponseEntity.noContent().build();
    }
}
