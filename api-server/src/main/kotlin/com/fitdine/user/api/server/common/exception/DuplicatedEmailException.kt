package com.fitdine.user.api.server.common.exception

class DuplicatedEmailException : RuntimeException {

    companion object {
        const val DEFAULT_MESSAGE = "Email is already taken"
    }

    constructor() : super(DEFAULT_MESSAGE)

    constructor(message: String) : super(message)

    constructor(message: String, cause: Throwable) : super(message, cause)
}