package cn.foxnickel.enterpriselearning.bean;

/**
 * Created by Night on 2017/7/18.
 * Desc:
 */

public class Issue {
    //试题题目
    private String question;
    //试题类别 0--单选  1--多选
    private int type;
    //试题A选项内容
    private String answerA;
    //试题B选项内容
    private String answerB;
    //试题C选项内容
    private String answerC;
    //试题D选项内容
    private String answerD;
    //题目正确答案
    private String right;
    //记录点击的单选选项，默认不选
    private int selectedId = -1;
    //记录点击的多选选项，默认全不选
    private int[] selectedIds = {-1, -1, -1, -1};

    public boolean isRight() {
        return isRight;
    }

    public void setRight(boolean right) {
        isRight = right;
    }

    //记录该题是否答对，默认错误
    private boolean isRight = false;

    public String getAnalysis() {
        return analysis;
    }

    public void setAnalysis(String analysis) {
        this.analysis = analysis;
    }

    private String analysis;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getAnswerA() {
        return answerA;
    }

    public void setAnswerA(String answerA) {
        this.answerA = answerA;
    }

    public String getAnswerB() {
        return answerB;
    }

    public void setAnswerB(String answerB) {
        this.answerB = answerB;
    }

    public String getAnswerC() {
        return answerC;
    }

    public void setAnswerC(String answerC) {
        this.answerC = answerC;
    }

    public String getAnswerD() {
        return answerD;
    }

    public void setAnswerD(String answerD) {
        this.answerD = answerD;
    }

    public String getRight() {
        return right;
    }

    public void setRight(String right) {
        this.right = right;
    }

    public int getSelectedId() {
        return selectedId;
    }

    public void setSelectedId(int selectedId) {
        this.selectedId = selectedId;
    }

    public int[] getSelectedIds() {
        return selectedIds;
    }

    public void setSelectedIds(int[] selectedIds) {
        this.selectedIds = selectedIds;
    }

}
