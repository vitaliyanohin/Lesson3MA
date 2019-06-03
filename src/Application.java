import java.util.Arrays;

public class Application {

  public static void main(String[] args) {
    Robot robot = new Robot(0, 0, Direction.UP);
    robot.moveRobot(robot, -2, -2);
    System.out.println("Next:");
    ComplexNumber numberA = new ComplexNumber(2.2, 2.2);
    ComplexNumber numberB = new ComplexNumber(2.2, 2.2);
    System.out.println(numberA.equals(numberB));
    System.out.println(numberA.hashCode());
    ComplexNumber numberC = new ComplexNumber(2.2, 2.2);
    ComplexNumber numberD = new ComplexNumber(2.2, 2.19);
    System.out.println(numberC.equals(numberD));
    System.out.println(numberD.hashCode());
    ComplexNumber numberE = new ComplexNumber(2.1, 2.2);
    ComplexNumber numberF = new ComplexNumber(2.2, 2.2);
    System.out.println(numberE.equals(numberF));
    ComplexNumber numberG = new ComplexNumber(2.2, 2.1);
    ComplexNumber numberH = new ComplexNumber(2.2, 2.2);
    System.out.println(numberG.equals(numberH));
    System.out.println("Next:");
    String[] rolesPool = {"Городничий", "Аммос Федорович", "Артемий Филиппович", "Лука Лукич"};
    String[] textLinesPool = {"Городничий: Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие: к нам едет ревизор.", "Аммос Федорович: Как Аммос Федорович ревизор?", "Артемий Филиппович: Как Артемий Филиппович: ревизор?", "Городничий: Ревизор из Петербурга, инкогнито. И еще с секретным предписаньем.", "Аммос Федорович: Вот те на!", "Артемий Филиппович: Вот не было заботы, так подай!", "Лука Лукич: Господи боже! еще и с секретным предписаньем!"};
    System.out.println(printTextPerRole(rolesPool, textLinesPool));
    System.out.println("Next:");
    System.out.println(Arrays.toString(mergeArrays(new int[]{4, 6, 2}, new int[]{1, 3, 7, 5})));
  }

  private static String printTextPerRole(String[] roles, String[] textLines) {
    StringBuilder result = new StringBuilder();
    for (String role : roles) {
      result.append(role).append(":\n");
      for (int i = 0; i < textLines.length; ++i)
        if (textLines[i].startsWith(role + ":"))
          result.append(" ").append(i + 1).append(")").append(textLines[i].substring(role.length() + 1)).append("\n");
      result.append("\n");
    }
    return result.toString();
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
