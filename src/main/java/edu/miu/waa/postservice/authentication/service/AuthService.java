package edu.miu.waa.postservice.authentication.service;

import edu.miu.waa.postservice.authentication.dto.request.LoginRequest;
import edu.miu.waa.postservice.authentication.dto.request.RefreshTokenRequest;
import edu.miu.waa.postservice.authentication.dto.response.LoginResponse;

public interface AuthService {
    LoginResponse login(LoginRequest loginRequest);

    LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
