package no.dunder.mifflin.dundermifflinquotes.resource

import no.dunder.mifflin.dundermifflinquotes.service.IQuotesService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/quotes")
class QuotesResource(val quotesService: IQuotesService) {



}