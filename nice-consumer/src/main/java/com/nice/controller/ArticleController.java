package com.nice.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.nice.model.Article;
import com.nice.service.ArticleService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author nice
 */
@Controller
public class ArticleController {
    @Reference(
            version = "${dubbo.service.version}",
            application = "${dubbo.application.id}",
            url = "dubbo://localhost:20885"
    )
    public ArticleService articleService;

    @Resource
    private RedisTemplate<String,List<Article>> redisTemplate;

    /**
     * 主页
     * @return
     */
    @GetMapping(value = "/index")
    public ModelAndView index(){
        String key = "article";
        if (redisTemplate.opsForList().getOperations().opsForValue().get(key) == null){
            List<Article> list = articleService.queryArticleAll();
            redisTemplate.opsForList().getOperations().opsForValue().set("article",list);
            ModelAndView view = new ModelAndView();
            view.addObject("list",list);
            return view;
        }else {
            List<Article> list = redisTemplate.opsForList().getOperations().opsForValue().get("article");
            ModelAndView view = new ModelAndView();
            view.addObject("list",list);
            return view;
        }
    }

    /**
     * 接收要查看的文章名
     * @param articleTitle
     * @param request
     * @return
     */
    @GetMapping(value = "/{articleTitle}")
    public String getArticleTitleRequest(@PathVariable("articleTitle")String articleTitle, HttpServletRequest request){
        Article article = articleService.queryArticleByArticleTitle(articleTitle);
        request.setAttribute("article",article);
        return "forward:article";
    }

    /**
     * 渲染文章页面
     * @param request
     * @return
     */
    @GetMapping(value = "/article")
    public ModelAndView showArticle(HttpServletRequest request){
        Article article = (Article) request.getAttribute("article");
        System.out.println(article);
        ModelAndView view = new ModelAndView();
        view.addObject("article",article);
        return view;
    }
}
