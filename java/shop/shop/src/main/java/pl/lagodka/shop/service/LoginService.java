package pl.lagodka.shop.service;

import pl.lagodka.shop.model.dto.LoginDto;
import pl.lagodka.shop.model.dto.TokenDto;

public interface LoginService {
    TokenDto login(LoginDto loginDto);
}
