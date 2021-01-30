package com.dicoding.picodiploma.barvolume

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.dicoding.picodiploma.barvolume.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {


    companion object{
        private const val STATE_RESULT = "state_result"
    }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)




        binding.btnCalculate.setOnClickListener(this)

        if (savedInstanceState != null){
            val result = savedInstanceState.getString(STATE_RESULT)
            binding.tvResult.text = result
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_RESULT, binding.tvResult.text.toString())
    }

    override fun onClick(v: View?) {
        if (v != null) {
            if (v.id == R.id.btn_calculate){
                val inputLength = binding.edtLength.text.toString().trim()
                val inputWidth = binding.edtWidth.text.toString().trim()
                val inputHeight = binding.edtHeight.text.toString().trim()

                var isEmptyField = false

                when{
                    inputLength.isEmpty() -> {
                        isEmptyField = true
                        binding.edtLength.error = "Field ini tidak boleh kosong!"
                    }
                    inputWidth.isEmpty() -> {
                        isEmptyField = true
                        binding.edtWidth.error = "Field ini tidak boleh kosong!"
                    }
                    inputHeight.isEmpty() -> {
                        isEmptyField = true
                        binding.edtHeight.error = "Field ini tidak boleh kosong!"
                    }
                }

                if (!isEmptyField){
                    val volume = inputHeight.toDouble() * inputLength.toDouble() * inputWidth.toDouble()
                    binding.tvResult.text = volume.toString()
                }


            }
        }
    }
}