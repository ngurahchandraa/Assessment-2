package org.d3if0059.hitungPangkat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import org.d3if0059.hitungPangkat.R
import org.d3if0059.hitungPangkat.databinding.ActivityMainBinding
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener { hitungPangkat() }
        binding.button2.setOnClickListener { clearButton() }
    }
    private fun hitungPangkat() {
        val angka = binding.angkaInp.text.toString()
        if (TextUtils.isEmpty(angka)) {
            Toast.makeText(this, R.string.angka_invalid, Toast.LENGTH_LONG).show()
            return
        }
        val pangkat = binding.pangkatInp.text.toString()
        if (TextUtils.isEmpty(pangkat)) {
            Toast.makeText(this, R.string.pangkat_invalid, Toast.LENGTH_LONG).show()
            return
        }
        val hitung = angka.toDouble().pow(pangkat.toDouble())
        binding.hasilTextView.text = getString(R.string.hitungPangkat_x, hitung)

    }
    private fun clearButton(){
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener { hitungPangkat() }
        binding.button2.setOnClickListener { clearButton() }
    }

}