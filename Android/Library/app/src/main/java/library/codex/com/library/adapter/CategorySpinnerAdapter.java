package library.codex.com.library.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

import library.codex.com.library.bean.Category;

/**
 * Created by jeevan.kumar on 03-Nov-17.
 */

public class CategorySpinnerAdapter extends ArrayAdapter<Category> {

    private Context context;
    private List<Category> categoryList;
    public CategorySpinnerAdapter(Context context, List<Category> categoryList) {
        super(context, 0, categoryList);
    }

    @Override
    public int getCount() {
        return categoryList.size();
    }

    @Nullable
    @Override
    public Category getItem(int position) {
        return categoryList.get(position);
    }

    @Override
    public int getPosition(@Nullable Category item) {
        return categoryList.indexOf(item);
    }

    @Override
    public long getItemId(int position) {
        return categoryList.get(position).getId();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        if(convertView==null)
//            convertView = LayoutInflater.from(this.context).inflate(android.R.layout.sim)
        return null;
    }
}
