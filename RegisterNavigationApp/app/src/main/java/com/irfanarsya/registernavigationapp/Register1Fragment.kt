package com.irfanarsya.registernavigationapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_register1.*

class Register1Fragment : Fragment(), View.OnClickListener {

    lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        btnBack.setOnClickListener(this)
        btnNext.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.btnNext -> {
                if (eNama.text.toString().isEmpty()){
                    eNama.error = "Nama harus diisi !"
                }else if (eEmail.text.toString().isEmpty()){
                    eEmail.error = "E-mail harus diisi !"
                }else{
                    val bundle = bundleOf("nm" to eNama.text.toString(), "em" to eEmail.text.toString())
                    navController.navigate(R.id.action_register1Fragment_to_register2Fragment, bundle)
                }
            }
            R.id.btnBack -> activity?.onBackPressed()
        }
    }

}