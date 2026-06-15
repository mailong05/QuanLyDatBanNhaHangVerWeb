package com.QuanLyDatBanNhaHang.demo.service;

import com.QuanLyDatBanNhaHang.demo.dto.request.MonAnCreateRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.request.MonAnUpdateRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.response.MonAnResponseDTO;
import java.util.List;
import java.util.stream.Collectors;

public interface MonAnService {
    List<MonAnResponseDTO> getAllMonAn();
    MonAnResponseDTO getMonAnById(String maMon);
    MonAnResponseDTO createMonAn(MonAnCreateRequestDTO requestDTO);
    MonAnResponseDTO updateMonAn(String maMon, MonAnUpdateRequestDTO requestDTO);
    void deleteMonAn(String maMon);
}
