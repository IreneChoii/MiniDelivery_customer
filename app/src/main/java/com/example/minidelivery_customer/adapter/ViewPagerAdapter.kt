package com.example.minidelivery_customer.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.minidelivery_customer.R
import com.example.minidelivery_customer.item.BannerItem
import com.example.minidelivery_customer.model.Interaction

class ViewPagerAdapter(private val interaction: Interaction) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    companion object {
        const val ITEM_COUNT = 5
    }

    private var bannerItemList: List<BannerItem>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return BannerViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_layout_banner, parent, false),
            interaction
        )
    }

    override fun getItemCount(): Int {
        return ITEM_COUNT
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        bannerItemList?.let { bannerItemList ->
            (holder as BannerViewHolder).bind(bannerItemList[position])
        }
    }

    // functions
    fun submitList(list: List<BannerItem>?) {
        bannerItemList = list
        notifyDataSetChanged()
    }


    // ViewHolder
    class BannerViewHolder constructor(itemView: View, private val interaction: Interaction) :
        RecyclerView.ViewHolder(itemView) {
        private val ivBannerImage: ImageView = itemView.findViewById(R.id.iv_banner_image)

        fun bind(bannerItem: BannerItem) {
            itemView.setOnClickListener {
                interaction.onBannerItemClicked(bannerItem)
            }
            ivBannerImage.setImageResource(bannerItem.image)
        }
    }
}