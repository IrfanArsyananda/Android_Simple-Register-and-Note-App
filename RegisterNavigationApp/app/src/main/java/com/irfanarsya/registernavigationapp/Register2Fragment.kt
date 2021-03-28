package com.irfanarsya.registernavigationapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_register1.*
import kotlinx.android.synthetic.main.fragment_register2.*
import kotlinx.android.synthetic.main.fragment_register2.btnBack

class Register2Fragment : Fragment(), View.OnClickListener {

    lateinit var navController: NavController
    var get_name: String? = null
    var get_email:String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register2, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        get_name = arguments?.getString("nm")
        get_email = arguments?.getString("em")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        btnFinish.setOnClickListener(this)
        btnBack.setOnClickListener(this)

        tHalo.text = "Halo $get_name, untuk melanjutkan registrasi, silahkan buat password di bawah "
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.btnFinish -> {
                if (ePassword.text.toString().isEmpty()){
                    ePassword.error = "Password harus diisi !"
                }else if (eConfirmPassword.text.toString().isEmpty()){
                    eConfirmPassword.error = "Konfirmasi password harus diisi !"
                }else if (ePassword.text.toString() != eConfirmPassword.text.toString()){
                    eConfirmPassword.error = "Konfirmasi password tidak cocok !"
                    Toast.makeText(context,"Konfirmasi tidak cocok !", Toast.LENGTH_LONG).show()
                }else{
                    val bundle = bundleOf(
                            "nm" to get_name,
                            "em" to get_email,
                            "pw" to ePassword.text.toString()
                    )
                    navController.navigate(R.id.action_register2Fragment_to_resultFragment, bundle)
                }
            }
            R.id.btnBack -> activity?.onBackPressed()
        }
    }

}