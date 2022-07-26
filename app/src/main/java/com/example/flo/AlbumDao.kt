package com.example.flo

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface AlbumDao {

    @Insert
    fun insert(album:Album)

    @Query("SELECT * FROM AlbumTable")
    fun getAlbum():List<Album>

    @Insert
    fun likeAlbum(Like: Like)

    @Query("SELECT id FROM LIkeTable WHERE userId = :userId AND albumId = :albumId")
    fun isLikedAlbum(userId: Int, albumId: Int) : Int?

    @Query("DELETE FROM LIkeTable WHERE userId = :userId AND albumId = :albumId")
    fun disLikedAlbum(userId: Int, albumId: Int)

    @Query("SELECT AT.* FROM lIKEtABLE AS LT LEFT JOIN AlbumTable as AT ON LT.albumId = AT.id WHERE LT.userId = :userId")
    fun getLikedAlbums(userId : Int) : List<Album>

}