package com.example.aboutesports.Repo.dataBin

import java.time.LocalDateTime

class Tournaments(
    val id: Int
    , val head: String
    , val text: String
    , val imageUrl: String? = null
    , val imageHeadUrl: String? = null
    , val partList: List<PartTour>
    , val time: LocalDateTime
    , val rules: String
    , val review: String? = null
    , val draw: String = "Сетка турнира еще не опубликована"
    , val participants: String = "Зарегистрировано"
    , val playerList: List<Player> = listOf()

)