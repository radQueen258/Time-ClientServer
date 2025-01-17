# Time Server and Client

## Overview
This project consists of two console applications written in Java:

1. **timeserver**: A server application that listens on a specified port, accepts client connections, and sends the current date and time.
2. **timeclient**: A client application that connects to the server, receives the date and time, and displays it on the console.

These applications are designed to work on Ubuntu 24.04 and use sockets for communication.

## Prerequisites
- **Java Development Kit (JDK)** installed on your system.
- Basic knowledge of using the terminal in Ubuntu.

## Compilation
To compile the Java files:

```bash
javac timeserver.java timeclient.java
```

This will generate `timeserver.class` and `timeclient.class` files.

## Running the Applications

### Starting the Server
Run the server with the desired port number:

```bash
java timeserver <port>
```

Example:
```bash
java timeserver 8182
```
The server will start listening on the specified port for incoming client connections.

### Running the Client
Run the client with the server's IP address and port number:

```bash
java timeclient <server-ip> <port>
```

Example:
```bash
java timeclient 127.0.0.1 8182
```
The client will connect to the server, retrieve the current date and time, display it, and then terminate.

## Functional Requirements

### Server
1. Listens on a specified port for client connections.
2. Sends the current date and time in the format `dd.MM.yyyy HH:mm` to the connected client.
3. Closes the connection with the client after sending the date and time.
4. Waits for new client connections after handling each client.

### Client
1. Connects to the server using the provided IP address and port.
2. Receives the current date and time from the server.
3. Displays the received date and time in the console.
4. Terminates after displaying the server's response.

## Example Interaction

1. Start the server:
   ```bash
   java timeserver 8182
   ```
   Output:
   ```
   Server is listening on port 8182
   New client connected
   Sent date and time: 31.12.2024 23:59
   ```

2. Start the client:
   ```bash
   java timeclient 127.0.0.1 8182
   ```
   Output:
   ```
   Server time: 31.12.2024 23:59
   ```

## Notes
- Ensure the server is running before starting the client.
- Replace `127.0.0.1` with the actual IP address of the server if running on different machines.

## Cleanup
To clean up compiled files:

```bash
rm *.class
```

## License
This project is free to use and modify for educational purposes.

