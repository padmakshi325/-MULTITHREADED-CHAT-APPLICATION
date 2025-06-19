# -MULTITHREADED-CHAT-APPLICATION

*COMPANY* : CODE TECH IT SOLUTIONS

*NAME* : SUSARLA PADMAKSHI

*INTERN ID* : CT04DN839

*DOMAIN* : JAVA PROGRAMMING

*DURATION* : 4 WEEKS

*MENTROR* : NEELA SANTOSH

*DESCRIPTION* : 

This project demonstrates a basic real-time messaging application built using Java’s Socket and ServerSocket classes. The primary goal of the project is to enable two-way communication between a server and one or more clients using TCP/IP networking. Implemented and tested using Visual Studio Code, this system serves as a foundational exercise in Java networking and multithreading.
The system consists of two main components: Server.java and Client.java. The server initializes a socket to listen on a specific port (e.g., 12345) and waits for incoming client connections. Once a client connects, both parties can exchange messages in real time using input and output streams. The communication model uses blocking I/O and a basic message loop to simulate a live chat environment. The client, on the other hand, establishes a connection to the server’s IP address and port and launches a thread to listen for incoming messages while allowing the user to input and send messages concurrently.

Key Components:
Server.java: Initializes a ServerSocket, waits for a client connection, and handles incoming messages. It uses BufferedReader and PrintWriter for message transmission, and InputStreamReader for reading from the console. The server can read messages from the client and respond back interactively.
Client.java: Connects to the server using a Socket, launches a dedicated thread to handle incoming messages from the server, and allows the user to send responses in parallel. The use of a nested Runnable class (ReceiveMessages) enables asynchronous reading without blocking the main thread.
Multithreading: The chat client uses a background thread to continuously read incoming messages while keeping the main thread responsive to user input. This is essential for any real-time messaging application to function effectively.

Functionality Overview:
Server Initialization: The server listens on a specified port using new ServerSocket(port).
Client Connection: The client uses new Socket("localhost", port) to connect to the server.
Bidirectional Messaging: Both server and client can send and receive text messages.
User Interaction: Inputs are read via the console, making the chat system interactive and text-based.
Threaded Listening: The client runs a thread to constantly listen for server messages.

Execution Environment:
Language: Java (JDK 21)
IDE: Visual Studio Code
Execution Steps:

Compile both files:
bash

javac Server.java
javac Client.java

Run in two separate terminals:
bash

java Server
java Client

Learning Outcomes:
This project introduces key concepts in Java networking, including socket programming, stream handling, and thread-based concurrency. It provides a practical foundation for understanding how low-level communication occurs over TCP/IP protocols. By building a live chat tool, learners explore the fundamentals of client-server architecture and concurrent execution in Java.
This application models the backbone of real-world communication systems and is an excellent stepping stone toward more advanced networked applications like multiplayer games, chat rooms, or REST-based services. It is especially useful for students and beginner developers aiming to strengthen their grasp of interprocess communication and Java’s core I/O libraries.

