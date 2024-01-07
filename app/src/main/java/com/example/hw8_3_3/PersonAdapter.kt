package com.example.hw8_3_3
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.hw8_3_3.databinding.ItemPersonBinding

class PersonAdapter(private val personList: ArrayList<Person>, var onClick: (position: Int) -> Unit): Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemPersonBinding.inflate
            (LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return personList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(personList[position])
        holder.itemView.setOnClickListener {
            onClick(position)
        }
    }
}

class ViewHolder(private val binding: ItemPersonBinding): RecyclerView.ViewHolder(binding.root){

    fun onBind(person: Person){
        binding.tvName.text = person.name
        binding.tvStatus.text = person.status
        binding.imgPoster.loadImage(person.img)
    }
}