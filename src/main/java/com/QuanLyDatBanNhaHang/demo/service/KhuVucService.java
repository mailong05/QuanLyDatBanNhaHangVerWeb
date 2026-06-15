package com.QuanLyDatBanNhaHang.demo.service;

import com.QuanLyDatBanNhaHang.demo.dto.request.KhuVucCreateRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.request.KhuVucUpdateRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.response.KhuVucResponseDTO;
import java.util.List;
import java.util.stream.Collectors;

public interface KhuVucService {
    List<KhuVucResponseDTO> getAllKhuVuc();
    KhuVucResponseDTO getKhuVucById(String maKhuVuc);
    KhuVucResponseDTO createKhuVuc(KhuVucCreateRequestDTO requestDTO);
    KhuVucResponseDTO updateKhuVuc(String maKhuVuc, KhuVucUpdateRequestDTO requestDTO);
    void deleteKhuVuc(String maKhuVuc);
}
