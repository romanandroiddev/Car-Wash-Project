package uz.project.mycarwashproject.presenter.main

import android.annotation.SuppressLint
import android.os.Bundle
import android.system.Os.bind
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import uz.project.mycarwashproject.R
import uz.project.mycarwashproject.databinding.FragmentMainBinding
import java.util.*

class MainFragment : Fragment(R.layout.fragment_main) {
    private val bindingNav by viewBinding(FragmentMainBinding::bind)
    private val viewModel by viewModel<MainViewModel>()
    private lateinit var pagerAdapter: MainPageAdapter

    @SuppressLint("FragmentLiveDataObserve")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pagerAdapter = MainPageAdapter(childFragmentManager, lifecycle)

        bindingNav.viewPager2.adapter = pagerAdapter
        bindingNav.viewPager2.isUserInputEnabled = false

        bindingNav.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.bottomMain -> bindingNav.viewPager2.currentItem = 0
                R.id.bottomHistory -> bindingNav.viewPager2.currentItem = 1
                R.id.bottomQueue -> bindingNav.viewPager2.currentItem = 2
                R.id.bottomAbout -> bindingNav.viewPager2.currentItem = 3
                R.id.bottomProfile -> bindingNav.viewPager2.currentItem = 4

            }
            return@setOnItemSelectedListener true
        }
    }


}
