package ghar.dfw.myviewpager.view

import android.content.Context
import android.util.Log
import ghar.dfw.myviewpager.data.DataModel
import androidx.viewpager.widget.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import ghar.dfw.myviewpager.R
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

internal class CustomPagerAdapter(context: Context, private val itemList: List<DataModel>) : PagerAdapter() {

  private val layoutInflater: LayoutInflater
  init {
    layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
  }

  override fun getCount(): Int {
    return itemList.size
  }

  override fun isViewFromObject(view: View, `object`: Any): Boolean {
    return view === `object`
  }

  override fun instantiateItem(container: ViewGroup, position: Int): Any {

    Log.v("instantiateCall-position", position.toString())
    val itemView = layoutInflater.inflate(R.layout.viewpager_item, container, false)
    val imageView = itemView.findViewById<ImageView>(R.id.imageItem)
    val textView = itemView.findViewById<TextView>(R.id.imageItemText)
    val dataModel = itemList[position]
    imageView.setImageResource(dataModel.imageId)
    textView.text = dataModel.title
    container.addView(itemView)

    return itemView
  }

  override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {

    Log.v("destroyCall", "destroyItem-call-position: $position")
    container.removeView(`object` as ConstraintLayout)
  }

}