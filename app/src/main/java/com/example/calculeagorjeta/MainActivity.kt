package com.example.calculeagorjeta

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.calculeagorjeta.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.botaoCalcular.setOnClickListener { calculo() }
    }
    fun calculo(){
        val stringInTextField = binding.custoDoServico.text.toString()
        val custo = stringInTextField.toDouble()
        val selecaoid = binding.opcoes.checkedRadioButtonId
        val calculoPorcentagem = when (selecaoid){
            R.id.opcao_vinte_porcento -> 0.20
            R.id.opcao_dezoito_porcento -> 0.18
            else -> 0.15
        }
        var tip = calculoPorcentagem * custo
        val arredondar = binding.arredondarValor.isChecked
        if(arredondar){
            tip = kotlin.math.ceil(tip)
        }
        val formattedTip = NumberFormat.getCurrencyInstance().format(tip)
        binding.resultado.text = getString(R.string.valor_da_gorjeta, formattedTip)

    }

}