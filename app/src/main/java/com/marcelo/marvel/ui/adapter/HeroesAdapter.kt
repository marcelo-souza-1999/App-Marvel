package com.marcelo.marvel.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.marcelo.marvel.R
import com.marcelo.marvel.databinding.ListItensHeroesBinding
import com.marcelo.marvel.models.Heroes

class HeroesAdapter(private val heroes: List<Heroes> = listOf()) :
    RecyclerView.Adapter<HeroesAdapter.HeroesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroesViewHolder {

        val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
        val binding: ListItensHeroesBinding = DataBindingUtil.inflate(layoutInflater, R.layout.list_itens_heroes, parent, false)

        return HeroesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HeroesViewHolder, position: Int) {
        holder.bind(heroes[position])
    }

    override fun getItemCount(): Int {
        return heroes.size
    }


    class HeroesViewHolder(private val binding: ListItensHeroesBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(heroes: Heroes) {

            binding.txtNameHeroes.text = heroes.name
            binding.txtDescriptionHeroes.text = heroes.description

            Glide
                .with(binding.root)
                .load(heroes.thumbnail.path + heroes.thumbnail.extension)
                .centerCrop()
                .into(binding.imageViewHeroes)
        }
    }

}