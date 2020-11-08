package com.udacity.shoestore

import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginBinding
import com.udacity.shoestore.models.User
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment() {


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentLoginBinding>(inflater, R.layout.fragment_login, container, false)
        binding.apply {
            user?.email = email_edt_text?.text.toString()
            user?.password = pass_edt_text?.text.toString()
            invalidateAll()
        }
        binding.hideBtn.setOnClickListener {
            binding.hideBtn.visibility = View.INVISIBLE
            binding.showBtn.visibility = View.VISIBLE
            pass_edt_text.transformationMethod = HideReturnsTransformationMethod.getInstance()

        }
        binding.showBtn.setOnClickListener {
            binding.showBtn.visibility = View.INVISIBLE
            binding.hideBtn.visibility = View.VISIBLE
            pass_edt_text.transformationMethod = PasswordTransformationMethod.getInstance()
        }

        binding.loginBtn.setOnClickListener(
                Navigation.createNavigateOnClickListener(R.id.action_loginFragment_to_welcomeFragment))
        binding.newAccountBtn.setOnClickListener(
                Navigation.createNavigateOnClickListener(R.id.action_loginFragment_to_welcomeFragment))
        return binding.root

    }


}