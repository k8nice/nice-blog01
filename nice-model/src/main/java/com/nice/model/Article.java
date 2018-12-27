package com.nice.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 文章实体类
 * @author nice
 */
@Data
public class Article implements Serializable {
    private static final long serialVersionUID = -3900707362516261200L;
    /**
     * 主键自增
     * 文章名
     * 文章类型
     * 文章日期
     * 文章内容
     * 文章作者
     */
    private Long   articleId;
    private String articleTitle;
    private String articleType;
    private Date   articleDate;
    private String articleContent;
    private String articleAuthor;
}
