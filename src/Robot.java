public class Robot {
  private int startingPositionOnAxisX;
  private int startingPositionOnAxisY;
  private Direction setDirection;

  public Robot(int setStartPositionOnAxisX, int setStartPositionOnAxisY, Direction direction) {
    this.startingPositionOnAxisX = setStartPositionOnAxisX;
    this.startingPositionOnAxisY = setStartPositionOnAxisY;
    this.setDirection = direction;
  }

  public static void moveRobot(Robot robot, int toX, int toY) {
    int directionOnAxisX = toX - robot.getX();
    int directionOnAxisY = toY - robot.getY();
    while (robot.getDirection() != Direction.RIGHT) {
      robot.turnRight();
      if (robot.getDirection() == Direction.RIGHT) {
        while (directionOnAxisX > 0) {
          robot.stepForward();
          directionOnAxisX--;
        }
      }
    }
    while (robot.getDirection() != Direction.LEFT) {
      robot.turnRight();
      if (robot.getDirection() == Direction.LEFT) {
        while (directionOnAxisX < 0) {
          robot.stepForward();
          directionOnAxisX++;
        }
      }
    }
    while (robot.getDirection() != Direction.UP) {
      robot.turnLeft();
      if (robot.getDirection() == Direction.UP) {
        while (directionOnAxisY > 0) {
          robot.stepForward();
          directionOnAxisY--;
        }
      }
    }
    while (robot.getDirection() != Direction.DOWN) {
      robot.turnLeft();
      if (robot.getDirection() == Direction.DOWN) {
        while (directionOnAxisY < 0) {
          robot.stepForward();
          directionOnAxisY++;
        }
      }
    }
  }

  private Direction getDirection() {
    return setDirection;
  }

  private int getX() {
    return startingPositionOnAxisX;
  }

  private int getY() {
    return startingPositionOnAxisY;
  }

  private void turnLeft() {
    switch (getDirection()) {
      case UP:
        setDirection = Direction.LEFT;
        break;
      case LEFT:
        setDirection = Direction.DOWN;
        break;
      case DOWN:
        setDirection = Direction.RIGHT;
        break;
      case RIGHT:
        setDirection = Direction.UP;
        break;
    }
  }

  private void turnRight() {
    switch (getDirection()) {
      case UP:
        setDirection = Direction.RIGHT;
        break;
      case RIGHT:
        setDirection = Direction.DOWN;
        break;
      case DOWN:
        setDirection = Direction.LEFT;
        break;
      case LEFT:
        setDirection = Direction.UP;
        break;
    }
  }

  private void stepForward() {
    if (getDirection().equals(Direction.RIGHT)) {
      startingPositionOnAxisX++;
      System.out.println("я двигаюсь! По направению: " + getDirection() + " Ось X  "
              + startingPositionOnAxisX);
    }
    if (getDirection().equals(Direction.LEFT)) {
      startingPositionOnAxisX--;
      System.out.println("я двигаюсь! По направению: " + getDirection() + " Ось X  "
              + startingPositionOnAxisX);
    }
    if (getDirection().equals(Direction.UP)) {
      startingPositionOnAxisY++;
      System.out.println("я двигаюсь! По направению: " + getDirection() + " Ось Y  "
              + startingPositionOnAxisY);
    }
    if (getDirection().equals(Direction.DOWN)) {
      startingPositionOnAxisY--;
      System.out.println("я двигаюсь! По направению: " + getDirection() + " Ось Y  "
              + startingPositionOnAxisY);
    }
  }
}
