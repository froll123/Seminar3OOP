package Seminar3OOP;

public class Record {

    Object data;
    private Record next;
    private Record previous;

    public Record(Object data) {
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Record getNext() {
        return next;
    }

    void setNext(Record element){
        next = element;
    }

    void setPrevious(Record element){
        previous = element;
    }

    public Record getPrevious() {
        return previous;
    }
}
