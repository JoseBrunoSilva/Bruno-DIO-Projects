package br.com.dio.davellopbruno.businesscard.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.dio.davellopbruno.businesscard.data.BusinessCardRepository
import br.com.dio.davellopbruno.businesscard.data.Businesscard

class MainViewModel (private val businessCardRepository: BusinessCardRepository ): ViewModel() {

    fun insert(businessCard : Businesscard) {
        businessCardRepository.insert(businessCard)
    }

    fun getAll(): LiveData<List<Businesscard>> {
        return businessCardRepository.getAll()
    }
}

class MainViewModelFactory(private val repository:BusinessCardRepository) :
        ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel:: class.java)){
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknow ViewModel Class")
    }

}