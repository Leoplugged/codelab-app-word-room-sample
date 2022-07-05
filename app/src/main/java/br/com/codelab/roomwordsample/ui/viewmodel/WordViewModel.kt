package br.com.codelab.roomwordsample.ui.viewmodel

import androidx.lifecycle.*
import br.com.codelab.roomwordsample.domain.model.Word
import br.com.codelab.roomwordsample.domain.repository.WordRepository
import kotlinx.coroutines.launch

class WordViewModel {
    class WordViewModel(private val repository: WordRepository) : ViewModel() {

        val allWords: LiveData<List<Word>> = repository.getAllWords.asLiveData()

        fun insertWord(word: Word) = viewModelScope.launch {
            repository.insertWord(word)
        }
    }

    class WordViewModelFactory(private val repository: WordRepository) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(WordViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return WordViewModel(repository) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}