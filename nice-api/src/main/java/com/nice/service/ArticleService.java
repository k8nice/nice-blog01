package com.nice.service;

import com.nice.model.Article;

import java.util.List;

/**
 * @author nice
 */
public interface ArticleService {
    /**
     * 查询全部文章
     * @return List<Article>
     */
    List<Article> queryArticleAll();

    /**
     * 查询全部文章标题
     * @return List<String>
     */
    List<String> queryArticleTitleAll();

    /**
     * 根据标题名字查询文章
     * @param articleTitle
     * @return
     */
    Article       queryArticleByArticleTitle(String articleTitle);
}
