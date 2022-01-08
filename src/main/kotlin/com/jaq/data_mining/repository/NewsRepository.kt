package com.jaq.data_mining.repository

import com.jaq.data_mining.data.NewsEntity
import org.springframework.data.jpa.repository.JpaRepository

interface NewsRepository : JpaRepository<NewsEntity, Long> {

}