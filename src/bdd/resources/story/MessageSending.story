Narrative:
In order to communicate with participants
As a participant of a room
I want to be able to send messages

Scenario: A specific participant sends a message and all participants of his room receives it

Given the new user(s) U_1,U_2,U_3
And a new room R_1 created by the user U_1 and with the following invited user(s) U_2,U_3
And the participants P_A,P_B,P_C of the room R_1
When the participant P_A sends a message M_1
Then the participants P_A,P_B,P_C must receive the message M_1