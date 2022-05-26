package org.d3if0059.hitungPangkat.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bmi")
data class HitungEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L,
    var tanggal: Long = System.currentTimeMillis(),
    var angka: Float,
    var pangkat: Float,
)