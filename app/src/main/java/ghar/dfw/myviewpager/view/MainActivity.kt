package ghar.dfw.myviewpager.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import ghar.dfw.myviewpager.R
import ghar.dfw.myviewpager.data.DataModel
import java.util.*

class MainActivity : AppCompatActivity() {

  lateinit var viewPager: ViewPager
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    // link ViewPager with CustomAdapter
    viewPager = findViewById(R.id.viewPager)
    val adapter = CustomPagerAdapter(this, getDataList())
    viewPager.adapter = adapter
  }

  private fun getDataList(): List<DataModel> {

    val listItem = ArrayList<DataModel>()
    val imageIds: List<Int> = listOf(
      R.drawable.eagle,
      R.drawable.image01,
      R.drawable.image02,
      R.drawable.image03,
      R.drawable.image05,
      R.drawable.image06
    )

    val titles: List<String> =
      listOf("Image01", "Image02", "Image03", "Image05", "Image06", "eagle")

    for (i in imageIds.indices) {
      listItem.add(DataModel(imageIds[i], titles[i]))
    }

    return listItem

  }

}
