package im.vector.repositories

import android.content.Context
import android.database.Cursor
import android.net.Uri
import android.util.Log

/**
 * Created by Dev_am1 on 5/11/2020
 */
object UseAddressProvider {
    private val BASE_CONTENT_URI = Uri.parse("com.example.addresshost.CostumeProvider")
    private val CONTENT_URI = Uri.parse("content://$BASE_CONTENT_URI")
    private val CONTENT_URI_TABLE = Uri.withAppendedPath(CONTENT_URI, "apps")

    fun getUrlFromProvider(context: Context): String {
        val cursor: Cursor? = context.contentResolver.query(CONTENT_URI_TABLE, null, null, null, null)
        cursor?.moveToFirst()
        if (cursor != null) {
            //
            if (cursor.getString(1).equals("riot", true)) {
                Log.d("address is", cursor.getString(2))

                return cursor.getString(2)
            }
        } else {
            Log.d("cursor is ", "Null!")
        }
        cursor?.close()
        return "No Url"
    }
}