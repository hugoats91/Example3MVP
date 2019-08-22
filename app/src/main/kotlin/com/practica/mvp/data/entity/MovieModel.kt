package com.practica.mvp.data.entity

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.annotation.NameInDb


@Entity
class MovieModel(
        @Id(assignable = true) @NameInDb("id") var id: Long,
        @NameInDb("video") val video: Boolean,
        @NameInDb("vote_average") val voteAverage: String,
        @NameInDb("title") val title: String,
        @NameInDb("poster_path") val posterPath: String,
        @NameInDb("backdrop_path") val backdropPath: String?,
        @NameInDb("adult") val adult: Boolean,
        @NameInDb("overview") val overview: String,
        @NameInDb("release_date") val releaseDate: String
)