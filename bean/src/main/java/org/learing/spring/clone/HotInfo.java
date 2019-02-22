package org.learing.spring.clone;


import com.google.common.collect.Lists;
import lombok.Data;

import java.util.List;

@Data
public class HotInfo implements Cloneable {
    private Long id;
    private Long structPId;

    private List<Info> infos;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        HotInfo hotInfo = (HotInfo) super.clone();
//        List<Info> infos = Lists.newArrayList();
//        for (Info info : hotInfo.getInfos()) {
//            infos.add((Info) info.clone());
//        }
//        hotInfo.setInfos(infos);
        return hotInfo;
    }
}
