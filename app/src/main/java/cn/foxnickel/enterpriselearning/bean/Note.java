package cn.foxnickel.enterpriselearning.bean;

/**
 * Created by Night on 2017/7/23.
 * Desc:Note bean
 */

public class Note {

    private int mCourseId;
    private String mSourse;
    private String mContent;

    public String getTime() {
        return mTime;
    }

    public void setTime(String time) {
        mTime = time;
    }

    private String mTime;

    public Note(String sourse, String content, String time) {
        mSourse = sourse;
        mContent = content;
        mTime = time;
    }

    public String getSourse() {
        return mSourse;
    }

    public void setSourse(String sourse) {
        mSourse = sourse;
    }

    public String getContent() {
        return mContent;
    }

    public void setContent(String content) {
        mContent = content;
    }
}
