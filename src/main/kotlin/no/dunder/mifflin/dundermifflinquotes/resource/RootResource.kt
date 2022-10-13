package no.dunder.mifflin.dundermifflinquotes.resource

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/")
class RootResource {

    @GetMapping("/")
    fun root(): String {
        return "OK"
    }

}