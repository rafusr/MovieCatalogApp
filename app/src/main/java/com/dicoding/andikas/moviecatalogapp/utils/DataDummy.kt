package com.dicoding.andikas.moviecatalogapp.utils

import com.dicoding.andikas.moviecatalogapp.R
import com.dicoding.andikas.moviecatalogapp.model.DataEntity

object DataDummy {

    fun generateDummyMovies(): List<DataEntity> {

        val movies = ArrayList<DataEntity>()

        movies.add(DataEntity(
                "MOVIE_1",
            R.drawable.poster_a_star_is_born,
            R.drawable.bg_star_is_born,
                "A Star Is Born",
                "(2018)",
                "Drama, Romance, Music",
                "Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even as Ally's career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons."
        ))

        movies.add(DataEntity(
                "MOVIE_2",
            R.drawable.poster_alita,
            R.drawable.bg_alita,
                "Alita: Battle Angel",
                "(2019)",
                "Action, Science Fiction, Adventure",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past."
        ))

        movies.add(DataEntity(
                "MOVIE_3",
            R.drawable.poster_aquaman,
            R.drawable.bg_aquaman,
                "Aquaman",
                "(2018)",
                "Action, Adventure, Fantasy",
                "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne."
        ))

        movies.add(DataEntity(
                "MOVIE_4",
            R.drawable.poster_bohemian,
            R.drawable.bg_bohemian,
                "Bohemian Rhapsody",
                "(2018)",
                "Music, Drama",
                "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess."
        ))

        movies.add(DataEntity(
                "MOVIE_5",
            R.drawable.poster_how_to_train,
            R.drawable.bg_how_to_train,
                "How to Train Your Dragon: The Hidden World",
                "(2019)",
                "Animation, Family, Adventure",
                "As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless’ discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup’s reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind."
        ))

        movies.add(DataEntity(
                "MOVIE_6",
            R.drawable.poster_infinity_war,
            R.drawable.bg_infinity_war,
                "Avengers: Infinity War",
                "(2018)",
                "Adventure, Action, Science Fiction",
                "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain."
        ))

        movies.add(DataEntity(
                "MOVIE_7",
            R.drawable.poster_mary_queen,
            R.drawable.bg_mary_queen,
                "Mary Queen of Scots",
                "(2018)",
                "Drama, History",
                "In 1561, Mary Stuart, widow of the King of France, returns to Scotland, reclaims her rightful throne and menaces the future of Queen Elizabeth I as ruler of England, because she has a legitimate claim to the English throne. Betrayals, rebellions, conspiracies and their own life choices imperil both Queens. They experience the bitter cost of power, until their tragic fate is finally fulfilled."
        ))

        movies.add(DataEntity(
                "MOVIE_8",
            R.drawable.poster_master_z,
            R.drawable.bg_master_z,
                "Master Z: Ip Man Legacy",
                "(2018)",
                "Action",
                "Following his defeat by Master Ip, Cheung Tin Chi tries to make a life with his young son in Hong Kong, waiting tables at a bar that caters to expats. But it's not long before the mix of foreigners, money, and triad leaders draw him once again to the fight."
        ))

        movies.add(DataEntity(
                "MOVIE_9",
            R.drawable.poster_mortal_engines,
            R.drawable.bg_mortal_engines,
                "Mortal Engines",
                "(2018)",
                "Adventure, Fantasy",
                "Many thousands of years in the future, Earth’s cities roam the globe on huge wheels, devouring each other in a struggle for ever diminishing resources. On one of these massive traction cities, the old London, Tom Natsworthy has an unexpected encounter with a mysterious young woman from the wastelands who will change the course of his life forever."
        ))

        movies.add(DataEntity(
                "MOVIE_10",
            R.drawable.poster_overlord,
            R.drawable.bg_overlord,
                "Overlord",
                "(2018)",
                "Horror, War, Science Fiction",
                "France, June 1944. On the eve of D-Day, some American paratroopers fall behind enemy lines after their aircraft crashes while on a mission to destroy a radio tower in a small village near the beaches of Normandy. After reaching their target, the surviving paratroopers realise that, in addition to fighting the Nazi troops that patrol the village, they also must fight against something else."
        ))

        movies.add(DataEntity(
                "MOVIE_11",
            R.drawable.poster_ralph,
            R.drawable.bg_ralph,
                "Ralph Breaks the Internet",
                "(2018)",
                "Family, Animation, Comedy, Adventure",
                "Video game bad guy Ralph and fellow misfit Vanellope von Schweetz must risk it all by traveling to the World Wide Web in search of a replacement part to save Vanellope's video game, Sugar Rush. In way over their heads, Ralph and Vanellope rely on the citizens of the internet — the netizens — to help navigate their way, including an entrepreneur named Yesss, who is the head algorithm and the heart and soul of trend-making site BuzzzTube."
        ))

        movies.add(DataEntity(
                "MOVIE_12",
            R.drawable.poster_spiderman,
            R.drawable.bg_spiderman,
                "Spider-Man: Into the Spider-Verse",
                "(2018)",
                "Action, Adventure, Animation, Science Fiction, Comedy",
                "Miles Morales is juggling his life between being a high school student and being a spider-man. When Wilson \"Kingpin\" Fisk uses a super collider, others from across the Spider-Verse are transported to this dimension."
        ))

        return movies
    }

