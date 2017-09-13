package cn.foxnickel.enterpriselearning.bean;

/**
 * Created by Night on 2017/9/4.
 * Desc:
 */

public class LoginRequest {
    private int status;
    private String description;

    public LoginRequest(int status, String description) {
        this.status = status;
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
