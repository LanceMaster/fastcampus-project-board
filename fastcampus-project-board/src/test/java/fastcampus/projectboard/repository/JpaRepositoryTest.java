package fastcampus.projectboard.repository;

import fastcampus.projectboard.config.JpaConfig;
import fastcampus.projectboard.domain.Article;
import fastcampus.projectboard.domain.UserAccount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import static org.assertj.core.api.Assertions.*;

@DisplayName("JPA 연결 테스트")
@Import(JpaConfig.class)
@DataJpaTest

class JpaRepositoryTest {

    private final ArticleRepository articleRepository;
    private final ArticleCommentRepository articleCommentRepository;

    private final UserAccountRepository userAccountRepository;
    public JpaRepositoryTest(
        @Autowired ArticleRepository articleRepository,
        @Autowired ArticleCommentRepository articleCommentRepository,
        @Autowired UserAccountRepository userAccountRepository
    ) {
        this.articleRepository = articleRepository;
        this.articleCommentRepository = articleCommentRepository;
        this.userAccountRepository = userAccountRepository;
    }
    @DisplayName("select 테스트")
    @Test
    void givenTestData_whenSelecting_thenWorksFine() {
        //Given
        long previousCount = articleRepository.count();
        UserAccount userAccount = userAccountRepository.save(UserAccount.of("Jhk","pw",null,null,null));
        Article article = Article.of(userAccount,"new Article","new content","#spring");

        //When
        articleRepository.save(article);

        //Then
        assertThat(articleRepository.count()).isEqualTo(previousCount+1);
    }

    @DisplayName("Update 테스트")
    @Test
    void givenTestData_whenUpdating_thenWorksFine() {

        Article article = articleRepository.findById(1L).orElseThrow();
        String updatedHashtag = "#Springboot";
        article.setHashtag(updatedHashtag);

        //When
        Article savedArticle = articleRepository.saveAndFlush(article);

        //Then
        assertThat(savedArticle).hasFieldOrPropertyWithValue("hashtag", updatedHashtag);
    }
    @DisplayName("Delete 테스트")
    @Test
    void givenTestData_whenDeleting_thenWorksFine() {
        //Given
        Article article = articleRepository.findById(1L).orElseThrow();
        long previousArticleCount = articleRepository.count();
        long previousArticleCommentCount = articleCommentRepository.count();
        int  deletedCommentSize = article.getArticleComments().size();

        //When
        articleRepository.delete(article);
        //void method not return

        //Then
        assertThat(articleRepository.count()).isEqualTo(previousArticleCount - 1);
        assertThat(articleCommentRepository.count()).isEqualTo(previousArticleCommentCount - deletedCommentSize);
    }

}