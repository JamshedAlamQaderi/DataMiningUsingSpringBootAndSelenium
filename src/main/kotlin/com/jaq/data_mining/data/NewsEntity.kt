package com.jaq.data_mining.data

import org.hibernate.Hibernate
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType.AUTO
import javax.persistence.Id

@Entity(name = "news_entity")
data class NewsEntity(
    @Id
    @GeneratedValue(strategy = AUTO)
    val id: Long?,
    val title: String,
    val url: String,
    val news: String
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as NewsEntity

        return id != null && id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id , title = $title , url = $url , news = $news )"
    }
}