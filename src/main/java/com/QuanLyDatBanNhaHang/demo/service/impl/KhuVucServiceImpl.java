package com.QuanLyDatBanNhaHang.demo.service.impl;

import com.QuanLyDatBanNhaHang.demo.dto.request.KhuVucRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.request.KhuVucUpdateRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.response.KhuVucResponseDTO;
import com.QuanLyDatBanNhaHang.demo.entity.KhuVuc;
import com.QuanLyDatBanNhaHang.demo.repository.KhuVucRepository;
import com.QuanLyDatBanNhaHang.demo.service.KhuVucService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class KhuVucServiceImpl implements KhuVucService {

    private final KhuVucRepository khuVucRepository;

    @Override
    public List<KhuVucResponseDTO> getAll() {
        return khuVucRepository.findAllWithRelations().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<KhuVucResponseDTO> getById(String maKhuVuc) {
        return khuVucRepository.findByIdWithRelations(maKhuVuc)
                .map(this::convertToDTO);
    }

    @Override
    @Transactional
    public KhuVucResponseDTO create(KhuVucRequestDTO dto) {
        KhuVuc khuVuc = KhuVuc.builder()
                .maKhuVuc(dto.getMaKhuVuc())
                .tenKhuVuc(dto.getTenKhuVuc())
                .build();
        KhuVuc saved = khuVucRepository.save(khuVuc);
        return convertToDTO(saved);
    }

    @Override
    @Transactional
    public Optional<KhuVucResponseDTO> update(String maKhuVuc, KhuVucUpdateRequestDTO dto) {
        return khuVucRepository.findById(maKhuVuc).map(khuVuc -> {
            khuVuc.setTenKhuVuc(dto.getTenKhuVuc());
            KhuVuc updated = khuVucRepository.save(khuVuc);
            return convertToDTO(updated);
        });
    }

    @Override
    @Transactional
    public void delete(String maKhuVuc) {
        khuVucRepository.deleteById(maKhuVuc);
    }

    private KhuVucResponseDTO convertToDTO(KhuVuc khuVuc) {
        return KhuVucResponseDTO.builder()
                .maKhuVuc(khuVuc.getMaKhuVuc())
                .tenKhuVuc(khuVuc.getTenKhuVuc())
                .build();
    }
}

