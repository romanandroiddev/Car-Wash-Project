package uz.project.mycarwashproject.presenter.selectprice

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import uz.project.mycarwashproject.R
import uz.project.mycarwashproject.databinding.FragmentSelectPriceBinding
import uz.project.mycarwashproject.utils.scope

class SelectPriceFragment : Fragment(R.layout.fragment_select_price) {
    private val binding: FragmentSelectPriceBinding by viewBinding(FragmentSelectPriceBinding::bind)
    private val viewModel by viewModel<SelectPriceViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = binding.scope {
        super.onViewCreated(view, savedInstanceState)
        btnBack.setOnClickListener {
            findNavController().popBackStack()
        }

    }
}