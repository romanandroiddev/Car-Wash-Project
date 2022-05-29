package uz.project.mycarwashproject.presenter.main.pages.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import uz.project.mycarwashproject.R
import uz.project.mycarwashproject.databinding.PageMainBinding

class MainPage : Fragment(R.layout.page_main) {
    private val binding by viewBinding(PageMainBinding::bind)
    private val viewModel by viewModel<MainPageViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}