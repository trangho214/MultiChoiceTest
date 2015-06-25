package paxcreation.com.multiplechoicequestionstest.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import paxcreation.com.multiplechoicequestionstest.entity.ConstructedQuestion;
import paxcreation.com.multiplechoicequestionstest.entity.MultiChoiceQuestion;

/**
 * Created by Administrator on 16/06/2015.
 */
public class Data {


    public static List<ConstructedQuestion> getConstructedQuestionIOS()
    {
        List<ConstructedQuestion> constructedQuestions = new CopyOnWriteArrayList<ConstructedQuestion>();

        ConstructedQuestion constructedQuestion = new ConstructedQuestion();
        constructedQuestion.setId(9);
        constructedQuestion.setQuestion(" 9.\tĐiền vào phương thức sau để trả ra mảng có giá trị giảm dần:");
        constructedQuestion.setContent("func sortNumber(inNumber : [Int]) -> [Int] {\n" +
                "  \t\t\treturn ..................\n" +
                "    \t}\n");
        constructedQuestions.add(constructedQuestion);

        ConstructedQuestion constructedQuestion1 = new ConstructedQuestion();
        constructedQuestion1.setId(10);
        constructedQuestion1.setQuestion(" 10.\tViết chương trình chuyển đổi JSON thành danh sách đối tượng bằng Swift hoặc Objective C\n" +
                "\t\tJSON có giá trị như sau: \n");
        constructedQuestion1.setContent("{\"message\": \"success\",\"objects\": [{\"id\": 10,\"image\": \"http://example.com/images/s5.png\",\"name\": \"Samsung S5\",},{\"id\": 11,\"image\": \"http://example.com/images/s4.png\",\"name\": \"Samsung S4\",}],\"status\": \"ok\",\"total\": 2};");
        constructedQuestions.add(constructedQuestion1);

        return constructedQuestions;
    }

