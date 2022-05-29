package uz.project.mycarwashproject.presenter.selectprice

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import uz.project.mycarwashproject.domain.repository.MainRepository
import uz.project.mycarwashproject.model.remote.ProposalModel
import uz.project.mycarwashproject.presenter.UniversalViewModel
import uz.project.mycarwashproject.presenter.addvehiclenum.VehicleNumClass
import uz.project.mycarwashproject.utils.isConnected

class SelectPriceViewModel(private var mainRepository: MainRepository) : ViewModel(),
    UniversalViewModel<String> {

    override val loadingLD = MutableLiveData<Boolean>()
    override val errorLD = MutableLiveData<String>()
    override val errorInternetLD = MutableLiveData<String>()
    override val successLD = MutableLiveData<String>()

    fun getYourCars(): Set<VehicleNumClass> {
        if (!isConnected()) {
            errorInternetLD.value = "Интернет не подключен!"
        }
        return mainRepository.getYourCars()
    }
}
