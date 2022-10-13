package no.dunder.mifflin.dundermifflinquotes.service

import no.dunder.mifflin.dundermifflinquotes.domain.dto.Quote

interface IQuotesService {

    fun getQuotes(length: Int): List<Quote>

    fun getRandomQuote(): Quote
}