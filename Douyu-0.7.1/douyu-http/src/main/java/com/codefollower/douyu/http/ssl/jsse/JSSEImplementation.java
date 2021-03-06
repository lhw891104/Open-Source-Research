/*
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.codefollower.douyu.http.ssl.jsse;

import java.net.Socket;

import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;

import com.codefollower.douyu.http.ssl.SSLConfig;
import com.codefollower.douyu.http.ssl.SSLSupport;
import com.codefollower.douyu.http.ssl.SSLUtil;
import com.codefollower.douyu.http.ssl.ServerSocketFactory;

/* JSSEImplementation:

   Concrete implementation class for JSSE

   @author EKR
*/
        
public class JSSEImplementation extends com.codefollower.douyu.http.ssl.SSLImplementation {

    @Override
    public String getImplementationName(){
        return "JSSE";
    }
      
    @Override
    public ServerSocketFactory getServerSocketFactory(SSLConfig config)  {
        return new JSSESocketFactory(config);
    } 

    @Override
    public SSLSupport getSSLSupport(Socket s) {
        return new JSSESupport((SSLSocket) s);
    }

    @Override
    public SSLSupport getSSLSupport(SSLSession session) {
        return new JSSESupport(session);
    }

    @Override
    public SSLUtil getSSLUtil(SSLConfig config) {
        return new JSSESocketFactory(config);
    }
}
