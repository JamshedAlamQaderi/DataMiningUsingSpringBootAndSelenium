package com.jaq.data_mining.api

import com.jaq.data_mining.data.NewsEntity
import com.jaq.data_mining.model.ParamNewsModel
import com.jaq.data_mining.repository.NewsRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class NewsController(@Autowired val newsRepository: NewsRepository) {

    @GetMapping("/user")
    fun getUser(): String {
        return "user"
    }

    @PostMapping("/create")
    fun createNews(@RequestBody newsModel: ParamNewsModel): NewsEntity {
        return newsRepository.save(NewsEntity(null, newsModel.url, newsModel.news))
    }

    @GetMapping("/news/{pageNo}")
    fun getNews(@PathVariable(name = "pageNo") pageNo: Int): Page<NewsEntity> {
        val pageable = PageRequest.of(pageNo, 10)
        return newsRepository.findAll(pageable)
    }

    @GetMapping("/delete/newsId")
    fun deleteNews(@PathVariable(name = "newsId") newsId: Long): String {
        newsRepository.deleteById(newsId)
        return "deleted"
    }
}