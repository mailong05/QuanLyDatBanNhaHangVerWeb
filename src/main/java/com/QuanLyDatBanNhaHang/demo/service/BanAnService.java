package com.QuanLyDatBanNhaHang.demo.service;

import com.QuanLyDatBanNhaHang.demo.dto.request.BanAnCreateRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.request.BanAnUpdateRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.response.BanAnResponseDTO;
import java.util.List;
import java.util.stream.Collectors;

public interface BanAnService {
    List<BanAnResponseDTO> getAllBanAn();
    BanAnResponseDTO getBanAnById(String maBan);
    BanAnResponseDTO createBanAn(BanAnCreateRequestDTO requestDTO);
    BanAnResponseDTO updateBanAn(String maBan, BanAnUpdateRequestDTO requestDTO);
    void deleteBanAn(String maBan);
}
