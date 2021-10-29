package br.com.dio.davellopbruno.businesscard.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Businesscard(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val nome: String,
    val empresa: String,
    val telefone:String,
    val email: String,
    val fundoPersonalizado: String,
)