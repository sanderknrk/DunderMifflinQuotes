package no.dunder.mifflin.dundermifflinquotes.db

import no.dunder.mifflin.dundermifflinquotes.domain.dto.Quote

interface IQuotesRepository {
    fun create(quote: Quote)
    fun createMany(quotes: List<Quote>)
    fun getAll(): List<Quote>
    fun get(id: Long): Quote?
    fun update(quote: Quote)
    fun delete(id: Long)
    fun warmUp()
}