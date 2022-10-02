package ghar.dfw.myviewpager.view;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

import ghar.dfw.myviewpager.R;
import ghar.dfw.myviewpager.data.DataModel;

class CustomPagerAdapter extends PagerAdapter {

   private Context context;

   public CustomPagerAdapter(Context context, List<DataModel> itemList) {
      this.context = context;
      this.itemList = itemList;
      this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
   }

   private final List<DataModel> itemList;
   private final LayoutInflater layoutInflater;


   @Override
   public int getCount() {
      return itemList.size();
   }

   @Override
   public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
      //compares if the View is the Page View
      return view == object;
   }

   @NonNull
   @Override
   public Object instantiateItem(@NonNull ViewGroup container, int position) {

      Log.v("instantiateCall-position", String.valueOf(position));
      // Get the view of the single view Pager Item
      View itemView = layoutInflater.inflate(R.layout.viewpager_item, container, false);
      ImageView imageView = itemView.findViewById(R.id.imageItem);
      TextView textView = itemView.findViewById(R.id.imageItemText);

      // Get the Data Model of the current Position
      DataModel dataModel = itemList.get(position);
      imageView.setImageResource(dataModel.getImageId());
      textView.setText(dataModel.getTitle());

      // adding viewpager_Item.xml to View Pager
      container.addView(itemView);

      // return super.instantiateItem(container, position);
      return itemView;              // return the view of viewPager-Item
   }

   @Override
   public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
      Log.v("destroyCall", "destroyItem-call-position: " + position);

      // destroy items here to free-momory
      container.removeView((ConstraintLayout) object);
//      super.destroyItem(container, position, object);
   }
}
