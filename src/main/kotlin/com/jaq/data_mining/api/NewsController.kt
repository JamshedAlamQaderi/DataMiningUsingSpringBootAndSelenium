package com.jaq.data_mining.api

import com.jaq.data_mining.data.NewsEntity
import com.jaq.data_mining.model.ParamNewsModel
import com.jaq.data_mining.repository.NewsRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.PageRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin(origins = ["http://localhost:8080", "http://192.168.0.101:8080"])
@RequestMapping("/api")
class NewsController(@Autowired val newsRepository: NewsRepository) {

    @PostMapping("/create")
    fun createNews(@RequestBody newsModel: ParamNewsModel): NewsEntity {
        return newsRepository.save(NewsEntity(null, newsModel.title, newsModel.url, newsModel.news))
    }

    @GetMapping("/news/{pageNo}")
    fun getNews(@PathVariable(name = "pageNo") pageNo: Int): Any {
        try {
            val pageable = PageRequest.of(pageNo, 10)
            return ResponseEntity(newsRepository.findAll(pageable), HttpStatus.OK)
        } catch (e: Exception) {
            return ResponseEntity("[]", HttpStatus.OK)
        }
    }

    @GetMapping("/singlenews/{newsId}")
    fun getSingleNews(@PathVariable(name = "newsId") newsId: Long): Any {
        try {
            val newsEntities = newsRepository.findById(newsId)
            if (newsEntities.isPresent) {
                return ResponseEntity<NewsEntity>(newsEntities.get(), HttpStatus.OK)
            }
        } catch (e: Exception) {
            return ResponseEntity<String>("{}", HttpStatus.OK)
        }
        return ResponseEntity<String>("{}", HttpStatus.OK)
    }

    @GetMapping("/delete/{newsId}")
    fun deleteNews(@PathVariable(name = "newsId") newsId: Long): String {
        newsRepository.deleteById(newsId)
        return "deleted"
    }
}