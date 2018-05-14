#1. Inception: clarify the details of the problem:

###a. What will a jumper do if the location in front of it is empty, but the location two cells in front contains a flower or a rock?
####- It will move forward right till the rock or flower.
###b. What will a jumper do if the location two cells in front of the jumper is out of the grid?
####-Change the direction(45 degree).
###c. What will a jumper do if it is facing an edge of the grid?
####-Change it's direction for 45 degree
###d. What will a jumper do if another actor (not a flower or a rock) is in the cell that is two cells in front of the jumper?
####-Keep going straight.
###e. What will a jumper do if it encounters another jumper in its path?
####-Turning around 90 degree.
###f. Are there any other tests the jumper needs to make?
####-No.