    public static List<MultiChoiceQuestion> getMultiChoiceQuestionIOS()
    {
        List<MultiChoiceQuestion> multiChoiceQuestions = new ArrayList<MultiChoiceQuestion>();

        MultiChoiceQuestion multiChoiceQuestion = new MultiChoiceQuestion();
        multiChoiceQuestion.setId(0);
        multiChoiceQuestion.setQuestion("1.\tChọn câu đúng nhất. Core Data  là");
        multiChoiceQuestion.setPossibleAnswers(Arrays.asList(" a)\tFramework hiển thị dữ liệu ứng dụng",
                " b)\tFramework chứa cơ sở dữ liệu của hệ điều hành.",
                " c)\tFramework lưu trữ dữ liệu theo hướng đối tượng",
                " d)\tFramework tương tác mọi dữ liệu trong ứng dụng ",
                " e)\tFramework chứa tất cả dữ liệu cần thiết cho ứng dụng"));
        multiChoiceQuestion.setRightAnswer(2);
        multiChoiceQuestions.add(multiChoiceQuestion);

        MultiChoiceQuestion multiChoiceQuestion1 = new MultiChoiceQuestion();
        multiChoiceQuestion1.setId(1);
        multiChoiceQuestion1.setQuestion(" 2.\tChọn câu đúng nhất. Delegate là gì?");
        multiChoiceQuestion1.setPossibleAnswers(Arrays.asList(

                " a)\tLà các đối tượng có sẵn trong IOS để tương tác với View",
                        " b)\tLà những đối tượng có sẵn chứa một số phương thức tương tác ",
                        " c)\tLà giao thức kết nối trao đổi thông tin giữa các đối tượng ",
                        " d)\tLà giao thức chia sẽ thông tin một số sự kiện xảy ra trên hệ điều hành",
                        " e)\t Là con trỏ trỏ vào một đối tượng nào đó trong ứng dụng"));
        multiChoiceQuestion1.setRightAnswer(2);
        multiChoiceQuestions.add(multiChoiceQuestion1);


        MultiChoiceQuestion multiChoiceQuestion2 = new MultiChoiceQuestion();
        multiChoiceQuestion2.setId(2);
        multiChoiceQuestion2.setQuestion("3.\tChọn giá trị in ra :");
        multiChoiceQuestion2.setContent(
                "- (void) calculate {\n" +
                        "    \t\t\tNSNumber *a = [NSNumber numberWithFloat:5.5];\n" +
                        "    \t\t\tNSNumber *b = [NSNumber numberWithFloat:2.8];\n" +
                        "    \t\t\tNSNumber *c = [NSNumber numberWithFloat:(a.intValue/2)*b.intValue];\n" +
                        "    \t\t\tNSLog(@\"%@\",c);\n" +
                        "\t\t}\n");
        multiChoiceQuestion2.setPossibleAnswers(Arrays.asList(
                " a)\t3",
                " b)\t4",
                " c)\t5",
                " d)\t6",
                " e)\t8"));
        multiChoiceQuestion2.setRightAnswer(1);
        multiChoiceQuestions.add(multiChoiceQuestion2);

        MultiChoiceQuestion multiChoiceQuestion3 = new MultiChoiceQuestion();
        multiChoiceQuestion3.setId(3);
        multiChoiceQuestion3.setQuestion(" 4.\tPhương thức nào dùng cho push notification? ");
        multiChoiceQuestion3.setPossibleAnswers(Arrays.asList(
                " a)\t- (void)application:(UIApplication*)application didRegisterForRemoteNotificationsWithDeviceToken:(NSData*)deviceToken{}",
                        " b)\t- (void)application:(UIApplication*)application didReceiveForRemoteNotificationsWithDeviceToken:(NSData*)deviceToken{}",
                        " c)\t- (void)application:(UIApplication*)application didReceiveLocalNotificationWithDeviceToken:(NSData*)deviceToken{}",
                        " d)\t- (void)application:(UIApplication*)application didCompleteLocalNotificationWithDeviceToken:(NSData*)deviceToken{}"));
        multiChoiceQuestion3.setRightAnswer(0);
        multiChoiceQuestions.add(multiChoiceQuestion3);

        MultiChoiceQuestion multiChoiceQuestion4 = new MultiChoiceQuestion();
        multiChoiceQuestion4.setId(4);
        multiChoiceQuestion4.setQuestion(" 5.\tChọn kết quả in ra ");
        multiChoiceQuestion4.setContent(
                " func whatIsPrint (){\n" +
                        "        \t\t\tvar x = 5\n" +
                        "        \t\t\tvar b1 = true;\n" +
                        "        \t\t\tvar b2 = true;\n" +
                        "        \t\t\tif ((x==4) && !b2){\n" +
                        "            \t\tprint(\"1 \")\n" +
                        "        \t\t\t}\n" +
                        "        \t\t\tprint(\"2 \")\n" +
                        "        \t\t\tif ((b2 == true) && b1){\n" +
                        "            \t\tprint(\"3 \")\n" +
                        "        \t\t\t}\n" +
                        "    \t }\n");
        multiChoiceQuestion4.setPossibleAnswers(Arrays.asList(
                " a)\t2",
                " b)\t3",
                " c)\t1 2",
                " d)\t2 3",
                " e)\t1 2 3",
                " f)\tPhát sinh lỗi"));
        multiChoiceQuestion4.setRightAnswer(3);
        multiChoiceQuestions.add(multiChoiceQuestion4);

        MultiChoiceQuestion multiChoiceQuestion5 = new MultiChoiceQuestion();
        multiChoiceQuestion5.setId(5);
        multiChoiceQuestion5.setQuestion(" 6.\tChọn kết quả in ra từ outputByPass ");
        multiChoiceQuestion5.setContent(
                "func outputByPass (){\n" +
                        "        \t\t\tvar pass = Pass();\n" +
                        "        \t\t\tpass.doStuff();\n" +
                        "        \t\t\tprint(\" main x = \\(pass.number)\")\n" +
                        "    \t\t}\n" +
                        "    \t\tclass Pass {\n" +
                        "        \t\t\tvar number = 5\n" +
                        "        \t\t\tfunc doStuff() {\n" +
                        "            \t\tprint(\" doStuff x = \\(number++)\")\n" +
                        "        \t\t\t}\n" +
                        "    \t}\n");
        multiChoiceQuestion5.setPossibleAnswers(Arrays.asList(
                " a)\tdoStuff x = 5 main x = 5",
                " b)\tdoStuff x = 6 main x = 6",
                " c)\tdoStuff x = 5 main x = 6",
                " d)\tdoStuff x = 6 main x = 5",
                " e)\tPhát sinh lỗi"));
        multiChoiceQuestion5.setRightAnswer(2);
        multiChoiceQuestions.add(multiChoiceQuestion5);

        MultiChoiceQuestion multiChoiceQuestion6 = new MultiChoiceQuestion();
        multiChoiceQuestion6.setId(6);
        multiChoiceQuestion6.setQuestion(" 7.\tChọn kết quả in ra ");
        multiChoiceQuestion6.setContent(
                "func outputDoWhile (){\n" +
                        "        \t\t\tvar  x = 0\n" +
                        "        \t\t\tvar  y = 10\n" +
                        "        \t\t\tdo {\n" +
                        "            \t\ty--;\n" +
                        "            \t\t++x;\n" +
                        "        \t\t\t} while (x < 5)\n" +
                        "        \t\t\tprint(\"\\(x),\\(y)\")\n" +
                        "   \t }\n");
        multiChoiceQuestion6.setPossibleAnswers(Arrays.asList(
                " a)\t5,6",
                " b)\t5,5",
                " c)\t6,5",
                " d)\t6,6"));
        multiChoiceQuestion6.setRightAnswer(1);
        multiChoiceQuestions.add(multiChoiceQuestion6);


        MultiChoiceQuestion multiChoiceQuestion7 = new MultiChoiceQuestion();
        multiChoiceQuestion7.setId(7);
        multiChoiceQuestion7.setQuestion(" 8.\tChọn câu đúng ");
        multiChoiceQuestion7.setContent(
                "  func sortYourName () {\n" +
                        "        \t\t\tlet yournames  = [\"aAaA\",\"AaA\",\"aAa\",\"AAaa\"]\n" +
                        "        \t\t\tlet sortedNames = sorted(yournames)\n" +
                        "        \t\t\tfor name in sortedNames{\n" +
                        "            \t\tprint(\"\\(name) \")\n" +
                        "        \t\t\t}\n" +
                        "    \t  }\n");
        multiChoiceQuestion7.setPossibleAnswers(Arrays.asList(
                " a)\taAaA aAa AAaa AaA",
                        " b)\tAAaa AaA aAa aAaA",
                        " c)\tAaA AAaa aAaA aAa",
                        " d)\taAa AaA aAaA AAaa",
                        " e)\tKhi chạy sẽ ném ra lỗi"));
        multiChoiceQuestion7.setRightAnswer(1);
        multiChoiceQuestions.add(multiChoiceQuestion7);

        return multiChoiceQuestions;

    }

