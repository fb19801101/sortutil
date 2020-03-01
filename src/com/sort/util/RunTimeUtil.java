package com.sort.util;

/**
 * @author 信息化管理部-方波
 * @site http://www.cr121.com/
 * @company 中铁十二局集团第一工程有限公司
 * @create 2020-02-29 9:30
 */
public class RunTimeUtil {
    private long start;
    private long end;

    public RunTimeUtil() {
        start = System.currentTimeMillis();
    }

    public long getTime() {
        end = System.currentTimeMillis();
        return end-start;
    }

    public void outTime() {
        end = System.currentTimeMillis();
        System.out.println("the run time is "+(end-start)+" ms.");
    }
}