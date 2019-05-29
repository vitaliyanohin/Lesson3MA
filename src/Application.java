import java.util.Arrays;

public class Application {

  public static void main(String[] args) {
    Robot robot = new Robot(4, -2, Robot.Direction.UP);
    robot.moveRobot(robot, 2, 2);
    System.out.println("Next:");
    ComplexNumber numberA = new ComplexNumber(2.2, 2.2);
    ComplexNumber numberB = new ComplexNumber(2.2, 2.2);
    System.out.println(numberA.equals(numberB));
    System.out.println("Next:");
    printTextPerRole();
    System.out.println("Next:");
    System.out.println(mergeArrays(new int[]{4, 6, 2}, new int[]{1, 3, 7, 5}));
  }

  private static void printTextPerRole() {
    int count = 0;
    StringBuilder tempRolesBuilder = new StringBuilder();
    StringBuilder tempTextLinesBuilder = new StringBuilder();
    StringBuilder finalBuilderForPrint = new StringBuilder();
    String[] rolesPool = {"Городничий", "Аммос Федорович", "Артемий Филиппович", "Лука Лукич"};
    String[] textLinesPool = {
            "Городничий: Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие: к нам едет ревизор.",
            "Аммос Федорович: Как Аммос Федорович ревизор?",
            "Артемий Филиппович: Как Артемий Филиппович: ревизор?",
            "Городничий: Ревизор из Петербурга, инкогнито. И еще с секретным предписаньем.",
            "Аммос Федорович: Вот те на!",
            "Артемий Филиппович: Вот не было заботы, так подай!",
            "Лука Лукич: Господи боже! еще и с секретным предписаньем!"
    };

    for (String roles : rolesPool) {
      tempRolesBuilder.delete(0, tempRolesBuilder.length());
      tempRolesBuilder.append(roles);
      finalBuilderForPrint.append(roles).append(":").append("\n");

      for (String textLine : textLinesPool) {
        tempTextLinesBuilder.delete(0, tempTextLinesBuilder.length());
        tempTextLinesBuilder.append(textLine.substring(0, textLine.indexOf(":")));

        if ((tempRolesBuilder.toString()).equals(tempTextLinesBuilder.toString())) {
          count++;
          finalBuilderForPrint.append(count).append(") ");
          finalBuilderForPrint.append(textLine.substring(textLine.indexOf(":") + 1)).append("\n");
        }
      }
    }
    System.out.println(finalBuilderForPrint);
  }

  private static String mergeArrays(int[] firstArray, int[] secondArray) {
    int[] finalArray = new int[firstArray.length + secondArray.length];
    boolean isSorted = false;
    int flagIndexForFirstArray = 0;
    int flagIndexForSecondArray = 0;

    while (flagIndexForFirstArray < firstArray.length) {
      finalArray[flagIndexForFirstArray] = firstArray[flagIndexForFirstArray];
      flagIndexForFirstArray++;
    }
    while (flagIndexForSecondArray < (finalArray.length - firstArray.length)) {
      finalArray[flagIndexForFirstArray] = secondArray[flagIndexForSecondArray];
      flagIndexForFirstArray++;
      flagIndexForSecondArray++;
    }

    int bufferBubble;
    while (!isSorted) {
      isSorted = true;
      for (int i = 0; i < finalArray.length - 1; i++) {
        if (finalArray[i] > finalArray[i + 1]) {
          isSorted = false;
          bufferBubble = finalArray[i];
          finalArray[i] = finalArray[i + 1];
          finalArray[i + 1] = bufferBubble;
        }
      }
    }
    return Arrays.toString(finalArray);
  }
}
