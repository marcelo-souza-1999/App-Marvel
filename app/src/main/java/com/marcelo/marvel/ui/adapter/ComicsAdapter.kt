package com.marcelo.marvel.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.marcelo.marvel.R
import com.marcelo.marvel.databinding.ListItensComicsBinding
import com.marcelo.marvel.models.Comics

class ComicsAdapter(private val context: Context, private val comics: List<Comics>) :
    RecyclerView.Adapter<ComicsAdapter.ComicsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComicsViewHolder {

        val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
        val binding: ListItensComicsBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.list_itens_comics, parent, false)

        return ComicsViewHolder(binding, context)
    }

    override fun onBindViewHolder(holder: ComicsViewHolder, position: Int) {
        holder.bind(comics[position])
    }

    override fun getItemCount(): Int {
        return comics.size
    }

    class ComicsViewHolder(private val binding: ListItensComicsBinding, private val context: Context) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(comics: Comics) {

            val numberPages: String = comics.pageCount.toString()  + context.getString(R.string.comics_pages)
            binding.txtTitleComic.text = comics.title
            binding.txtDescriptionComic.text = comics.description
            binding.txtNumberPages.text = numberPages

            Glide
                .with(binding.root)
                .load(comics.thumbnail.path + "." + comics.thumbnail.extension)
                .centerCrop()
                .into(binding.imageViewComics)

        }
    }

}