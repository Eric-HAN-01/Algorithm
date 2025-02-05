import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();

        System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
        // 한문장씩 나누고 ____(4칸) 반복해서 출력 해보면 될듯?
        String str = "\"재귀함수가 뭔가요?\"\n";
        String str2 = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n";
        String str3 = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n";
        String str4 = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n";

        // 재귀 함수 호출
        recursion(str, str2, str3, str4, count, 0);

        scanner.close();

    }

    public static void recursion(String str, String str2, String str3, String str4, int count, int depth) {
        String indent = "____".repeat(depth);

        if (count == 0){
            System.out.println(indent + "\"재귀함수가 뭔가요?\"");
            System.out.println(indent + "\"재귀함수는 자기 자신을 호출하는 함수라네\"");
            System.out.println(indent + "라고 답변하였지.");
            return;
        }
        System.out.print(indent + str);
        System.out.print(indent + str2);
        System.out.print(indent + str3);
        System.out.print(indent + str4);

        recursion(str, str2, str3, str4, count - 1, depth + 1);

        System.out.println(indent + "라고 답변하였지.");
    }
}