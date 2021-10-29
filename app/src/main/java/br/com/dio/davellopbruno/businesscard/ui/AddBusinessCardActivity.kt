package br.com.dio.davellopbruno.businesscard.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import br.com.dio.davellopbruno.businesscard.App
import br.com.dio.davellopbruno.businesscard.R
import br.com.dio.davellopbruno.businesscard.data.Businesscard
import br.com.dio.davellopbruno.businesscard.databinding.ActivityAddBusinessCardBinding

class AddBusinessCardActivity : AppCompatActivity() {
    private val binding by lazy { ActivityAddBusinessCardBinding.inflate(layoutInflater) }

    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as App).repository)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        insertListener()
    }

    private fun insertListener() {

        binding.btnClose.setOnClickListener{
            finish()
        }

        binding.btnConfirmar.setOnClickListener{
            val businesscard = Businesscard (
                nome = binding.tilName.editText?.text.toString(),
                empresa = binding.tilEmpresa.editText?.text.toString(),
                telefone = binding.tilTelefone.editText?.text.toString(),
                email = binding.tilEmail.editText?.text.toString(),
                fundoPersonalizado = binding.tilCor.editText?.text.toString()
            )
            mainViewModel.insert(businesscard)
            Toast.makeText(this, R.string.label_show_success,Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}