package org.d3if0059.hitungPangkat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import org.d3if0059.hitungPangkat.databinding.ActivityMainBinding
import org.d3if0059.hitungPangkat.model.HasilHitungAkar
import org.d3if0059.hitungPangkat.model.HasilHitungKubik
import org.d3if0059.hitungPangkat.model.HasilHitungPangkat
import java.lang.Math.cbrt
import kotlin.math.pow
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener { hitungPangkat() }
        binding.buttonKuadrat.setOnClickListener { hitungAkarKuadrat() }
        binding.buttonKubik.setOnClickListener { hitungAkarKubik() }
        binding.buttonClear.setOnClickListener { clearButton() }
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
        val result = hitungPangkat(
            angka.toFloat(),
            pangkat.toFloat(),
        )
        showResult(result)

    }
    private fun hitungPangkat(angka:Float , pangkat:Float): HasilHitungPangkat {
        val hitung = angka.toDouble().pow(pangkat.toDouble())
        return HasilHitungPangkat(hitung)
    }

    private fun showResult(result: HasilHitungPangkat) {
        binding.hasilTextView.text = getString(R.string.hitungPangkat_x, result.pangkat)
    }


    private fun hitungAkarKuadrat() {
        val angkaAkar = binding.angkaAkarInp.text.toString()
        if (TextUtils.isEmpty(angkaAkar)) {
            Toast.makeText(this, R.string.angka_invalid, Toast.LENGTH_LONG).show()
            return
        }
        val result = hitungAkarKuadrat(
            angkaAkar.toFloat(),
        )
        showResult(result)
    }

    private fun hitungAkarKuadrat(angkaAkar:Float): HasilHitungAkar {
        val hitungAkar = (sqrt(angkaAkar.toDouble()))
        return HasilHitungAkar(hitungAkar)
    }
    private fun showResult(result: HasilHitungAkar) {
        binding.hasilAkarTextView.text = getString(R.string.hitungAkar_x, result.akar)
    }

    private fun hitungAkarKubik() {
        val angkaKubik = binding.angkaAkarInp.text.toString()
        if (TextUtils.isEmpty(angkaKubik)) {
            Toast.makeText(this, R.string.angka_invalid, Toast.LENGTH_LONG).show()
            return
        }
        val result = hitungAkarKubik(
            angkaKubik.toFloat(),
        )
        showResult(result)
    }
    private fun hitungAkarKubik(angkaKubik:Float): HasilHitungKubik {
        val hitungKubik = (cbrt(angkaKubik.toDouble()))
        return HasilHitungKubik(hitungKubik)
    }
    private fun showResult(result: HasilHitungKubik) {
        binding.hasilAkarTextView.text = getString(R.string.hitungAkar_x, result.kubik)
    }

    private fun clearButton(){
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener { hitungPangkat() }
        binding.buttonClear.setOnClickListener { clearButton() }
    }

}