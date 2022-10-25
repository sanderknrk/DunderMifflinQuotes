package no.dunder.mifflin.dundermifflinquotes.auth

import com.auth0.jwt.JWT
import com.auth0.jwt.JWTVerifier
import com.auth0.jwt.algorithms.Algorithm
import com.auth0.jwt.exceptions.JWTDecodeException
import com.auth0.jwt.impl.JWTParser
import com.auth0.jwt.interfaces.Payload
import org.slf4j.LoggerFactory
import java.util.*

class JWTTokenValidator(
    secretsBySubject: Map<String, String>,
    private val issuer: String,
    private val audience: String) {
    private val logger = LoggerFactory.getLogger(JWTTokenValidator::class.java)
    private val verifiersBySubject = HashMap<String, JWTVerifier>()

    init {
        for (subject in secretsBySubject.keys)
            addJwtVerifier(subject, secretsBySubject[subject]!!)
    }

    fun authenticate(jwtToken: String): AccessTokenPrincipal {
        val payload = parsePayloadWithoutVerification(jwtToken)
        val subject = payload.subject
        val jwtVerifier = verifiersBySubject[subject]

        if (jwtVerifier == null) {
            logger.warn("Cannot find JWT Verifier for subject {}. Throwing authentication exception", subject)
            throw AuthenticationException("Token not valid")
        }

        val decodedJWT = jwtVerifier.verify(jwtToken)
        return AccessTokenPrincipal(decodedJWT.subject)
    }

    private fun addJwtVerifier(subject: String, secret: String) {
        logger.info("Creating JWT verifier for subject: {}", subject)
        val jwtVerifier =
            JWT.require(Algorithm.HMAC256(secret))
            .withIssuer(issuer)
            .withAudience(audience)
            .withSubject(subject).build()
        verifiersBySubject[subject] = jwtVerifier
    }

    private fun parsePayloadWithoutVerification(jwtToken: String) : Payload {
        val parts: List<String?> = splitToken(jwtToken)

        val base64EncodedClaims = parts[1]

        val jsonClaims = String(Base64.getDecoder().decode(base64EncodedClaims))
        return JWTParser().parsePayload(jsonClaims)
    }

    private fun splitToken(token: String) : List<String> {
        val parts = token.split(".")

        if (token.endsWith(".") && parts.size == 2)
            return listOf(parts[0], parts[1], "")

        if (parts.size != 3)
            throw JWTDecodeException(String.format("The token was expected to have 3 parts, but got %s.", parts.size))

        return parts
    }

}