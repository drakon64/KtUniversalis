package cloud.drakon.ktuniversalis.exception

class InvalidEntriesException(message: String = "`entries` must be between `0` and `200`"):
    Throwable(message)
