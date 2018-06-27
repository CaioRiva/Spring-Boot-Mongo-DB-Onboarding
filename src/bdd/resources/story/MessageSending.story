Narrative:
In order to communicate with participants
As a participant of a room
I want to be able to send messages

Scenario: A specific participant sends a message and all participants of his room receives it

Given the participant Caio of a room with 10 participants in total
When the participant Caio sends a message test-message
Then all participants from the participant Caio room must receive the message test-message