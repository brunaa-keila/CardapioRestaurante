package com.example.appdepizzaria

import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.appdepizzaria.adapter.ProductAdapter
import com.example.appdepizzaria.databinding.ActivityMainBinding
import com.example.appdepizzaria.listitems.Products
import com.example.appdepizzaria.model.Product
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectIndexed
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var productAdapter: ProductAdapter
    private val products = Products()
    private val productList: MutableList<Product> = mutableListOf()
    var clicked = false


    @RequiresApi(Build.VERSION_CODES.M)
    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.statusBarColor = Color.parseColor("#E0E0E0")

        CoroutineScope(Dispatchers.IO).launch {
            products.getProducts().collectIndexed { index, value ->
               for (p: Product in value){
                   productList.add(p)
               }
            }

        }

        val recyclerViewProducts: RecyclerView = binding.recyclerViewProducts
        recyclerViewProducts.layoutManager = GridLayoutManager(this,2)
        recyclerViewProducts.setHasFixedSize(true)
        productAdapter = ProductAdapter(this,productList)
        recyclerViewProducts.adapter = productAdapter


        binding.btAll.setOnClickListener{
            clicked = true
            if (clicked){
                binding.btAll.setBackgroundResource(R.drawable.bg_button_enabled)
                binding.btAll.setTextColor(getColor(R.color.white))
                binding.btChicken.setBackgroundResource(R.drawable.bg_button_disabled)
                binding.btChicken.setTextColor(R.color.dark_gray)
                binding.btKebab.setBackgroundResource(R.drawable.bg_button_disabled)
                binding.btKebab.setTextColor(R.color.dark_gray)
                binding.btPizza.setBackgroundResource(R.drawable.bg_button_disabled)
                binding.btPizza.setTextColor(R.color.dark_gray)
                binding.recyclerViewProducts.visibility = View.INVISIBLE
                binding.txtListTitle.text = "All"


            }
        }

        binding.btChicken.setOnClickListener{
            clicked = true
            if (clicked){
                binding.btChicken.setBackgroundResource(R.drawable.bg_button_enabled)
                binding.btChicken.setTextColor(getColor(R.color.white))

                binding.btAll.setBackgroundResource(R.drawable.bg_button_disabled)
                binding.btAll.setTextColor(R.color.dark_gray)

                binding.btKebab.setBackgroundResource(R.drawable.bg_button_disabled)
                binding.btKebab.setTextColor(R.color.dark_gray)

                binding.btPizza.setBackgroundResource(R.drawable.bg_button_disabled)
                binding.btPizza.setTextColor(R.color.dark_gray)

                binding.recyclerViewProducts.visibility = View.INVISIBLE
                binding.txtListTitle.text = "Chicken"


            }
        }

        binding.btPizza.setOnClickListener{
            clicked = true
            if (clicked){

                binding.btPizza.setBackgroundResource(R.drawable.bg_button_enabled)
                binding.btPizza.setTextColor(getColor(R.color.white))

                binding.btChicken.setBackgroundResource(R.drawable.bg_button_disabled)
                binding.btChicken.setTextColor(R.color.dark_gray)

                binding.btAll.setBackgroundResource(R.drawable.bg_button_disabled)
                binding.btAll.setTextColor(R.color.dark_gray)

                binding.btKebab.setBackgroundResource(R.drawable.bg_button_disabled)
                binding.btKebab.setTextColor(R.color.dark_gray)


                binding.recyclerViewProducts.visibility = View.VISIBLE
                binding.txtListTitle.text = "Popular Pizza"


            }
        }

        binding.btKebab.setOnClickListener{
            clicked = true
            if (clicked){

                binding.btKebab.setBackgroundResource(R.drawable.bg_button_enabled)
                binding.btKebab.setTextColor(getColor(R.color.white))

                binding.btPizza.setBackgroundResource(R.drawable.bg_button_disabled)
                binding.btPizza.setTextColor(R.color.dark_gray)

                binding.btChicken.setBackgroundResource(R.drawable.bg_button_disabled)
                binding.btChicken.setTextColor(R.color.dark_gray)

                binding.btAll.setBackgroundResource(R.drawable.bg_button_disabled)
                binding.btAll.setTextColor(R.color.dark_gray)


                binding.recyclerViewProducts.visibility = View.INVISIBLE
                binding.txtListTitle.text = "Kebab"


            }
        }



        }
    }
