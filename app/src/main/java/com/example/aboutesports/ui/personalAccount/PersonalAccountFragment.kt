package com.example.aboutesports.ui.personalAccount

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.aboutesports.MainActivity
import com.example.aboutesports.R
import com.example.aboutesports.Repo.dataTest.NewsTest
import com.example.aboutesports.Repo.dataTest.NewsTest.user
import com.example.aboutesports.databinding.FragmentPersonalAccountBinding

class PersonalAccountFragment : Fragment() {

    private var _binding: FragmentPersonalAccountBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentPersonalAccountBinding.inflate(inflater, container, false)

         if (user != null){
             binding.name.text = user?.email
             binding.signIn.text = "Выйти"
             binding.signIn.setOnClickListener{
                 binding.name.text = getString(R.string.sign_up_need)
                 binding.signIn.text = getString(R.string.sign_in_action)
                 user = null
                 binding.signIn.setOnClickListener{
                     (activity as MainActivity).sign_in()
                     binding.signIn.text = "Выйти"
                     binding.name.text = user?.email
                 }
             }
        } else {
             binding.name.text = getString(R.string.sign_up_need)
             binding.signIn.text = getString(R.string.sign_in_action)
             binding.signIn.setOnClickListener{
                 (activity as MainActivity).sign_in()
                 binding.signIn.text = "Выйти"
                 binding.name.text = user?.email
             }
        }



        return binding.root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}