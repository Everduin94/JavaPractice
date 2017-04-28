# TCP/IP Model
- Application
    - Data
- Transport
    - Header: TCP or UDP
    - Data
- Internet
    - IP Header: holds source ip and dest ip
    - TCP or UDP
    - Data
- Network Interface
    - Ethernet Header
    - IP Header
    - TCP or UDP
    - Data
    - Trailer

* Data goes down the stack then up the stack,
from computer A to computer B.*

# TCP vs UDP
- Transmission Control Protocol
    - Tracking transmitted data segments
        - Keeps track of # of segments sent from host to dest
    - Acknowledging received data
    - Retransmitting nay unacknowledged data
- User Datagram Protocol
    - Packets may be lost or delivered out of order
    - Message split into datagrams, user sends datagrams
    as packets on network layer (internet layer)
    - Unreliable but fast
    - Application must deal with lost packets.
- Internet Protocol
    - *Connectionless*: No connection with the destination
    is established before sending data packets
    - *Best Effort (unreliable)*: packet delivery is not garunteed.
    - *Media Independent*: Operation is independent of the medium
    carrying the data.

# Loopback Interface
- Lookback interface -> 127.0.0.1/32 -> "Localhost" or "Lookback"

# Threads
- Probably won't take many notes on this subject
