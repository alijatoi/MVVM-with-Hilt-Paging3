package com.example.paging3library.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.paging3library.repository.QuoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class QuoteViewModel @Inject constructor( repository: QuoteRepository) : ViewModel() {
    val list = repository.getQuotes().cachedIn(viewModelScope)
}