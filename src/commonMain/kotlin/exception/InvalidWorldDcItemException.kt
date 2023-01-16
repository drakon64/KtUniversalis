package cloud.drakon.ktuniversalis.exception

/**
 * The world/DC or item requested is invalid.
 */
class InvalidWorldDcItemException(message: String = "The world/DC or item requested is invalid"):
    Throwable(message)