    public static List<MultiChoiceQuestion> getMultiChoiceQuestionsAndroid()
    {
        List<MultiChoiceQuestion> multiChoiceQuestions = new ArrayList<MultiChoiceQuestion>();

        MultiChoiceQuestion multiChoiceQuestion = new MultiChoiceQuestion();
        multiChoiceQuestion.setId(0);
        multiChoiceQuestion.setQuestion("1.\tChọn câu trả lời đúng:");
        multiChoiceQuestion.setContent(
                "\n" +
                        "\tpublic static void main(String[] args) {\n" +
                        "\t\tint x = 5;\n" +
                        "\t\tboolean b1 = true;\n" +
                        "\t\tboolean b2 = false;\n" +
                        "\t\tif ((x == 4) && !b2)\n" +
                        "\t\t\tSystem.out.print(\"1 \");\n" +
                        "\t\tSystem.out.print(\"2 \");\n" +
                        "\t\tif ((b2 = true) && b1)\n" +
                        "\t\t\tSystem.out.print(\"3 \");\n" +
                        "\t}\n");
        multiChoiceQuestion.setPossibleAnswers(Arrays.asList("A. 2", "B. 3", "C. 1 2", "D. 2 3", "E. 1 2 3", "F. Lỗi biên dịch"));
        multiChoiceQuestion.setRightAnswer(3);
        multiChoiceQuestions.add(multiChoiceQuestion);

        MultiChoiceQuestion multiChoiceQuestion1 = new MultiChoiceQuestion();
        multiChoiceQuestion1.setId(1);
        multiChoiceQuestion1.setQuestion("2.\tChọn câu trả lời đúng:");
        multiChoiceQuestion1.setContent(
                "\n" +
                        "\tpublic class Money {\n" +
                        "\tprivate String country;\n" +
                        "\tpublic String getCountry() {\n" +
                        "\t\treturn country;\n" +
                        "\t}\n" +
                        "\tpublic void setCountry(String country) {\n" +
                        "\t\tthis.country = country;\n" +
                        "\t}\n" +
                        "\t}\n" +
                        "\tclass Yen extends Money{\n" +
                        "\t\tpublic String getCountry() { return super.country; }\n" +
                        "\t}\n" +
                        "\tpublic class Euro extends Money{\n" +
                        "\t    \tpublic String getCountry(String timeZone) {\n" +
                        "\t\t\t\treturn super.getCountry();\n" +
                        "\t\t}\n" +
                        "\t}\n");
        multiChoiceQuestion1.setPossibleAnswers(Arrays.asList(
                "A. Yen trả ra giá trị đúng",
                "B. Khi chạy sẽ ném ra exception",
                "C. Yen và Euro trả ra giá trị đúng",
                "D. Lỗi biên dịch ở Yen",
                "E. Lỗi biên dịch ở Euro"));
        multiChoiceQuestion1.setRightAnswer(3);
        multiChoiceQuestions.add(multiChoiceQuestion1);


        MultiChoiceQuestion multiChoiceQuestion2 = new MultiChoiceQuestion();
        multiChoiceQuestion2.setId(2);
        multiChoiceQuestion2.setQuestion("3.\tChọn câu trả lời đúng:");
        multiChoiceQuestion2.setContent(
                "\n" +
                        "\tpublic static void main(String[] args) {\n" +
                        "\t\tObject [] myObjects = {\n" +
                        "\t\t\t\tnew Integer(12),\n" +
                        "\t\t\t\tnew String(\"foo\"),\n" +
                        "\t\t\t\tnew Integer(5),\n" +
                        "\t\t\t\tnew Boolean(true)\n" +
                        "\t\t\t\t};\n" +
                        "\t\tArrays.sort(myObjects);\n" +
                        "\t\tfor( int i=0; i<myObjects.length; i++) { \n" +
                        "\t\t\tSystem.out.print(myObjects[i].toString());\n" +
                        "\t\t\tSystem.out.print(\" \");\n" +
                        "\t\t}\n" +
                        "\t}\n");
        multiChoiceQuestion2.setPossibleAnswers(Arrays.asList(
                "A. Lỗi biên dịch ",
                "B. Kết quả sắp xếp in ra không theo thứ tự",
                "C. Kết quả sắp xếp in ra theo đúng thứ tự",
                "D. Xuất hiện ClassCastException khi chạy"));
        multiChoiceQuestion2.setRightAnswer(3);
        multiChoiceQuestions.add(multiChoiceQuestion2);

        MultiChoiceQuestion multiChoiceQuestion3 = new MultiChoiceQuestion();
        multiChoiceQuestion3.setId(3);
        multiChoiceQuestion3.setQuestion("4.\tChọn câu trả lời đúng:");
        multiChoiceQuestion3.setContent(
                "\n" +
                        "\tpublic class Pass {\n" +
                        "\t\tpublic static void main(String [] args) {\n" +
                        "\t\t\tint x = 5;\n" +
                        "\t\t\tPass p = new Pass();\n" +
                        "\t\t\tp.doStuff(x);\n" +
                        "\t\t\tSystem.out.print(\" main x = \"+ x);\n" +
                        "\t\t}\n" +
                        "\t\tvoid doStuff(int x) {\n" +
                        "\t\t\tSystem.out.print(\" doStuff x = \"+ x++);\n" +
                        "\t\t}\n" +
                        "\t}\n");
        multiChoiceQuestion3.setPossibleAnswers(Arrays.asList(
                "A. Lỗi biên dịch",
                "B. Khi chạy sẽ ném ra exception",
                "C. doStuff x = 5 main x = 5",
                "D. doStuff x = 6 main x = 6",
                "E. doStuff x = 5 main x = 6",
                "F. doStuff x = 6 main x = 5"));
        multiChoiceQuestion3.setRightAnswer(2);
        multiChoiceQuestions.add(multiChoiceQuestion3);

        MultiChoiceQuestion multiChoiceQuestion4 = new MultiChoiceQuestion();
        multiChoiceQuestion4.setId(4);
        multiChoiceQuestion4.setQuestion("5.\t Khi tạo 1 interface B kế thừa interface A thì ta dùng cách nào?");
        multiChoiceQuestion4.setContent(
                "\n" +
                        "\tpublic interface A {\n" +
                        "\t\tString DEFAULT_GREETING = \"Hello world\";\n" +
                        "\t\tpublic void method1();\n" +
                        "\t}\n");
        multiChoiceQuestion4.setPossibleAnswers(Arrays.asList(
                "A. public interface B extends A { }",
                "B. public interface B implements A {}",
                "C. public interface B instanceOf A {}",
                "D. public interface B inheritsFrom A { }"));
        multiChoiceQuestion4.setRightAnswer(0);
        multiChoiceQuestions.add(multiChoiceQuestion4);

        MultiChoiceQuestion multiChoiceQuestion5 = new MultiChoiceQuestion();
        multiChoiceQuestion5.setId(5);
        multiChoiceQuestion5.setQuestion("6.\tChọn câu trả lời đúng\n");
        multiChoiceQuestion5.setContent(
                "\n" +
                        "\tpublic class Person {\n" +
                        "\t\tprotected String name = \"No name\";\n" +
                        "\t\tpublic Person(String name) {\n" +
                        "\t\t\tthis.name = name;\n" +
                        "\t\t}\n" +
                        "\t}\n" +
                        "\tpublic class Employee extends Person {\n" +
                        "\t\tpublic String emplD = \"0000\";\n" +
                        "\t\tpublic Employee(String id) {\n" +
                        "\t\t\templD = id;\n" +
                        "\t\t}\n" +
                        "\t}\n" +
                        "\tpublic class EmployeeTest {\n" +
                        "\t\tpublic static void main(String[] args) {\n" +
                        "\t\t\tEmployee e = new Employee(\"4321\");\n" +
                        "\t\t\tSystem.out.println(e.empID);\n" +
                        "\t\t}\n" +
                        "\t}\n");
        multiChoiceQuestion5.setPossibleAnswers(Arrays.asList(
                "A. 4321",
                "B. 0000",
                "C. Khi chạy sẽ ném ra exception",
                "D. Lỗi biên dịch"));
        multiChoiceQuestion5.setRightAnswer(3);
        multiChoiceQuestions.add(multiChoiceQuestion5);

        MultiChoiceQuestion multiChoiceQuestion6 = new MultiChoiceQuestion();
        multiChoiceQuestion6.setId(6);
        multiChoiceQuestion6.setQuestion("7.\tChọn câu trả lời đúng");
        multiChoiceQuestion6.setContent(
                "\n" +
                        "\tpublic static void main(String[] args) {\n" +
                        "\t\tint x = 0;\n" +
                        "\t\tint y = 10;\n" +
                        "\t\tdo {\n" +
                        "\t\t\ty--;\n" +
                        "\t\t\t++x;\n" +
                        "\t\t} while (x < 5);\n" +
                        "\t\tSystem.out.print(x + \",\" + y);\n" +
                        "\t}\n");
        multiChoiceQuestion6.setPossibleAnswers(Arrays.asList(
                "A. 5,6",
                "B. 5,5",
                "C. 6,5",
                "D. 6,6"));
        multiChoiceQuestion6.setRightAnswer(1);
        multiChoiceQuestions.add(multiChoiceQuestion6);


        MultiChoiceQuestion multiChoiceQuestion7 = new MultiChoiceQuestion();
        multiChoiceQuestion7.setId(7);
        multiChoiceQuestion7.setQuestion("8.\tChọn câu trả lời đúng");
        multiChoiceQuestion7.setContent(
                "\tpublic class Target {\n" +
                        "\t\tpublic int i = 0;\n" +
                        "\t\tpublic int addOne() {\n" +
                        "\t\t \treturn i++;\n" +
                        "\t\t}\n" +
                        "\t}\n" +
                        "\tpublic static void main(String[] args) {\n" +
                        "\t\tTarget target = new Target();\n" +
                        "\t\tSystem.out.println(target.addOne()+\",\"+target.i);\n" +
                        "\t}\n");
        multiChoiceQuestion7.setPossibleAnswers(Arrays.asList(
                "A. 0,1",
                "B. 1,1",
                "C. 1,0",
                "D. 0,0"));
        multiChoiceQuestion7.setRightAnswer(0);
        multiChoiceQuestions.add(multiChoiceQuestion7);

        MultiChoiceQuestion multiChoiceQuestion8 = new MultiChoiceQuestion();
        multiChoiceQuestion8.setId(8);
        multiChoiceQuestion8.setQuestion("9.\tChọn câu trả lời đúng");
        multiChoiceQuestion8.setContent(
                "\n" +
                        "\tpublic class Drink implements Comparable{\n" +
                        "\t\tpublic String name;\n" +
                        "\t\t@Override\n" +
                        "\t\tpublic int compareTo(Object o) {\n" +
                        "\t\t\treturn 0;\n" +
                        "\t\t}\n" +
                        "\t}\n" +
                        "\n" +
                        "\tpublic static void main(String[] args) {\n" +
                        "\t\tDrink one = new Drink();\n" +
                        "\t\tDrink two = new Drink();\n" +
                        "\t\tone.name= \"Coffee\";\n" +
                        "\t\ttwo.name= \"Tea\";\n" +
                        "\t\tTreeSet<Drink> set = new TreeSet<Drink>();\n" +
                        "\t\tset.add(one);\n" +
                        "\t\tset.add(two);\n" +
                        "\t\tfor (Drink drink : set){\n" +
                        "\t\t\tSystem.out.print(drink.name);\n" +
                        "\t\t}\n" +
                        "\t}\n");
        multiChoiceQuestion8.setPossibleAnswers(Arrays.asList(
                "A. Tea",
                "B.  Coffee",
                "C. CoffeeTea",
                "D. TeaCoffee"));
        multiChoiceQuestion8.setRightAnswer(1);
        multiChoiceQuestions.add(multiChoiceQuestion8);

        MultiChoiceQuestion multiChoiceQuestion9 = new MultiChoiceQuestion();
        multiChoiceQuestion9.setId(9);
        multiChoiceQuestion9.setQuestion("10.\tChọn câu trả lời đúng");
        multiChoiceQuestion9.setContent(
                "\n" +
                        "\tpublic static void main(String[] args) {\n" +
                        "\t\tArrayList<String> strings = new ArrayList<String>(); \n" +
                        "\t\tstrings.add(\"aAaA\");\n" +
                        "\t\tstrings.add(\"AaA\");\n" +
                        "\t\tstrings.add(\"aAa\");\n" +
                        "\t\tstrings.add(\"AAaa\");\n" +
                        "\t\tCollections.sort(strings);\n" +
                        "\t\tfor (String s: strings) { \n" +
                        "\t\t\tSystem.out.print(s + \" \"); \n" +
                        "\t\t}\n" +
                        "\t}\n");
        multiChoiceQuestion9.setPossibleAnswers(Arrays.asList(
                "A. aAaA aAa AAaa AaA",
                "B. AAaa AaA aAa aAaA",
                "C. AaA AAaa aAaA aAa",
                "D. aAa AaA aAaA AAaa",
                "E. Khi chạy sẽ ném ra exception"));
        multiChoiceQuestion9.setRightAnswer(1);
        multiChoiceQuestions.add(multiChoiceQuestion9);

        return multiChoiceQuestions;
    }

