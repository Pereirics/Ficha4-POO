package Main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

public class Stack {

    private ArrayList<String> stack;
    private int sp;

    // Construtor por omissão
    public Stack() {
        this.stack = new ArrayList<>();
        this.sp = 0;
    }

    // Construtor parametrizado
    public Stack(ArrayList<String> stack, int sp) {
        this.stack = stack;
        this.sp = sp;
    }

    // Construtor cópia
    public Stack(Stack s) {
        this.stack = s.getStack();
        this.sp = s.getSp();
    }

    public ArrayList<String> getStack() {
        return this.stack;
    }

    public int getSp() {
        return this.sp;
    }

    public void setStack(ArrayList<String> stack) {
        this.stack = stack;
    }

    public void setSp(int sp) {
        this.sp = sp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || (o.getClass() != this.getClass())) return false;
        Stack s = (Stack) o;
        return this.sp == s.getSp() &&
               this.stack.equals(s.stack);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.stack, this.sp);
    }

    @Override
    public String toString() {
        return "Stack{" +
                "stack=" + stack +
                ", sp=" + sp +
                '}';
    }

    public String top() {
        String r;
        if (sp > 0) {
            r = this.stack.get(sp - 1);
        }
        else r = "";
        return r;
    }

    public void push(String s) {
        this.stack.set(this.sp++, s);
    }

    public void pop() {
        if (this.sp > 0) {
            sp--;
        }
    }

    public boolean empty() {
        return this.sp == 0;
    }

    public int length() {
        return this.sp;
    }
}
