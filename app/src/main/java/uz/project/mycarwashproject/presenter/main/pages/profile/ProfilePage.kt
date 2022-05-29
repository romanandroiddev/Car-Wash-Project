package uz.project.mycarwashproject.presenter.main.pages.profile

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import uz.project.mycarwashproject.NavGraphDirections
import uz.project.mycarwashproject.R
import uz.project.mycarwashproject.databinding.PageProfileBinding
import uz.project.mycarwashproject.utils.onClick
import uz.project.mycarwashproject.utils.scope

class ProfilePage : Fragment(R.layout.page_profile) {
    private val binding by viewBinding(PageProfileBinding::bind)
    private val viewModel by viewModel<ProfilePageViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = binding.scope {
        super.onViewCreated(view, savedInstanceState)

        phonenumber.text = viewModel.getDataPhone()

        logout.setOnClickListener {
            viewModel.saveSignUpState(false)
            findNavController().navigate(
                NavGraphDirections.actionGlobalSignUpFragment()
            )
        }


        invitefriend.setOnClickListener {
            shareApp()
        }

        myvehicle.setOnClickListener {
            findNavController().navigate(NavGraphDirections.actionGlobalAddVehicleFragment())
        }



        giftcards.setOnClickListener {
        }

    }

    private fun shareApp() {
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
        val text = """
             https://play.google.com/store/apps/details?id=${requireActivity().packageName}
             """.trimIndent()
        intent.putExtra(Intent.EXTRA_TEXT, text)
        startActivity(Intent.createChooser(intent, "Share:"))
    }

}
