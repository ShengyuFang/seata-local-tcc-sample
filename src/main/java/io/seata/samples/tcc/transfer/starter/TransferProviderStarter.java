/*
 *  Copyright 1999-2021 Seata.io Group.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package io.seata.samples.tcc.transfer.starter;

import io.seata.samples.tcc.transfer.ApplicationKeeper;
import io.seata.samples.tcc.transfer.env.TransferDataPrepares;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 转账TCC Dubbo服务 提供方
 *
 * @author zhangsen
 */
public class TransferProviderStarter {

    public static void main(String[] args) throws Exception {

        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
            new String[] {"db-bean/to-datasource-bean.xml", "db-bean/from-datasource-bean.xml"});

        //初始化数据库和账号余额
        TransferDataPrepares transferDataPrepares = (TransferDataPrepares)applicationContext.getBean(
            "transferDataPrepares");
        transferDataPrepares.init(100);

    }

}
