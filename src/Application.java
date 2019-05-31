import java.util.Arrays;

public class Application {

  public static void main(String[] args) {
    Robot robot = new Robot(2, 2, Robot.Direction.UP);
    robot.moveRobot(robot, 4, -2);
    System.out.println("Next:");
    ComplexNumber numberA = new ComplexNumber(2.2, 2.2);
    ComplexNumber numberB = new ComplexNumber(2.2, 2.2);
    System.out.println(numberA.equals(numberB));
    System.out.println("Next:");
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
    System.out.println(printTextPerRole(rolesPool, textLinesPool));
    System.out.println("Next:");
    System.out.println(Arrays.toString(mergeArrays(new int[]{4, 6, 2}, new int[]{1, 3, 7, 5})));
  }

  private static String printTextPerRole(String[] roles, String[] textLines) {
    int count;
    StringBuilder tempRolesBuilder = new StringBuilder();
    StringBuilder tempTextLinesBuilder = new StringBuilder();
    StringBuilder finalBuilderForPrint = new StringBuilder();
    for (String roles2 : roles) {
      tempRolesBuilder.delete(0, tempRolesBuilder.length());
      tempRolesBuilder.append(roles2);
      finalBuilderForPrint.append("\n");
      finalBuilderForPrint.append(roles2).append(":").append("\n");
      count = 0;
      for (String textLine2 : textLines) {

        tempTextLinesBuilder.delete(0, tempTextLinesBuilder.length());
        count++;
        tempTextLinesBuilder.append(textLine2.substring(0, textLine2.indexOf(":")));


        if ((tempRolesBuilder.toString()).equals(tempTextLinesBuilder.toString())) {
          finalBuilderForPrint.append(count).append(")").append(textLine2.substring(textLine2.indexOf(":") + 1))
                  .append("\n");
        }
      }
    }
    return finalBuilderForPrint.toString();
  }

  private static int[] mergeArrays(int[] firstArray, int[] secondArray) {
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
    return finalArray;
  }
}
