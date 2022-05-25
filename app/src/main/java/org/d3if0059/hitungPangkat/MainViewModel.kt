package org.d3if0059.hitungPangkat

import androidx.lifecycle.ViewModel
import org.d3if0059.hitungPangkat.model.HasilHitungAkar
import org.d3if0059.hitungPangkat.model.HasilHitungPangkat
import kotlin.math.pow
import kotlin.math.sqrt

class MainViewModel : ViewModel() {
    fun hitungPangkat(angka:Float , pangkat:Float): HasilHitungPangkat {
        val hitung = angka.toDouble().pow(pangkat.toDouble())
        return HasilHitungPangkat(hitung)
    }
    fun hitungPangkat(angkaAkar:Float): HasilHitungAkar {
        val hitungAkar = (sqrt(angkaAkar.toDouble()))
        return HasilHitungAkar(hitungAkar)
    }

}