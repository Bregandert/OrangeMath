package com.bregandert.orangemath.utils.rv_adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bregandert.orangemath.R
import com.bregandert.orangemath.databinding.OrangeItemBinding
import com.bregandert.orangemath.domain.entity.Orange

class OrangeAdapter: RecyclerView.Adapter<OrangeAdapter.OrangeHolder>() {



    val orangeList = ArrayList<Orange>()
    class OrangeHolder(item: View): RecyclerView.ViewHolder(item) {
        val binding = OrangeItemBinding.bind(item)
        fun bind(orange: Orange) = with(binding){
            imageOrange.setImageResource(orange.orangeImage)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrangeHolder {
        val viewOrange = LayoutInflater.from(parent.context).inflate(R.layout.orange_item, parent, false)
        return OrangeHolder(viewOrange)
    }

    override fun onBindViewHolder(holder: OrangeHolder, position: Int) {
        holder.bind(orangeList[position])
    }

    override fun getItemCount(): Int {
        return orangeList.size
    }

    fun addOrange(orange: Orange) {
        orangeList.add(orange)
        notifyDataSetChanged()

    }

    fun deleteOrange(orange: Orange){
    orangeList.remove(orangeList.last())
        notifyDataSetChanged()
    }

    fun clearOrangeList(orange: Orange) {
        orangeList.clear()
        notifyDataSetChanged()
    }


}