package com.QuanLyDatBanNhaHang.demo.service.impl;

import com.QuanLyDatBanNhaHang.demo.service.KhuVucService;

import com.QuanLyDatBanNhaHang.demo.dto.request.KhuVucCreateRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.request.KhuVucUpdateRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.response.KhuVucResponseDTO;
import com.QuanLyDatBanNhaHang.demo.entity.KhuVuc;
import com.QuanLyDatBanNhaHang.demo.repository.KhuVucRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import com.QuanLyDatBanNhaHang.demo.exception.ResourceNotFoundException;

@Service
@RequiredArgsConstructor
public class KhuVucServiceImpl implements KhuVucService {

    private final KhuVucRepository khuVucRepository;

    public List<KhuVucResponseDTO> getAllKhuVuc() {
        return khuVucRepository.findAll().stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    public KhuVucResponseDTO getKhuVucById(String maKhuVuc) {
        KhuVuc khuVuc = khuVucRepository.findByMaKhuVucIgnoreCase(maKhuVuc)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy Khu Vực với mã: " + maKhuVuc));
        return convertToResponseDTO(khuVuc);
    }

    public KhuVucResponseDTO createKhuVuc(KhuVucCreateRequestDTO requestDTO) {
        KhuVuc khuVuc = KhuVuc.builder()
                .maKhuVuc(requestDTO.getMaKhuVuc())
                .tenKhuVuc(requestDTO.getTenKhuVuc())
                .build();

        KhuVuc saved = khuVucRepository.save(khuVuc);
        return convertToResponseDTO(saved);
    }

    public KhuVucResponseDTO updateKhuVuc(String maKhuVuc, KhuVucUpdateRequestDTO requestDTO) {
        KhuVuc khuVuc = khuVucRepository.findByMaKhuVucIgnoreCase(maKhuVuc)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy Khu Vực với mã: " + maKhuVuc));

        khuVuc.setTenKhuVuc(requestDTO.getTenKhuVuc());

        KhuVuc updated = khuVucRepository.save(khuVuc);
        return convertToResponseDTO(updated);
    }

    public void deleteKhuVuc(String maKhuVuc) {
        KhuVuc khuVuc = khuVucRepository.findByMaKhuVucIgnoreCase(maKhuVuc).orElseThrow(() -> new ResourceNotFoundException("Khong tim thay"));
        khuVucRepository.delete(khuVuc);
    }

    private KhuVucResponseDTO convertToResponseDTO(KhuVuc khuVuc) {
        return KhuVucResponseDTO.builder()
                .maKhuVuc(khuVuc.getMaKhuVuc())
                .tenKhuVuc(khuVuc.getTenKhuVuc())
                .build();
    }
}
