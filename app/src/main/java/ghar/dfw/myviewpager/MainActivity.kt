package ghar.dfw.myviewpager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ghar.dfw.myviewpager.data.DataModel
import java.util.*

class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
  }

  fun getDataList() : List<DataModel> {

    val listItem = ArrayList<DataModel>()

    val imageIds: List<Int> = listOf(
      R.drawable.eagle,
      R.drawable.image01,
      R.drawable.image02,
      R.drawable.image03,
      R.drawable.image05,
      R.drawable.image06,
      )

    val titles:List<String> = listOf(
      "Image 1",
      "Image 2",
      "Image 3",
      "Image 4",
      "Image 5",
      "Image 6"
    )

    for (i in 1..imageIds.size){
      listItem.add(DataModel(imageIds[i], titles[i]))
    }

    return listItem

  }

}
