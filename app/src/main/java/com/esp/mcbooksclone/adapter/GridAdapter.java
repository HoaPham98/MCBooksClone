package com.esp.mcbooksclone.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.esp.mcbooksclone.R;
import com.esp.mcbooksclone.ScannerActivity;
import com.esp.mcbooksclone.data.BookData;

import java.util.ArrayList;

/**
 * Created by Hoa's PC on 5/28/2017.
 */

public class GridAdapter extends RecyclerView.Adapter<GridAdapter.BookViewHolder> {

    private Context context;
    private ArrayList<BookData> bookDataArrayList;

    public GridAdapter(Context context, ArrayList bookDataArrayList) {
        this.context = context;
        this.bookDataArrayList = bookDataArrayList;
    }

    @Override
    public BookViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.no_book_item, null);
        BookViewHolder rcv = new BookViewHolder(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(BookViewHolder holder, int position) {
        Log.d("TAG","Getting book data");
        BookData book = bookDataArrayList.get(position);
        if(book.getName() == null || book.getCoverPath() == null){
            NoBookLayout(holder.itemView);
        }
    }

    @Override
    public int getItemCount() {
        return bookDataArrayList.size();
    }

    public void NoBookLayout(View v){
        Log.d("TAG","No book layout");
        v.findViewById(R.id.item_no_book).setVisibility(View.VISIBLE);
        v.findViewById(R.id.item_book).setVisibility(View.INVISIBLE);

    }

    public void BookLayout(View v){
        v.findViewById(R.id.item_no_book).setVisibility(View.INVISIBLE);
        v.findViewById(R.id.item_book).setVisibility(View.VISIBLE);

    }

    public class BookViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{



        public BookViewHolder(View itemView) {
            super(itemView);
            itemView.findViewById(R.id.item_no_book).setOnClickListener(this);
            itemView.findViewById(R.id.item_book).setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            int id = v.getId();
            if (id == R.id.item_no_book){
                Intent intent = new Intent(context,ScannerActivity.class);
                context.startActivity(intent);
            }
        }
    }
}
