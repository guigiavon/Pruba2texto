package com.example.pruba2texto
import MainViewModel
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.pruba2texto.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModelComparison: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModelComparison = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.btnComparar.setOnClickListener {
            val text1 = binding.editText1.text.toString()
            val text2 = binding.editText2.text.toString()

            viewModelComparison.comparar(text1, text2)
        }

        viewModelComparison.resultLiveData.observe(this, Observer { result ->
            if (result) {
                binding.textViewResult.text = "Los textos son iguales."
            } else {
                binding.textViewResult.text = "Los textos son diferentes."
            }
        })
    }
}
