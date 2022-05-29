package uz.project.mycarwashproject.domain.repository

import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.navigation.fragment.NavHostFragment.findNavController
import uz.project.mycarwashproject.NavGraphDirections
import uz.project.mycarwashproject.model.remote.ProposalModel
import uz.project.mycarwashproject.presenter.addvehiclenum.VehicleNumClass
import uz.project.mycarwashproject.presenter.main.pages.history.Car

interface MainRepository {
    fun isSignUp(): Boolean
    fun saveSignUpState(state: Boolean)
    fun submitProposal(proposalModel: ProposalModel): String
    fun submitProposalNum(proposalModel: VehicleNumClass): String
    fun getYourCars(): Set<VehicleNumClass>
    fun historyPageCars(): List<Car>
    fun getPhone(): String
    fun saveProfileNum(phone: String)


}