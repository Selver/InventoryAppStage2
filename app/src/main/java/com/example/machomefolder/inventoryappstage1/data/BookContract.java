package com.example.machomefolder.inventoryappstage1.data;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;

//API Contract for the Books app.
public final class BookContract {

    public static final String CONTENT_AUTHORITY = "com.example.android.books";

    // A convenient string to use for the content authority is the package name for the app, which is unique on the device
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);
    public static final String PATH_BOOKS = "books";

    // To prevent someone from accidentally instantiating the contract class empty constructor must be private
    private BookContract() {
    }

    //Inner class that defines constant values for the books database table.
    public static final class BookEntry implements BaseColumns {

        //The content URI to access the book data in the provider
        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_BOOKS);

        public static final String CONTENT_LIST_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_BOOKS;

        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_BOOKS;

        public final static String TABLE_NAME = "books";

        //Unique ID number for the book (only for use in the database table). Type: integer
        public final static String _ID = BaseColumns._ID;

        //Name of the book. Type: TEXT
        public final static String COLUMN_BOOK_NAME = "name";

        // Price of the book. Type: integer
        public final static String COLUMN_BOOK_PRICE = "price";

        //Quantity of the book. Type: integer
        public final static String COLUMN_BOOK_QUANTITY = "quantity";

        //Supplier name of the book. Type: TEXT
        public final static String COLUMN_BOOK_SUPPLIER_NAME = "supplierName";

        //Supplier`s phone number. Type: TEXT
        public final static String COLUMN_BOOK_SUPPLIER_PHONE = "supplierPhone";
    }
}






