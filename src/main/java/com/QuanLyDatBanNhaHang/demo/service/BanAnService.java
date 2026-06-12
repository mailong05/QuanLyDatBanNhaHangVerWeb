package com.QuanLyDatBanNhaHang.demo.service;

import com.QuanLyDatBanNhaHang.demo.dto.request.BanAnRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.response.BanAnResponseDTO;

import java.util.List;

/**
 * Service Interface cho BanAn.
 * Định nghĩa các contract CRUD operation.
 */
public interface BanAnService {

    /**
     * Lấy tất cả bàn ăn.
     */
    List<BanAnResponseDTO> getAll();

    /**
     * Lấy bàn ăn theo ID.
     * @throws RuntimeException nếu không tìm thấy
     */
    BanAnResponseDTO getById(String maBan);

    /**
     * Tạo bàn ăn mới.
     */
    BanAnResponseDTO create(BanAnRequestDTO dto);

    /**
     * Cập nhật bàn ăn.
     * @throws RuntimeException nếu không tìm thấy
     */
    BanAnResponseDTO update(String maBan, BanAnRequestDTO dto);

    /**
     * Xóa bàn ăn.
     * @throws RuntimeException nếu không tìm thấy
     */
    void delete(String maBan);

    /**
     * Lấy bàn ăn theo trạng thái.
     */
    List<BanAnResponseDTO> getByTrangThai(String trangThai);

    /**
     * Lấy bàn ăn của một khu vực.
     */
    List<BanAnResponseDTO> getByKhuVuc(String maKhuVuc);
}

