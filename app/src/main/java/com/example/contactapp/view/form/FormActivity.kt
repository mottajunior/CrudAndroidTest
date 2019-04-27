package com.example.contactapp.view.form

import android.app.Activity
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.contactapp.R
import com.example.contactapp.model.ResponseStatus
import kotlinx.android.synthetic.main.activity_form.*
//import kotlinx.android.synthetic.main.loading.*

class FormActivity : AppCompatActivity() {

    private lateinit var formularioViewModel: FormViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)


    val FormViewModel = ViewModelProviders.of(this)
    .get(FormViewModel::class.java)

    btSalvar.setOnClickListener {
        FormViewModel.salvar(
            0,
            inputNome.editText?.text.toString(),
            Integer.parseInt(inputIdade.editText?.text.toString())
        )
    }

    registerObserver()
    }
 }

private fun registerObserver() {
    //FormViewModel.responseStatus.observe(this, responseObserver)
    //FormViewModel.isLoading.observe(this, loadingObserver)
}

/*private var loadingObserver = Observer<Boolean> {
    if (it == true) {
        containerLoading.visibility = View.VISIBLE
    } else {
        containerLoading.visibility = View.GONE
    }
}*/

private var responseObserver = Observer<ResponseStatus> {
    //Toast.makeText(this, it?.mensagem, Toast.LENGTH_SHORT).show()
    if (it?.sucesso == true) {
        //setResult(Activity.RESULT_OK)
      //  finish()
    }

}

