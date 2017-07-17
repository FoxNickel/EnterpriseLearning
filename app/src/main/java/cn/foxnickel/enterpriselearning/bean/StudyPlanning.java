package cn.foxnickel.enterpriselearning.bean;

import java.util.List;

/**
 * Created by Night on 2017/7/17.
 * Desc:
 */

public class StudyPlanning {
    private String mPlanName;
    private List<String> mPlanningStage;
    private boolean isBeginning;

    public StudyPlanning(String planName, List<String> planningStage, boolean isBeginning) {
        mPlanName = planName;
        mPlanningStage = planningStage;
        this.isBeginning = isBeginning;
    }

    public String getPlanName() {
        return mPlanName;
    }

    public void setPlanName(String planName) {
        mPlanName = planName;
    }

    public List<String> getPlanningStage() {
        return mPlanningStage;
    }

    public void setPlanningStage(List<String> planningStage) {
        mPlanningStage = planningStage;
    }

    public boolean isBeginning() {
        return isBeginning;
    }

    public void setBeginning(boolean beginning) {
        isBeginning = beginning;
    }
}
