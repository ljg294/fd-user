package com.fitdine.user.api.server.common.code

import com.fasterxml.jackson.annotation.JsonProperty

interface DescriptionCode {

    // The `code` is either the enum's name or a custom string
    val code: String?
        get() = if (this is Enum<*>) this.name else null

    @get:JsonProperty("text")
    val description: String

    companion object {
        fun toIdentityDescriptionCode(code: String): DescriptionCode {
            return object : DescriptionCode {
                override val code: String?
                    get() = code

                override val description: String
                    get() = code
            }
        }
    }
}