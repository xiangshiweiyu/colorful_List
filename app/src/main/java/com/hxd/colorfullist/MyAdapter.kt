package com.hxd.colorfullist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

/**
 * @CreateTime: 2020/8/19  15:34
 * @author:
 * @Content:
 * @UpdateTime:
 * @UpdateName;
 * @UpdateContent:
 */
class MyAdapter(private var context: Context) :

    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val head: Int = 1000
    private val itemPt: Int = 1001
    private val cardView: Int = 1002
    private val img: Int = 1003

    private lateinit var data: List<Bean>


    public fun setData(data: List<Bean>) {
        this.data = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        when (viewType) {
            head -> HeadViewHolder(
                LayoutInflater.from(context).inflate(R.layout.item_head, parent, false)
            )
            itemPt -> PtViewHolder(
                LayoutInflater.from(context).inflate(R.layout.item_pt, parent, false)
            )
            cardView -> CardViewHolder(
                LayoutInflater.from(context).inflate(R.layout.item_card_view, parent, false)
            )
            else -> ImageViewHolder(
                LayoutInflater.from(context).inflate(R.layout.item_img, parent, false)
            )
        }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val bean = data[position]
        when (holder) {
            is HeadViewHolder -> {
                Glide.with(context).load(bean.id1).into(holder.ibHead)
                holder.tvHead.text = bean.text
            }
            is PtViewHolder -> {
                Glide.with(context).load(bean.id1).into(holder.ivItemPt)
                holder.tvItemPt.text = bean.text
            }

            is CardViewHolder -> {
                Glide.with(context).load(bean.id1).into(holder.ivCard1)
                Glide.with(context).load(bean.id2).into(holder.ivCard2)
                Glide.with(context).load(bean.id3).into(holder.ivCard3)
            }

            is ImageViewHolder -> Glide.with(context).load(bean.id1).into(holder.ivItemImg)
        }
    }

    /**
     * 返回 数据 size
     */
    override fun getItemCount(): Int = data.size


    /**
     * 返回不同 item 标志位
     */
    override fun getItemViewType(position: Int): Int = data[position].type


    inner class HeadViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ibHead: ImageButton = itemView.findViewById(R.id.ib_head)
        val tvHead: TextView = itemView.findViewById(R.id.tv_username)
    }

    inner class PtViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val ivItemPt: ImageView = itemView.findViewById(R.id.iv_pt_item)
        val tvItemPt: TextView = itemView.findViewById(R.id.tv_pt_item);
    }

    inner class CardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val ivCard1: ImageView = itemView.findViewById(R.id.iv_card_1)
        val ivCard2: ImageView = itemView.findViewById(R.id.iv_card_2)
        val ivCard3: ImageView = itemView.findViewById(R.id.iv_card_3)
        val cvCard: CardView = itemView.findViewById(R.id.cv_card_view)
    }

    inner class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivItemImg: ImageView = itemView.findViewById(R.id.iv_img)
    }
}