## bouncing ball on 2 computers

A single ball is bouncing inside a rectangular container box in full screen mode. Assume that this program is running on two computers. If the ball touches the right side border of the first computer screen, it will emerge from the left side screen border of the second computer . Similarly if the ball touches the left side screen border of the second computer, it will emerge from the right side screen border of the first computer.

When the ball touches the right side border, you will capture current attributes of the ball object and send this information using sockets to the ball bouncing program which is running on the second computer. This program will create a ball object with the variables received from the first computer. The ball object on the first computer should be destroyed.

Remember that both computer work as servers and clients. The client of the first computer is the second computer and the client of the second computer is the first computer.
