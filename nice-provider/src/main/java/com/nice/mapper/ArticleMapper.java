package com.nice.mapper;

import com.nice.model.Article;
import org.apache.ibatis.annotations.Mapper;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

/**
 * @author nice
 */
@Mapper
public interface ArticleMapper extends BaseMapper<Article> {
    /**
     * 查询所有文章
     * @return List<Article>
     */
    List<Article> queryArticleAll();

    /**
     * 查询所有文章标题
     * @return List<String>
     */
    List<String>  queryArticleTitleAll();

    /**
     * 根据文章标题查询文章内容
     * @param articleTitle
     * @return Article
     */
    Article       queryArticleByArticleTitle(String articleTitle);
}
