package no.dunder.mifflin.dundermifflinquotes.domain.dto

class Quote(val id: Int, val season: Int, val episode: Int, val scene: Int, val lineText: String, val speaker: String, val deleted: Boolean)