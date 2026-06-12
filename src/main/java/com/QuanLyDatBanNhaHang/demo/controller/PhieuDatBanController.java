package com.QuanLyDatBanNhaHang.demo.controller;

import com.QuanLyDatBanNhaHang.demo.dto.response.PhieuDatBanDTO;
import com.QuanLyDatBanNhaHang.demo.service.PhieuDatBanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller cho Phiếu Đặt Bàn.
 *
 * Trách nhiệm:
 * - Nhận request từ client
 * - Gọi Service để lấy dữ liệu (đã là DTO, an toàn)
 * - Trả JSON response (tự động qua Spring's @RestController)
 *
 * Điểm quan trọng:
 * - Trả DTO, không trả Entity (tránh StackOverflow nếu có recursion)
 * - Service đã xử lý N+1 query bằng JOIN FETCH
 * - JSON serialize DTO (plain object) không gây issue
 */
@RestController
@RequestMapping("/api/v1/phieu-dat-ban")
@RequiredArgsConstructor
public class PhieuDatBanController {

    private final PhieuDatBanService phieuDatBanService;

    /**
     * GET /api/v1/phieu-dat-ban
     *
     * Lấy danh sách tất cả phiếu đặt bàn.
     *
     * Luồng:
     * 1. Controller gọi service.getAllPhieuDatBan()
     * 2. Service gọi repository.findAllWithRelations() (JOIN FETCH - 1 query)
     * 3. Service chuyển Entity -> DTO
     * 4. Controller trả list DTO dạng JSON
     *
     * @return ResponseEntity chứa list DTO
     */
    @GetMapping
    public ResponseEntity<List<PhieuDatBanDTO>> getAllPhieuDatBan() {
        List<PhieuDatBanDTO> phieus = phieuDatBanService.getAllPhieuDatBan();
        return ResponseEntity.ok(phieus);
    }

    /**
     * GET /api/v1/phieu-dat-ban/{maPhieuDat}
     *
     * Lấy chi tiết một phiếu đặt bàn theo ID.
     *
     * @param maPhieuDat ID phiếu
     * @return ResponseEntity chứa DTO phiếu (hoặc 404 nếu không tồn tại)
     */
    @GetMapping("/{maPhieuDat}")
    public ResponseEntity<PhieuDatBanDTO> getPhieuDatBanById(
            @PathVariable String maPhieuDat) {
        return phieuDatBanService.getPhieuDatBanById(maPhieuDat)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * GET /api/v1/phieu-dat-ban/khach-hang/{maKH}
     *
     * Lấy danh sách phiếu của một khách hàng cụ thể.
     *
     * @param maKH ID khách hàng
     * @return ResponseEntity chứa list DTO phiếu
     */
    @GetMapping("/khach-hang/{maKH}")
    public ResponseEntity<List<PhieuDatBanDTO>> getPhieuByKhachHang(
            @PathVariable String maKH) {
        List<PhieuDatBanDTO> phieus = phieuDatBanService.getPhieuByKhachHang(maKH);
        return ResponseEntity.ok(phieus);
    }

    /**
     * GET /api/v1/phieu-dat-ban/pending
     *
     * Lấy danh sách phiếu đang chờ (DANG_CHO, DANG_SU_DUNG).
     * Trường hợp: chuẩn bị lập hóa đơn.
     *
     * @return ResponseEntity chứa list DTO phiếu chờ
     */
    @GetMapping("/pending")
    public ResponseEntity<List<PhieuDatBanDTO>> getPendingPhieuDatBan() {
        List<PhieuDatBanDTO> phieus = phieuDatBanService.getPendingPhieuDatBan();
        return ResponseEntity.ok(phieus);
    }
}

