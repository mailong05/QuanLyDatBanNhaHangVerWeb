package com.QuanLyDatBanNhaHang.demo.service;

import com.QuanLyDatBanNhaHang.demo.dto.request.ThueCreateRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.request.ThueUpdateRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.response.ThueResponseDTO;
import com.QuanLyDatBanNhaHang.demo.entity.Thue;
import com.QuanLyDatBanNhaHang.demo.repository.ThueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ThueService {

    private final ThueRepository thueRepository;

    public List<ThueResponseDTO> getAllThue() {
        return thueRepository.findAll().stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    public ThueResponseDTO getThueById(String maThue) {
        Thue thue = thueRepository.findById(maThue)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy Thuế với mã: " + maThue));
        return convertToResponseDTO(thue);
    }

    public ThueResponseDTO createThue(ThueCreateRequestDTO requestDTO) {
        Thue thue = Thue.builder()
                .maThue(requestDTO.getMaThue())
                .tenThue(requestDTO.getTenThue())
                .thueSuat(requestDTO.getThueSuat())
                .trangThai(requestDTO.getTrangThai())
                .build();

        Thue saved = thueRepository.save(thue);
        return convertToResponseDTO(saved);
    }

    public ThueResponseDTO updateThue(String maThue, ThueUpdateRequestDTO requestDTO) {
        Thue thue = thueRepository.findById(maThue)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy Thuế với mã: " + maThue));

        thue.setTenThue(requestDTO.getTenThue());
        thue.setThueSuat(requestDTO.getThueSuat());
        thue.setTrangThai(requestDTO.getTrangThai());

        Thue updated = thueRepository.save(thue);
        return convertToResponseDTO(updated);
    }

    public void deleteThue(String maThue) {
        thueRepository.deleteById(maThue);
    }

    private ThueResponseDTO convertToResponseDTO(Thue thue) {
        return ThueResponseDTO.builder()
                .maThue(thue.getMaThue())
                .tenThue(thue.getTenThue())
                .thueSuat(thue.getThueSuat())
                .trangThai(thue.getTrangThai())
                .build();
    }
}
