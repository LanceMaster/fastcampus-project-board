package fastcampus.projectboard.controller;

import fastcampus.projectboard.config.SecurityConfig;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@DisplayName("View 컨트롤러")
@Import(SecurityConfig.class) //securityConfig
@WebMvcTest(ArticleController.class)
//해당 컨트로러만 인식하여 족므더 가벼운상태로 가능하다.
class ArticleControllerTest {
    private  final MockMvc mvc;
    public ArticleControllerTest(@Autowired MockMvc mvc) {this.mvc = mvc;}
   //현재 build가 에러가 나서 disables를 추가
    @DisplayName("[View] [GET] 게시글 리스트(게시판 페이지) - 정상 호출")
    @Test
    public void givenNothing_whenRequestArticlesView_thenReturnArticlesView() throws Exception {
        //Given
        //When & Then
        mvc.perform(get("/articles")) //get stack
                .andExpect(status().isOk()) //200 Ok
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML))
                .andExpect(model().attributeExists("articles")) //articles라는 이름의 key가 있는지 check
                .andExpect(view().name("articles/index"));

    }

    @DisplayName("[View] [GET] 게시글 리스트 게시글 상세 페이지 - 정상 호출")
    @Test
    public void givenNothing_whenRequestArticleView_thenReturnArticleView() throws Exception {

        mvc.perform(get("/articles/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML))
                .andExpect(view().name("articles/detail"))
                .andExpect(model().attributeExists("article"))
                .andExpect(model().attributeExists("articleComments"));

    }

    @DisplayName("[View] [GET] 게시글 검색 전용 페이지 - 정상 호출")
    @Test
    public void givenNothing_whenRequestArticleSearchView_thenReturnArticleSearchView() throws Exception {

        mvc.perform(get("/articles/search"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML))
                .andExpect(model().attributeExists("articles/search"));
//                .andExpect(model().attributeExists("article"));

    }

    @DisplayName("[View] [GET] 게시글 해시태그 검색 페이지 - 정상 호출")
    @Test
    public  void givenNothing_whenRequestArticleHashTagSearchView_thenReturnArticleHashTagView() throws Exception{
        mvc.perform(get("/articles/search-hashtag"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML))
                .andExpect(model().attributeExists("articles/search-hashTag"));




    }
}