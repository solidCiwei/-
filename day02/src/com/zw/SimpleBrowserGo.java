package com.zw;

/**
 * <p> SimpleBrowserGo </p >
 * 一个简单的浏览器前进后退实现
 *
 * @author zw
 * @version 1.0
 * @date 2023/4/8 10:47
 */
public class SimpleBrowserGo {

    SimpleLinkedStack before;

    SimpleLinkedStack after;

    String currentPage;

    public SimpleBrowserGo() {
        this.before = new SimpleLinkedStack();
        this.after = new SimpleLinkedStack();
    }

    /**
     * 打开页面
     */
    public void open(String url) {
        //说明之前还有别的网页
        if (this.currentPage != null) {
            //将之前的页面压入返回栈
            this.before.push(this.currentPage);
            //清空存放前进页面栈
            after.clear();
        }
        //直接跳转网页
        show(url, "open");
    }


    /**
     * 浏览器的前进
     */
    public String goForward() {
        if (after.isEmpty()) return "no pages";
        String url = after.pop();
        before.push(this.currentPage);
        show(url, "forward");
        return url;
    }

    public String goBack() {
        if (before.isEmpty()) return "no pages";
        String url = before.pop();
        after.push(this.currentPage);
        show(url, "back");
        return url;
    }

    public void show(String url, String operation) {
        System.out.println(operation + ":" + url);
        this.currentPage = url;
    }

    public void checkCurrentPage() {
        System.out.println("current page is" + this.currentPage);
    }
}
