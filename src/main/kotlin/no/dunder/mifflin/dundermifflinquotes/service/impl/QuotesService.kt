package no.dunder.mifflin.dundermifflinquotes.service.impl

import no.dunder.mifflin.dundermifflinquotes.domain.dto.Quote
import no.dunder.mifflin.dundermifflinquotes.service.IQuotesService
import org.springframework.stereotype.Service

@Service
class QuotesService : IQuotesService {
    override fun getQuotes(length: Int): List<Quote> {
        TODO("Not yet implemented")
    }

    override fun getRandomQuote(): Quote {
        TODO("Not yet implemented")
    }

}