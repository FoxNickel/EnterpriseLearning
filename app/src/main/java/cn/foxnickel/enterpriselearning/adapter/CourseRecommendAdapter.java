package cn.foxnickel.enterpriselearning.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cn.foxnickel.enterpriselearning.R;
import cn.foxnickel.enterpriselearning.SpecificCouseActivity;
import cn.foxnickel.enterpriselearning.bean.Chapter;
import cn.foxnickel.enterpriselearning.bean.Course;
import cn.foxnickel.enterpriselearning.bean.CourseRecommend;
import cn.foxnickel.enterpriselearning.bean.Note;
import cn.foxnickel.enterpriselearning.utils.Resources;

/**
 * Created by NickelFox on 2017/7/2.
 */

public class CourseRecommendAdapter extends RecyclerView.Adapter<CourseRecommendAdapter.ViewHolder> {
    private List<CourseRecommend> mList;
    private Context mContext;

    private List<Integer> mIntegers;

    public CourseRecommendAdapter(Context context, List<CourseRecommend> list) {
        mContext = context;
        mList = list;
        mIntegers = new ArrayList<>();

    }

    int mCourseRecommendPic[] = {R.drawable.course_recommend_pic4, R.drawable.course_recommend_pic2,
            R.drawable.course_recommend_pic3, R.drawable.course_recommend_pic1};

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.recycler_item_course_recommend, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        int d = (int) (Math.random() * mCourseRecommendPic.length);
        if (mIntegers.size() > 0) {
            while (mIntegers.contains(d)) {
                d = (int) (Math.random() * mCourseRecommendPic.length);
            }
        }
        mIntegers.add(d);
        holder.mLinearLayout.setBackgroundResource(mCourseRecommendPic[d]);
        final CourseRecommend courseRecommend = mList.get(position);
        holder.mCourseName.setText(courseRecommend.getCourseName());
        holder.mChapterTitle.setText(courseRecommend.getChapterTitle());
        holder.mChapterDescription.setText(courseRecommend.getChapterDescription());
        holder.mLearningNumber.setText(courseRecommend.getLearningNumber());
        List<Chapter> chapters = new ArrayList<>();
        List<Note> notes = new ArrayList<>();
        Course mCourse;
        switch (courseRecommend.getChapterTitle()) {
            case "Web UI设计理论入门":
                chapters.add(new Chapter("第1章 webUI课程简介", true, null, ""));
                chapters.add(new Chapter("1-1课程介绍", false, Resources.VIDEO, "http://112.17.2.183/video.study.163.com/edu-video/nos/mp4/2017/04/27/1006157378_79df7d044dc644c0b0abdacc51f3f7dc_shd.mp4?ak=99ed7479ee303d1b1361b0ee5a4abcee4e96dd59549ea432cc13c8ad7b52a9e476d57ed0438f9d1ecf50b33bb61d8c7b8760bbae5996a1ed191108c718bc022fc5c2392413a096f94c1b700ffc15fb5490b601143824cf18b58a69ea00438816e2c4caba0e116581c14e4824cb46dc107feb6d0bf73a0d052df948b3525aefb09eed6bb2ffe8530b0f8655d97b53dc6197cbdc8f6a5d1563323094d2340ba3cf2919f5e4aded4ea11a82dd96c04efc1a&wshc_tag=0&wsts_tag=59b7bd9f&wsid_tag=700ab4b2&wsiphost=ipdbm"));
                chapters.add(new Chapter("第2章 从设计角度初识web页面", true, null, ""));
                chapters.add(new Chapter("2-1 webUI是什么", false, Resources.VIDEO, "http://112.17.2.183/video.study.163.com/edu-video/nos/mp4/2017/04/27/1006157378_79df7d044dc644c0b0abdacc51f3f7dc_shd.mp4?ak=99ed7479ee303d1b1361b0ee5a4abcee4e96dd59549ea432cc13c8ad7b52a9e476d57ed0438f9d1ecf50b33bb61d8c7b8760bbae5996a1ed191108c718bc022fc5c2392413a096f94c1b700ffc15fb5490b601143824cf18b58a69ea00438816e2c4caba0e116581c14e4824cb46dc107feb6d0bf73a0d052df948b3525aefb09eed6bb2ffe8530b0f8655d97b53dc6197cbdc8f6a5d1563323094d2340ba3cf2919f5e4aded4ea11a82dd96c04efc1a&wshc_tag=0&wsts_tag=59b7bd9f&wsid_tag=700ab4b2&wsiphost=ipdbm"));
                chapters.add(new Chapter("2-2 关于分辨率", false, Resources.VIDEO, "http://112.17.2.183/video.study.163.com/edu-video/nos/mp4/2017/04/27/1006157378_79df7d044dc644c0b0abdacc51f3f7dc_shd.mp4?ak=99ed7479ee303d1b1361b0ee5a4abcee4e96dd59549ea432cc13c8ad7b52a9e476d57ed0438f9d1ecf50b33bb61d8c7b8760bbae5996a1ed191108c718bc022fc5c2392413a096f94c1b700ffc15fb5490b601143824cf18b58a69ea00438816e2c4caba0e116581c14e4824cb46dc107feb6d0bf73a0d052df948b3525aefb09eed6bb2ffe8530b0f8655d97b53dc6197cbdc8f6a5d1563323094d2340ba3cf2919f5e4aded4ea11a82dd96c04efc1a&wshc_tag=0&wsts_tag=59b7bd9f&wsid_tag=700ab4b2&wsiphost=ipdbm"));
                chapters.add(new Chapter("2-3 web的基本分类", false, Resources.VIDEO, "http://112.17.2.183/video.study.163.com/edu-video/nos/mp4/2017/04/27/1006157378_79df7d044dc644c0b0abdacc51f3f7dc_shd.mp4?ak=99ed7479ee303d1b1361b0ee5a4abcee4e96dd59549ea432cc13c8ad7b52a9e476d57ed0438f9d1ecf50b33bb61d8c7b8760bbae5996a1ed191108c718bc022fc5c2392413a096f94c1b700ffc15fb5490b601143824cf18b58a69ea00438816e2c4caba0e116581c14e4824cb46dc107feb6d0bf73a0d052df948b3525aefb09eed6bb2ffe8530b0f8655d97b53dc6197cbdc8f6a5d1563323094d2340ba3cf2919f5e4aded4ea11a82dd96c04efc1a&wshc_tag=0&wsts_tag=59b7bd9f&wsid_tag=700ab4b2&wsiphost=ipdbm"));
                chapters.add(new Chapter("2-4 网页是如何实现的", false, Resources.VIDEO, "http://112.17.2.183/video.study.163.com/edu-video/nos/mp4/2017/04/27/1006157378_79df7d044dc644c0b0abdacc51f3f7dc_shd.mp4?ak=99ed7479ee303d1b1361b0ee5a4abcee4e96dd59549ea432cc13c8ad7b52a9e476d57ed0438f9d1ecf50b33bb61d8c7b8760bbae5996a1ed191108c718bc022fc5c2392413a096f94c1b700ffc15fb5490b601143824cf18b58a69ea00438816e2c4caba0e116581c14e4824cb46dc107feb6d0bf73a0d052df948b3525aefb09eed6bb2ffe8530b0f8655d97b53dc6197cbdc8f6a5d1563323094d2340ba3cf2919f5e4aded4ea11a82dd96c04efc1a&wshc_tag=0&wsts_tag=59b7bd9f&wsid_tag=700ab4b2&wsiphost=ipdbm"));
                notes.add(new Note("源自:web UI设计理论入门-网页是如何实现的", "web 标准化布局原理\n" +
                        "把网页看成多个网格\n" +
                        "先有行再有列（从上到下）\n" +
                        "先做容器再做内容（从外到内）", "2017-07-10"));
                notes.add(new Note("源自:web UI设计理论入门-关于分辨率", "分辨率：水平和垂直像素个数", "2017-07-09"));
                notes.add(new Note("源自:web UI设计理论入门-webUI是什么", "UI的3个方向：\n" +
                        "1.用户研究\n" +
                        "2.交互设计\n" +
                        "3.界面设计", "2017-07-08"));
                notes.add(new Note("源自:web UI设计理论入门-课程介绍", "ie9+、chrome、flex及主流浏览器都可兼容css3", "2017-07-07"));
                notes.add(new Note("源自:web UI设计理论入门-课程介绍", "ps里面有切片工具可以用来切图", "2017-07-07"));

                mCourse = new Course(courseRecommend.getChapterTitle(), chapters, 2, "网页在我们生活中已经占据了重要地位,相对于移动端，web的优点是信息展示更具多样性。我们在课程中为大家详细的剖析web的特征属性、构成、设计逻辑等，为webUI设计提供扎实的理论基础。"
                        , "本课程是webUI的入门课程,以理论与赏析为主，\n没有门槛", "1、教你如何从设计的角度去了解web\n"
                        + "2、明白设计思路，我们更多的使用脑而不是用软件去做设计\n"
                        + "3、设计流程和设计规范的重要性\n"
                        + "4、学会分析页面，逆向解析作品", notes);
                break;
            case "Java基础-反射":
                //TODO:待完善数据
                chapters.add(new Chapter("第1章 反射基础", true, null, ""));
                chapters.add(new Chapter("1-1 引出反射,什么是反射？？", false, Resources.VIDEO, "http://117.148.163.114/video.study.163.com/edu-video/nos/mp4/2017/08/17/1006760456_5343c7dd96524fbfb2e699090eac3e2d_shd.mp4?ak=1e378d453e2e06e0ac50e7e24a30f34505729cd6ab1166e18866d3a26abfebf24bfe8a77fc26d39e471603b6d22ca7061ee2fb6240fc719e1b3940ed872a11f1f6650dd25ebdf2cae559daa4436eac17f455d97e99102a49b825836de913910ef0837682774232610f0d4e39d8436cb9a153bdeea4a2bfbae357803dfb6768a742fe395e87eba0c3e30b7b64ef1be06585111bf60ea26d5dad1f891edd9e94a8e167e0b04144490499ffe31e0d97a0a1babcbd7d2e007d850cc3bf7aa697e8ff&wshc_tag=0&wsts_tag=59b3e06f&wsid_tag=700ab5b4&wsiphost=ipdbm"));
                chapters.add(new Chapter("1-2 Class类和Class实例.", false, Resources.VIDEO, "http://117.148.163.114/video.study.163.com/edu-video/nos/flv/2017/08/17/1006758424_792c97d73e134fe48a71022f81f95dc7_sd.flv?ak=99ed7479ee303d1b1361b0ee5a4abcee5a412075db75eb7c7c541053f823cfacf55ba5874ada333a389cd1e2b28917ed8c964a6e50dcfdf8e6781c1f155993f3c5c2392413a096f94c1b700ffc15fb5490b601143824cf18b58a69ea00438816e2c4caba0e116581c14e4824cb46dc107feb6d0bf73a0d052df948b3525aefb09eed6bb2ffe8530b0f8655d97b53dc6197cbdc8f6a5d1563323094d2340ba3cf2919f5e4aded4ea11a82dd96c04efc1a&wshc_tag=0&wsts_tag=59b3e174&wsid_tag=700ab5b4&wsiphost=ipdbm"));
                chapters.add(new Chapter("1-3 Java中9大内置Class实例和数组的Class实例", false, Resources.VIDEO, "http://117.148.163.114/video.study.163.com/edu-video/nos/flv/2017/08/17/1006758424_792c97d73e134fe48a71022f81f95dc7_sd.flv?ak=99ed7479ee303d1b1361b0ee5a4abcee5a412075db75eb7c7c541053f823cfacf55ba5874ada333a389cd1e2b28917ed8c964a6e50dcfdf8e6781c1f155993f3c5c2392413a096f94c1b700ffc15fb5490b601143824cf18b58a69ea00438816e2c4caba0e116581c14e4824cb46dc107feb6d0bf73a0d052df948b3525aefb09eed6bb2ffe8530b0f8655d97b53dc6197cbdc8f6a5d1563323094d2340ba3cf2919f5e4aded4ea11a82dd96c04efc1a&wshc_tag=0&wsts_tag=59b3e174&wsid_tag=700ab5b4&wsiphost=ipdbm"));
                chapters.add(new Chapter("1-4 获取构造器", false, Resources.VIDEO, "http://117.148.163.114/video.study.163.com/edu-video/nos/flv/2017/08/17/1006758424_792c97d73e134fe48a71022f81f95dc7_sd.flv?ak=99ed7479ee303d1b1361b0ee5a4abcee5a412075db75eb7c7c541053f823cfacf55ba5874ada333a389cd1e2b28917ed8c964a6e50dcfdf8e6781c1f155993f3c5c2392413a096f94c1b700ffc15fb5490b601143824cf18b58a69ea00438816e2c4caba0e116581c14e4824cb46dc107feb6d0bf73a0d052df948b3525aefb09eed6bb2ffe8530b0f8655d97b53dc6197cbdc8f6a5d1563323094d2340ba3cf2919f5e4aded4ea11a82dd96c04efc1a&wshc_tag=0&wsts_tag=59b3e174&wsid_tag=700ab5b4&wsiphost=ipdbm"));
                chapters.add(new Chapter("第2章 反射基础补充", true, null, ""));
                chapters.add(new Chapter("2-1 如何获取泛型参数信息", false, Resources.VIDEO, "http://117.148.163.115/video.study.163.com/edu-video/nos/flv/2017/08/17/1006759450_bb33b98eb9ed4c658d6df9cc0928041e_sd.flv?ak=99ed7479ee303d1b1361b0ee5a4abcee38d62449e6a0d850b6ade99475fff674f0e9daece616d25101e89343a1ba4cea8865dd125f960860510ff27240aaac51c5c2392413a096f94c1b700ffc15fb5490b601143824cf18b58a69ea00438816e2c4caba0e116581c14e4824cb46dc107feb6d0bf73a0d052df948b3525aefb09eed6bb2ffe8530b0f8655d97b53dc6197cbdc8f6a5d1563323094d2340ba3cf2919f5e4aded4ea11a82dd96c04efc1a&wshc_tag=0&wsts_tag=59b3e1d8&wsid_tag=700ab5b4&wsiphost=ipdbm"));
                chapters.add(new Chapter("2-2 使用反射实现对象工厂", false, Resources.VIDEO, "http://117.148.163.115/video.study.163.com/edu-video/nos/flv/2017/08/17/1006759450_bb33b98eb9ed4c658d6df9cc0928041e_sd.flv?ak=99ed7479ee303d1b1361b0ee5a4abcee38d62449e6a0d850b6ade99475fff674f0e9daece616d25101e89343a1ba4cea8865dd125f960860510ff27240aaac51c5c2392413a096f94c1b700ffc15fb5490b601143824cf18b58a69ea00438816e2c4caba0e116581c14e4824cb46dc107feb6d0bf73a0d052df948b3525aefb09eed6bb2ffe8530b0f8655d97b53dc6197cbdc8f6a5d1563323094d2340ba3cf2919f5e4aded4ea11a82dd96c04efc1a&wshc_tag=0&wsts_tag=59b3e1d8&wsid_tag=700ab5b4&wsiphost=ipdbm"));
                chapters.add(new Chapter("2-3 工具类的编写方式", false, Resources.VIDEO, "http://117.148.163.115/video.study.163.com/edu-video/nos/flv/2017/08/17/1006759450_bb33b98eb9ed4c658d6df9cc0928041e_sd.flv?ak=99ed7479ee303d1b1361b0ee5a4abcee38d62449e6a0d850b6ade99475fff674f0e9daece616d25101e89343a1ba4cea8865dd125f960860510ff27240aaac51c5c2392413a096f94c1b700ffc15fb5490b601143824cf18b58a69ea00438816e2c4caba0e116581c14e4824cb46dc107feb6d0bf73a0d052df948b3525aefb09eed6bb2ffe8530b0f8655d97b53dc6197cbdc8f6a5d1563323094d2340ba3cf2919f5e4aded4ea11a82dd96c04efc1a&wshc_tag=0&wsts_tag=59b3e1d8&wsid_tag=700ab5b4&wsiphost=ipdbm"));
                notes.add(new Note("源自:Java基础-反射-网页是如何实现的", "反射： 得到元数据的行为", "2017-07-10"));
                notes.add(new Note("源自:Java基础-反射-网页是如何实现的", "调用构造器 主要是用来创建对象的。\n" +
                        "需求:调用一个构造器，创建其构造器的对象。\n" +
                        "传统方法：Emp e = new Emp();\n" +
                        "\n" +
                        "使用反射来调用的话：\n" +
                        "1，先找到被调用构造器所在的类的字节码\n" +
                        "2，找到被调用的制定构造器\n" +
                        "3，执行该构造器", "2017-07-10"));
                mCourse = new Course(courseRecommend.getChapterTitle(), chapters, 2, "Java中，反射是一种强大的工具。它使您能够创建灵活的代码，这些代码可以在运行时装配，无需在组件之间进行源代表链接。反射允许我们在编写与执行时，使我们的程序代码能够接入装载到JVM中的类的内部信息，而不是源代码中选定的类协作的代码。这使反射成为构建灵活的应用的主要工具。但需注意的是：如果使用不当，反射的成本很高。"
                        , "本课程是初学JAVA者，爱好软件开发者的入门\n课程"
                        , "1、能够理解并应用反射机制。 \n" +
                        "2、能够了解反射机制在集合泛型中的应用。 \n" +
                        "3、有利于更好的学习框架等Java高级技术。", notes);

                break;
            case "Android自动化测试":
                //TODO:待完善数据
                chapters.add(new Chapter("第1章 自动化基础篇", true, null, ""));
                chapters.add(new Chapter("1-1 自动化预备知识（上）", false, Resources.VIDEO, "http://120.221.64.130/video.study.163.com/edu-video/nos/mp4/2014/07/12/507153_sd.mp4?ak=99ed7479ee303d1b1361b0ee5a4abcee97c0cef09cb96fd615c0ac81c0f778663cc7cec1931216ab165d9b2137031d1920d04103874421dce5cd7bbabbfc3c2284a1c46e13dea4037cf2150b0ef7e0e2493d3b07147c2ace70d66e57880ba1a7237b1f1b474d469b8af3e6ce54f580b31651daa307f794c4c0f7b7fe70a9ca043606e7af4345d9a11bc4fc0505d12bf6976386d60da86b917348b1a6565e9523e13094dfa9acdeeffa795d972f220604&wshc_tag=0&wsts_tag=59b6b27e&wsid_tag=700ab4b2&wsiphost=ipdbm"));
                chapters.add(new Chapter("1-2 自动化预备知识（下）", false, Resources.VIDEO, "http://120.221.64.130/video.study.163.com/edu-video/nos/mp4/2014/07/12/507153_sd.mp4?ak=99ed7479ee303d1b1361b0ee5a4abcee97c0cef09cb96fd615c0ac81c0f778663cc7cec1931216ab165d9b2137031d1920d04103874421dce5cd7bbabbfc3c2284a1c46e13dea4037cf2150b0ef7e0e2493d3b07147c2ace70d66e57880ba1a7237b1f1b474d469b8af3e6ce54f580b31651daa307f794c4c0f7b7fe70a9ca043606e7af4345d9a11bc4fc0505d12bf6976386d60da86b917348b1a6565e9523e13094dfa9acdeeffa795d972f220604&wshc_tag=0&wsts_tag=59b6b27e&wsid_tag=700ab4b2&wsiphost=ipdbm"));
                chapters.add(new Chapter("1-3 电池续航自动化测试(上) ", false, Resources.VIDEO, "http://120.221.64.130/video.study.163.com/edu-video/nos/mp4/2014/07/12/507153_sd.mp4?ak=99ed7479ee303d1b1361b0ee5a4abcee97c0cef09cb96fd615c0ac81c0f778663cc7cec1931216ab165d9b2137031d1920d04103874421dce5cd7bbabbfc3c2284a1c46e13dea4037cf2150b0ef7e0e2493d3b07147c2ace70d66e57880ba1a7237b1f1b474d469b8af3e6ce54f580b31651daa307f794c4c0f7b7fe70a9ca043606e7af4345d9a11bc4fc0505d12bf6976386d60da86b917348b1a6565e9523e13094dfa9acdeeffa795d972f220604&wshc_tag=0&wsts_tag=59b6b27e&wsid_tag=700ab4b2&wsiphost=ipdbm"));
                chapters.add(new Chapter("1-4 电池续航自动化测试(下) ", false, Resources.VIDEO, "http://120.221.64.130/video.study.163.com/edu-video/nos/mp4/2014/07/12/507153_sd.mp4?ak=99ed7479ee303d1b1361b0ee5a4abcee97c0cef09cb96fd615c0ac81c0f778663cc7cec1931216ab165d9b2137031d1920d04103874421dce5cd7bbabbfc3c2284a1c46e13dea4037cf2150b0ef7e0e2493d3b07147c2ace70d66e57880ba1a7237b1f1b474d469b8af3e6ce54f580b31651daa307f794c4c0f7b7fe70a9ca043606e7af4345d9a11bc4fc0505d12bf6976386d60da86b917348b1a6565e9523e13094dfa9acdeeffa795d972f220604&wshc_tag=0&wsts_tag=59b6b27e&wsid_tag=700ab4b2&wsiphost=ipdbm"));
                chapters.add(new Chapter("1-5 MonkeyRunner原理初步 ", false, Resources.VIDEO, "http://120.221.64.130/video.study.163.com/edu-video/nos/mp4/2014/07/12/507153_sd.mp4?ak=99ed7479ee303d1b1361b0ee5a4abcee97c0cef09cb96fd615c0ac81c0f778663cc7cec1931216ab165d9b2137031d1920d04103874421dce5cd7bbabbfc3c2284a1c46e13dea4037cf2150b0ef7e0e2493d3b07147c2ace70d66e57880ba1a7237b1f1b474d469b8af3e6ce54f580b31651daa307f794c4c0f7b7fe70a9ca043606e7af4345d9a11bc4fc0505d12bf6976386d60da86b917348b1a6565e9523e13094dfa9acdeeffa795d972f220604&wshc_tag=0&wsts_tag=59b6b27e&wsid_tag=700ab4b2&wsiphost=ipdbm"));
                chapters.add(new Chapter("第2章 自动化提高篇", true, null, ""));
                chapters.add(new Chapter("2-1 instrumentation框架（上）", false, Resources.VIDEO, "http://120.221.64.130/video.study.163.com/edu-video/nos/mp4/2014/07/12/507153_sd.mp4?ak=99ed7479ee303d1b1361b0ee5a4abcee97c0cef09cb96fd615c0ac81c0f778663cc7cec1931216ab165d9b2137031d1920d04103874421dce5cd7bbabbfc3c2284a1c46e13dea4037cf2150b0ef7e0e2493d3b07147c2ace70d66e57880ba1a7237b1f1b474d469b8af3e6ce54f580b31651daa307f794c4c0f7b7fe70a9ca043606e7af4345d9a11bc4fc0505d12bf6976386d60da86b917348b1a6565e9523e13094dfa9acdeeffa795d972f220604&wshc_tag=0&wsts_tag=59b6b27e&wsid_tag=700ab4b2&wsiphost=ipdbm"));
                chapters.add(new Chapter("2-2 instrumentation框架（下）", false, Resources.VIDEO, "http://120.221.64.130/video.study.163.com/edu-video/nos/mp4/2014/07/12/507153_sd.mp4?ak=99ed7479ee303d1b1361b0ee5a4abcee97c0cef09cb96fd615c0ac81c0f778663cc7cec1931216ab165d9b2137031d1920d04103874421dce5cd7bbabbfc3c2284a1c46e13dea4037cf2150b0ef7e0e2493d3b07147c2ace70d66e57880ba1a7237b1f1b474d469b8af3e6ce54f580b31651daa307f794c4c0f7b7fe70a9ca043606e7af4345d9a11bc4fc0505d12bf6976386d60da86b917348b1a6565e9523e13094dfa9acdeeffa795d972f220604&wshc_tag=0&wsts_tag=59b6b27e&wsid_tag=700ab4b2&wsiphost=ipdbm"));
                chapters.add(new Chapter("2-3 截图原理深入分析（上）", false, Resources.VIDEO, "http://120.221.64.130/video.study.163.com/edu-video/nos/mp4/2014/07/12/507153_sd.mp4?ak=99ed7479ee303d1b1361b0ee5a4abcee97c0cef09cb96fd615c0ac81c0f778663cc7cec1931216ab165d9b2137031d1920d04103874421dce5cd7bbabbfc3c2284a1c46e13dea4037cf2150b0ef7e0e2493d3b07147c2ace70d66e57880ba1a7237b1f1b474d469b8af3e6ce54f580b31651daa307f794c4c0f7b7fe70a9ca043606e7af4345d9a11bc4fc0505d12bf6976386d60da86b917348b1a6565e9523e13094dfa9acdeeffa795d972f220604&wshc_tag=0&wsts_tag=59b6b27e&wsid_tag=700ab4b2&wsiphost=ipdbm"));
                chapters.add(new Chapter("2-4 截图原理深入分析（下）", false, Resources.VIDEO, ""));
                notes.add(new Note("源自:Android自动化测试-自动化预备知识（上）",
                        "Robotium基于控件的自动化框架，遇到不支持的控件使用点击坐标点方法", "2017-07-10"));
                notes.add(new Note("源自:Android自动化测试-自动化预备知识（上）", "1、如何测试分布式ATM机？\n" +
                        "2、如何用数组实现三个堆站，要求有效的使用数据的存储空间，可以使用其他的数据结构\n" +
                        "3、编写一个脚本，统计log文件中首歌单词出现的次数，如error:xxx", "2017-07-09"));

                mCourse = new Course(courseRecommend.getChapterTitle(), chapters, 2, "自动化测试永远是软件测试的热点，企业总希望通过测试自动化大幅降低测试工作的成本。到底如何实施自动化测试?自动化测试框架如何使用?这些既是热点问题，也是难点!"
                        , "本课程是Android自动化测试的系统课程"
                        , "1、教你掌握自动化测试技术、工具和框架\n"
                        + "2、明白掌握自动化测试脚本的编写和阅读\n"
                        , notes);

                break;
            case "kotlin从零基础到进阶":
                //TODO:待完善数据
                chapters.add(new Chapter("第1章 初识kotlin", true, null, ""));
                chapters.add(new Chapter("1-1 kotlin选好教练车", false, Resources.VIDEO, "http://223.111.18.46/video.study.163.com/edu-video/nos/mp4/2017/08/17/1006760456_5343c7dd96524fbfb2e699090eac3e2d_shd.mp4?ak=99ed7479ee303d1b1361b0ee5a4abcee723c57f29189d94f20855dcfcebd7309a57ff4473bf4d914a17c202e18f8054b28724715ecded5e5baf51400a4e7dda9c5c2392413a096f94c1b700ffc15fb5490b601143824cf18b58a69ea00438816e2c4caba0e116581c14e4824cb46dc107feb6d0bf73a0d052df948b3525aefb09eed6bb2ffe8530b0f8655d97b53dc6197cbdc8f6a5d1563323094d2340ba3cf2919f5e4aded4ea11a82dd96c04efc1a&wshc_tag=0&wsts_tag=59b6b150&wsid_tag=700ab4b2&wsiphost=ipdbm"));
                chapters.add(new Chapter("1-2 kotlin你好世界", false, Resources.VIDEO, "http://223.111.18.46/video.study.163.com/edu-video/nos/mp4/2017/08/17/1006760456_5343c7dd96524fbfb2e699090eac3e2d_shd.mp4?ak=99ed7479ee303d1b1361b0ee5a4abcee723c57f29189d94f20855dcfcebd7309a57ff4473bf4d914a17c202e18f8054b28724715ecded5e5baf51400a4e7dda9c5c2392413a096f94c1b700ffc15fb5490b601143824cf18b58a69ea00438816e2c4caba0e116581c14e4824cb46dc107feb6d0bf73a0d052df948b3525aefb09eed6bb2ffe8530b0f8655d97b53dc6197cbdc8f6a5d1563323094d2340ba3cf2919f5e4aded4ea11a82dd96c04efc1a&wshc_tag=0&wsts_tag=59b6b150&wsid_tag=700ab4b2&wsiphost=ipdbm"));
                chapters.add(new Chapter("第2章 kotlin基本知识", true, null, ""));
                chapters.add(new Chapter("2-1 kotlin变量与输出", false, Resources.VIDEO, "http://223.111.18.46/video.study.163.com/edu-video/nos/mp4/2017/08/17/1006760456_5343c7dd96524fbfb2e699090eac3e2d_shd.mp4?ak=99ed7479ee303d1b1361b0ee5a4abcee723c57f29189d94f20855dcfcebd7309a57ff4473bf4d914a17c202e18f8054b28724715ecded5e5baf51400a4e7dda9c5c2392413a096f94c1b700ffc15fb5490b601143824cf18b58a69ea00438816e2c4caba0e116581c14e4824cb46dc107feb6d0bf73a0d052df948b3525aefb09eed6bb2ffe8530b0f8655d97b53dc6197cbdc8f6a5d1563323094d2340ba3cf2919f5e4aded4ea11a82dd96c04efc1a&wshc_tag=0&wsts_tag=59b6b150&wsid_tag=700ab4b2&wsiphost=ipdbm"));
                chapters.add(new Chapter("2-2 kotlin二进制基础", false, Resources.VIDEO, "http://223.111.18.46/video.study.163.com/edu-video/nos/mp4/2017/08/17/1006760456_5343c7dd96524fbfb2e699090eac3e2d_shd.mp4?ak=99ed7479ee303d1b1361b0ee5a4abcee723c57f29189d94f20855dcfcebd7309a57ff4473bf4d914a17c202e18f8054b28724715ecded5e5baf51400a4e7dda9c5c2392413a096f94c1b700ffc15fb5490b601143824cf18b58a69ea00438816e2c4caba0e116581c14e4824cb46dc107feb6d0bf73a0d052df948b3525aefb09eed6bb2ffe8530b0f8655d97b53dc6197cbdc8f6a5d1563323094d2340ba3cf2919f5e4aded4ea11a82dd96c04efc1a&wshc_tag=0&wsts_tag=59b6b150&wsid_tag=700ab4b2&wsiphost=ipdbm"));
                chapters.add(new Chapter("2-3 kotlin变量和常量", false, Resources.VIDEO, "http://223.111.18.46/video.study.163.com/edu-video/nos/mp4/2017/08/17/1006760456_5343c7dd96524fbfb2e699090eac3e2d_shd.mp4?ak=99ed7479ee303d1b1361b0ee5a4abcee723c57f29189d94f20855dcfcebd7309a57ff4473bf4d914a17c202e18f8054b28724715ecded5e5baf51400a4e7dda9c5c2392413a096f94c1b700ffc15fb5490b601143824cf18b58a69ea00438816e2c4caba0e116581c14e4824cb46dc107feb6d0bf73a0d052df948b3525aefb09eed6bb2ffe8530b0f8655d97b53dc6197cbdc8f6a5d1563323094d2340ba3cf2919f5e4aded4ea11a82dd96c04efc1a&wshc_tag=0&wsts_tag=59b6b150&wsid_tag=700ab4b2&wsiphost=ipdbm"));
                chapters.add(new Chapter("2-4 kotlin变量取值范围", false, Resources.VIDEO, "http://223.111.18.46/video.study.163.com/edu-video/nos/mp4/2017/08/17/1006760456_5343c7dd96524fbfb2e699090eac3e2d_shd.mp4?ak=99ed7479ee303d1b1361b0ee5a4abcee723c57f29189d94f20855dcfcebd7309a57ff4473bf4d914a17c202e18f8054b28724715ecded5e5baf51400a4e7dda9c5c2392413a096f94c1b700ffc15fb5490b601143824cf18b58a69ea00438816e2c4caba0e116581c14e4824cb46dc107feb6d0bf73a0d052df948b3525aefb09eed6bb2ffe8530b0f8655d97b53dc6197cbdc8f6a5d1563323094d2340ba3cf2919f5e4aded4ea11a82dd96c04efc1a&wshc_tag=0&wsts_tag=59b6b150&wsid_tag=700ab4b2&wsiphost=ipdbm"));
                mCourse = new Course("kotlin从零基础到进阶", chapters, 2, "学习kotlin最好的时机是三年前,其次是现在.\n" +
                        "掌握kotlin可以开发 Web前端 Web后端 Android移动端 Server脚本 桌面游戏\n" +
                        "本套课程采用真实案例讲解, 拒绝纸上谈兵\n" +
                        "顺便带你复习高中物理、化学、生物和数学, 重新找回学霸的感觉"
                        , "本课程是kotlin的入门课程,需具备基础的\nJAVA知识"
                        , "1、学会kotlin基本语法知识\n"
                        + "2、掌握kotlin与JAVA的混合开发\n"
                        , notes);

                break;
            default:
                mCourse = null;
                break;
        }
        final Course course = mCourse;
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putParcelable("course", course);
                Intent intent = new Intent(mContext, SpecificCouseActivity.class);
                intent.putExtras(bundle);
                mContext.startActivity(intent);
            }
        });
        if (position == mList.size() - 1) {
            mIntegers = new ArrayList<>();
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private View mLinearLayout;
        private TextView mCourseName, mChapterTitle, mChapterDescription, mLearningNumber;

        public ViewHolder(View itemView) {
            super(itemView);
            mLinearLayout = itemView.findViewById(R.id.linear_layout);
            mCourseName = (TextView) itemView.findViewById(R.id.tv_course_name);
            mChapterTitle = (TextView) itemView.findViewById(R.id.tv_chapter_title);
            mChapterDescription = (TextView) itemView.findViewById(R.id.tv_chapter_description);
            mLearningNumber = (TextView) itemView.findViewById(R.id.tv_learning_numbers);
        }
    }
}
