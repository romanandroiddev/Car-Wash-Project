package uz.project.mycarwashproject.presenter.addvehiclenum

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import uz.project.mycarwashproject.NavGraphDirections
import uz.project.mycarwashproject.R
import uz.project.mycarwashproject.databinding.FragmentVehiclenumBinding
import uz.project.mycarwashproject.presenter.vehicle.ObjectClass
import uz.project.mycarwashproject.utils.scope

class AddVehicleNumFragment : Fragment(R.layout.fragment_vehiclenum) {
    private val binding: FragmentVehiclenumBinding by viewBinding(FragmentVehiclenumBinding::bind)
    private val viewModel by viewModel<AddVehicleNumViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = binding.scope {
        super.onViewCreated(view, savedInstanceState)

        val bundle = arguments
        val obj = bundle?.getParcelable<ObjectClass>("objecttt")
        carrPhoto.setImageResource(obj!!.img_car)
        companyyyName.text = obj.companyName
        modelllName.text = obj.modelName


        yurfizswitch.setOnCheckedChangeListener { compoundButton, b ->
            if (compoundButton.isChecked) {
                binding.savecarNum.hint = "777AAA"
            } else {
                binding.savecarNum.hint = "A777AA"
            }


        }
        button.setOnClickListener {
            constraintLayout.alpha = 0.1F
            progressBar2.visibility = View.VISIBLE
            if (savecarNum.text.isNotEmpty()) {
                viewModel.submitProposalNum(
                    VehicleNumClass(
                        modelName = obj.modelName,
                        modelNumber = savecarNum.text.toString().trim(),
                        modelImg = obj.img_car
                    )

                )

            } else {
                Toast.makeText(
                    requireContext(),
                    "Iltimas ha'mme jerin toltirin'!",
                    Toast.LENGTH_SHORT
                ).show()
            }
            Toast.makeText(requireContext(),"Mashin qosildi", Toast.LENGTH_SHORT).show()
            findNavController().navigate(NavGraphDirections.actionGlobalVehicleFragment())
        }

    }
}