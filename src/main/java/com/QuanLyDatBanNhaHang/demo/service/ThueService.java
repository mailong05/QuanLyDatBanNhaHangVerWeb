package com.QuanLyDatBanNhaHang.demo.service;

import com.QuanLyDatBanNhaHang.demo.dto.request.ThueCreateRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.request.ThueUpdateRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.response.ThueResponseDTO;
import java.util.List;
import java.util.stream.Collectors;

public interface ThueService {
    List<ThueResponseDTO> getAllThue();
    ThueResponseDTO getThueById(String maThue);
    ThueResponseDTO createThue(ThueCreateRequestDTO requestDTO);
    ThueResponseDTO updateThue(String maThue, ThueUpdateRequestDTO requestDTO);
    void deleteThue(String maThue);
}
