package com.QuanLyDatBanNhaHang.demo.service;

import com.QuanLyDatBanNhaHang.demo.dto.response.PhieuDatBanDTO;
import java.util.List;
import java.util.Optional;

/**
 * Interface cho PhieuDatBanService.
 * Định nghĩa các hợp đồng (methods) mà implementation phải tuân theo.
 */
public interface PhieuDatBanServiceInterface {

    /**
     * Lấy tất cả phiếu đặt bàn.
     */
    List<PhieuDatBanDTO> getAllPhieuDatBan();

    /**
     * Lấy phiếu đặt bàn theo ID.
     */
    Optional<PhieuDatBanDTO> getPhieuDatBanById(String maPhieuDat);

    /**
     * Lấy danh sách phiếu của một khách hàng.
     */
    List<PhieuDatBanDTO> getPhieuByKhachHang(String maKH);

    /**
     * Lấy danh sách phiếu đang chờ.
     */
    List<PhieuDatBanDTO> getPendingPhieuDatBan();
}

