# TP3 CAR : AKKA

The goal of the project is to implement actors distributed with Akka.

# Structure

```
CAR_TP3_AKKA
|____src
| |____test
| | |____java
| |____main
| | |____resources
| | |____java
| | | |____Graph.java
| | | |____Node.java
| | | |____Main.java
| | | |____Tree.java
| | | |____Message.java
| | | |____TreeRepart.java
|____Readme.md
|____pom.xml

```

# Use
## Question 2

```
java -jar akka_q2.jar
```
Result
```
Question 02
------------------------------------>>
Message : Pigeon, sended by : Node1
<<------------------------------------
Message : Pigeon, received by : Node2
Message : Pigeon, received by : Node5
Message : Pigeon, received by : Node4
Message : Pigeon, received by : Node6
Message : Pigeon, received by : Node3
```
## Question 3

```
java -jar akka_q3.jar
```
Result
```
Question 03
------------------------------------>>
Message : Pigeon, sended by : Node2
<<------------------------------------
Message : Pigeon, received by : Node3
Message : Pigeon, received by : Node4
```

## Question 4
Actors 1, 2 and 3 are on the first system. Actors 4, 5 and 6 are on the second.
```
java -jar akka_q4.jar
```
Result
```
Question 04
------------------------------------>>
Message : Pigeon, sended by : Node1
<<------------------------------------
Message : Pigeon, received by : Node2
Message : Pigeon, received by : Node5
Message : Pigeon, received by : Node3
Message : Pigeon, received by : Node4
Message : Pigeon, received by : Node6
```

## Question 5
- An arc is created between the actor 4 and the actor 6.
- The graph is non-oriented.
- A node does not send the same message twice.
- A node can receive the same message more than once.

No test with Junit but the scenarios are:
For trees:
- test that all wires have received the message sent.
- test that the message comes from the good father.
- test whether the nodes relay the message correctly
For the graph:
- test whether the message is sent once per node.

```
java -jar akka_q5.jar
```
Result
```
Question 05
------------------------------------>>
Message : Pigeon, sended by : Node1
<<------------------------------------
Message : Pigeon, received by : Node2
Message : Pigeon, received by : Node5
Message : Pigeon, received by : Node4
Message : Pigeon, received by : Node6
Message : Pigeon, received by : Node3
Message : Pigeon, received by : Node4
Message : Pigeon, received by : Node6
```


   