    public static List<ConstructedQuestion> getConstructedQuestionAndroid()
    {
        List<ConstructedQuestion> constructedQuestions = new ArrayList<ConstructedQuestion>();

        ConstructedQuestion constructedQuestion0 = new ConstructedQuestion();

        constructedQuestion0.setId(11);
        constructedQuestion0.setQuestion(" 11.\tTên phiên bản Android  mới nhất hiện nay? ");
        constructedQuestions.add(constructedQuestion0);

        ConstructedQuestion constructedQuestion1 = new ConstructedQuestion();
        constructedQuestion1.setId(12);
        constructedQuestion1.setQuestion(" 12.\tSự giống nhau và khác nhau giữa Activity và Fragment ?");
        constructedQuestions.add(constructedQuestion1);

        ConstructedQuestion constructedQuestion2 = new ConstructedQuestion();
        constructedQuestion2.setId(13);
        constructedQuestion2.setQuestion(" 13.\tBạn hãy viết chương trình lấy dữ liệu từ Api sau (không dùng thư viện )");
        constructedQuestion2.setContent("URL:  http://example.com/api/top-product\n" +
                "JSON trả về:\n" +
                "\t{\n" +
                "  \t\t\"message\": \"success\",\n" +
                "  \t\t\"objects\": [\n" +
                "    \t\t\t{\n" +
                "      \t\t\t\"id\": 10,\n" +
                "      \t\t\t\"image\": \"http://example.com/images/s5.png\",\n" +
                "      \t\t\t\"name\": \"Samsung S5\",\n" +
                "    \t\t\t},\n" +
                "\t\t\t{\n" +
                "      \t\t\t\"id\": 11,\n" +
                "      \t\t\t\"image\": \"http://example.com/images/s4.png\",\n" +
                "      \t\t\t\"name\": \"Samsung S4\",\n" +
                "    \t\t\t}\n" +
                "  \t\t],\"status\": \"ok\",\"total\": 2}\n");
        constructedQuestions.add(constructedQuestion2);

        return constructedQuestions;
    }

}
