package uz.project.mycarwashproject.presenter.vehicle

import android.app.Fragment
import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import uz.project.mycarwashproject.R
import uz.project.mycarwashproject.databinding.FragmentVehicleBinding
import uz.project.mycarwashproject.utils.scope

class VehicleFragment : Fragment(R.layout.fragment_vehicle) {
    private val binding: FragmentVehicleBinding by viewBinding(FragmentVehicleBinding::bind)
    private val viewModel by viewModel<VehicleViewModel>()
    private lateinit var myAdapter: UniversalAdapterCar
    private lateinit var myAdapterHyundai: UniversalAdapterCar
    private lateinit var myAdapterKia: UniversalAdapterCar
    var cars_chevrolet = listOf<ObjectClass>()
    var cars_hyundai = listOf<ObjectClass>()
    var cars_kia = listOf<ObjectClass>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = binding.scope {
        super.onViewCreated(view, savedInstanceState)

        recyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        recyclerViewSuv.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        recyclerViewKia.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        cars_chevrolet = mutableListOf(
            ObjectClass(R.drawable.gentraic, "Chevrolet", "Gentra/Lacetti"),
            ObjectClass(R.drawable.nexia3, "Chevrolet", "Nexia 3"),
            ObjectClass(R.drawable.cobaltic, "Chevrolet", "Cobalt"),
            ObjectClass(R.drawable.malibuic, "Chevrolet", "Malibu"),
            ObjectClass(R.drawable.mercedes, "Chevrolet", "Nexia 2"),
            ObjectClass(R.drawable.sparkic, "Chevrolet", "Spark"),
            ObjectClass(R.drawable.captivaic, "Chevrolet", "Captiva"),
            ObjectClass(R.drawable.laboic, "Chevrolet", "Labo"),
            ObjectClass(R.drawable.damasic, "Chevrolet", "Damas")
        )
        cars_hyundai = mutableListOf(ObjectClass(R.drawable.hyundayic, "Hyundai", "Sonata"))
        cars_kia = mutableListOf(ObjectClass(R.drawable.kiaic, "Kia", "K5"))

        myAdapter = UniversalAdapterCar { onItemClick(it) }
        myAdapterHyundai = UniversalAdapterCar { onItemClick(it) }
        myAdapterKia = UniversalAdapterCar { onItemClick(it) }

        myAdapter.submitList(cars_chevrolet)
        myAdapterHyundai.submitList(cars_hyundai)
        myAdapterKia.submitList(cars_kia)
        recyclerView.adapter = myAdapter
        recyclerViewSuv.adapter = myAdapterHyundai
        recyclerViewKia.adapter = myAdapterKia

        btnBack.setOnClickListener {
            findNavController().popBackStack()

        }


    }


    private fun onItemClick(position: ObjectClass) {
        val bundle = Bundle()
        bundle.putParcelable("objecttt", position);
        findNavController().navigate(R.id.action_vehicleFragment_to_addVehicleNumFragment, bundle)
    }


}

//}
