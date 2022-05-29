package uz.project.mycarwashproject.presenter.addvehiclenum

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import uz.project.mycarwashproject.domain.repository.MainRepository
import uz.project.mycarwashproject.presenter.UniversalViewModel
import uz.project.mycarwashproject.utils.isConnected

class AddVehicleNumViewModel(private var mainRepository: MainRepository) : ViewModel(),
    UniversalViewModel<String> {

    override val loadingLD = MutableLiveData<Boolean>()
    override val errorLD = MutableLiveData<String>()
    override val errorInternetLD = MutableLiveData<String>()
    override val successLD = MutableLiveData<String>()

    //  private var successGetDataMutableLD = MutableLiveData<List<ProposalModel>>()
    //val successGetDataLD: LiveData<List<ProposalModel>> = successGetDataMutableLD {

    fun submitProposalNum(proposalModel: VehicleNumClass) {
        if (!isConnected()) {
            errorInternetLD.value = "Интернет не подключен!"
            return
        }
        successLD.value = mainRepository.submitProposalNum(proposalModel)
    }


}
