

## HTTP

## HTTP Client

The HTTP client is built on the same principle as the file compressor. All HTTP headers are decompressed, and
the ``Location`` header is rewritten if necessary.

The HTTP client is the only client that has to deal with the fact that decompressed data can be compressed
again.

## HTTP Server

The HTTP server has to deal with the fact that data can be decompressed again. If it receives the ``Accept-Encoding``
header with ``gzip`` or ``deflate`` as value, it checks if the ``Content-Encoding`` header is ``gzip`` or ``deflate``.

## Compression

The server has to deal with the fact that the file compressor does not know about the compressed data, but only the
decompressed data. Because of this, the server has to change the ``Content-Encoding`` header to ``gzip`` or ``deflate``
after writing the decompressed data to the client.

## HTTP Client

The HTTP client has to deal with the fact that the file compressor does not know about the decompressed data, but only
the compressed data. If the server writes the decompressed data to the client, the ``Content-Encoding`` header is
rewritten to ``gzip`` or ``deflate``.
"""

__all__ = [
    "compressor",
    "decompressor"
]
