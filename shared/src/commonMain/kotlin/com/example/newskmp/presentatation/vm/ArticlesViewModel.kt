package com.example.newskmp.presentatation.vm

import com.adeo.kviewmodel.BaseSharedViewModel
import com.example.newskmp.data.repository.ArticleRepository
import com.example.newskmp.data.service.ArticleService
import com.example.newskmp.presentatation.store.ArticlesScreenAction
import com.example.newskmp.presentatation.store.ArticlesScreenEvent
import com.example.newskmp.presentatation.store.ArticlesScreenState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ArticlesViewModel(private val articleRepository: ArticleRepository): BaseSharedViewModel<ArticlesScreenState, ArticlesScreenAction, ArticlesScreenEvent>(ArticlesScreenState.Initial){
    private val _state = MutableStateFlow<ArticlesScreenState>(ArticlesScreenState.Initial)
    private val state = _state.asStateFlow()
    override fun obtainEvent(viewEvent: ArticlesScreenEvent) {
        when(viewEvent){
            is ArticlesScreenEvent.GetArticles->{

            }
        }
    }

    private fun getArticles() = viewModelScope.launch(Dispatchers.IO) {
        val articles = articleRepository.getArticles()
        _state.emit(ArticlesScreenState.Success(articles))
    }
}