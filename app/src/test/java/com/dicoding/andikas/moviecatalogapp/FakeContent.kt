package com.dicoding.andikas.moviecatalogapp

import com.dicoding.andikas.moviecatalogapp.model.movie.Movie
import com.dicoding.andikas.moviecatalogapp.model.movie.MovieGenre
import com.dicoding.andikas.moviecatalogapp.model.tvshow.TvShow
import com.dicoding.andikas.moviecatalogapp.model.tvshow.TvShowGenre

object FakeContent {

    fun generateDummyMovies(): List<Movie> {
        val movies = ArrayList<Movie>()

        movies.add(Movie(464052, "", listOf(MovieGenre("genre")), "", "", "", ""))

        movies.add(Movie(587996, "", listOf(MovieGenre("genre")), "", "", "", ""))

        movies.add(
            Movie(
                602269,
                "/vfuzELmhBjBTswXj2Vqxnu5ge4g.jpg",
                listOf(MovieGenre("Crime"), MovieGenre("Action")),
                "The Little Things",
                "Deputy Sheriff Joe \"Deke\" Deacon joins forces with Sgt. Jim Baxter to search for a serial killer who's terrorizing Los Angeles. As they track the culprit, Baxter is unaware that the investigation is dredging up echoes of Deke's past, uncovering disturbing secrets that could threaten more than his case.",
                "/c7VlGCCgM9GZivKSzBgzuOVxQn7.jpg",
                "2021-01-27"
        ))

        movies.add(Movie(775996, "", listOf(MovieGenre("genre")), "", "", "", ""))

        movies.add(Movie(604822, "", listOf(MovieGenre("genre")), "", "", "", ""))

        movies.add(Movie(651571, "", listOf(MovieGenre("genre")), "", "", "", ""))

        movies.add(Movie(508442, "", listOf(MovieGenre("genre")), "", "", "", ""))

        movies.add(Movie(560144, "", listOf(MovieGenre("genre")), "", "", "", ""))

        movies.add(Movie(522444, "", listOf(MovieGenre("genre")), "", "", "", ""))

        movies.add(Movie(644092, "", listOf(MovieGenre("genre")), "", "", "", ""))

        movies.add(Movie(539885, "", listOf(MovieGenre("genre")), "", "", "", ""))

        movies.add(Movie(581387, "", listOf(MovieGenre("genre")), "", "", "", ""))

        movies.add(Movie(520946, "", listOf(MovieGenre("genre")), "", "", "", ""))

        movies.add(Movie(495764, "", listOf(MovieGenre("genre")), "", "", "", ""))

        movies.add(Movie(553604, "", listOf(MovieGenre("genre")), "", "", "", ""))

        movies.add(Movie(737568, "", listOf(MovieGenre("genre")), "", "", "", ""))

        movies.add(Movie(373571, "", listOf(MovieGenre("genre")), "", "", "", ""))

        movies.add(Movie(577922, "", listOf(MovieGenre("genre")), "", "", "", ""))

        movies.add(Movie(531499, "", listOf(MovieGenre("genre")), "", "", "", ""))

        movies.add(Movie(399566, "", listOf(MovieGenre("genre")), "", "", "", ""))

        return movies
    }

