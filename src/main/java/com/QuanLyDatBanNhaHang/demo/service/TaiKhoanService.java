package com.QuanLyDatBanNhaHang.demo.service;

import com.QuanLyDatBanNhaHang.demo.dto.request.TaiKhoanRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.response.TaiKhoanResponseDTO;

import java.util.List;
import java.util.Optional;

public interface TaiKhoanService {
    List<TaiKhoanResponseDTO> getAll();
    Optional<TaiKhoanResponseDTO> getById(String username);
    TaiKhoanResponseDTO create(TaiKhoanRequestDTO requestDTO);
    Optional<TaiKhoanResponseDTO> update(String username, TaiKhoanRequestDTO requestDTO);
    void delete(String username);
}
