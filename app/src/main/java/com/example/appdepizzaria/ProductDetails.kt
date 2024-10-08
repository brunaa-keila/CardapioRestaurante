package com.example.appdepizzaria

import android.content.Intent
import android.graphics.Color
import android.icu.text.DecimalFormat
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.appdepizzaria.databinding.ActivityProductDetailsBinding

class ProductDetails : AppCompatActivity() {

    private lateinit var binding: ActivityProductDetailsBinding
    var amount = 1

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Corrige o formato da cor
        window.statusBarColor = Color.parseColor("#E0E0E0")

        // Verifica se os extras não são nulos
        val extras = intent.extras
        if (extras != null) {
            // Obtém os valores da Intent com verificações de nulos
            val imgProduct = extras.getInt("imgProduct", -1)
            val name = extras.getString("name") ?: "Produto desconhecido"
            val price = extras.getString("price")?.toDoubleOrNull() ?: 0.0
            var newPrice = price
            val decimalFormat = DecimalFormat.getCurrencyInstance()

            // Atualiza os campos apenas se imgProduct for válido
            if (imgProduct != -1) {
                binding.imgProduct.setBackgroundResource(imgProduct)
            }

            binding.txtProductName.text = name
            binding.txtPrice.text = String.format("R$ %.2f", price)

            binding.btBack.setOnClickListener{
                val intent = Intent(this,MainActivity::class.java)
                startActivity(intent)
                finish()
            }
            binding.btIncrease.setOnClickListener{
                if (amount == 1) {
                    binding.txtAmount.text = "2"
                    newPrice += price // Adicionando o preço
                    amount = 2
                } else if (amount == 2) {
                    binding.txtAmount.text = "3"
                    newPrice += price // Adicionando o preço novamente
                    amount = 3
                }
                binding.txtPrice.text = decimalFormat.format(newPrice)
            }

            binding.btToDecrease.setOnClickListener{
                if (amount == 3) {
                    binding.txtAmount.text = "2"
                    newPrice += price // Adicionando o preço
                    amount = 2
                } else if (amount == 2) {
                    binding.txtAmount.text = "1"
                    newPrice -= price // Adicionando o preço novamente
                    amount = 1
                }
                binding.txtPrice.text = decimalFormat.format(newPrice)
            }

            binding.btConfirm.setOnClickListener{
                val mustard = binding.btMustard
                val ketchup = binding.btKetchup
                val lemonSoda = binding.btLemonSoda
                val juice = binding.btJuice

                val saucesAndDrinks = when{
                    mustard.isChecked -> {
                        "Mustard"
                    }
                    ketchup.isChecked -> {
                        "Ketchup"
                    }
                    lemonSoda.isChecked -> {
                        "Lemon Soda"
                    }
                    juice.isChecked -> {
                        "Juice"
                    }

                    else -> {
                        ""
                    }
                }
                val intent = Intent(this,Payment::class.java)
                intent.putExtra("name",name)
                intent.putExtra("amount",amount)
                intent.putExtra("total",newPrice)
                intent.putExtra("saucesAndDrinks",saucesAndDrinks)
                startActivity(intent)



            }





        } else {
            // Lidar com a situação em que os extras são nulos
            binding.txtProductName.text = "Produto não encontrado"
            binding.txtPrice.text = "R$ 0.00"
        }
    }
}
