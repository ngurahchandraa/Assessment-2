package org.d3if0059.hitungPangkat.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.d3if0059.hitungPangkat.db.HitungDao
import org.d3if0059.hitungPangkat.db.HitungEntity
import org.d3if0059.hitungPangkat.model.HasilHitungAkar
import org.d3if0059.hitungPangkat.model.HasilHitungPangkat
import org.d3if0059.hitungPangkat.model.HasilHitungKubik
import kotlin.math.pow
import kotlin.math.sqrt

class HitungViewModel : ViewModel() {

    fun hitungPangkat(angka:Float , pangkat:Float): HasilHitungPangkat {
        val hitung = angka.toDouble().pow(pangkat.toDouble())
        return HasilHitungPangkat(hitung)

    }
    fun hitungPangkatKuadrat(angkaAkar:Float): HasilHitungAkar {
        val hitungAkar = (sqrt(angkaAkar.toDouble()))
        return HasilHitungAkar(hitungAkar)
    }
    fun hitungPangkatKubik(angkaKubik:Float):HasilHitungKubik{
        val hitungKubik = (Math.cbrt(angkaKubik.toDouble()))
        return HasilHitungKubik(hitungKubik)
    }

}