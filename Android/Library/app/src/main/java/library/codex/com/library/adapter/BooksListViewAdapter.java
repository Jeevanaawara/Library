package library.codex.com.library.adapter;

import android.content.ContentProvider;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import library.codex.com.library.R;
import library.codex.com.library.bean.Book;
import library.codex.com.library.bean.Category;


/**
 * Created by jeevan.kumar on 03-Nov-17.
 */

public class BooksListViewAdapter extends ArrayAdapter<Book> {
    private List<Book> bookList = null;
    private Context context = null;
    private static final String TAG = "BOOK_LIST_VIEW_ADAPTER";

    public BooksListViewAdapter(Context context, Category selectedCategory) {
        super(context, 0, selectedCategory==null?new ArrayList<Book>():selectedCategory.getBooks());
        this.bookList = bookList==null?new ArrayList<Book>():selectedCategory.getBooks();
        this.context = context;
    }

    @Override
    public int getCount() {
//        return bookList.size()>0?bookList.size():1;
        return bookList.size();
    }

    @Override
    public Book getItem(int i) {
        Log.i(TAG, "getItem(i): "+i);
        return bookList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return bookList.get(i).getId();
    }


    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.book_list_item, viewGroup, false);
        }


        Book book = getItem(i);
        ((TextView)view.findViewById(R.id.book_list_item_header_tv)).setText(book.getTitle());
        ((TextView)view.findViewById(R.id.book_list_item_subheader_tv)).setText(book.getTitle());
        return view;
    }
}
