package com.example.basketballteam.controller;

import com.example.basketballteam.mapper.PhotoMapper;
import com.example.basketballteam.model.*;
import com.example.basketballteam.service.ArticleService;
import com.example.basketballteam.service.PhotoService;
import com.example.basketballteam.service.PlayerService;
import com.example.basketballteam.service.ScheduleService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {
    @Autowired
    private ArticleService articleService;
    @Autowired
    private ScheduleService scheduleService;
    @Autowired
    private PlayerService playerService;
    @Autowired
    private PhotoService photoService;

    @RequestMapping("/")
    public String home() {
        return "index";
    }

    @RequestMapping("/index")
    public String list(ModelMap map) {
        Subject subject = SecurityUtils.getSubject();
        Manager manager = (Manager) subject.getSession().getAttribute("manager");
        if (manager != null) {
            map.addAttribute("manager", manager);
        } else {
            map.addAttribute("manager", null);
        }
        List<Article> articleFiveList = new ArrayList();
        List<Schedule> scheduleList = new ArrayList();
        scheduleList = scheduleService.findSchedulesFive();
        articleFiveList = articleService.findLatestFiveArticles();
        map.addAttribute("schedules", scheduleList);
        map.addAttribute("articleFive", articleFiveList);
        return "index";
    }

    @RequestMapping("/article/ad/{articleId}")
    public String articleById(@PathVariable int articleId, ModelMap map) {
        Subject subject = SecurityUtils.getSubject();
        Manager manager = (Manager) subject.getSession().getAttribute("manager");
        if (manager != null) {
            map.addAttribute("manager", manager);
        } else {
            map.addAttribute("manager", null);
        }
        Article article = articleService.findArticleById(articleId);
        map.addAttribute("article", article);
        return "articleByArticleId";
    }

    @RequestMapping("/article")
    public String findAllArticle(ModelMap map) {
        Subject subject = SecurityUtils.getSubject();
        Manager manager = (Manager) subject.getSession().getAttribute("manager");
        if (manager != null) {
            map.addAttribute("manager", manager);
        } else {
            map.addAttribute("manager", null);
        }
        int pageNumber = 1;
        int articleCount = articleService.countAllArticles();
        int articleNumber = (articleCount + 14) / 15;
        List<Article> articleList = articleService.findArticlesPage(0);
        List<Schedule> scheduleList = scheduleService.findSchedulesFive();
        map.addAttribute("schedules", scheduleList);
        map.addAttribute("articles", articleList);
        map.addAttribute("pagenumber", pageNumber);
        map.addAttribute("articlenumber", articleNumber);
        return "article";
    }

    @RequestMapping("/article/PN={pagenumber}")
    public String getArticleByPage(@PathVariable("pagenumber") int pageNumber, ModelMap map) {
        Subject subject = SecurityUtils.getSubject();
        Manager manager = (Manager) subject.getSession().getAttribute("manager");
        if (manager != null) {
            map.addAttribute("manager", manager);
        } else {
            map.addAttribute("manager", null);
        }
        int articleCount = articleService.countAllArticles();
        int articleNumber = (articleCount + 14) / 15;
        List<Article> articleList = articleService.findArticlesPage(pageNumber);
        List<Schedule> scheduleList = scheduleService.findSchedulesFive();
        map.addAttribute("schedules", scheduleList);
        map.addAttribute("articles", articleList);
        map.addAttribute("pagenumber", pageNumber);
        map.addAttribute("articlenumber", articleNumber);
        return "article";
    }

    @RequestMapping("/player")
    public String findAllPlayer(ModelMap map) {
        Subject subject = SecurityUtils.getSubject();
        Manager manager = (Manager) subject.getSession().getAttribute("manager");
        if (manager != null) {
            map.addAttribute("manager", manager);
        } else {
            map.addAttribute("manager", null);
        }
        List<Player> player2020 = playerService.findPlayerBy2020();
        List<Player> player2021 = playerService.findPlayerBy2021();
        List<Player> player2022 = playerService.findPlayerBy2022();
        map.addAttribute("player2020", player2020);
        map.addAttribute("player2021", player2021);
        map.addAttribute("player2022", player2022);
        return "player";
    }

    @RequestMapping("/player/pr/{playerId}")
    public String playerById(@PathVariable int playerId, ModelMap map) {
        Subject subject = SecurityUtils.getSubject();
        Manager manager = (Manager) subject.getSession().getAttribute("manager");
        if (manager != null) {
            map.addAttribute("manager", manager);
        }
        Player player = playerService.selectById(playerId);
        map.addAttribute("player", player);
        return "playByPlayerId";
    }

    @RequestMapping("/photo")
    public String findAllPhoto(ModelMap map) {
        Subject subject = SecurityUtils.getSubject();
        Manager manager = (Manager) subject.getSession().getAttribute("manager");
        if (manager != null) {
            map.addAttribute("manager", manager);
        }
        List<Photo> photoList = photoService.findAllPhoto();
        map.addAttribute("photos", photoList);
        return "photo";
    }

    @RequestMapping("/schedule")
    public String findAllSchedule(ModelMap map) {
        Subject subject = SecurityUtils.getSubject();
        Manager manager = (Manager) subject.getSession().getAttribute("manager");
        if (manager != null) {
            map.addAttribute("manager", manager);
        }
        List<Schedule> scheduleList = scheduleService.findSchedulesByPage(1);
        List<Schedule> schedule1List = new ArrayList();
        List<Schedule> schedule2List = new ArrayList();
        List<Schedule> schedule3List = new ArrayList();
        int size = scheduleList.size();
        if (size >= 10 && size <= 15) {
            schedule1List = scheduleList.subList(0, 5);
            schedule2List = scheduleList.subList(5, 10);
            schedule3List = scheduleList.subList(10, size);
        } else if (size >= 5 && size <= 10) {
            schedule1List = scheduleList.subList(0, 5);
            schedule2List = scheduleList.subList(5, size);
        } else {
            schedule1List = scheduleList.subList(0, size);
        }

        int scheduleCount = scheduleService.countAllSchedules();
        int scheduleNumber = (scheduleCount + 14) / 15;
        int pageNumber = 1;
        map.addAttribute("schedules1", schedule1List);
        map.addAttribute("schedules2", schedule2List);
        map.addAttribute("schedules3", schedule3List);
        map.addAttribute("scheduleNumber", scheduleNumber);
        map.addAttribute("pagenumber", pageNumber);
        return "schedule";
    }

    @RequestMapping("/schedule/pN={pagenumber}")
    public String getScheduleByPage(@PathVariable("pagenumber") int pageNumber, ModelMap map) {
        Subject subject = SecurityUtils.getSubject();
        Manager manager = (Manager) subject.getSession().getAttribute("manager");
        if (manager != null) {
            map.addAttribute("manager", manager);
        }
        List<Schedule> scheduleList = scheduleService.findSchedulesByPage(pageNumber);
        List<Schedule> schedule1List = new ArrayList();
        List<Schedule> schedule2List = new ArrayList();
        List<Schedule> schedule3List = new ArrayList();
        int size = scheduleList.size();
        if (size >= 10 && size <= 15) {
            schedule1List = scheduleList.subList(0, 5);
            schedule2List = scheduleList.subList(5, 10);
            schedule3List = scheduleList.subList(10, size);
        } else if (size >= 5 && size <= 10) {
            schedule1List = scheduleList.subList(0, 5);
            schedule2List = scheduleList.subList(5, size);
        } else {
            schedule1List = scheduleList.subList(0, size);
        }
        int scheduleCount = scheduleService.countAllSchedules();
        int scheduleNumber = (scheduleCount + 14) / 15;
        map.addAttribute("schedules1", schedule1List);
        map.addAttribute("schedules2", schedule2List);
        map.addAttribute("schedules3", schedule3List);
        map.addAttribute("scheduleNumber", scheduleNumber);
        map.addAttribute("pagenumber", pageNumber);
        return "schedule";
    }


}
