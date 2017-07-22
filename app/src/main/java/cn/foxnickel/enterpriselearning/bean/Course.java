package cn.foxnickel.enterpriselearning.bean;

import android.support.annotation.NonNull;

/**
 * Created by Night on 2017/7/22.
 * Desc:
 */

public class Course implements Comparable<Course> {
    private String mCourseName;
    private String mCoursePic;
    private float mCourseStars;
    private int lastLearningTime;

    public Course(String courseName, String coursePic, float courseStars) {
        mCourseName = courseName;
        mCoursePic = coursePic;
        mCourseStars = courseStars;
    }

    public String getCourseName() {
        return mCourseName;
    }

    public void setCourseName(String courseName) {
        mCourseName = courseName;
    }

    public String getCoursePic() {
        return mCoursePic;
    }

    public void setCoursePic(String coursePic) {
        mCoursePic = coursePic;
    }

    public float getCourseStars() {
        return mCourseStars;
    }

    public void setCourseStars(float courseStars) {
        mCourseStars = courseStars;
    }

    public int getLastLearningTime() {
        return lastLearningTime;
    }

    public void setLastLearningTime(int lastLearningTime) {
        this.lastLearningTime = lastLearningTime;
    }

    @Override
    public int compareTo(@NonNull Course o) {
        float i = getCourseStars() - o.getCourseStars();
        return (int) i;
    }
}
