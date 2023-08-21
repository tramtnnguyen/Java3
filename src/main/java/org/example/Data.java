package org.example;



public class Data {
    private String id;
    private String type;
    private String name;
    private String question;

    public Data(String id, String type, String name,String question) {
        this.name = name;
        this.type = type;
        this.id = id;
        this.question = question;
    }

    public String getX() {
        return id;
    }

    public void setX(String x) {
        this.id = x;
    }


    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
