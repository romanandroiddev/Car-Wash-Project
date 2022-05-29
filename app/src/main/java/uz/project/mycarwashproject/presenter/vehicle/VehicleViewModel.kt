package uz.project.mycarwashproject.presenter.vehicle

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import uz.project.mycarwashproject.domain.repository.MainRepository
import uz.project.mycarwashproject.model.remote.ProposalModel
import uz.project.mycarwashproject.presenter.UniversalViewModel

class VehicleViewModel(private var mainRepository: MainRepository) : ViewModel(),
    UniversalViewModel<String> {
    private val profileNumber: MutableLiveData<Boolean> = MutableLiveData()
    val phoneId: LiveData<Boolean> = profileNumber

    override val loadingLD = MutableLiveData<Boolean>()
    override val errorLD = MutableLiveData<String>()
    override val errorInternetLD = MutableLiveData<String>()
    override val successLD = MutableLiveData<String>()
    private var successGetDataMutableLD = MutableLiveData<List<ProposalModel>>()
    val successGetDataLD: LiveData<List<ProposalModel>> = successGetDataMutableLD


    fun getDataPhone(): String {
        return mainRepository.getPhone()
    }
}