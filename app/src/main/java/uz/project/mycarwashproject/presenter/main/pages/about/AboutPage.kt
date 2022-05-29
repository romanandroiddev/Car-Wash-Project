package uz.project.mycarwashproject.presenter.main.pages.about

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.gms.maps.model.LatLng
import org.koin.androidx.viewmodel.ext.android.viewModel
import uz.project.mycarwashproject.R
import uz.project.mycarwashproject.databinding.PageAboutBinding
import uz.project.mycarwashproject.utils.scope

class AboutPage : Fragment(R.layout.page_about) {
    private val binding by viewBinding(PageAboutBinding::bind)
    private val viewModel by viewModel<AboutPageViewModel>()
    val position = LatLng(-33.920455, 18.466941)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = binding.scope {
        super.onViewCreated(view, savedInstanceState)


    }
}

