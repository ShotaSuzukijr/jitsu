package com.example.jitsu

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.*

@Entity(tableName = "photo_table")
data class Photo (
    @PrimaryKey @ColumnInfo(name = "uri") val uri: String,
    @ColumnInfo(name = "memo") val memo: String,
    @ColumnInfo(name = "price") val price: String,
    @ColumnInfo(name = "time") val time: String

)

@Dao
interface PhotoDao{
    @Query("SELECT * from photo_table")
    fun getPhotos(): LiveData<List<Photo>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(photo: Photo)

    @Delete()
    suspend fun delete(photo: Photo)
}

@Database(entities = arrayOf(Photo::class), version = 1, exportSchema = false)
public abstract class PhotoRoomDatabase : RoomDatabase() {
    abstract fun photoDao():PhotoDao

    companion object {
        @Volatile
        private var INSTANCE: PhotoRoomDatabase? = null

        fun getPhotoDatabase(context: Context): PhotoRoomDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PhotoRoomDatabase::class.java,
                    "photo_database"
                ).build()
                INSTANCE = instance
            return instance}
        }
    }
}