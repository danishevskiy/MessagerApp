# MessagerApp

Run application:

run start.sh

#The use case for this task is as bellow:
1. create 2 players
2. wait until both players are "ready"
3. one of the players should send a message to second player
4. when a player receives a message should send back a new message that contains the previous message concatenated with the message
counter that this player sent (additional info: terminate the program after the "initiator" received 10 messages. the counter should be per player)
5. finalize the program (gracefully) after one of the players sent 10 messages (stop condition)
