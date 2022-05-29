package uz.project.mycarwashproject.presenter.register.signup

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import uz.project.mycarwashproject.domain.repository.MainRepository
import uz.project.mycarwashproject.presenter.UniversalViewModel
import uz.project.mycarwashproject.utils.isConnected

class SignUpViewModel(private val mainRepository: MainRepository) : ViewModel(),
    UniversalViewModel<Int> {

    override val loadingLD = MutableLiveData<Boolean>()
    override val errorLD = MutableLiveData<String>()
    override val errorInternetLD = MutableLiveData<String>()
    override val successLD = MutableLiveData<Int>()

    fun saveSignUpState(state:Boolean) {
        mainRepository.saveSignUpState(state)
    }
    fun savePhoneNumber(phone:String) {
        mainRepository.saveProfileNum(phone)
    }

    fun sendCode() {
        if (!isConnected()) {
            errorInternetLD.value = "Интернет не подключен!"
            return
        }
        loadingLD.value = true

    }



}