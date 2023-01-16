package cloud.drakon.ktuniversalis.exception

/**
 * The world requested is invalid.
 */
class InvalidWorldException(message: String = "The world requested is invalid"):
    Throwable(message)
