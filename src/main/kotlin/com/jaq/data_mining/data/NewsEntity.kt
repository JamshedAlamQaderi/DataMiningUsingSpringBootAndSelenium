package com.jaq.data_mining.data

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType.AUTO
import javax.persistence.Id

@Entity(name = "news_entity")
data class NewsEntity(
    @Id
    @GeneratedValue(strategy = AUTO)
    val id: Long?,
    val url: String,
    val news: String
){
}