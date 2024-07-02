package com.bregandert.orangemath.data

import com.bregandert.orangemath.R
import com.bregandert.orangemath.R.layout.orange_animation_item
import com.bregandert.orangemath.domain.entity.NumberCount
import com.bregandert.orangemath.domain.entity.Orange

class Mainrepository {

    var orangeList = mutableListOf<Orange>()

    val numbersList = listOf(
        NumberCount("1", R.drawable.number_background),
        NumberCount("2", R.drawable.number_background)
    )

//    fun addOrangeItem(n: Int): List<Orange> {
//        if (0<n && n<11) {
//            for (i in 1..n) {
//                orangeList.add(Orange(i, orange_animation_item))
//            }
//            return orangeList
//        }
//        else
//            orangeList = emptyList<Orange>().toMutableList()
//        return orangeList
//    }
//
//    fun getNumberItem(id: Int) : NumberCount {
//        return numbersList.get(id)
//        }

}