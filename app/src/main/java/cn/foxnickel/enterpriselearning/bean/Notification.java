package cn.foxnickel.enterpriselearning.bean;

/**
 * Created by Night on 2017/7/22.
 * Desc:
 */

public class Notification {
    private String mPrivateLetterContent;
    private String mReleaseTime;

    public Notification(String privateLetterContent, String releaseTime) {
        mPrivateLetterContent = privateLetterContent;
        mReleaseTime = releaseTime;
    }


    public String getPrivateLetterContent() {
        return mPrivateLetterContent;
    }

    public void setPrivateLetterContent(String privateLetterContent) {
        mPrivateLetterContent = privateLetterContent;
    }

    public String getReleaseTime() {
        return mReleaseTime;
    }

    public void setReleaseTime(String releaseTime) {
        mReleaseTime = releaseTime;
    }
}
