package com.QuanLyDatBanNhaHang.demo.service.impl;

import com.QuanLyDatBanNhaHang.demo.dto.request.KhuVucCreateRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.request.KhuVucUpdateRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.response.KhuVucResponseDTO;
import com.QuanLyDatBanNhaHang.demo.entity.KhuVuc;
import com.QuanLyDatBanNhaHang.demo.exception.DuplicateResourceException;
import com.QuanLyDatBanNhaHang.demo.exception.ResourceNotFoundException;
import com.QuanLyDatBanNhaHang.demo.repository.KhuVucRepository;
import com.QuanLyDatBanNhaHang.demo.service.KhuVucService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KhuVucServiceImpl implements KhuVucService {

    private final KhuVucRepository khuVucRepository;

    @Override
    public Page<KhuVucResponseDTO> getAllKhuVuc(Pageable pageable) {
        return khuVucRepository.findAll(pageable).map(this::convertToResponseDTO);
    }

    @Override
    public KhuVucResponseDTO getKhuVucByMa(String maKhuVuc) {
        KhuVuc kv = khuVucRepository.findByMaKhuVucIgnoreCase(maKhuVuc)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy Khu vực với mã: " + maKhuVuc));
        return convertToResponseDTO(kv);
    }

    @Override
    public KhuVucResponseDTO createKhuVuc(KhuVucCreateRequestDTO requestDTO) {

        
        KhuVuc kv = KhuVuc.builder()
                .maKhuVuc(generateNextMaKV())
                .tenKhuVuc(requestDTO.getTenKhuVuc())
                .build();
                
        return convertToResponseDTO(khuVucRepository.save(kv));
    }

    @Override
    public KhuVucResponseDTO updateKhuVuc(String maKhuVuc, KhuVucUpdateRequestDTO requestDTO) {
        KhuVuc kv = khuVucRepository.findByMaKhuVucIgnoreCase(maKhuVuc)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy Khu vực với mã: " + maKhuVuc));
                
        kv.setTenKhuVuc(requestDTO.getTenKhuVuc());
        return convertToResponseDTO(khuVucRepository.save(kv));
    }

    @Override
    public void deleteKhuVuc(String maKhuVuc) {
        KhuVuc kv = khuVucRepository.findByMaKhuVucIgnoreCase(maKhuVuc)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy Khu vực với mã: " + maKhuVuc));
        khuVucRepository.delete(kv);
    }

    private KhuVucResponseDTO convertToResponseDTO(KhuVuc kv) {
        return KhuVucResponseDTO.builder()
                .id(kv.getId())
                .maKhuVuc(kv.getMaKhuVuc())
                .tenKhuVuc(kv.getTenKhuVuc())
                .build();
    }

    private String generateNextMaKV() {
        String maxMa = khuVucRepository.findMaxMaKhuVuc();
        if (maxMa == null || maxMa.isEmpty()) {
            return String.format("KV%04d", 1);
        }
        try {
            String numberPart = maxMa.substring(2);
            int currentNum = Integer.parseInt(numberPart);
            return String.format("KV%04d", currentNum + 1);
        } catch (Exception e) {
            return String.format("KV%04d", 1);
        }
    }

    private String generateNextMaKhuVuc() {
        String maxMa = khuVucRepository.findMaxMaKhuVuc();
        if (maxMa == null || maxMa.isEmpty()) {
            return String.format("KV%02d", 1);
        }
        try {
            String numberPart = maxMa.substring(2);
            int currentNum = Integer.parseInt(numberPart);
            return String.format("KV%02d", currentNum + 1);
        } catch (Exception e) {
            return String.format("KV%02d", 1);
        }
    }
}
