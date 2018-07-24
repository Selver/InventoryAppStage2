package com.example.machomefolder.inventoryappstage1.data;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;

/**
 * API Contract for the Books app.
 */
public final class BookContract {

    // To prevent someone from accidentally instantiating the contract class it must be private,
    // give it an empty constructor.
    private BookContract() {
    }

    /**
     * The "Content authority" is a name for the entire content provider, similar to the
     * relationship between a domain name and its website.  A convenient string to use for the
     * content authority is the package name for the app, which is guaranteed to be unique on the
     * device.
     */
    public static final String CONTENT_AUTHORITY = "com.example.android.books";

    /**
     * Use CONTENT_AUTHORITY to create the base of all URI's which apps will use to contact
     * the content provider.
     */
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    public static final String PATH_BOOKS = "books";

    /**
     * Inner class that defines constant values for the books database table.
     */
    public static final class BookEntry implements BaseColumns {

        /** The content URI to access the book data in the provider */
        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_BOOKS);

        /**
         * The MIME type of the {@link #CONTENT_URI} for a list of books.
         */
        public static final String CONTENT_LIST_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_BOOKS;

        /**
         * The MIME type of the {@link #CONTENT_URI} for a single book.
         */
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_BOOKS;

        /**
         * Name of database table for books
         */
        public final static String TABLE_NAME = "books";

        /**
         * Unique ID number for the book (only for use in the database table).
         * <p>
         * Type: integer
         */
        public final static String _ID = BaseColumns._ID;

        /**
         * Name of the book.
         * <p>
         * Type: TEXT
         */
        public final static String COLUMN_BOOK_NAME = "name";

        /**
         * Price of the book.
         * <p>
         * Type: integer
         */
        public final static String COLUMN_BOOK_PRICE = "price";

        /**
         * Quantity of the book.
         * <p>
         * <p>
         * Type: integer
         */
        public final static String COLUMN_BOOK_QUANTITY = "quantity";

        /**
         * Supplier name of the book.
         * <p>
         * Type: TEXT
         */
        public final static String COLUMN_BOOK_SUPPLIER_NAME = "supplierName";

        /**
         * Supplier`s phone number.
         * <p>
         * Type: TEXT
         */
        public final static String COLUMN_BOOK_SUPPLIER_PHONE = "supplierPhone";
    }
}




