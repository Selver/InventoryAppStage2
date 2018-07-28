package com.example.machomefolder.inventoryappstage1;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.example.machomefolder.inventoryappstage1.data.BookContract;

public class BookCursorAdapter extends CursorAdapter {

    public BookCursorAdapter(Context context, Cursor c) {
        super(context, c, 0 /* flags */);
    }

    // Makes a new blank list item view. No data is set (or bound) to the views yet.
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        // Inflate a list item view using the layout specified in list_item.xml
        return LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
    }

    //This method binds the book data (in the current row pointed to by cursor) to the given list item layout.
    @Override
    public void bindView(View view, final Context context, Cursor cursor) {
        // Find individual views that we want to modify in the list item layout
        TextView nameTextView = view.findViewById(R.id.name);
        final TextView quantityTextView = view.findViewById(R.id.quantity);
        TextView priceTextView = view.findViewById(R.id.price);
        Button saleButton = view.findViewById(R.id.sale);

        // Find the columns of book attributes that we're interested in
        int nameColumnIndex = cursor.getColumnIndex(BookContract.BookEntry.COLUMN_BOOK_NAME);
        int quantityColumnIndex = cursor.getColumnIndex(BookContract.BookEntry.COLUMN_BOOK_QUANTITY);
        final int quantity = cursor.getInt(cursor.getColumnIndexOrThrow(BookContract.BookEntry.COLUMN_BOOK_QUANTITY));
        int priceColumnIndex = cursor.getColumnIndex(BookContract.BookEntry.COLUMN_BOOK_PRICE);

        // Read the book attributes from the Cursor for the current book.
        final String bookName = cursor.getString(nameColumnIndex);
        final String bookQuantity = cursor.getString(quantityColumnIndex);
        final String bookPrice = cursor.getString(priceColumnIndex);

        final Uri uri = ContentUris.withAppendedId(BookContract.BookEntry.CONTENT_URI,
                cursor.getInt(cursor.getColumnIndexOrThrow(BookContract.BookEntry._ID)));

        //set data to views
        nameTextView.setText(bookName);
        quantityTextView.setText(" " + bookQuantity);
        priceTextView.setText(" " + bookPrice);

        //sale button on click listener
        saleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (quantity > 0) {
                    Integer afterSale = quantity - 1;

                    ContentValues values = new ContentValues();
                    values.put(BookContract.BookEntry.COLUMN_BOOK_QUANTITY, afterSale);
                    context.getContentResolver().update(uri, values, null, null);

                    quantityTextView.setText(afterSale.toString());
                }
            }
        });
    }
}










