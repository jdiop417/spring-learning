package org.learning.foundation.rpc;

import org.apache.commons.lang3.StringUtils;

public class EchoServiceImpl implements EchoService {
    @Override
    public String echo(String ping) {
        return StringUtils.isNotBlank(ping) ? ping + "-->I'm ok." : "I'm ok.";
    }
}
