package uz.project.mycarwashproject.presenter.addvehicle

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import uz.project.mycarwashproject.NavGraphDirections
import uz.project.mycarwashproject.R
import uz.project.mycarwashproject.databinding.FragmentAddVehicleBinding
import uz.project.mycarwashproject.presenter.addvehiclenum.VehicleNumClass
import uz.project.mycarwashproject.utils.scope

class AddVehicleFragment : Fragment(R.layout.fragment_add_vehicle) {
    private val binding: FragmentAddVehicleBinding by viewBinding(FragmentAddVehicleBinding::bind)
    private val viewModel by viewModel<AddVehicleViewModel>()
    private lateinit var myAdapter: AdapterVehicle
    private  lateinit var myList: List<VehicleNumClass>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = binding.scope {
        super.onViewCreated(view, savedInstanceState)

        myList = viewModel.getYourCars().toList()
        yourcarsRcview.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        yourcarsRcview.setHasFixedSize(true)


        myAdapter = AdapterVehicle(myList)
        yourcarsRcview.adapter = myAdapter

        addMyVehicle.setOnClickListener {
            findNavController().navigate(NavGraphDirections.actionGlobalVehicleFragment())
        }

        btnBack.setOnClickListener {
            findNavController().popBackStack()
        }


    }
}