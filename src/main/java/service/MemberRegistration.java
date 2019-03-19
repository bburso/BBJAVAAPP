/*
 * JBoss, Home of Professional Open Source
 * Copyright 2013, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package service;

import model.MemberList;
import model.Member;
import javax.inject.Inject;
import javax.persistence.*;
import java.util.logging.Logger;
//import javax.enterprise.event.Event;


// The @Stateless annotation eliminates the need for manual transaction demarcation
//@Stateless
public class MemberRegistration {

    private static final Logger mrlogger = Logger.getLogger(MemberRegistration.class.getName());

    @Inject
    private EntityManager em;


   // @Inject
   // private Event<Member> memberEventSrc;

    public void register(Member member,MemberList memberlist) {
        mrlogger.info("Member Registration:register");
        mrlogger.info("Member Registration:register Registering member name is(" + member.getName() + ")");
        mrlogger.info("Member Registration:register Registering member id is(" + member.getId() + ")");
        //mrlogger.info("Member Registration:register mbrs list size before adding extras is:" + mbrs.size());
        memberlist.addMember(member);

        // em.persist(member);
       // memberEventSrc.fire(member);
    }
}
