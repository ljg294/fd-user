package com.fitdine.user.api.server.common.exception

class UserNotFoundException : RuntimeException {

    companion object {
        const val DEFAULT_MESSAGE = "User not found"
    }

    constructor() : super(DEFAULT_MESSAGE)

    constructor(message: String) : super(message)

    constructor(message: String, cause: Throwable) : super(message, cause)
}