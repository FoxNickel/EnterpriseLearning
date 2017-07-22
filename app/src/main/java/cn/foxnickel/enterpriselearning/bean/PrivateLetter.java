package cn.foxnickel.enterpriselearning.bean;

/**
 * Created by Night on 2017/7/22.
 * Desc:
 */

public class PrivateLetter {
    private String mUserName;
    private String mPrivateLetterContent;
    private String mReleaseTime;

    public PrivateLetter(String userName, String privateLetterContent, String releaseTime) {
        mUserName = userName;
        mPrivateLetterContent = privateLetterContent;
        mReleaseTime = releaseTime;
    }

    public String getUserName() {
        return mUserName;
    }

    public void setUserName(String userName) {
        mUserName = userName;
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
