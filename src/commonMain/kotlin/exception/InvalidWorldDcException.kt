package cloud.drakon.ktuniversalis.exception

/**
 * The world/DC requested is invalid.
 */
class InvalidWorldDcException(message: String = "The world/DC requested is invalid"):
    Throwable(message)
