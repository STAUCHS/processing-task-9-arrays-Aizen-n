import processing.core.PApplet;

public class Sketch extends PApplet {

  // Related arrays for the (x, y) coordinate of the snowflakes
  float[] snowX = new float[42];
  float[] snowY = new float[42];
  int snowDiameter = 10;

  // player circle variables & player circle collision 
  float circleX = 150;
  float circleY = 150;
  boolean collision = false;

  // unused variables to change the colour of the life boxes & to count how many collisions have taken place 
  int lifeBoxColour = 225;
  int lifeBoxColour2 = 225;
  int collisionCounter = 0;

  public void settings() {
    size(400, 400);
  }

  public void setup() {
    background(0);

    // generate random places for the snowflakes to be (x and y values)
    for (int i = 0; i < snowX.length; i++) {
      snowX[i] = random(width);
      snowY[i] = random(height);
      circle(snowX[i], snowY[i], snowDiameter);
    }
  }

  public void draw() {

    // draw snow 
    background(0);
    snow();

      // WASD movement's tied to a blue circle 
    if (keyPressed) {
      if (key == 'w') {
        circleY--;
      }
      else if (key == 's') {
        circleY++;
      }
      else if(key == 'a'){
        circleX--;
      }
      else if(key == 'd'){
       circleX++;
      }
    }
    // collision detection for blue circle 
    for (int i = 0; i < snowX.length; i++) {
    if(dist(circleX,circleY,snowX[i],snowY[i]) < snowDiameter) {
      collision = true;
      collisionCounter++;
      break;
    }
  }
  // changes background to whit eif collision takes place
  if (collision) {
    background(225);
  }

  // not sure why this didnt work 

  /*  

    if (collision && collisionCounter == 1) {
      
    }
    
    else if (collision && collisionCounter == 2){

    }
    else  {

  } 

  */

  // player circle 
  fill(0,0,225);
  circle(circleX,circleY,10);
  
  // life boxes 
for(int i = width/3; i < width; i+=90) {
  square(i,height/10,50);
}
  }

  // All other defined methods are written below:
  public void snow() {
    for (int i = 0; i < snowX.length; i++ ) {
      fill(225);
      circle(snowX[i], snowY[i], snowDiameter);

      snowY[i] += 2; 

      // reset snowflakes back to the top
      if (snowY[i] > height) {
        snowY[i] = 0;
      }

      if (snowY[i] < 50 - height) {
        snowY[i] = 0;
      }

      if(keyPressed) {

        if(keyCode == UP) {
        snowY[i] -= 1; 
        }
        else if (keyCode == DOWN){
          snowY[i] += 1;
        }

      }
    }
  }
}