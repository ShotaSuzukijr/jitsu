package com.example.jitsu

@Entity(tableName = "photo_table")
data class Photo(
    @PrimaryKey @ColumnInfo(name = "uri") val uri: String, @ColumnInfo(name = "memo") val memo: String
){ }

@Dao
interface PhotoDao {
    @Query("SELECT * from photo_table")
    fun getPhotos(): List<Photo>
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(photo: Photo)
}

@Query("SELECT * from photo_table")
fun getPhots(): LiveData<List<Photo>>