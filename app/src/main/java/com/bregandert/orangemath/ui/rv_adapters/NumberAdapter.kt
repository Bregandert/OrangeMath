package com.bregandert.orangemath.ui.rv_adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bregandert.orangemath.R
import com.bregandert.orangemath.databinding.NumbercountItemBinding
import com.bregandert.orangemath.domain.entity.NumberCount

class NumberAdapter: RecyclerView.Adapter<NumberAdapter.NumberHolder>() {

    val numberList = ArrayList<NumberCount>()
    class NumberHolder(item: View): RecyclerView.ViewHolder(item) {
        val binding = NumbercountItemBinding.bind(item)



        fun bind(numberCount: NumberCount) = with(binding){
            imageNumber.setImageResource(numberCount.numberImage)
            textNumber.text=numberCount.number

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NumberHolder {
        val viewNumber = LayoutInflater.from(parent.context).inflate(R.layout.numbercount_item, parent, false)
        return NumberHolder(viewNumber)
    }

    override fun onBindViewHolder(holder: NumberHolder, position: Int) {
        holder.bind(numberList[position])
    }

    override fun getItemCount(): Int {
        return numberList.size
    }

    fun addNumber(number: NumberCount) {
        numberList.clear()
        numberList.add(number)
        notifyDataSetChanged()

    }

    fun deleteNumber(number: NumberCount){
    numberList.remove(numberList.last())
        notifyDataSetChanged()
    }


}