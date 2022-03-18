package pl.lagodka.shop.cotroller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.lagodka.shop.model.dto.LoginDto;
import pl.lagodka.shop.model.dto.TokenDto;
import pl.lagodka.shop.service.LoginService;

@RestController
@RequestMapping(value = "/api/login", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class LoginController {
    private final LoginService loginService;

    @PostMapping
    public TokenDto login(@RequestBody LoginDto loginDto){
        return loginService.login(loginDto);
    }
}
