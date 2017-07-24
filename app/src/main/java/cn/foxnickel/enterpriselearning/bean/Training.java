package cn.foxnickel.enterpriselearning.bean;

/**
 * Created by Night on 2017/7/23.
 * Desc:
 */

public class Training {

    private String mTrainingName;
    private String mIntro;
    private int mNum;
    private String mPlace;
    private String mStartTime;
    private String mDuration;

    public Training(String trainingName, String intro, int num, String place, String startTime, String duration) {
        mTrainingName = trainingName;
        mIntro = intro;
        mNum = num;
        mPlace = place;
        mStartTime = startTime;
        mDuration = duration;
    }

    public String getTrainingName() {
        return mTrainingName;
    }

    public void setTrainingName(String trainingName) {
        mTrainingName = trainingName;
    }

    public String getIntro() {
        return mIntro;
    }

    public void setIntro(String intro) {
        mIntro = intro;
    }

    public int getNum() {
        return mNum;
    }

    public void setNum(int num) {
        mNum = num;
    }

    public String getPlace() {
        return mPlace;
    }

    public void setPlace(String place) {
        mPlace = place;
    }

    public String getStartTime() {
        return mStartTime;
    }

    public void setStartTime(String startTime) {
        mStartTime = startTime;
    }

    public String getDuration() {
        return mDuration;
    }

    public void setDuration(String duration) {
        mDuration = duration;
    }
}
