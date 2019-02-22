package org.learing.spring.clone;

import com.google.common.collect.Lists;

import java.util.List;

public class Test {

    public static void main(String[] args) throws CloneNotSupportedException {
        Info info = new Info();
        info.setId(1L);
        info.setStructCId(1L);
        info.setValue("1");
        List<Info> infos = Lists.newArrayList();
        infos.add(info);


        HotInfo hotInfo = new HotInfo();
        hotInfo.setId(1L);
        hotInfo.setStructPId(1L);
        hotInfo.setStructPId(0L);
        hotInfo.setInfos(infos);


        HotInfo hotInfo1 = (HotInfo) hotInfo.clone();
        System.out.println("浅拷贝？？" + (hotInfo == hotInfo1));
        System.out.println("浅拷贝？？" + (hotInfo.getInfos() == hotInfo1.getInfos()));
    }
}
