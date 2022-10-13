package no.dunder.mifflin.dundermifflinquotes.db.impl

import no.dunder.mifflin.dundermifflinquotes.db.IQuotesRepository
import no.dunder.mifflin.dundermifflinquotes.domain.dto.Quote

class SqLiteQuotesRepository : IQuotesRepository {
    override fun create(quote: Quote) {
        TODO("Not yet implemented")
    }

    override fun createMany(quotes: List<Quote>) {
        TODO("Not yet implemented")
    }

    override fun getAll(): List<Quote> {
        TODO("Not yet implemented")
    }

    override fun get(id: Long): Quote? {
        TODO("Not yet implemented")
    }

    override fun update(quote: Quote) {
        TODO("Not yet implemented")
    }

    override fun delete(id: Long) {
        TODO("Not yet implemented")
    }

    override fun warmUp() {
        TODO("Not yet implemented")
    }
}