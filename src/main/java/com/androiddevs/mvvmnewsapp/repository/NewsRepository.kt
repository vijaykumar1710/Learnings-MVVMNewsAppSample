package com.androiddevs.mvvmnewsapp.repository

import com.androiddevs.mvvmnewsapp.api.RetrofitInstance
import com.androiddevs.mvvmnewsapp.db.ArticleDatabase
import com.androiddevs.mvvmnewsapp.models.Article

class NewsRepository(
    val db : ArticleDatabase
) {
    suspend fun getBreakingNews(countryCode :String ,  pageNumber: Int) = RetrofitInstance.api.getBreakingNews(countryCode,pageNumber)

    suspend fun getSearchNews( searchQuery :String , pageNumber: Int ) = RetrofitInstance.api.searchForNews(searchQuery,pageNumber)

    suspend fun upsertArticleToDb ( article: Article ) = db.getArticleDao().upsert(article)

    fun getAllSavedArticles() = db.getArticleDao().getAllArticles()

    suspend fun deleteArticleFromDb( article: Article) = db.getArticleDao().deleteArticle(article)
}