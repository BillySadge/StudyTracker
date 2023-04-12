package by.bsuir.studytracker.controllers.auth;

public class AuthenticationResponse {

    private String token;



    public AuthenticationResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public AuthenticationResponse() {
    }

    public String showErrorMessage(String message){
        return message;
    }

}
