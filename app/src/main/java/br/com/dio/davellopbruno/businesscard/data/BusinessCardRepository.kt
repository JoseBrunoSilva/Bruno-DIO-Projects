package br.com.dio.davellopbruno.businesscard.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class BusinessCardRepository (private val dao: BusinessCardDao){

    fun insert(businesscard: Businesscard) = runBlocking {
        launch (Dispatchers.IO) {
            dao.insert(businesscard)
            getAll()
        }
    }
    fun getAll() = dao.getAll()
}