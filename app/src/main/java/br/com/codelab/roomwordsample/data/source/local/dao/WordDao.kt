package br.com.codelab.roomwordsample.data.source.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import br.com.codelab.roomwordsample.domain.model.Word
import kotlinx.coroutines.flow.Flow

@Dao
interface WordDao {
    @Query("SELECT * FROM words_table ORDER BY word_column ASC")
    fun getAlphabetizedWords(): Flow<List<Word>>

    @Query("SELECT * FROM words_table WHERE word_column =:word")
    fun getWord(): Flow<List<Word>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertWord(word: Word){
    }

    @Query("DELETE FROM words_table")
    suspend fun deleteWord(word: Word){
    }
}