    fun generateDummyTvShows(): List<TvShow> {
        val tvShow = ArrayList<TvShow>()

        tvShow.add(TvShow(85271, "", "", listOf(TvShowGenre("")), "", "", ""))

        tvShow.add(TvShow(69050, "/9hvhGtcsGhQY58pukw8w55UEUbL.jpg", "2017-01-26", listOf(TvShowGenre("Mystery"), TvShowGenre("Drama"), TvShowGenre("Crime")), "Riverdale", "Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their friends, exploring the surreality of small-town life, the darkness and weirdness bubbling beneath Riverdale’s wholesome facade.", "/wRbjVBdDo5qHAEOVYoMWpM58FSA.jpg"))

        tvShow.add(TvShow(79460, "/fRYwdeNjMqC30EhofPx5PlDpdun.jpg", "2018-10-25", listOf(TvShowGenre("Sci-Fi & Fantasy"), TvShowGenre("Drama")), "Legacies", "In a place where young witches, vampires, and werewolves are nurtured to be their best selves in spite of their worst impulses, Klaus Mikaelson’s daughter, 17-year-old Hope Mikaelson, Alaric Saltzman’s twins, Lizzie and Josie Saltzman, among others, come of age into heroes and villains at The Salvatore School for the Young and Gifted.", "/qTZIgXrBKURBK1KrsT7fe3qwtl9.jpg"))

        tvShow.add(TvShow(114695, "/wAEWZm2pSopAbqE5dQWE0ET8aR5.jpg", "2021-01-08", listOf(TvShowGenre("Documentary")), "Marvel Studios: Legends", "Revisit the epic heroes, villains and moments from across the MCU in preparation for the stories still to come. Each dynamic segment feeds directly into the upcoming series — setting the stage for future events. This series weaves together the many threads that constitute the unparalleled Marvel Cinematic Universe.", "/EpDuYIK81YtCUT3gH2JDpyj8Qk.jpg"))

        tvShow.add(TvShow(71712, "/mZjZgY6ObiKtVuKVDrnS9VnuNlE.jpg", "2017-09-25", listOf(TvShowGenre("Drama")), "The Good Doctor", "A young surgeon with Savant syndrome is recruited into the surgical unit of a prestigious hospital. The question will arise: can a person who doesn't have the ability to relate to people actually save their lives", "/6tfT03sGp9k4c0J3dypjrI8TSAI.jpg"))

        tvShow.add(TvShow(77169, "", "", listOf(TvShowGenre("")), "", "", ""))

        tvShow.add(TvShow(1416, "", "", listOf(TvShowGenre("")), "", "", ""))

        tvShow.add(TvShow(82856, "", "", listOf(TvShowGenre("")), "", "", ""))

        tvShow.add(TvShow(93297, "", "", listOf(TvShowGenre("")), "", "", ""))

        tvShow.add(TvShow(44217, "", "", listOf(TvShowGenre("")), "", "", ""))

        tvShow.add(TvShow(63174, "", "", listOf(TvShowGenre("")), "", "", ""))

        tvShow.add(TvShow(97175, "", "", listOf(TvShowGenre("")), "", "", ""))

        tvShow.add(TvShow(79680, "", "", listOf(TvShowGenre("")), "", "", ""))

        tvShow.add(TvShow(46639, "", "", listOf(TvShowGenre("")), "", "", ""))

        tvShow.add(TvShow(18165, "", "", listOf(TvShowGenre("")), "", "", ""))

        tvShow.add(TvShow(1399, "", "", listOf(TvShowGenre("")), "", "", ""))

        tvShow.add(TvShow(96677, "", "", listOf(TvShowGenre("")), "", "", ""))

        tvShow.add(TvShow(79611, "", "", listOf(TvShowGenre("")), "", "", ""))

        tvShow.add(TvShow(75006, "", "", listOf(TvShowGenre("")), "", "", ""))

        tvShow.add(TvShow(456, "", "", listOf(TvShowGenre("")), "", "", ""))

        return tvShow
    }

    fun generateDummyDetailMovie(): Movie {
        return Movie(
                602269,
                "/vfuzELmhBjBTswXj2Vqxnu5ge4g.jpg",
                listOf(MovieGenre("Crime"), MovieGenre("Action")),
                "The Little Things",
                "Deputy Sheriff Joe \"Deke\" Deacon joins forces with Sgt. Jim Baxter to search for a serial killer who's terrorizing Los Angeles. As they track the culprit, Baxter is unaware that the investigation is dredging up echoes of Deke's past, uncovering disturbing secrets that could threaten more than his case.",
                "/c7VlGCCgM9GZivKSzBgzuOVxQn7.jpg",
                "2021-01-27"
        )
    }

    fun generateDummyDetailTvShow(): TvShow {
        return TvShow(
                69050,
                "/9hvhGtcsGhQY58pukw8w55UEUbL.jpg",
                "2017-01-26",
                listOf(TvShowGenre("Mystery"), TvShowGenre("Drama"), TvShowGenre("Crime")),
                "Riverdale",
                "Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their friends, exploring the surreality of small-town life, the darkness and weirdness bubbling beneath Riverdale’s wholesome facade.",
                "/wRbjVBdDo5qHAEOVYoMWpM58FSA.jpg")
    }

}