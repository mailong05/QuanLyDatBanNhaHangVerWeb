package com.QuanLyDatBanNhaHang.demo.service.impl;

import com.QuanLyDatBanNhaHang.demo.dto.request.BanAnRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.response.BanAnResponseDTO;
import com.QuanLyDatBanNhaHang.demo.entity.BanAn;
import com.QuanLyDatBanNhaHang.demo.entity.KhuVuc;
import com.QuanLyDatBanNhaHang.demo.repository.BanAnRepository;
import com.QuanLyDatBanNhaHang.demo.repository.KhuVucRepository;
import com.QuanLyDatBanNhaHang.demo.service.BanAnService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service Implementation cho BanAn.
 * Xử lý logic nghiệp vụ + Mapping Entity <-> DTO.
 */
@Service
@RequiredArgsConstructor
@Transactional
public class BanAnServiceImpl implements BanAnService {

    private final BanAnRepository banAnRepository;
    private final KhuVucRepository khuVucRepository;

    @Override
    @Transactional(readOnly = true)
    public List<BanAnResponseDTO> getAll() {
        return banAnRepository.findAllWithRelations()
                .stream()
                .map(this::mapEntityToDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public BanAnResponseDTO getById(String maBan) {
        BanAn banAn = banAnRepository.findByIdWithRelations(maBan)
                .orElseThrow(() -> new RuntimeException("Bàn ăn không tồn tại: " + maBan));
        return mapEntityToDTO(banAn);
    }

    @Override
    public BanAnResponseDTO create(BanAnRequestDTO dto) {
        // Kiểm tra KhuVuc có tồn tại không
        KhuVuc khuVuc = null;
        if (dto.getMaKhuVuc() != null) {
            khuVuc = khuVucRepository.findById(dto.getMaKhuVuc())
                    .orElseThrow(() -> new RuntimeException("Khu vực không tồn tại: " + dto.getMaKhuVuc()));
        }

        BanAn banAn = BanAn.builder()
                .maBan(dto.getMaBan())
                .soGhe(dto.getSoGhe())
                .viTri(dto.getViTri())
                .trangThai(dto.getTrangThai())
                .khuVuc(khuVuc)
                .build();

        banAn = banAnRepository.save(banAn);
        return mapEntityToDTO(banAn);
    }

    @Override
    public BanAnResponseDTO update(String maBan, BanAnRequestDTO dto) {
        BanAn banAn = banAnRepository.findById(maBan)
                .orElseThrow(() -> new RuntimeException("Bàn ăn không tồn tại: " + maBan));

        banAn.setSoGhe(dto.getSoGhe());
        banAn.setViTri(dto.getViTri());
        banAn.setTrangThai(dto.getTrangThai());

        if (dto.getMaKhuVuc() != null) {
            KhuVuc khuVuc = khuVucRepository.findById(dto.getMaKhuVuc())
                    .orElseThrow(() -> new RuntimeException("Khu vực không tồn tại: " + dto.getMaKhuVuc()));
            banAn.setKhuVuc(khuVuc);
        }

        banAn = banAnRepository.save(banAn);
        return mapEntityToDTO(banAn);
    }

    @Override
    public void delete(String maBan) {
        if (!banAnRepository.existsById(maBan)) {
            throw new RuntimeException("Bàn ăn không tồn tại: " + maBan);
        }
        banAnRepository.deleteById(maBan);
    }

    @Override
    @Transactional(readOnly = true)
    public List<BanAnResponseDTO> getByTrangThai(String trangThai) {
        return banAnRepository.findByTrangThaiWithRelations(trangThai)
                .stream()
                .map(this::mapEntityToDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<BanAnResponseDTO> getByKhuVuc(String maKhuVuc) {
        return banAnRepository.findByKhuVucWithRelations(maKhuVuc)
                .stream()
                .map(this::mapEntityToDTO)
                .collect(Collectors.toList());
    }

    /**
     * Chuyển đổi Entity BanAn sang DTO Response.
     */
    private BanAnResponseDTO mapEntityToDTO(BanAn banAn) {
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

