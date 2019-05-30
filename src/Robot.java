public class Robot {
  private int startingPositionOnAxisX;
  private int startingPositionOnAxisY;
  private int endPointOfTheWayOnAxisX;
  private int endPointOfTheWayOnAxisY;
  private Direction setDirection;

  public Robot(int setStartPositionOnAxisX, int setStartPositionOnAxisY, Direction direction) {
    this.startingPositionOnAxisX = setStartPositionOnAxisX;
    this.startingPositionOnAxisY = setStartPositionOnAxisY;
    this.setDirection = direction;
  }

  public void moveRobot(Robot robot, int setEndPointOfTheWayOnAxisX, int setEndPointOfTheWayOnAxisY) {
    this.endPointOfTheWayOnAxisX = setEndPointOfTheWayOnAxisX;
    this.endPointOfTheWayOnAxisY = setEndPointOfTheWayOnAxisY;
    robot.stepForward();
  }

  public enum Direction {
    UP, DOWN, LEFT, RIGHT
  }

  private Direction lookRightOrLeft() {
    setDirection = (endPointOfTheWayOnAxisX > startingPositionOnAxisX) ? Direction.RIGHT : Direction.LEFT;
    return setDirection;
  }

  private Direction lookUpOrDown() {
    setDirection = (endPointOfTheWayOnAxisY > startingPositionOnAxisY) ? Direction.UP : Direction.DOWN;
    return setDirection;
  }

  private void stepForward() {
    if (lookRightOrLeft().equals(Direction.RIGHT)) {
      for (int i = startingPositionOnAxisX; i < endPointOfTheWayOnAxisX; i++) {
        startingPositionOnAxisX++;
        System.out.println("я двигаюсь! По направению: " + Direction.RIGHT + " Ось X  "
                + startingPositionOnAxisX);
      }
    }
    if (lookRightOrLeft().equals(Direction.LEFT)) {
      for (int i = startingPositionOnAxisX; i > endPointOfTheWayOnAxisX; i--) {
        startingPositionOnAxisX--;
        System.out.println("я двигаюсь! По направению: " + Direction.LEFT + " Ось X  "
                + startingPositionOnAxisX);
      }
    }
    if (lookUpOrDown().equals(Direction.UP)) {
      for (int i = startingPositionOnAxisY; i < endPointOfTheWayOnAxisY; i++) {
        startingPositionOnAxisY++;
        System.out.println("я двигаюсь! По направению: " + Direction.UP + " Ось Y  "
                + startingPositionOnAxisY);
      }
    }
    if (lookUpOrDown().equals(Direction.DOWN)) {
      for (int i = startingPositionOnAxisY; i > endPointOfTheWayOnAxisY; i--) {
        startingPositionOnAxisY--;
        System.out.println("я двигаюсь! По направению: " + Direction.DOWN + " Ось Y  "
                + startingPositionOnAxisY);
      }
    }
    System.out.println("Моя конечная точка: X = " + startingPositionOnAxisX + " Y = "
            + startingPositionOnAxisY + " Достигнута!");
  }
}