    fun generateDummyTVShows(): List<DataEntity> {

        val tvShows = ArrayList<DataEntity>()

        tvShows.add(DataEntity(
                "TV_SHOW_1",
            R.drawable.poster_tv_arrow,
            R.drawable.bg_tv_arrow,
                "Arrow",
                "(2012)",
                "Crime, Drama, Mystery, Action & Adventure",
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow."
        ))

        tvShows.add(DataEntity(
                "TV_SHOW_2",
            R.drawable.poster_tv_dragon_ball,
            R.drawable.bg_tv_dragonball,
                "Dragon Ball",
                "(1986)",
                "Comedy, Sci-Fi & Fantasy, Animation, Action & Adventure",
                "Long ago in the mountains, a fighting master known as Gohan discovered a strange boy whom he named Goku. Gohan raised him and trained Goku in martial arts until he died. The young and very strong boy was on his own, but easily managed. Then one day, Goku met a teenage girl named Bulma, whose search for the mystical Dragon Balls brought her to Goku's home. Together, they set off to find all seven and to grant her wish."
        ))

        tvShows.add(DataEntity(
                "TV_SHOW_3",
            R.drawable.poster_tv_fairytail,
            R.drawable.bg_tv_fairytail,
                "Fairy Tail",
                "(2009)",
                "Action & Adventure, Animation, Comedy, Sci-Fi & Fantasy",
                "Lucy is a 17-year-old girl, who wants to be a full-fledged mage. One day when visiting Harujion Town, she meets Natsu, a young man who gets sick easily by any type of transportation. But Natsu isn't just any ordinary kid, he's a member of one of the world's most infamous mage guilds: Fairy Tail."
        ))

        tvShows.add(DataEntity(
                "TV_SHOW_4",
            R.drawable.poster_tv_family_guy,
            R.drawable.bg_tv_family_guy,
                "Family Guy",
                "(1999)",
                "Animation, Comedy",
                "Sick, twisted, politically incorrect and Freakin' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he's not very bright but has a passion for movies). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues."
        ))

        tvShows.add(DataEntity(
                "TV_SHOW_5",
            R.drawable.poster_tv_flash,
            R.drawable.bg_tv_the_flash,
                "The Flash",
                "(2014)",
                "Drama, Sci-Fi & Fantasy",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash."
        ))

        tvShows.add(DataEntity(
                "TV_SHOW_6",
            R.drawable.poster_tv_got,
            R.drawable.bg_tv_got,
                "Game of Thrones",
                "(2011)",
                "Sci-Fi & Fantasy, Drama, Action & Adventure, Mystery",
                "Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night's Watch, is all that stands between the realms of men and icy horrors beyond."
        ))

        tvShows.add(DataEntity(
                "TV_SHOW_7",
            R.drawable.poster_tv_iron_fist,
            R.drawable.bg_tv_iron_fist,
                "Marvel's Iron Fist",
                "(2017)",
                "Action & Adventure, Drama, Sci-Fi & Fantasy",
                "Danny Rand resurfaces 15 years after being presumed dead. Now, with the power of the Iron Fist, he seeks to reclaim his past and fulfill his destiny."
        ))

        tvShows.add(DataEntity(
                "TV_SHOW_8",
            R.drawable.poster_tv_naruto_shipudden,
            R.drawable.bg_tv_naruto,
                "Naruto Shippūden",
                "(2007)",
                "Animation, Action & Adventure, Sci-Fi & Fantasy",
                "Naruto Shippuuden is the continuation of the original animated TV series Naruto.The story revolves around an older and slightly more matured Uzumaki Naruto and his quest to save his friend Uchiha Sasuke from the grips of the snake-like Shinobi, Orochimaru. After 2 and a half years Naruto finally returns to his village of Konoha, and sets about putting his ambitions to work, though it will not be easy, as He has amassed a few (more dangerous) enemies, in the likes of the shinobi organization; Akatsuki."
        ))

        tvShows.add(DataEntity(
                "TV_SHOW_9",
            R.drawable.poster_tv_supergirl,
            R.drawable.bg_tv_supergirl,
                "Supergirl",
                "(2015)",
                "Action, Adventure, Drama, Science Fiction\n",
                "Twenty-four-year-old Kara Zor-El, who was taken in by the Danvers family when she was 13 after being sent away from Krypton, must learn to embrace her powers after previously hiding them. The Danvers teach her to be careful with her powers, until she has to reveal them during an unexpected disaster, setting her on her journey of heroism."
        ))

        tvShows.add(DataEntity(
                "TV_SHOW_10",
            R.drawable.poster_tv_supernatural,
            R.drawable.bg_tv_supernatural,
                "Supernatural",
                "(2005)",
                "Drama, Mystery, Sci-Fi & Fantasy",
                "When they were boys, Sam and Dean Winchester lost their mother to a mysterious and demonic supernatural force. Subsequently, their father raised them to be soldiers. He taught them about the paranormal evil that lives in the dark corners and on the back roads of America ... and he taught them how to kill it. Now, the Winchester brothers crisscross the country in their '67 Chevy Impala, battling every kind of supernatural threat they encounter along the way."
        ))

        tvShows.add(DataEntity(
                "TV_SHOW_11",
            R.drawable.poster_tv_the_simpson,
            R.drawable.bg_tv_the_simpsons,
                "The Simpsons",
                "(1989)",
                "Animation, Comedy, Family, Drama",
                "Set in Springfield, the average American town, the show focuses on the antics and everyday adventures of the Simpson family; Homer, Marge, Bart, Lisa and Maggie, as well as a virtual cast of thousands. Since the beginning, the series has been a pop culture icon, attracting hundreds of celebrities to guest star. The show has also made name for itself in its fearless satirical take on politics, media and American life in general."
        ))

        tvShows.add(DataEntity(
                "TV_SHOW_12",
            R.drawable.poster_tv_the_walking_dead,
            R.drawable.bg_walking_dead,
                "The Walking Dead",
                "(2010)",
                "Action & Adventure, Drama, Sci-Fi & Fantasy",
                "Sheriff's deputy Rick Grimes awakens from a coma to find a post-apocalyptic world dominated by flesh-eating zombies. He sets out to find his family and encounters many other survivors along the way."
        ))

        return tvShows
    }

}