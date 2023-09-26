package fastcampus.projectboard.controller;

import fastcampus.projectboard.config.SecurityConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@DisplayName("View 컨트롤러 - 인증")
@Import(SecurityConfig.class) //동일한 환경에서 테스트를위해 Import 설정
@WebMvcTest
public class AuthControllerTest {
    private  final MockMvc mvc;
    public AuthControllerTest(@Autowired MockMvc mvc) {this.mvc = mvc;}

    @DisplayName("[View] [GET] 로그인페이지 - 정상 호출")
    @Test
    public void givenNothing_whenTryingtoLogin_thenReturnLoginView() throws Exception {
        //Given
        //When & Then
        mvc.perform(get("/login")) //get stack
                .andExpect(status().isOk()) //200 Ok
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML));
    }
    //springsecurity로 가능하다.
}
