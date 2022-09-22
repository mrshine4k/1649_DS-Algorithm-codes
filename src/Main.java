public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world !");

        Stack<Integer> myStack = new Stack<>();

        myStack.push(5);
        myStack.push(10);
        myStack.push(16);
        myStack.push(19);

        int x = myStack.pop();
        System.out.println(x);
    }
}