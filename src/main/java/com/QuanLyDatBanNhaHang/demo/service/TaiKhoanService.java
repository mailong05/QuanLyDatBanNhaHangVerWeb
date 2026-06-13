package com.QuanLyDatBanNhaHang.demo.service;

import com.QuanLyDatBanNhaHang.demo.dto.request.TaiKhoanCreateRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.request.TaiKhoanUpdateRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.response.TaiKhoanResponseDTO;
import com.QuanLyDatBanNhaHang.demo.entity.NhanVien;
import com.QuanLyDatBanNhaHang.demo.entity.TaiKhoan;
import com.QuanLyDatBanNhaHang.demo.repository.NhanVienRepository;
import com.QuanLyDatBanNhaHang.demo.repository.TaiKhoanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaiKhoanService {

    private final TaiKhoanRepository taiKhoanRepository;
    private final NhanVienRepository nhanVienRepository;

    public List<TaiKhoanResponseDTO> getAllTaiKhoan() {
        List<TaiKhoan> taiKhoans = taiKhoanRepository.findAllWithRelations();
        return taiKhoans.stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    public TaiKhoanResponseDTO getTaiKhoanById(String username) {
        TaiKhoan taiKhoan = taiKhoanRepository.findById(username)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy Tài Khoản với Username: " + username));
        return convertToResponseDTO(taiKhoan);
    }

    public TaiKhoanResponseDTO createTaiKhoan(TaiKhoanCreateRequestDTO requestDTO) {
        NhanVien nhanVien = nhanVienRepository.findById(requestDTO.getMaNV())
                .orElseThrow(() -> new RuntimeException("Nhân viên không tồn tại"));

        // Normally you would hash the password here using BCrypt or similar
        // String hashedPassword = passwordEncoder.encode(requestDTO.getPassword());
        
        TaiKhoan taiKhoan = TaiKhoan.builder()
                .username(requestDTO.getUsername())
                .password(requestDTO.getPassword()) // Use hashed password in real app
                .quyenHan(requestDTO.getQuyenHan())
                .nhanVien(nhanVien)
                .build();

        TaiKhoan saved = taiKhoanRepository.save(taiKhoan);
        return convertToResponseDTO(saved);
    }

    public TaiKhoanResponseDTO updateTaiKhoan(String username, TaiKhoanUpdateRequestDTO requestDTO) {
        TaiKhoan taiKhoan = taiKhoanRepository.findById(username)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy Tài Khoản với Username: " + username));

        NhanVien nhanVien = nhanVienRepository.findById(requestDTO.getMaNV())
                .orElseThrow(() -> new RuntimeException("Nhân viên không tồn tại"));

        taiKhoan.setQuyenHan(requestDTO.getQuyenHan());
        taiKhoan.setNhanVien(nhanVien);

        if (requestDTO.getPassword() != null && !requestDTO.getPassword().isEmpty()) {
            taiKhoan.setPassword(requestDTO.getPassword()); // Hash it if needed
        }

        TaiKhoan updated = taiKhoanRepository.save(taiKhoan);
        return convertToResponseDTO(updated);
    }

    public void deleteTaiKhoan(String username) {
        taiKhoanRepository.deleteById(username);
    }

    private TaiKhoanResponseDTO convertToResponseDTO(TaiKhoan taiKhoan) {
        return TaiKhoanResponseDTO.builder()
                .username(taiKhoan.getUsername())
                .quyenHan(taiKhoan.getQuyenHan())
                .maNV(taiKhoan.getNhanVien() != null ? taiKhoan.getNhanVien().getMaNV() : null)
                .tenNV(taiKhoan.getNhanVien() != null ? taiKhoan.getNhanVien().getHoTen() : null)
                .build();
    }
}
