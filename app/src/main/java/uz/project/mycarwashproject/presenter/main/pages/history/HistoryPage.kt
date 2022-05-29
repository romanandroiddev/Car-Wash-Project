package uz.project.mycarwashproject.presenter.main.pages.history

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import uz.project.mycarwashproject.R
import uz.project.mycarwashproject.databinding.PageHistoryBinding
import uz.project.mycarwashproject.utils.scope

class HistoryPage : Fragment(R.layout.page_history) {
    private val binding by viewBinding(PageHistoryBinding::bind)
    private val viewModel by viewModel<HistoryPageViewModel>()
    private lateinit var myAdapter: MyAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = binding.scope {
        super.onViewCreated(view, savedInstanceState)

        rcHistory.layoutManager = LinearLayoutManager(requireContext())
        rcHistory.setHasFixedSize(true)

        myAdapter = MyAdapter(viewModel.getCarslist())
        rcHistory.adapter = myAdapter

    }


}
