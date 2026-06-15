package com.QuanLyDatBanNhaHang.demo.service;

import com.QuanLyDatBanNhaHang.demo.dto.request.TaiKhoanCreateRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.request.TaiKhoanUpdateRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.response.TaiKhoanResponseDTO;
import java.util.List;
import java.util.stream.Collectors;

public interface TaiKhoanService {
    List<TaiKhoanResponseDTO> getAllTaiKhoan();
    TaiKhoanResponseDTO getTaiKhoanById(String username);
    TaiKhoanResponseDTO createTaiKhoan(TaiKhoanCreateRequestDTO requestDTO);
    TaiKhoanResponseDTO updateTaiKhoan(String username, TaiKhoanUpdateRequestDTO requestDTO);
    void deleteTaiKhoan(String username);
}
