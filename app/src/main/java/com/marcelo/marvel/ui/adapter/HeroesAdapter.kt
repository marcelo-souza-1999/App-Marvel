package com.marcelo.marvel.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.marcelo.marvel.R
import com.marcelo.marvel.models.Heroes
import kotlinx.android.synthetic.main.list_itens_heroes.view.*

class HeroesAdapter(private val heroes: List<Heroes>) :
    RecyclerView.Adapter<HeroesAdapter.HeroesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroesViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_itens_heroes, parent, false)

        return HeroesViewHolder(view)
    }

    override fun onBindViewHolder(holder: HeroesViewHolder, position: Int) {
        holder.bind(heroes[position])
    }

    override fun getItemCount(): Int {
        return heroes.size
    }

    class HeroesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameHeroe = itemView.txtNameHeroes
        private val descriptionHeroe = itemView.txtDescriptionHeroes
        private val imageHeroe = itemView.imageViewHeroes

        fun bind(heroes: Heroes) {
            nameHeroe.text = heroes.name
            descriptionHeroe.text = heroes.description

            Log.d("testeAdapter", "Aqui 1");

            Glide
                .with(itemView)
                .load(heroes.thumbnail.path + "." + heroes.thumbnail.extension)
                .centerCrop()
                .into(this.imageHeroe)

            Log.d("testeAdapter", "Aqui foto: "+ heroes.thumbnail.path + "." + heroes.thumbnail.extension);
        }
    }

}