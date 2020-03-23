package com.example.comp_admin.groceryapp.helpers

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast
import com.example.comp_admin.groceryapp.models.Product

class DBHelper(var mContext: Context) :
    SQLiteOpenHelper(mContext, DATABASE_NAME, null, DATABASE_VERSION) {
    var db: SQLiteDatabase = writableDatabase

    companion object {
        private const val DATABASE_NAME = "my_db"
        private const val DATABASE_VERSION = 2
        private const val TABLE_NAME = "product"
        private const val COLUMNS_NAME = "name"
        private const val COLUMNS_IMAGE = "image"
        private const val COLUMNS_PRICE = "price"
        private const val COLUMN_MRP = "mrp"
        private const val COLUMNS__ID = "_id"
        private const val COLUMNS_QUANTITY = "quantity"

    }

    override fun onCreate(p0: SQLiteDatabase) {
        var createTable = "create table $TABLE_NAME($COLUMNS_NAME text, " +
                "$COLUMNS_IMAGE text, " +
                "$COLUMNS_PRICE text, " +
                "$COLUMN_MRP text, " +
                "$COLUMNS_QUANTITY text, " +
                "$COLUMNS__ID text, " +
                "password text)"
        p0.execSQL(createTable)
    }

    override fun onUpgrade(p0: SQLiteDatabase, p1: Int, p2: Int) {
        var dropTable = "drop table $TABLE_NAME"
        p0.execSQL(dropTable)
        onCreate(p0)
    }

    fun addToCart(product: Product) {
        if (!isItemInCart(product)) {
            var contentValues = ContentValues()
            contentValues.put(COLUMNS_NAME, product.productName)
            contentValues.put(COLUMNS_IMAGE, product.productImage)
            contentValues.put(COLUMNS_PRICE, product.price)
            contentValues.put(COLUMN_MRP, product.mrp)
            contentValues.put(COLUMNS__ID, product._id)
            product.quantity = 1
            contentValues.put(COLUMNS_QUANTITY, product.quantity)
            db.insert(TABLE_NAME, null, contentValues)
            Toast.makeText(mContext, "Inserted", Toast.LENGTH_SHORT).show()
        }
    }


    fun readProduct(): ArrayList<Product> {
        var mList: ArrayList<Product> = ArrayList()
        var columns = arrayOf(
            COLUMNS_NAME,
            COLUMNS_IMAGE,
            COLUMNS_PRICE,
            COLUMN_MRP,
            COLUMNS__ID,
            COLUMNS_QUANTITY
        )
        var cursor = db.query(TABLE_NAME, columns, null, null, null, null, null)
        if (cursor != null && cursor.moveToFirst()) {
            do {
                var name = cursor.getString(cursor.getColumnIndex(COLUMNS_NAME))
                var image = cursor.getString(cursor.getColumnIndex(COLUMNS_IMAGE))
                var price = cursor.getString(cursor.getColumnIndex(COLUMNS_PRICE))
                var mrp = cursor.getString(cursor.getColumnIndex(COLUMN_MRP))
                var _id = cursor.getString(cursor.getColumnIndex(COLUMNS__ID))
                var quantity = cursor.getInt(cursor.getColumnIndex(COLUMNS_QUANTITY))
                var product = Product(name, image, price, mrp, _id, quantity)
                mList.add(product)
            } while (cursor.moveToNext())
        }
        cursor.close()
        return mList
    }

    fun isItemInCart(product: Product): Boolean {
        var query = "select * from $TABLE_NAME where $COLUMNS__ID=?"
        var cursor = db.rawQuery(query, arrayOf(product._id))
        var count = cursor.count
        cursor.close()
        return count != 0
    }

    fun updateQuantity(product: Product) {
        var whereClause = "$COLUMNS__ID=?"
        var whereArgs = arrayOf(product._id)
        var contentValues = ContentValues()
        contentValues.put(COLUMNS_QUANTITY, product.quantity)
        db.update(TABLE_NAME, contentValues, whereClause, whereArgs)

    }
    fun deleteProduct(product: Product) {
        var whereClause = "$COLUMNS__ID=?"
        var whereArgs = arrayOf(product._id.toString())
        db.delete(TABLE_NAME,whereClause,whereArgs)
    }


}