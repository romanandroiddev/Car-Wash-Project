package uz.project.mycarwashproject.presenter.splash

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import uz.project.mycarwashproject.domain.repository.MainRepository

class SplashViewModel(private val mainRepository: MainRepository) : ViewModel() {
    private val isSignUpMutableLD: MutableLiveData<Boolean> = MutableLiveData()
    val isSignUpLD: LiveData<Boolean> = isSignUpMutableLD


    fun start() {
        viewModelScope.launch {
            delay(1000)
            isSignUpMutableLD.value = mainRepository.isSignUp()
        }

    }

}

