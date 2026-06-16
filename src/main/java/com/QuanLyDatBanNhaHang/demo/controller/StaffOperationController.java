package com.QuanLyDatBanNhaHang.demo.controller;

import com.QuanLyDatBanNhaHang.demo.dto.request.ChangeTableRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.request.MergeTableRequestDTO;
import com.QuanLyDatBanNhaHang.demo.service.StaffOperationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/staff/orders")
@RequiredArgsConstructor
public class StaffOperationController {

    private final StaffOperationService staffOperationService;

    @PostMapping("/{id}/change-table")
    public ResponseEntity<?> changeTable(@PathVariable Long id, @Valid @RequestBody ChangeTableRequestDTO request) {
        staffOperationService.changeTable(id, request);
        return ResponseEntity.ok("Đổi bàn thành công!");
    }

    @PostMapping("/{id}/merge-tables")
    public ResponseEntity<?> mergeTables(@PathVariable Long id, @Valid @RequestBody MergeTableRequestDTO request) {
        staffOperationService.mergeTables(id, request);
        return ResponseEntity.ok("Gộp phiếu đặt bàn thành công!");
    }
}
