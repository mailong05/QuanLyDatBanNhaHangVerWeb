package com.QuanLyDatBanNhaHang.demo.controller;

import com.QuanLyDatBanNhaHang.demo.dto.request.LoginRequestDTO;
import com.QuanLyDatBanNhaHang.demo.dto.response.JwtAuthResponseDTO;
import com.QuanLyDatBanNhaHang.demo.security.CustomUserDetails;
import com.QuanLyDatBanNhaHang.demo.security.JwtTokenProvider;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider tokenProvider;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequestDTO loginRequest) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getUsername(),
                            loginRequest.getPassword()
                    )
            );

            SecurityContextHolder.getContext().setAuthentication(authentication);

            String jwt = tokenProvider.generateToken(authentication);
            CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();

            return ResponseEntity.ok(JwtAuthResponseDTO.builder()
                    .accessToken(jwt)
                    .username(userDetails.getUsername())
                    .role(userDetails.getTaiKhoan().getQuyenHan().name())
                    .build());
        } catch (org.springframework.security.core.AuthenticationException e) {
            // Trả về 401 Unauthorized thay vì để lỗi văng ra ngoài gây 403 Forbidden
            return ResponseEntity.status(org.springframework.http.HttpStatus.UNAUTHORIZED)
                    .body("Sai tên đăng nhập hoặc mật khẩu!");
        }
    }
}
