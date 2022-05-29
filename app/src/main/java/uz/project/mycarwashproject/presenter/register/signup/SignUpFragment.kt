package uz.project.mycarwashproject.presenter.register.signup

import android.os.Bundle
import android.system.Os.bind
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import com.google.firebase.auth.PhoneAuthProvider.ForceResendingToken
import org.koin.androidx.viewmodel.ext.android.viewModel
import uz.project.mycarwashproject.R
import uz.project.mycarwashproject.databinding.FragmentSignUpBinding
import java.util.concurrent.TimeUnit


class SignUpFragment : Fragment(R.layout.fragment_sign_up) {

    private val binding: FragmentSignUpBinding by viewBinding(FragmentSignUpBinding::bind)
    private val viewModel by viewModel<SignUpViewModel>()
    private var foreResendToken: ForceResendingToken? = null

    private var mCallBacks: PhoneAuthProvider.OnVerificationStateChangedCallbacks? = null
    private var mVerificationID: String? = null
    private lateinit var fireBaseAuth: FirebaseAuth


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fireBaseAuth = FirebaseAuth.getInstance()


        mCallBacks = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            override fun onVerificationCompleted(p0: PhoneAuthCredential) {
                signWithPhoneAuthCredential(p0)
            }

            override fun onVerificationFailed(p0: FirebaseException) {
                binding.progressBar.visibility = View.GONE
                Log.v("TTTT", p0.localizedMessage)
                Toast.makeText(requireContext(), "Your number failed", Toast.LENGTH_SHORT).show()
            }

            override fun onCodeSent(verifivationId: String, token: ForceResendingToken) {
                Log.v("TTTT", verifivationId)
                mVerificationID = verifivationId
                foreResendToken = token
                binding.signuplayout.visibility = View.GONE
                binding.verifylayout.visibility = View.VISIBLE



            }
        }

        binding.btnSend.setOnClickListener {
            val phone = binding.mPhoneNumberField.text.toString().trim()
            if (TextUtils.isEmpty(phone)) {
                Toast.makeText(requireContext(), "Enter number!!", Toast.LENGTH_LONG).show()
            } else {
                startPhoneNumberVerification(phone)
                binding.signuplayout.alpha = 0.1F
            }

        }

        binding.btnSend2.setOnClickListener {
            val code = binding.mPhoneNumberField2.text.toString().trim()
            if (TextUtils.isEmpty(code)) {
                Toast.makeText(requireContext(), "Enter number!!", Toast.LENGTH_LONG).show()
            } else {
                mVerificationID?.let { it1 -> verifyPhoneNumberWithCode(it1, code) }
            }
        }

    }
//

    private fun startPhoneNumberVerification(phone: String) {

        val options = PhoneAuthOptions.newBuilder(fireBaseAuth)
            .setPhoneNumber(phone)
            .setTimeout(60L, TimeUnit.SECONDS)
            .setActivity(requireActivity())
            .setCallbacks(mCallBacks!!)
            .build()

        PhoneAuthProvider.verifyPhoneNumber(options)
    }

    private fun verifyPhoneNumberWithCode(verificationId: String, code: String) {
        val credential = PhoneAuthProvider.getCredential(verificationId, code)

        signWithPhoneAuthCredential(credential)
    }

    private fun signWithPhoneAuthCredential(credential: PhoneAuthCredential) {

        fireBaseAuth.signInWithCredential(credential)
            .addOnSuccessListener {
                binding.progressBar.visibility = View.GONE
                val phone = fireBaseAuth.currentUser?.phoneNumber
                Toast.makeText(requireContext(), "your number " + phone, Toast.LENGTH_SHORT).show()
                viewModel.saveSignUpState(true)
                viewModel.savePhoneNumber(phone!!)
                findNavController().navigate(SignUpFragmentDirections.actionSignUpFragmentToMainFragment())
            }
            .addOnFailureListener {
                binding.progressBar.visibility = View.GONE
                Toast.makeText(requireContext(), "Your number failed", Toast.LENGTH_SHORT).show()
            }
    }


}