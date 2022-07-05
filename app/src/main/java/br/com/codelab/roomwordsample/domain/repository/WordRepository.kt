package br.com.codelab.roomwordsample.domain.repository

import androidx.annotation.WorkerThread
import br.com.codelab.roomwordsample.domain.model.Word
import br.com.codelab.roomwordsample.data.source.local.dao.WordDao
import kotlinx.coroutines.flow.Flow

class WordRepository(private val wordDao: WordDao) {

    val getAllWords: Flow<List<Word>> = wordDao.getAlphabetizedWords()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insertWord(word: Word) {
        wordDao.insertWord(word)
    }
}