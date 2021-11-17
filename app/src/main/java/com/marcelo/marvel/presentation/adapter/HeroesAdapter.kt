package com.marcelo.marvel.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.marcelo.marvel.R
import com.marcelo.marvel.databinding.ListItensHeroesBinding
import com.marcelo.marvel.domain.models.Hero

class HeroesAdapter(
    private val heroes: List<Hero>,
    private val onItemClickListener: ((heroi: Hero) -> Unit)
) :
    RecyclerView.Adapter<HeroesAdapter.HeroesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroesViewHolder {

        val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
        val binding: ListItensHeroesBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.list_itens_heroes, parent, false)

        return HeroesViewHolder(binding, onItemClickListener)
    }

    override fun onBindViewHolder(holder: HeroesViewHolder, position: Int) {
        holder.bind(heroes[position])
    }

    override fun getItemCount(): Int {
        return heroes.size
    }

    class HeroesViewHolder(private val binding: ListItensHeroesBinding, private val onItemClickListener: ((heroi: Hero) -> Unit)) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(hero: Hero) {

            binding.txtNameHeroes.text = hero.name
            binding.txtDescriptionHeroes.text = hero.description

            Glide
                .with(binding.root)
                .load(hero.thumbnail.path + "." + hero.thumbnail.extension)
                .centerCrop()
                .error(R.drawable.broken_shield)
                .into(binding.imageViewHeroes)

            binding.imageViewHeroes.setOnClickListener {
                onItemClickListener(hero)
            }
        }
    }

}