package uz.project.mycarwashproject.presenter.splash

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import uz.project.mycarwashproject.R
import uz.project.mycarwashproject.databinding.FragmentSplashBinding

class SplashFragment : Fragment(R.layout.fragment_splash) {
    private val binding by viewBinding(FragmentSplashBinding::bind)
    private val viewModel by viewModel<SplashViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.start()


        viewModel.isSignUpLD.observe(viewLifecycleOwner) {
            if (it)
                findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToMainFragment())
            else
                findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToSignUpFragment())

        }


    }

}
