package com.nice.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nice.mapper.ArticleMapper;
import com.nice.model.Article;
import com.nice.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.List;
/**
 * @author nice
 */
@Component
@Service(
        version = "${dubbo.service.version}",
        application = "${dubbo.application.id}",
        protocol = "${dubbo.protocol.id}",
        registry = "${dubbo.registry.id}"
)
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    /**
     * 查询全部文章
     * @return List<Article>
     */
    @Override
    public List<Article> queryArticleAll() {
        final PageInfo<Article> pageInfo = PageHelper.startPage(1,10).setOrderBy("article_id desc").doSelectPageInfo(() -> this.articleMapper.queryArticleAll());
        List<Article> list = pageInfo.getList();
        return list;
    }

    /**
     * 查询全部文章标题
     */
    @Override
    public List<String> queryArticleTitleAll() {
        final PageInfo<String> pageInfo = PageHelper.startPage(1,10).setOrderBy("article_id desc").doSelectPageInfo(() -> this.articleMapper.queryArticleTitleAll());
        List<String> list = pageInfo.getList();
        return list;
    }

    /**Article
     * 根据文章标题查询文章
     * @param articleTitle
     * @return
     */
    @Override
    public Article queryArticleByArticleTitle(String articleTitle) {
        System.out.println();
        return articleMapper.queryArticleByArticleTitle(articleTitle);
    }


}
