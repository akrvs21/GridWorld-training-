In this test report i'm going to introduce the Junit,and how i used unit testing to test functionality of my Jumper code.  
 So Jumper,is a bug that jumps over other actors if it meets on it's way.Jumper code consists of two methods, move();-method and canMove();-method. So on the grid,there can be different scenarios that can happened with Jumper,for example he can meet other Jumper, or meet other  actors(non-jumpers,such as rock,bug etc). So we need to test whether our methods works correctly by using unit testing.   
1) So first we test scenario with flower, Jumper meet a flower on its way(2 tile far from it).  
        
    @Test
    public void testFrontFlower() {
    ActorWorld world = new ActorWorld();
    Jumper jumper = new Jumper();
    Flower flower = new Flower();
    world.add(new Location(7, 6), jumper);
    world.add(new Location(5, 6), flower);
    
    jumper.act();
    
      assertFalse(jumper.getLocation().getRow() == 5);
      assertTrue(jumper.getLocation().getCol() ==  6);
    
    }  
In this unit, we add actors and call act() method, after we compare the answers. In this case i've used Assert class. Assert class provides a set of assertion methods useful for writing tests. So `assertFalse(jumper.getLocation().getRow() == 5);` asserts that a condition is false,i.e. the jumper's **row == 5** after calling act method **is false**,and that s correct, since the initial is 7 and after making another move it should go straight to the 6th row and not to the 5th,so the condition **is false** . Then we checking the columns, whether it changing it's direction after calling act method. So we can see, here `assertTrue(jumper.getLocation().getCol() ==  6);` it asserts that the condition(after `act()`) is true, and that returns true since initial position was on 6th column `world.add(new Location(7, 6), jumper);`. Now we have succesfully completed first unit test.  
2) Second  we do the same with Rock.  

     @Test
    public void testFrontRock() {
    ActorWorld world = new ActorWorld();
    Jumper jumper = new Jumper();
    Rock rock = new Rock();
    world.add(new Location(7, 3), jumper);
    world.add(new Location(5, 3), rock);
    
    jumper.act();
    
      assertFalse(jumper.getLocation().getRow() == 5);
      assertTrue(jumper.getLocation().getCol() ==  3);
    
    }  
I again used `assertTrue();` and `assertFalse();` to test the correctness. And in both cases test went successfully.  
3) Here we checking whether Jumper is in the grid 

    @Test
    public void outOfGrid() { // b
        
        ActorWorld world = new ActorWorld();
   
        Jumper jumper = new Jumper();
        world.add(new Location(1, 7), jumper);

        int previousDir = jumper.getDirection();
        jumper.act();

          assertNotNull(jumper.getGrid());
          assertTrue(jumper.getDirection() == previousDir);
    }  
Adding a jumper, creating new variable `previousDir` and assign a current direction of the Jumper. After act method is called, we asserting that our object is not null:  `assertNotNull(jumper.getGrid());`.Then `assertTrue(jumper.getDirection() == previousDir);` return us true if current direction is equal to previousDir.  
4) When facing the edge of the grid:  

        @Test
    public void facingEdge() {
    
    ActorWorld world = new ActorWorld();
    Jumper jumper = new Jumper();
    world.add(new Location(0, 0), jumper);
    int originalDir = jumper.getDirection();
    
    jumper.act(); 
    
      assertFalse(jumper.getDirection() == originalDir);
    }  

Getting current location, and comparing it,whether it return false.      `assertFalse(jumper.getDirection() == originalDir);`  
5) When meet a Bug in front  

    @Test
    public void testFrontBug() {
        ActorWorld world = new ActorWorld();
        Jumper jumper = new Jumper();
        Bug bug = new Bug();
        world.add(new Location(4, 6), jumper);
        world.add(new Location(5, 6), bug);

        int originalDir = jumper.getDirection();
        
        jumper.act();
          assertFalse(jumper.getLocation().getRow() == 5);
          assertTrue(jumper.getLocation().getCol() ==  6);
          assertEquals(jumper.getDirection(), originalDir);

    }  
First two,assertTrue and assertFalse, are similar to previous tests, the new `assertEquals(jumper.getDirection(), originalDir); ` asserts whether the first value `jumper.getDirection()`(expected value) and second value `originalDir`(actual value) are equal.  
6) When facing another Jumper  


    @Test
    public void testNewJumper() {
      
        ActorWorld world = new ActorWorld();

        Jumper jumper = new Jumper();
        Jumper jumper2 = new Jumper();
        world.add(new Location(8, 2), jumper);
        world.add(new Location(6, 2), jumper2);
        
        int originalDir = jumper.getDirection();
        
        jumper.act();
        
          assertTrue(jumper.getDirection() == originalDir);
          assertNotNull(jumper2.getGrid());
          assertEquals(jumper2.getLocation().getRow(), 6);
          assertEquals(jumper2.getLocation().getCol(), 2);

    }  

Here methods and assertion are similar as described above.  



  
  
    



    