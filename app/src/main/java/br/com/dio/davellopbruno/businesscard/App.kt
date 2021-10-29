package br.com.dio.davellopbruno.businesscard

import android.app.Application
import br.com.dio.davellopbruno.businesscard.data.AppDataBase
import br.com.dio.davellopbruno.businesscard.data.BusinessCardRepository

class App : Application() {
    private val database by lazy{AppDataBase.getDatabase(this)}
    val repository by lazy { BusinessCardRepository(database.businessDao()) }
}