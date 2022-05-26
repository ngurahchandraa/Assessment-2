package org.d3if0059.hitungPangkat.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface HitungDao {
    @Insert
    fun insert(hitung: HitungEntity)
    @Query("SELECT * FROM bmi ORDER BY id DESC LIMIT 1")
    fun getLastHitung(): LiveData<HitungEntity?>
}