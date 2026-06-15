package com.QuanLyDatBanNhaHang.demo.service.impl;

import com.QuanLyDatBanNhaHang.demo.service.BanAnService;

import com.QuanLyDatBanNhaHang.demo.dto.request.BanAnCreateRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.request.BanAnUpdateRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.response.BanAnResponseDTO;
import com.QuanLyDatBanNhaHang.demo.entity.BanAn;
import com.QuanLyDatBanNhaHang.demo.entity.KhuVuc;
import com.QuanLyDatBanNhaHang.demo.exception.ResourceNotFoundException;
import com.QuanLyDatBanNhaHang.demo.repository.BanAnRepository;
import com.QuanLyDatBanNhaHang.demo.repository.KhuVucRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BanAnServiceImpl implements BanAnService {

    private final BanAnRepository banAnRepository;
    private final KhuVucRepository khuVucRepository;

    public List<BanAnResponseDTO> getAllBanAn() {
        List<BanAn> banAns = banAnRepository.findAllWithRelations();
        return banAns.stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    public BanAnResponseDTO getBanAnById(String maBan) {
        BanAn banAn = banAnRepository.findByMaBanIgnoreCase(maBan)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy Bàn Ăn với mã: " + maBan));
        return convertToResponseDTO(banAn);
    }

    public BanAnResponseDTO createBanAn(BanAnCreateRequestDTO requestDTO) {
        KhuVuc khuVuc = khuVucRepository.findById(requestDTO.getMaKhuVuc())
                .orElseThrow(() -> new ResourceNotFoundException("Khu vực không tồn tại"));

        BanAn banAn = BanAn.builder()
                .maBan(requestDTO.getMaBan())
                .soGhe(requestDTO.getSoGhe())
                .viTri(requestDTO.getViTri())
                .trangThai(requestDTO.getTrangThai())
                .khuVuc(khuVuc)
                .build();

        BanAn saved = banAnRepository.save(banAn);
        return convertToResponseDTO(saved);
    }

    public BanAnResponseDTO updateBanAn(String maBan, BanAnUpdateRequestDTO requestDTO) {
        BanAn banAn = banAnRepository.findByMaBanIgnoreCase(maBan)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy Bàn Ăn với mã: " + maBan));

        KhuVuc khuVuc = khuVucRepository.findById(requestDTO.getMaKhuVuc())
                .orElseThrow(() -> new ResourceNotFoundException("Khu vực không tồn tại"));

        banAn.setSoGhe(requestDTO.getSoGhe());
        banAn.setViTri(requestDTO.getViTri());
        banAn.setTrangThai(requestDTO.getTrangThai());
        banAn.setKhuVuc(khuVuc);

        BanAn updated = banAnRepository.save(banAn);
        return convertToResponseDTO(updated);
    }

    public void deleteBanAn(String maBan) {
        banAnRepository.deleteById(maBan);
    }

    private BanAnResponseDTO convertToResponseDTO(BanAn banAn) {
        return BanAnResponseDTO.builder()
                .maBan(banAn.getMaBan())
                .soGhe(banAn.getSoGhe())
                .viTri(banAn.getViTri())
                .trangThai(banAn.getTrangThai())
                .maKhuVuc(banAn.getKhuVuc() != null ? banAn.getKhuVuc().getMaKhuVuc() : null)
                .tenKhuVuc(banAn.getKhuVuc() != null ? banAn.getKhuVuc().getTenKhuVuc() : null)
                .build();
    }
}
