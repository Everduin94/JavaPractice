package controller;

import model.Message;

import java.util.*;

/**
 * This is a sort of simulated message server
 *
 * Created by everduin on 12/22/2016.
 */
public class MessageServer implements Iterable<Message>{
    /*List of messages we imagine are on server
    in reality they're just stored here only.*/

    private Map<Integer, List<Message>> messages;
    private List<Message> selected;

    public MessageServer() {
        selected = new ArrayList<>();
        /*Tree Map to keey ID organized*/
        messages = new TreeMap<Integer, List<Message>>();

        List<Message> list = new ArrayList<>();

        list.add(new Message("Super Test One", "This is the ultimate test"));
        list.add(new Message("Super Test Two", "This is the second best test"));

        /*int 0 is probably New York?*/
        messages.put(4, list);

        list = new ArrayList<>();

        list.add(new Message("I don't know what to put", "Help I have no creativity"));
        list.add(new Message("Admin Message", "This text doesn't really matter"));
        messages.put(3, list);
    }

    public void setSelectedServers(Set<Integer> servers){

        selected.clear();
        for(int id : servers) {
            if(messages.containsKey(id)){
                List<Message> serverMessages = messages.get(id);
                selected.addAll(messages.get(id));
            }
        }
    }

    public int getMessageCount(){
        return selected.size();
    }

    /*54 Allow MessageServer to be used in for loop*/
    @Override
    public Iterator<Message> iterator() {

        /*Wrap selected list of messages*/
        return new MessageIterator(selected);
    }
}

/*(55) Adding SwingWorker*/
class MessageIterator implements Iterator {

    private Iterator<Message> iterator;

    public MessageIterator(List<Message> messages) {
        iterator = messages.iterator();
    }

    /*Wrapping the Iterator
    * in the list of Messages*/
    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public Message next() {

        try {
            /*Simulate slower message retrieval*/
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return iterator.next();
    }

    @Override
    public void remove() {
        iterator.remove();
    }
}
