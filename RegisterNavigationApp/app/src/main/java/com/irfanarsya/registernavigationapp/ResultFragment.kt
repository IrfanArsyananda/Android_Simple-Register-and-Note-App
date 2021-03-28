package com.irfanarsya.registernavigationapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_result.*

class ResultFragment : Fragment(), View.OnClickListener {

    lateinit var navController: NavController
    var get_name:String? = null
    var get_email:String? = null
    var get_password:String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_result, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        get_name = arguments?.getString("nm")
        get_email = arguments?.getString("em")
        get_password = arguments?.getString("pw")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        btnBack.setOnClickListener(this)
        btnBackLogin.setOnClickListener(this)

        tNama.text = get_name
        tEmail.text = get_email
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.btnBack -> activity?.onBackPressed()
        }
    }

}