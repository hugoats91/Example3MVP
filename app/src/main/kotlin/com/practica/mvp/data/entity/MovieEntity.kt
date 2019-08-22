package com.practica.mvp.data.entity

import com.google.gson.annotations.SerializedName

data class MovieEntity(
        @SerializedName("vote_count") val voteCount: Int,
        @SerializedName("id") val id: Long,
        @SerializedName("video") val video: Boolean,
        @SerializedName("vote_average") val voteAverage: String,
        @SerializedName("title") val title: String,
        @SerializedName("popularity") val popularity: Float,
        @SerializedName("poster_path") val posterPath: String,
        @SerializedName("original_language") val originalLanguage: String,
        @SerializedName("original_title") val originalTitle: String,
        @SerializedName("genre_ids") val genreIds: List<Int>?,
        @SerializedName("backdrop_path") val backdropPath: String?,
        @SerializedName("adult") val adult: Boolean,
        @SerializedName("overview") val overview: String,
        @SerializedName("release_date") val releaseDate: String) {

    fun toMovieModel() = MovieModel(id, video, voteAverage, title, posterPath, backdropPath, adult, overview, releaseDate)

}