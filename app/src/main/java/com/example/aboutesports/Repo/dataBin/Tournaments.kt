package com.example.aboutesports.Repo.dataBin

class Tournaments(
    val id: Int
    ,val head: String
    ,val text: String
    ,val imageUrl: String? = null
    ,val imageHeadUrl: String? = null
    ,val partList: List<PartTour>
    ,val time: Int
    ,val rules: String

)