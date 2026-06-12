package com.QuanLyDatBanNhaHang.demo.service.impl;

import com.QuanLyDatBanNhaHang.demo.dto.request.ThueRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.response.ThueResponseDTO;
import com.QuanLyDatBanNhaHang.demo.entity.Thue;
import com.QuanLyDatBanNhaHang.demo.repository.ThueRepository;
import com.QuanLyDatBanNhaHang.demo.service.ThueService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ThueServiceImpl implements ThueService {

    private final ThueRepository thueRepository;

    @Override
    public List<ThueResponseDTO> getAll() {
        return thueRepository.findAllWithRelations().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ThueResponseDTO> getById(String maThue) {
        return thueRepository.findByIdWithRelations(maThue)
                .map(this::convertToDTO);
    }

    @Override
    @Transactional
    public ThueResponseDTO create(ThueRequestDTO dto) {
        Thue thue = Thue.builder()
                .maThue(dto.getMaThue())
                .tenThue(dto.getTenThue())
                .thueSuat(dto.getThueSuat())
                .trangThai(dto.getTrangThai())
                .build();
        Thue saved = thueRepository.save(thue);
        return convertToDTO(saved);
    }

    @Override
    @Transactional
    public Optional<ThueResponseDTO> update(String maThue, ThueRequestDTO dto) {
        return thueRepository.findById(maThue).map(thue -> {
            thue.setTenThue(dto.getTenThue());
            thue.setThueSuat(dto.getThueSuat());
            thue.setTrangThai(dto.getTrangThai());
            Thue updated = thueRepository.save(thue);
            return convertToDTO(updated);
        });
    }

    @Override
    @Transactional
    public void delete(String maThue) {
        thueRepository.deleteById(maThue);
    }

    @Override
    public List<ThueResponseDTO> getByTrangThai(String trangThai) {
        return thueRepository.findByTrangThai(trangThai).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private ThueResponseDTO convertToDTO(Thue thue) {
        return ThueResponseDTO.builder()
                .maThue(thue.getMaThue())
                .tenThue(thue.getTenThue())
                .thueSuat(thue.getThueSuat())
                .trangThai(thue.getTrangThai())
                .build();
    }
}

