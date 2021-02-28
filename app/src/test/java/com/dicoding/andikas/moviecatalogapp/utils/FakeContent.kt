package com.dicoding.andikas.moviecatalogapp.utils

import com.dicoding.andikas.moviecatalogapp.model.movie.Movie
import com.dicoding.andikas.moviecatalogapp.model.tvshow.TvShow

object FakeContent {

    fun generateDummyMovies(): List<Movie> {
        val movies = ArrayList<Movie>()

        movies.add(Movie(464052, "", "", "", "", "", false))

        movies.add(Movie(587996, "", "", "", "", "", false))

        movies.add(
            Movie(
                602269,
                "/vfuzELmhBjBTswXj2Vqxnu5ge4g.jpg",
                "The Little Things",
                "Deputy Sheriff Joe \"Deke\" Deacon joins forces with Sgt. Jim Baxter to search for a serial killer who's terrorizing Los Angeles. As they track the culprit, Baxter is unaware that the investigation is dredging up echoes of Deke's past, uncovering disturbing secrets that could threaten more than his case.",
                "/c7VlGCCgM9GZivKSzBgzuOVxQn7.jpg",
                "2021-01-27",
                    false
        ))

        movies.add(Movie(775996, "", "", "", "", "", false))

        movies.add(Movie(604822, "", "", "", "", "", false))

        movies.add(Movie(651571, "", "", "", "", "", false))

        movies.add(Movie(508442, "", "", "", "", "", false))

        movies.add(Movie(560144, "", "", "", "", "", false))

        movies.add(Movie(522444, "", "", "", "", "", false))

        movies.add(Movie(644092, "", "", "", "", "", false))

        movies.add(Movie(539885, "", "", "", "", "", false))

        movies.add(Movie(581387, "", "", "", "", "", false))

        movies.add(Movie(520946, "", "", "", "", "", false))

        movies.add(Movie(495764, "", "", "", "", "", false))

        movies.add(Movie(553604, "", "", "", "", "", false))

        movies.add(Movie(737568, "", "", "", "", "", false))

        movies.add(Movie(373571, "", "", "", "", "", false))

        movies.add(Movie(577922, "", "", "", "", "", false))

        movies.add(Movie(531499, "", "", "", "", "", false))

        movies.add(Movie(399566, "", "", "", "", "", false))

        return movies
    }

    fun generateDummyTvShows(): List<TvShow> {
        val tvShow = ArrayList<TvShow>()

        tvShow.add(TvShow(85271, "", "", "", "", "", false))

        tvShow.add(TvShow(69050, "/9hvhGtcsGhQY58pukw8w55UEUbL.jpg", "2017-01-26", "Riverdale", "Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their friends, exploring the surreality of small-town life, the darkness and weirdness bubbling beneath Riverdale’s wholesome facade.", "/wRbjVBdDo5qHAEOVYoMWpM58FSA.jpg", false))

        tvShow.add(TvShow(79460, "/fRYwdeNjMqC30EhofPx5PlDpdun.jpg", "2018-10-25", "Legacies", "In a place where young witches, vampires, and werewolves are nurtured to be their best selves in spite of their worst impulses, Klaus Mikaelson’s daughter, 17-year-old Hope Mikaelson, Alaric Saltzman’s twins, Lizzie and Josie Saltzman, among others, come of age into heroes and villains at The Salvatore School for the Young and Gifted.", "/qTZIgXrBKURBK1KrsT7fe3qwtl9.jpg", false))

        tvShow.add(TvShow(114695, "/wAEWZm2pSopAbqE5dQWE0ET8aR5.jpg", "2021-01-08", "Marvel Studios: Legends", "Revisit the epic heroes, villains and moments from across the MCU in preparation for the stories still to come. Each dynamic segment feeds directly into the upcoming series — setting the stage for future events. This series weaves together the many threads that constitute the unparalleled Marvel Cinematic Universe.", "/EpDuYIK81YtCUT3gH2JDpyj8Qk.jpg", false))

        tvShow.add(TvShow(71712, "/mZjZgY6ObiKtVuKVDrnS9VnuNlE.jpg", "2017-09-25", "The Good Doctor", "A young surgeon with Savant syndrome is recruited into the surgical unit of a prestigious hospital. The question will arise: can a person who doesn't have the ability to relate to people actually save their lives", "/6tfT03sGp9k4c0J3dypjrI8TSAI.jpg", false))

        tvShow.add(TvShow(77169, "", "", "", "", "", false))

        tvShow.add(TvShow(1416, "", "", "", "", "", false))

        tvShow.add(TvShow(82856, "", "", "", "", "", false))

        tvShow.add(TvShow(93297, "", "", "", "", "", false))

        tvShow.add(TvShow(44217, "", "", "", "", "", false))

        tvShow.add(TvShow(63174, "", "", "", "", "", false))

        tvShow.add(TvShow(97175, "", "", "", "", "", false))

        tvShow.add(TvShow(79680, "", "", "", "", "", false))

        tvShow.add(TvShow(46639, "", "", "", "", "", false))

        tvShow.add(TvShow(18165, "", "", "", "", "", false))

        tvShow.add(TvShow(1399, "", "", "", "", "", false))

        tvShow.add(TvShow(96677, "", "", "", "", "", false))

        tvShow.add(TvShow(79611, "", "", "", "", "", false))

        tvShow.add(TvShow(75006, "", "", "", "", "", false))

        tvShow.add(TvShow(456, "", "", "", "", "", false))

        return tvShow
    }

    fun generateDummyDetailMovie(): Movie {
        return Movie(
                602269,
                "/vfuzELmhBjBTswXj2Vqxnu5ge4g.jpg",
                "The Little Things",
                "Deputy Sheriff Joe \"Deke\" Deacon joins forces with Sgt. Jim Baxter to search for a serial killer who's terrorizing Los Angeles. As they track the culprit, Baxter is unaware that the investigation is dredging up echoes of Deke's past, uncovering disturbing secrets that could threaten more than his case.",
                "/c7VlGCCgM9GZivKSzBgzuOVxQn7.jpg",
                "2021-01-27",
                false
        )
    }

    fun generateDummyDetailTvShow(): TvShow {
        return TvShow(
                69050,
                "/9hvhGtcsGhQY58pukw8w55UEUbL.jpg",
                "2017-01-26",
                "Riverdale",
                "Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their friends, exploring the surreality of small-town life, the darkness and weirdness bubbling beneath Riverdale’s wholesome facade.",
                "/wRbjVBdDo5qHAEOVYoMWpM58FSA.jpg",
                false
        )
    }

}