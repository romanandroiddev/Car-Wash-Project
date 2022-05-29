package uz.project.mycarwashproject.presenter.main.pages.about

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import uz.project.mycarwashproject.domain.repository.MainRepository
import uz.project.mycarwashproject.model.remote.ProposalModel
import uz.project.mycarwashproject.presenter.UniversalViewModel

class AboutPageViewModel(private var mainRepository: MainRepository) : ViewModel(),
    UniversalViewModel<String> {

    override val loadingLD = MutableLiveData<Boolean>()
    override val errorLD = MutableLiveData<String>()
    override val errorInternetLD = MutableLiveData<String>()
    override val successLD = MutableLiveData<String>()
    private var successGetDataMutableLD = MutableLiveData<List<ProposalModel>>()
    val successGetDataLD: LiveData<List<ProposalModel>> = successGetDataMutableLD

}