package com.example.aboutesports.Repo.dataTest

import com.example.aboutesports.Repo.dataBin.PartTour
import com.example.aboutesports.Repo.dataBin.Tournaments

object TournamentsTest {
    var lstTest1 = listOf(
        Tournaments(1, "The international 2015", "", null, listOf(),123),
        Tournaments(2, "The international 2016", "", null, listOf(),123),
        Tournaments(3, "The international 2017", "", null, listOf(),123),
        Tournaments(4, "The international 2018", "", null, listOf(),123),
        Tournaments(5, "The international 2019", "", null, listOf(),123),
        Tournaments(6, "The international 2020", "", null, listOf(),123),
        Tournaments(7, "The international 2021", "", null, listOf(),123),
        Tournaments(8, "The international 2022", "", null, listOf(),123),
        Tournaments(9, "The international 2023", "", null, listOf(PartTour(2,"Плей-офф","нет"),
            PartTour(2,"Групповая стадия","да")),123)
    )
}