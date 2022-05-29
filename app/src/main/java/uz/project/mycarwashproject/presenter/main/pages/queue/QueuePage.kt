package uz.project.mycarwashproject.presenter.main.pages.queue

import android.app.AlertDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import uz.project.mycarwashproject.NavGraphDirections
import uz.project.mycarwashproject.R
import uz.project.mycarwashproject.databinding.PageQueueBinding
import uz.project.mycarwashproject.model.remote.ProposalModel
import uz.project.mycarwashproject.presenter.addvehicle.AdapterVehicle
import uz.project.mycarwashproject.presenter.addvehiclenum.VehicleNumClass
import uz.project.mycarwashproject.presenter.vehicle.ObjectClass
import uz.project.mycarwashproject.presenter.vehicle.UniversalAdapterCar
import uz.project.mycarwashproject.utils.scope

class QueuePage : Fragment(R.layout.page_queue) {
    private val binding by viewBinding(PageQueueBinding::bind)
    private val viewModel by viewModel<QueuePageViewModel>()
    private lateinit var myAdapter: SelectCarAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = binding.scope {
        super.onViewCreated(view, savedInstanceState)
        rccarlist.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        myAdapter = SelectCarAdapter { onItemClick(it) }

        myAdapter.submitList(viewModel.getYourCars().toList())

        rccarlist.adapter = myAdapter




        viewModel.successLD.observe(viewLifecycleOwner, {
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
        })

    }
    fun onItemClick(item: VehicleNumClass) {
        findNavController().navigate(NavGraphDirections.actionGlobalSelectPriceFragment())
    }


}
//timepicker
//    private val timePickerDialogListener: TimePickerDialog.OnTimeSetListener =
//        TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
//            timeee = if (hourOfDay < 10 && minute < 10) {
//                "0$hourOfDay:0$minute"
//            } else if (hourOfDay < 10) {
//                "0$hourOfDay:$minute"
//            } else if (minute < 10) {
//                "$hourOfDay:0$minute"
//            } else {
//                "$hourOfDay:$minute"
//            }
//            binding.alertdialogoftime.text = timeee
//        }
//btnAddtoqueuedb.setOnClickListener {
//            if (!carName.text.isEmpty() && !carNumber.text.isEmpty() && !timeee!!.isEmpty()) {
//                viewModel.submitProposal(
//                    ProposalModel(
//                        carName = carName.text.toString().trim(),
//                        carNumber = carNumber.text.toString().trim(),
//                        price = "40000",
//                        time = timeee!!
//                    )
//
//                )
//
//            } else {
//                Toast.makeText(
//                    requireContext(),
//                    "Iltimas ha'mme jerin toltirin'!",
//                    Toast.LENGTH_SHORT
//                ).show()
//            }
//        }
//        alertdialogoftime.setOnClickListener {
//            val timePicker = TimePickerDialog(
//                requireContext(),
//                timePickerDialogListener,
//                0,
//                0,
//                true
//            )
//            timePicker.show()
//        }