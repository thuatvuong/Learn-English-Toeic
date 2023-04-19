package com.webtoeic.service;

import java.io.IOException;
import java.util.Optional;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.webtoeic.entities.Article;
import com.webtoeic.repository.ArticleRepository;

@Service
@EnableScheduling
public class ArticleService {

     private ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public boolean articleExists(String url) {
        return articleRepository.findArticleByUrl(url).isPresent();
    }

    public void saveArticle(Article article) {
        articleRepository.save(article);
    }

    public Page<Article> getAllArticles(int page, int size) {
        return articleRepository.findAll(PageRequest.of(page, size));
    }

    public Optional<Article> getArticle(Long id) {
        return articleRepository.findById(id);
    }

    //Check after 1 hour
    @Scheduled(fixedDelay = 3600000)
    public void crawlAndSaveArticles() throws IOException {
        try {
            String url = "https://e.vnexpress.net/news/world";
            Document document = Jsoup.connect(url).get();
            Elements articles = document.select("div.item_list_folder");
            ArticleService articleService = new ArticleService(articleRepository);


            System.out.println(" " + articles.size());
            System.out.println(" " + articles.get(6).toString());
            int n = articles.size();
            for (int i = 0; i < 10 && i < n; i++) {
                if (i == 6) {
                    continue;
                }
                Element article = articles.get(i);
                String title = article.select("h2.title_news_site > a").text();
                System.out.println("title: " + title);

                String articleUrl = article.select("h2.title_news_site > a").attr("href");
                System.out.println("articleUrl: " + articleUrl);

                String image = article.select("a.thumb_news_site.thumb_5x3 > img").attr("src");
    System.out.println("Image URL: " + image);

                // check if the article already exists
                if (!articleService.articleExists(articleUrl)) {
                    // crawl article content
                    Document articleDoc = Jsoup.connect(articleUrl).get();
                    articleDoc.select("div.block_title_detail").remove();
                    articleDoc.select("div.block_input_comment.width_common").remove();
                    articleDoc.select("a.follow_fb.btn_facebook, a.follow_twit.btn_twitter.get-link-bitly").remove();


                    String description = articleDoc.select("meta[name=description]").attr("content");
                    System.out.println("description: " + description);


                    String content = articleDoc.select("div.main_fck_detail").html();
                    System.out.println("content: " + content);

                    // save article to database
                    Article newArticle = new Article();
                    newArticle.setTitle(title);
                    newArticle.setDescription(description);
                    newArticle.setContent(content);
                    newArticle.setImage(image);
                    newArticle.setUrl(articleUrl);
                    articleRepository.save(newArticle);
                }

            }


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
