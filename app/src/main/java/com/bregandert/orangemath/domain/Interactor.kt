package com.bregandert.orangemath.domain

import com.bregandert.orangemath.R
import com.bregandert.orangemath.data.Mainrepository
import com.bregandert.orangemath.domain.entity.NumberCount
import com.bregandert.orangemath.domain.entity.Orange

class Interactor(val repo: Mainrepository) {

    fun getOrangeList(): List<Orange> = repo.orangeList

    fun getNumbersList(): List<NumberCount> = repo.numbersList

    fun addOrangeItem(n: Int): List<Orange> {
        if (0<n && n<11) {
            for (i in 1..n) {
                repo.orangeList.add(Orange(i, R.layout.orange_animation_item))
            }
            return repo.orangeList
        }
        else
            repo.orangeList = emptyList<Orange>().toMutableList()
        return repo.orangeList
    }

    fun getNumberItem(id: Int) : NumberCount {
        return repo.numbersList.get(id)
    }

}