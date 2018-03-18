package com.costular.marvelheroes.presentation.heroeslist

import android.app.VoiceInteractor
import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.support.v7.graphics.Palette
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.costular.marvelheroes.R
import com.costular.marvelheroes.domain.model.MarvelHeroEntity
import kotlinx.android.synthetic.main.item_hero.view.*

        /**
 * Created by costular on 17/03/2018.
 */
typealias Click = (MarvelHeroEntity, ImageView) -> Unit

class HeroesListAdapter(val clickListener: Click):  RecyclerView.Adapter<HeroesListAdapter.HeroesViewHolder>() {

    private lateinit var context: Context

    private var data: MutableList<MarvelHeroEntity> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroesViewHolder {
        context = parent.context!!
        return HeroesViewHolder(
                LayoutInflater.from(parent.context)
                        .inflate(R.layout.item_hero, parent, false)
        )
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: HeroesViewHolder, position: Int) = holder.bind(data[position])

    fun swapData(data: List<MarvelHeroEntity>) {
        this.data.clear()
        this.data.addAll(data)
        notifyDataSetChanged()
    }

    fun clear() {
        this.data.clear()
        notifyDataSetChanged()
    }

    inner class HeroesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: MarvelHeroEntity) = with(itemView) {
            kotlin.with(itemView) {
                Glide.with(context)
                        .asBitmap()
                        .load(item.photoUrl)
                        .listener(object : RequestListener<Bitmap> {
                            override fun onResourceReady(resource: Bitmap?, model: Any?, target: Target<Bitmap>?, dataSource: DataSource?, isFirstResource: Boolean): Boolean {
                                resource?.let { loadColorsFromBitmap(it) }
                                return false
                            }
                            override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<Bitmap>?, isFirstResource: Boolean): Boolean {
                                return false
                            }

                        })
                        .into(heroImage)

                heroTitle.text = item.name
                setOnClickListener { clickListener(item, heroImage) }
            }
        }

        fun loadColorsFromBitmap(bitmap: Bitmap) {
            with(itemView) {
                Palette.from(bitmap).generate { palette ->
                    val vibrant = palette.vibrantSwatch
                    vibrant?.let {
                        heroTitle.setBackgroundColor(vibrant.rgb)
                        heroTitle.setTextColor(vibrant.bodyTextColor)
                    }
                }
            }
        }
    }
}