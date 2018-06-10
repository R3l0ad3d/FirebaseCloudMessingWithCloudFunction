package net.atshq.firebasecloudmessagewithcloudfunction;

public class ModelClass {
    private String message;
    private String time;

    public ModelClass() {
    }

    public ModelClass(String message, String time) {
        this.message = message;
        this.time = time;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
